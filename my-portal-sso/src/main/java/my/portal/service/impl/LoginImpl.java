/**
 * 
 */
package my.portal.service.impl;



import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


import my.portal.common.CookieUtils;
import my.portal.common.JsonUtils;
import my.portal.common.MyResult;
import my.portal.dao.UserMapper;
import my.portal.pojo.User;
import my.portal.pojo.UserExample;
import my.portal.pojo.UserExample.Criteria;
import my.portal.service.JedisClient;
import my.portal.service.LoginService;

/**
 * 登录并返回token
 * @author 盼望
 * @date 2019年8月22日下午4:50:06
 */
@Service
public class LoginImpl implements LoginService {
	
	Log log = LogFactory.getLog(LoginImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${REDIS_SESSION_KEY}")
	private String REDIS_SESSION_KEY;
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;
	
	@Value("${CAPTCHA_SESSION_KEY}")
	private String CAPTCHA_SESSION_KEY;
	@Value("${CAPTCHA_KEY}")
	private String CAPTCHA_KEY;
	
	@Override
	public MyResult login(String username, String password,String captcha,
			HttpServletRequest request,HttpServletResponse response) {
		//System.out.println(captcha);
		//从cookie中获取token
		String captchaToken = CookieUtils.getCookieValue(request, CAPTCHA_SESSION_KEY);
		//System.out.println(CAPTCHA_SESSION_KEY);
		//String captchaToken = "49768719-4fa0-482c-9484-d9c36ad71b14";
		//从token取验证码
		String redisCaptcha = jedisClient.get(CAPTCHA_KEY+":"+captchaToken);
		//System.out.println(redisCaptcha);
		//判断图形验证码是否正确
		if(!captcha.equals(redisCaptcha)) {
			return MyResult.build(400, "图形验证码错误");
		}
		log.info("这是一行日志");
		//校验用户名密码是否正确
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);
		//取用户信息
		if(list ==null || list.isEmpty()) {
			return MyResult.build(400, "用户名或密码错误");
			
		}
		User user = list.get(0);
		String str = DigestUtils.md5DigestAsHex(password.getBytes());
		
		//System.out.println(str);
		//System.out.println(user.getPassword());
		
		//判断密码是否正确
		if(!user.getPassword().equals(str)) {
			return MyResult.build(400, "用户名或密码错误");
		}
		//登录成功
		//生成token
		String token = UUID.randomUUID().toString();
		//System.out.println(token);
		//把用户信息写入redis
		user.setPassword(null);
		
		String str2 = JsonUtils.objectToJson(user);
		//System.out.println(str2);
		jedisClient.set(REDIS_SESSION_KEY+":"+token,str2 );
		
		jedisClient.expire(REDIS_SESSION_KEY+":"+token,SESSION_EXPIRE);
		//写cookie
		CookieUtils.setCookie(request, response, "MY_TOKNE", token);
		return MyResult.ok(token);
	}

}
