/**
 * 
 */
package my.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import my.portal.common.MyResult;
import my.portal.service.JedisClient;
import my.portal.service.LogoutService;

/**
 * 退出登录
 * @author 盼望
 * @date 2019年8月23日下午7:27:04
 */
@Service
public class LogoutServiceImpl implements LogoutService {
	

	@Value("${REDIS_SESSION_KEY}")
	private String REDIS_SESSION_KEY;
	
	@Autowired
	private JedisClient jedisClient;

	
	@Override
	public MyResult Logout(String token) {
		//提取token信息
		String json = jedisClient.get(REDIS_SESSION_KEY+":"+token);
		/*//判断session是否已过期
		if(StringUtils.isEmpty(json)) {
			return	MyResult.build(400, "用户session已过期");
		}*/
		
		jedisClient.del(REDIS_SESSION_KEY+":"+token);
		return MyResult.ok();
	}

}
