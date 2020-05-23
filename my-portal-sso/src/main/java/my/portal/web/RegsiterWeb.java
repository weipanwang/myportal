/**
 * 
 */
package my.portal.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 盼望
 * @date 2019年8月28日下午6:36:42
 */
@Controller
public class RegsiterWeb {


	@RequestMapping("/user/regsiter")
	public String regsiterweb() {
		
		return "regsiter";
	}
}
