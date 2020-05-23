/**
 * 
 */
package my.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import my.portal.pojo.Sort;

/**获取分类
 * @author 盼望
 * @date 2019年8月30日下午3:38:39
 */
public interface GetSort {
	public List<Sort> getSort(HttpServletRequest request);
}
