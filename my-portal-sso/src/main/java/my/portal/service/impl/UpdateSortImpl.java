/**
 * 
 */
package my.portal.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.portal.common.MyResult;
import my.portal.dao.SortMapper;
import my.portal.pojo.Sort;
import my.portal.service.GetSort;
import my.portal.service.UpdateSort;

/**更新博客分类信息
 * @author 盼望
 * @date 2019年9月4日上午11:42:39
 */
@Service
public class UpdateSortImpl implements UpdateSort {
	
	@Autowired
	SortMapper sortMapper;
	@Autowired
	GetSort getSort;
	
	@Override
	public MyResult UpdateSortInfo(Long sortId, String sortName,HttpServletRequest request) {
		
		Sort sort = new Sort();
		List<Sort> list = getSort.getSort(request);
		for(int i=0;i<list.size();i++) {
			sort= list.get(i);
			if(sort.getSortId()==sortId) {
				if(!sortName.isEmpty()||sortName!=null) {
					sort.setSortName(sortName);
					sort.setSortUpdated(new Date());
					sortMapper.updateByPrimaryKeySelective(sort);
					return MyResult.ok();
				}
			}
		}
		return MyResult.build(400, "修改失败");
	}

}
