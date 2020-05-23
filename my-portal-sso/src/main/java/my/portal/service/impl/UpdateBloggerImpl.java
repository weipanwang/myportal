/**
 * 
 */
package my.portal.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.portal.common.JsonUtils;
import my.portal.common.MyResult;
import my.portal.dao.BloggerMapper;
import my.portal.pojo.Blogger;
import my.portal.service.GetBlogger;
import my.portal.service.UpdateBlogger;

/**修改博客个人信息
 * @author 盼望
 * @date 2019年8月30日下午1:46:32
 */
@Service
public class UpdateBloggerImpl implements UpdateBlogger {
	
	@Autowired
	BloggerMapper bloggerMapper;
	
	@Autowired
	GetBlogger getBlogger;

	@Override
	public MyResult updateBloggerImpl(String name, String city, String show,
			HttpServletRequest request,HttpServletResponse response) {
		
		Blogger blogger = new Blogger();
		
		List<Blogger> blogger2 = getBlogger.getBlogger(request, response);
		
		blogger = blogger2.get(0);
		
		try {
			if(!name.isEmpty()|| name!=null) {
				name = new String(name.getBytes("iso-8859-1"),"utf-8");
				blogger.setBloggerName(name);
			}
			if(!city.isEmpty()|| city!=null) {
				city = new String(city.getBytes("iso-8859-1"),"utf-8");
				blogger.setBloggerCity(city);	
					}
			if(!show.isEmpty()|| show!=null) {
				show = new String(show.getBytes("iso-8859-1"),"utf-8");
				blogger.setBloggerShow(show);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		blogger.setUpdated(new Date());
		bloggerMapper.updateByPrimaryKeySelective(blogger);
		
		return MyResult.ok();
	}

}
