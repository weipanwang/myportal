/**
 * 
 */
package my.portal.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.portal.common.MyResult;
import my.portal.dao.BlogMapper;
import my.portal.pojo.BlogWithBLOBs;
import my.portal.pojo.Blogger;
import my.portal.service.CreateBlog;
import my.portal.service.GetBlogger;

/**创建一条博客
 * @author 盼望
 * @date 2019年9月4日下午3:00:28
 */
@Service
public class CreateBlogImpl implements CreateBlog{
	
	@Autowired
	BlogMapper blogMapper;

	@Autowired
	GetBlogger getBlogger;
	
	@SuppressWarnings("unused")
	@Override
	public MyResult createBlog(String title, String body, String photo,
			String sort,HttpServletRequest request,
			HttpServletResponse response) {

		//创建一个博客对象
		BlogWithBLOBs bloBs = new BlogWithBLOBs();
		
		//博客id
		int blogId = UUID.randomUUID().toString().hashCode();
		//取博客作者
		List<Blogger> blogger = getBlogger.getBlogger(request, response);
		Blogger blogger2 = blogger.get(0);
		String blogAuthor = blogger2.getBloggerName();
		
		if(!title.isEmpty()||title!=null
				||!body.isEmpty()||body!=null
				||!sort.isEmpty()||sort!=null) {
			
			
			bloBs.setBlogId(blogId);
			try {
				String title1 = new String(title.getBytes("iso-8859-1"),"utf-8");
				bloBs.setBlogTitle(title1);
				String body1 = new String(body.getBytes("iso-8859-1"),"utf-8");
				bloBs.setBlogBody(body1);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				System.out.println("标题和内容乱码");
			}
			
			bloBs.setBlogAuthor(blogAuthor);
			bloBs.setBlogPhoto(photo);
			bloBs.setBlogSort(sort);
			bloBs.setBlogSeeNumber(0);
			bloBs.setBlogCommentNumber(0);
			bloBs.setBlogCreated(new Date());
			bloBs.setBlogUpdated(new Date());
			blogMapper.insert(bloBs);
			return MyResult.ok();
		}
		return MyResult.build(400, "新增失败");
	}

}
