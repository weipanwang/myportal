/**
 * 
 */
package my.portal.service.impl;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import my.portal.common.CookieUtils;
import my.portal.common.SCaptcha;
import my.portal.service.JedisClient;

/**图形验证码
 * @author 盼望
 * @date 2019年8月27日下午5:15:24
 */
@Service
public class SCaptchaServiceImpl {
	@Autowired
	private JedisClient jedisClient;
	
	@Value("${CAPTCHA_KEY}")
	private String CAPTCHA_KEY;
	
	@Value("${CAPTCHA_KEY_EXPIRE}")
	private Integer CAPTCHA_KEY_EXPIRE;
	
	@Value("${CAPTCHA_SESSION_KEY}")
	private String CAPTCHA_SESSION_KEY;
	
	@Value("${CAPTCHA_SESSION_EXPIRE}")
	private Integer CAPTCHA_SESSION_EXPIRE;
	
	
	public void verification(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		  // 设置响应的类型格式为图片格式
		  response.setContentType("image/jpeg");
		  // 禁止图像缓存。
		  response.setHeader("Pragma", "no-cache");
		  response.setHeader("Cache-Control", "no-cache");
		  response.setDateHeader("Expires", 0);
		  //实例生成验证码对象
		  SCaptcha instance = new SCaptcha();
		  //生成token
		  String token = UUID.randomUUID().toString();
		  //将图形验证码存进redis
		  String code = instance.getCode();
		  jedisClient.set(CAPTCHA_KEY+":"+token, code);
		  jedisClient.expire(CAPTCHA_KEY+":"+token, CAPTCHA_KEY_EXPIRE);
		  //将token存入cookie
		  CookieUtils.setCookie(request, response, CAPTCHA_SESSION_KEY, token,CAPTCHA_SESSION_EXPIRE);
		  //将验证码存入session
		  //session.setAttribute("verification", instance.getCode());
		  //向页面输出验证码图片
		  instance.write(response.getOutputStream());
		  
	  }
}
