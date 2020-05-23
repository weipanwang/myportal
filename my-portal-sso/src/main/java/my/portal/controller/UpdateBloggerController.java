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
import my.portal.service.UpdateBlogger;

/**
 * @author 盼望
 * @date 2019年8月30日下午2:01:28
 */
@Controller
public class UpdateBloggerController {
	
	@Autowired
	UpdateBlogger updateBlogger;
	
	@RequestMapping(name = "/blogger/update",method=RequestMethod.POST )
	@ResponseBody
	public MyResult updateBlogger(String name,String city,String show,
			HttpServletRequest request,HttpServletResponse response) {
		try {
			updateBlogger.updateBloggerImpl(name, city, show,request,response);
			return MyResult.ok();
			
		} catch (Exception e) {
			e.printStackTrace();
			return MyResult.build(400, ExceptionUtil.getStackTrace(e));
		}
	}
	
}
