/**
 * 
 */
package my.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import my.portal.common.ExceptionUtil;
import my.portal.common.MyResult;
import my.portal.pojo.Blogger;
import my.portal.service.GetBlogger;

/**
 * 查询博客个人信息
 * @author 盼望
 * @date 2019年8月29日下午6:29:38
 */
@Controller
public class GetBloggerController {
	
	@Autowired
	GetBlogger getBlogger;
	
	@RequestMapping("/blogger/info")
	@ResponseBody
	public MyResult getbloggerController(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Blogger> list = getBlogger.getBlogger(request, response);
			return MyResult.ok(list);
			
		} catch (Exception e) {
			e.printStackTrace();
			return MyResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
}
