/**
 * 
 */
package my.portal.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import my.portal.common.CookieUtils;
import my.portal.common.JsonUtils;
import my.portal.common.MyResult;
import my.portal.dao.SortMapper;
import my.portal.pojo.Sort;
import my.portal.pojo.SortExample;
import my.portal.pojo.SortExample.Criteria;
import my.portal.pojo.User;
import my.portal.service.GetSort;
import my.portal.service.GetUserByToken;
import my.portal.service.JedisClient;

/**获取博客分类
 * @author 盼望
 * @date 2019年8月30日下午3:50:40
 */
@Service
public class GetSortImpl implements GetSort {
	
	@Autowired
	SortMapper sortMapper;
	@Autowired
	JedisClient jedisClient;
	@Autowired
	GetUserByToken getUserByToken;
	
	@Value("${REDIS_SESSION_KEY}")
	private String REDIS_SESSION_KEY;
	
	@Override
	public List<Sort> getSort(HttpServletRequest request) {
		//从cookies中取token
		//String cookieValue = CookieUtils.getCookieValue(request, REDIS_SESSION_KEY);
		String cookieValue = "d2e7b004-996a-4ebc-86c6-2e04f014438a";
		//取用户登录信息
		MyResult result = getUserByToken.getUserByToken(cookieValue);		
		//将java对象转换成po
		String json = JsonUtils.objectToJson(result.getData());
		User user = JsonUtils.jsonToPojo(json, User.class);
		
		//通过id查询分类
		SortExample example = new SortExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(user.getId());
		List<Sort> list = sortMapper.selectByExample(example);
		
		return list;
	}

}
