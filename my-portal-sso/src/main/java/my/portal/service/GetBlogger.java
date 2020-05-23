/**
 * 
 */
package my.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.portal.pojo.Blogger;

/**查询博客个人信息
 * @author 盼望
 * @date 2019年8月29日下午3:47:11
 */
public interface GetBlogger {
	public List<Blogger> getBlogger(HttpServletRequest request,HttpServletResponse response);
}

