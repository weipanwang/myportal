/**
 * 
 */
package my.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import my.portal.common.JsonUtils;
import my.portal.common.MyResult;
import my.portal.pojo.User;
import my.portal.service.GetUserByToken;
import my.portal.service.JedisClient;


/**
 * 根据token查询用户信息
 * @author 盼望
 * @date 2019年8月23日下午9:00:40
 */
@Service
public class GetUserByTokenImpl implements GetUserByToken {
	
	@Value("${CAPTCHA_KEY}")
	private String CAPTCHA_KEY;
	
	@Value("${REDIS_SESSION_KEY}")
	private String REDIS_SESSION_KEY;
	@Value("${SESSION_EXPIRE}")
	private Integer SESSION_EXPIRE;

	
	@Autowired
	private JedisClient jedisClient;

	@Override
	public MyResult getUserByToken(String token) {
		//提取token信息
		String json = jedisClient.get(REDIS_SESSION_KEY+":"+token);
		//判断是否查询到结果
		if(StringUtils.isEmpty(json)) {
			return	MyResult.build(400, "用户session已过期");
			
		}
		//把json转换成java对象
		User user = JsonUtils.jsonToPojo(json, User.class);
		
		//更新session过期时间
		jedisClient.expire(REDIS_SESSION_KEY+":"+token, SESSION_EXPIRE);
		return MyResult.ok(user);
	}
	
	@Override
	public MyResult getCaptchaToken(String token) {
		//提取token信息
		String captcha = jedisClient.get(CAPTCHA_KEY+":"+token);
		//判断是否查询到结果
		if(StringUtils.isEmpty(captcha)) {
			return	MyResult.build(400, "用户session已过期");
		}
		return MyResult.ok(captcha);
	}
	

}
