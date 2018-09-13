package com.learn.mvc.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.collect.Lists;
import com.learn.mvc.entities.Singer;
import com.learn.mvc.repo.SingerRepository;

@RequestMapping("/singers")
@Controller
public class SingerController {
	private final Logger logger = LoggerFactory.getLogger(SingerController.class);
	
	@Autowired
	private SingerRepository singerRep;
	
	private MessageSource messaageSource;

	@GetMapping
	public String list(Model uiModel) {
		logger.info("Listing singers");
		List<Singer> singers = Lists.newArrayList(singerRep.findAll());
		uiModel.addAttribute("singers", singers);

		return "singers/list";
	}
}
