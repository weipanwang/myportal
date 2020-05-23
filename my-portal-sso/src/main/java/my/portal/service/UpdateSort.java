/**
 * 
 */
package my.portal.service;

import javax.servlet.http.HttpServletRequest;

import my.portal.common.MyResult;

/**更新分类信息
 * @author 盼望
 * @date 2019年9月4日上午11:37:42
 */
public interface UpdateSort {
	MyResult UpdateSortInfo(Long sortId, String sortName,HttpServletRequest request);
}
