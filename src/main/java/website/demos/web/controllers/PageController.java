package website.demos.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("page")
public class PageController{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("admin-login")
	public String pageAdminLogin() {
		logger.info("Page AdminLogin.htm");
		
		return "AdminLogin";
	}
	
	@RequestMapping("rest")
	public String pageRest() {
		logger.info("Page rest.htm");
		
		return "rest";
	}

}
