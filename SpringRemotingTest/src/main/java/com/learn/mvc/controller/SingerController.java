package com.learn.mvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.learn.mvc.entities.Singer;
import com.learn.mvc.services.SingerService;

@Controller
@RequestMapping("/singers")
public class SingerController {
	final	Logger	logger	=	LoggerFactory.getLogger(SingerController.class);
	
	@Autowired
	private	SingerService	singerService;
	
	@ResponseStatus(HttpStatus.OK)
//	@GetMapping("/all")
	@ResponseBody
	public	List<Singer>	listAll(){
		return	singerService.findAll();
	}
}
