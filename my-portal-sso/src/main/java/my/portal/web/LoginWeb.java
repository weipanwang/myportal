/**
 * 
 */
package my.portal.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 盼望
 * @date 2019年8月28日下午6:34:12
 */
@Controller
public class LoginWeb {

	
	@RequestMapping("/user/login")
	public String loginweb() {
		
		return "newlogin";
	}
	
}
