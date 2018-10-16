package com.learn.mvc.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.learn.mvc.entities.Singer;
import com.learn.mvc.services.SingerService;
import com.learn.mvc.util.Message;
import com.learn.mvc.util.SingerGrid;
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
			HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, Locale locale,
			@RequestParam(value = "file", required = false) Part file) {
		logger.info("Creating singer");
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute("message",
					new Message("error", messageSource.getMessage("singer_save_fail", new Object[] {}, locale)));
			uiModel.addAttribute("singer", singer);
			return "singers/create";
		}
		uiModel.asMap().clear();
		redirectAttributes.addFlashAttribute("message",
				new Message("success", messageSource.getMessage("singer_save_success", new Object[] {}, locale)));

		logger.info("Singer id: " + singer.getId());

		// Process upload file
		if (file != null) {
			logger.info("File name: " + file.getName());
			logger.info("File size: " + file.getSize());
			logger.info("File content type: " + file.getContentType());
			byte[] fileContent = null;
			try {
				InputStream inputStream = file.getInputStream();
				if (inputStream == null)
					logger.info("File inputstream is null");
				fileContent = IOUtils.toByteArray(inputStream);
				singer.setPhoto(fileContent);
			} catch (IOException ex) {
				logger.error("Error saving uploaded file");
			}
			singer.setPhoto(fileContent);
		}

		singerService.save(singer);
		return "redirect:/singers/";
	}
	
	@GetMapping("/photo/{id}")
	@ResponseBody
	public	byte[]	downloadPhoto(@PathVariable	Long id) {
		Singer	singer	=	singerService.findById(id);
		
		if (singer.getPhoto() != null) {
			logger.info("Downloading photo for id: {} with size: {}", singer.getId(), singer.getPhoto().length);
		}
		return	singer.getPhoto();
	}
	

	@GetMapping(params = "form")
	public String createForm(Model uiModel) {
		Singer singer = new Singer();
		uiModel.addAttribute("singer", singer);
		return "singers/create";
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
	
	@ResponseBody
    @RequestMapping(value = "/listgrid", method = RequestMethod.GET, produces="application/json")
    public SingerGrid listGrid(@RequestParam(value = "page", required = false) Integer page,
                                @RequestParam(value = "rows", required = false) Integer rows,
                                @RequestParam(value = "sidx", required = false) String sortBy,
                                @RequestParam(value = "sord", required = false) String order) {

        logger.info("Listing singers for grid with page: {}, rows: {}", page, rows);
        logger.info("Listing singers for grid with sort: {}, order: {}", sortBy, order);

        // Process order by
        Sort sort = null;
        String orderBy = sortBy;
        if (orderBy != null && orderBy.equals("birthDateString"))
            orderBy = "birthDate";

        if (orderBy != null && order != null) {
            if (order.equals("desc")) {
                sort = new Sort(Sort.Direction.DESC, orderBy);
            } else
                sort = new Sort(Sort.Direction.ASC, orderBy);
        }

        // Constructs page request for current page
        // Note: page number for Spring Data JPA starts with 0, while jqGrid starts with 1
        PageRequest pageRequest = null;

        if (sort != null) {
            pageRequest =  PageRequest.of(page - 1, rows, sort);
        } else {
            pageRequest = PageRequest.of(page - 1, rows);
        }

        Page<Singer> singerPage = singerService.findAllByPage(pageRequest);

        // Construct the grid data that will return as JSON data
        SingerGrid singerGrid = new SingerGrid();

        singerGrid.setCurrentPage(singerPage.getNumber() + 1);
        singerGrid.setTotalPages(singerPage.getTotalPages());
        singerGrid.setTotalRecords(singerPage.getTotalElements());

        singerGrid.setSingerData(Lists.newArrayList(singerPage.iterator()));

        return singerGrid;
    }

}
