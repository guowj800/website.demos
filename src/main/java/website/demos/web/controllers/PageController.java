package website.demos.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class PageController{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("admin-login")
	public String pageAdminLogin() {
		logger.info("Page AdminLogin.html");
		return "AdminLogin";
	}
	
	@RequestMapping("admin-control-panel")
	public String pageAdminControlPanel() {
		logger.info("Page AdminControlPanel.html");
		return "AdminControlPanel";
	}
	
	@RequestMapping("admin-cp-left")
	public String pageAdminCPLeft() {
		logger.info("Page pageAdminCPLeft.html");
		return "AdminCPLeft";
	}
	
	@RequestMapping("admin-cp-main")
	public String pageAdminCPMain() {
		logger.info("Page AdminCPMain.html");
		return "AdminCPMain";
	}
	
	@RequestMapping("rest")
	public String pageRest() {
		logger.info("Page rest.htm");
		return "rest";
	}

}
