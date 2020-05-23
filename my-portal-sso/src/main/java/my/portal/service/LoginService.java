/**
 * 
 */
package my.portal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.portal.common.MyResult;

/**
 * @author 盼望
 * @date 2019年8月22日下午3:17:49
 */
public interface LoginService {
	/**
	 * @param username
	 * @param password
	 * @param request
	 * @param response
	 * @return
	 */
	MyResult login(String username, String password, String captcha,HttpServletRequest request, HttpServletResponse response);
}
