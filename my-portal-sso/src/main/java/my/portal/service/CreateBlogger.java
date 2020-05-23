/**
 * 
 */
package my.portal.service;

import my.portal.common.MyResult;

/**创建博客个人信息
 * @author 盼望
 * @date 2019年8月29日下午8:28:59
 */
public interface CreateBlogger {
	public MyResult createBlogger(Long id,String name);
}
