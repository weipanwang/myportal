/**
 * 
 */
package my.portal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.portal.common.MyResult;

/**修改博客个人信息
 * @author 盼望
 * @date 2019年8月30日下午1:44:37
 */
public interface UpdateBlogger {
	public MyResult updateBloggerImpl(String name,String city,String show,
			HttpServletRequest request,HttpServletResponse response); 
}
