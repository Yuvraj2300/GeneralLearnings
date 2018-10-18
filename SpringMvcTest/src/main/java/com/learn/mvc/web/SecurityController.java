package com.learn.mvc.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learn.mvc.util.Message;

@Controller
@RequestMapping("/security")
public class SecurityController {
	private final Logger logger = LoggerFactory.getLogger(SecurityController.class);

	@Autowired
	private MessageSource messageSource;

	@RequestMapping("/loginFail")
	public String loginFail(Model uiModel, Locale locale) {
		logger.info("Wrong login triggered.");
		uiModel.addAttribute("message",
				new Message("error", messageSource.getMessage("messaage_login_fail", new Object[] {}, locale)));
		return "singers/list";
	}
}
