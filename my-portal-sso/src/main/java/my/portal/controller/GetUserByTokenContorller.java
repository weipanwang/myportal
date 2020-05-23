/**
 * 
 */
package my.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import my.portal.common.ExceptionUtil;
import my.portal.common.MyResult;
import my.portal.service.GetUserByToken;

/**
 * 根据token查询用户信息
 * @author 盼望
 * @date 2019年8月23日下午9:12:34
 */
@Controller
public class GetUserByTokenContorller {

	@Autowired
	private GetUserByToken getUserByToken;
	
	@RequestMapping("/user/token/{token}")
	@ResponseBody
	public Object getUserByToken(@PathVariable String token,String callback) {
		try {
			MyResult result = getUserByToken.getUserByToken(token);
			//支持jsonp
			if(!StringUtils.isEmpty(callback)) {
				MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
				mappingJacksonValue.setJsonpFunction(callback);
				return mappingJacksonValue;
			}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return MyResult.build(400, ExceptionUtil.getStackTrace(e));
		}
	}
}
