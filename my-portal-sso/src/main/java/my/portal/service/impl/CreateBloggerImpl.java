/**
 * 
 */
package my.portal.service.impl;





import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.portal.common.MyResult;
import my.portal.dao.BloggerMapper;
import my.portal.pojo.Blogger;
import my.portal.service.CreateBlogger;

/**
 * 创建博客个人信息
 * @author 盼望
 * @date 2019年8月29日下午8:35:46
 */
@Service
public class CreateBloggerImpl implements CreateBlogger {
	
	@Autowired
	BloggerMapper bloggerMapper;

	
	@Override
	public MyResult createBlogger(Long id, String name) {
		Blogger blogger = new Blogger();
		
		blogger.setBloggerId(id);
		blogger.setBloggerName(name);
		blogger.setBloggerCity("");
		blogger.setBloggerShow("这个人很懒，什么都没有留下。");
		blogger.setCreated(new Date());
		blogger.setUpdated(new Date());
		bloggerMapper.insert(blogger);
		return MyResult.ok();
	}

}
