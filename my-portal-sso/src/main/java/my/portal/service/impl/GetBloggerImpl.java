/**
 * 
 */
package my.portal.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import my.portal.common.CookieUtils;
import my.portal.common.JsonUtils;
import my.portal.common.MyResult;
import my.portal.dao.BloggerMapper;
import my.portal.pojo.Blogger;
import my.portal.pojo.BloggerExample;
import my.portal.pojo.BloggerExample.Criteria;
import my.portal.pojo.User;
import my.portal.service.GetBlogger;
import my.portal.service.GetUserByToken;
import my.portal.service.JedisClient;

/**
 * 获取用户的博客信息
 * @author 盼望
 * @date 2019年8月29日下午4:54:06
 */
@Service
public class GetBloggerImpl implements GetBlogger {
	
	@Autowired
	BloggerMapper bloggerMapper;
	@Autowired
	GetUserByToken getUserByToken;
	@Autowired
	JedisClient jedisClient;
	
	@Value("${REDIS_SESSION_KEY}")
	private String REDIS_SESSION_KEY;
	
	@Override
	public List<Blogger> getBlogger(HttpServletRequest request,HttpServletResponse response) {
		//从cookies中取token
		//String cookieValue = CookieUtils.getCookieValue(request, REDIS_SESSION_KEY);
		String cookieValue = "c3cd598d-bf3b-40f9-be44-c4d21e645970";
		//jedisClient.get(REDIS_SESSION_KEY+":"+cookieValue);
		//取用户登录信息
		MyResult result = getUserByToken.getUserByToken(cookieValue);
		//将java对象转换成po
		String json = JsonUtils.objectToJson(result.getData());
		User user = JsonUtils.jsonToPojo(json, User.class);
		//通过id查询博客个人信息
		BloggerExample example = new BloggerExample();
		Criteria criteria = example.createCriteria();
		criteria.andBloggerIdEqualTo(user.getId());
		List<Blogger> list = bloggerMapper.selectByExample(example);
		return list;
	}

}
