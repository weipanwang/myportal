/**
 * 
 */
package my.portal.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 盼望
 * @date 2019年8月28日下午6:39:07
 */
@Controller
public class HomeWeb {
	
	@RequestMapping("/home")
	public String homeweb() {
		return "home";
	}
}
