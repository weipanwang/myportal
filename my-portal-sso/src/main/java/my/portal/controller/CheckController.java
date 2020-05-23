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
import my.portal.service.CheckData;

/**
 * @author 盼望
 * @date 2019年8月23日下午7:07:01
 */
@Controller
@RequestMapping("/user")
public class CheckController {

	@Autowired
	CheckData  checkData;
	
	@RequestMapping("/check/{param}/{type}")
	@ResponseBody
	public Object Checkdata(@PathVariable String param,
			@PathVariable Integer type,String callback){
			//System.out.println("接收到了请求！");
		try {
			MyResult result = checkData.checkData(param, type);
			if(StringUtils.isEmpty(callback)) {
				MappingJacksonValue jacksonValue = new MappingJacksonValue(result);
				jacksonValue.setJsonpFunction(callback);
				return jacksonValue;
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return MyResult.build(500, ExceptionUtil.getStackTrace(e),"查询数据错误");
			}
		}
	
}
