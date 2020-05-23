/**
 * 
 */
package my.portal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.portal.common.MyResult;
import my.portal.dao.UserMapper;
import my.portal.pojo.User;
import my.portal.pojo.UserExample;
import my.portal.pojo.UserExample.Criteria;
import my.portal.service.CheckData;

/**查询用户信息 username、phone、email
 * @author 盼望
 * @date 2019年8月15日上午10:17:10
 */
@Service
public class CheckDataImpl implements CheckData {
	
	@Autowired
	UserMapper myUserMapper;
	
	
	public MyResult checkData(String param,int type) {
		
		UserExample example = new UserExample();
		
		Criteria criteria = example.createCriteria();
		//1、2、3 分别代表 username、phone、email
		if(type == 1) {
			criteria.andUsernameEqualTo(param);
		}else if(type == 2) {
			criteria.andPhoneEqualTo(param);
		}else if(type == 3) {
			criteria.andEmailEqualTo(param);
		}
		
		
		List<User> list = myUserMapper.selectByExample(example);
		/*for (UserInfo userInfo : list) {
			System.out.println(userInfo.getusername());
			System.out.println(userInfo.getPhone());
			System.out.println(userInfo.getEmail());
		}*/
		if(list == null ||list.isEmpty()) {
			return MyResult.ok(true);
		}
		return MyResult.ok(false);
	}

	
	
}
