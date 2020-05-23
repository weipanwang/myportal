/**
 * 
 */
package my.portal.service;

import my.portal.common.MyResult;

/**
 * 注销账号
 * @author 盼望
 * @date 2019年8月23日下午7:24:26
 */
public interface LogoutService {
	MyResult Logout(String token);
}
