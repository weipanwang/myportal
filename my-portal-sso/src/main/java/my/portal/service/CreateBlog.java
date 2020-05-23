/**
 * 
 */
package my.portal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.portal.common.MyResult;

/**
 * 发布一条博客
 * @author 盼望
 * @date 2019年9月4日下午2:56:33
 */
public interface CreateBlog {
	MyResult createBlog(String title,String body,String photo,String sort,HttpServletRequest request,
			HttpServletResponse response);
}
