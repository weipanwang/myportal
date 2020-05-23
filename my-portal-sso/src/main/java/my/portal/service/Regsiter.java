/**
 * 
 */
package my.portal.service;

import javax.servlet.http.HttpServletRequest;

import my.portal.common.MyResult;
import my.portal.pojo.User;

/**
 * @author 盼望
 * @date 2019年8月15日上午9:42:45
 */
public interface Regsiter {
	MyResult register(User userInfo,HttpServletRequest request);
}
