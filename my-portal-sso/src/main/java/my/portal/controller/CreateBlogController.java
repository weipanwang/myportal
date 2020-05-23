/**
 * 
 */
package my.portal.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import my.portal.common.ExceptionUtil;
import my.portal.common.MyResult;
import my.portal.service.CreateBlog;

/**创建一条博客
 * @author 盼望
 * @date 2019年9月4日下午3:54:49
 */
@Controller
public class CreateBlogController {
	@Autowired
	CreateBlog createBlog;
	
	@RequestMapping("/blog/create")
	@ResponseBody
	public MyResult createBlogController(String title, String body, String photo,
			String sort,HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			createBlog.createBlog(title, body, photo, sort, request, response);
			return MyResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return MyResult.build(400, ExceptionUtil.getStackTrace(e));
		}
		
		
		
	}
	
}