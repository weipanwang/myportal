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
import my.portal.service.LogoutService;

/**
 * 退出账号
 * @author 盼望
 * @date 2019年8月23日下午9:40:41
 */
@Controller
public class LogoutController {

	@Autowired
	LogoutService logoutService;
	
	
	@RequestMapping("/user/logout/{token}")
	@ResponseBody
	public Object LogoutCon(@PathVariable String token) {
		try {
			MyResult result = logoutService.Logout(token);
			//支持jsonp
			/*if(!StringUtils.isEmpty(callback)) {
				MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
				mappingJacksonValue.setJsonpFunction(callback);
				return mappingJacksonValue;
			}*/
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return MyResult.build(400, ExceptionUtil.getStackTrace(e));
		}
	}
	
}
