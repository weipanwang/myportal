/**
 * 
 */
package my.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import my.portal.common.ExceptionUtil;
import my.portal.common.MyResult;
import my.portal.pojo.Sort;
import my.portal.service.GetSort;

/**获取博客分类
 * @author 盼望
 * @date 2019年8月30日下午4:17:19
 */
@Controller
public class GetSortController {
	
	@Autowired
	GetSort getSort;
	
	@RequestMapping("/blogger/getsort")
	@ResponseBody
	public MyResult getSortController(HttpServletRequest request) {
		
		try {
		List<Sort> list = getSort.getSort(request);
			
			return MyResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return MyResult.build(400, ExceptionUtil.getStackTrace(e));
		}
	}
	
}
