/**
 * 
 */
package my.portal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import my.portal.common.ExceptionUtil;
import my.portal.common.MyResult;
import my.portal.pojo.User;
import my.portal.service.Regsiter;

/**
 * @author 盼望
 * @date 2019年8月15日上午10:52:40
 */
@Controller
@RequestMapping("/user")
public class RegsiterController {
	
	@Autowired 
	private Regsiter regsiter;
	
	
	@RequestMapping(value="/regsiter", method=RequestMethod.POST)
	@ResponseBody
	public MyResult register(User user,HttpServletRequest request) {
		try {
			return regsiter.register(user,request);
		} catch (Exception e) {
			return MyResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
