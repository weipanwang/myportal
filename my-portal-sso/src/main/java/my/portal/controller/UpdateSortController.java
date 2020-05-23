/**
 * 
 */
package my.portal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import my.portal.common.ExceptionUtil;
import my.portal.common.MyResult;
import my.portal.service.UpdateSort;

/**
 * 修改博客分类名称
 * @author 盼望
 * @date 2019年9月4日下午2:17:33
 */
@Controller
public class UpdateSortController {
	
	@Autowired
	UpdateSort updateSort;
	
	@RequestMapping(value = "/blogger/sort/update",method = RequestMethod.POST)
	@ResponseBody
	public MyResult updateSortcontroller(Long sortId,String sortName
			,HttpServletRequest request) {
		try {
			updateSort.UpdateSortInfo(sortId, sortName,request);
			return MyResult.ok();
			
		} catch (Exception e) {
			e.printStackTrace();
			return MyResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}
}
