/**
 * 
 */
package my.portal.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import my.portal.common.CookieUtils;
import my.portal.common.MyResult;
import my.portal.dao.UserMapper;
import my.portal.pojo.User;
import my.portal.service.CheckData;
import my.portal.service.CreateBlogger;
import my.portal.service.JedisClient;
import my.portal.service.Regsiter;

/**
 * 注册接口
 * @author 盼望
 * @date 2019年8月15日上午9:59:32
 */
@Service
public class RegsiterImpl implements Regsiter {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CheckData check;
	@Autowired
	CreateBlogger createBlogger;
	
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${CAPTCHA_KEY}")
	private String CAPTCHA_KEY;
	
	@Value("${CAPTCHA_SESSION_KEY}")
	private String CAPTCHA_SESSION_KEY;
	
	/* 
	 * 注册会员
	 */
	@Override
	public MyResult register(User userInfo,HttpServletRequest request) {
				//取cookie的key
				String cookieValue = CookieUtils.getCookieValue(request, CAPTCHA_SESSION_KEY);
				//String cookieValue = "49768719-4fa0-482c-9484-d9c36ad71b14";
				//取redis数据
				String redisValue = jedisClient.get(CAPTCHA_KEY+":"+cookieValue);
				//System.out.println("redis里面的验证码："+redisValue);
				//System.out.println("输入的验证码："+userInfo.getCaptcha());
				if(!redisValue.equals(userInfo.getCaptcha())) {
					return MyResult.build(400, "图形验证码错误");
				}
				
				//有效性验证
				if (StringUtils.isEmpty(userInfo.getUsername()) || StringUtils.isEmpty(userInfo.getPassword()) ) {
					return MyResult.build(400, "用户名或密码不能为空");
				}
				//校验数据是否重复
				//校验用户名
				MyResult result = check.checkData(userInfo.getUsername(),1);
				
				if (!(boolean)result.getData()) {
					return MyResult.build(400, "用户名重复");
				}
				//校验手机号
				if (userInfo.getPhone() != null) {
					result = check.checkData(userInfo.getPhone(),2);
					if (!(boolean)result.getData()) {
						return MyResult.build(400, "手机号已存在");
					}
				}
				//校验邮箱
				if (userInfo.getEmail() != null) {
					result = check.checkData(userInfo.getEmail(),3);
					if (!(boolean)result.getData()) {
						return MyResult.build(400, "邮箱已存在");
					}
				}
				
				//密码进行md5加密
				String password = DigestUtils.md5DigestAsHex(userInfo.getPassword().getBytes());
				userInfo.setPassword(password);
				
				//补全user对象中的信息
				userInfo.setCreated(new Date());
				userInfo.setUpdated(new Date());
				//把用户信息插入到数据库
				userMapper.insert(userInfo);
				//创建博主信息
				createBlogger.createBlogger(userInfo.getId(), userInfo.getUsername());
				
				return MyResult.ok();
	}
	

}
