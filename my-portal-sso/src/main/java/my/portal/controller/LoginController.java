/**
 * 
 */
package my.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import my.portal.common.ExceptionUtil;
import my.portal.common.MyResult;
import my.portal.service.LoginService;

/**
 * @author 盼望
 * @date 2019年8月23日下午2:02:27
 */
@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/user/login", method=RequestMethod.POST)
	@ResponseBody
	public MyResult Login(String username,String password,String captcha,
			HttpServletRequest request,HttpServletResponse response) {
		try {
			MyResult result = loginService.login(username, password, captcha,request, response);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return MyResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
}
