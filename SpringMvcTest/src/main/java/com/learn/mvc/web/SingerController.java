package com.learn.mvc.web;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learn.mvc.entities.Singer;
import com.learn.mvc.services.SingerService;
import com.learn.mvc.util.Message;
import com.learn.mvc.util.UrlUtils;;

@RequestMapping("/singers")
@Controller
public class SingerController {
	private final Logger logger = LoggerFactory.getLogger(SingerController.class);

	@Autowired
	private SingerService singerService;

	@Autowired
	private MessageSource messageSource;

	@PostMapping
	public String create(@Valid Singer singer, BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest, Locale locale, RedirectAttributes redirectAttribute) {
		logger.info("Creating	singer");
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute("message",
					new Message("error", messageSource.getMessage("singer_save_fail", new Object[] {}, locale)));
			uiModel.addAttribute("singer", singer);
			return "singers/create";
		}
		uiModel.asMap().clear();

		redirectAttribute.addFlashAttribute("message",
				new Message("success", messageSource.getMessage("singer_save_success", new Object[] {}, locale)));
		logger.info("Singer	id:" + singer.getId());
		singerService.save(singer);
		return "redirect:/singers/";
	}

	@GetMapping(params = "form")
	public String createForm(Model uiModel) {
		Singer singer = new Singer();
		uiModel.addAttribute("singer", singer);
		return "redirect:/singers/";
	}

	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model uiModel) {
		Singer singer = singerService.findById(id);
		uiModel.addAttribute("singer", singer);
		return "singers/show";
	}

	@PostMapping(path = "/{id}", params = "form")
	public String update(@Valid Singer singer, BindingResult bindingResult, Model uiModel,
			HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, Locale locale) {
		logger.info("Updating singer");
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute("message",
					new Message("error", messageSource.getMessage("singer_save_fail", new Object[] {}, locale)));
			uiModel.addAttribute("singer", singer);
			return "singers/update";
		}
		uiModel.asMap().clear();
		redirectAttributes.addFlashAttribute("message",
				new Message("success", messageSource.getMessage("singer_save_success", new Object[] {}, locale)));
		singerService.save(singer);
		return "redirect:/singers/" + UrlUtils.encodeUrlPathSegment(singer.getId().toString(), httpServletRequest);
	}

	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model uiModel) {
		uiModel.addAttribute("singer", singerService.findById(id));
		return "singers/update";
	}

	@DeleteMapping("/{id}")
	public String deleteSinger(@PathVariable("id") Long id, Model uiModel, HttpServletRequest httpServletRequest,
			Locale locale) {
		Singer	singer	=	singerService.findById(id);
		singerService.delete(singer);
		return	"redirect:/singers/list";
	}

	@GetMapping
	public String list(Model uiModel) {
		logger.info("Listing singers");
		List<Singer> singers = singerService.findAll();
		uiModel.addAttribute("singers", singers);

		return "singers/list";
	}
}
