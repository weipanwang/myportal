/**
 * 
 */
package my.portal.service;

import my.portal.common.MyResult;

/**
 * 根据token查询用户信息
 * @author 盼望
 * @date 2019年8月23日下午8:58:34
 */
public interface GetUserByToken {
	MyResult getUserByToken(String token);
	MyResult getCaptchaToken(String token);
}
