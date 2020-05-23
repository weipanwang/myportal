/**
 * 
 */
package my.portal.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import my.portal.common.CookieUtils;
import my.portal.common.SCaptcha;
import my.portal.service.JedisClient;
import my.portal.service.impl.SCaptchaServiceImpl;




/**
 * @author 盼望
 * @date 2019年8月27日上午11:25:19
 */
@Controller
public class SCaptchaController {
		
	
	@Autowired
	SCaptchaServiceImpl sCaptchaServiceImpl;
	
	 @RequestMapping(value = "/user/verification", method = {RequestMethod.POST, RequestMethod.GET})
	 @ResponseBody
	 public void verification(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		 sCaptchaServiceImpl.verification(request, response, session);
		 
	 }
}
