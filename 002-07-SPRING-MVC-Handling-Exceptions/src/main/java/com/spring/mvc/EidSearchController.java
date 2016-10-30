package com.spring.mvc;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EidSearchController {

	final static Logger LOGGER = Logger.getLogger(EidSearchController.class);

	@Autowired
	private EidValidator eidValidator;

	@RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
	@ExceptionHandler({ EmployeeNotFoundException.class })
	public String searchEmployee(
			@ModelAttribute("eidSearchCommand") EidSearchCommand eidCommand,
			Errors errors, HttpServletRequest request, Model model) {
		System.out.println("Search Employee");
		LOGGER.info("inside searchEmployee");
		eidValidator.validate(eidCommand, errors);
		if (errors.hasErrors()) {
			LOGGER.info("has errors");
			System.out.println("validation error count: "
					+ errors.getErrorCount());
			return "eidsearch";
		}
		String eid = eidCommand.getEid();
		String result = "";
		System.out.println(eid);
		if (eid.equals("EMP-123") || eid.equals("EMP-999")) {
			EmployeeTO eto = new EmployeeTO();
			eto.setEid(eid);
			eto.setDpid("Development");
			eto.setEname("W. Manjit Singh");
			eto.setPhone("9972317648");
			eto.setEmail("manjitsinghwk@gmail.com");

			model.addAttribute("ETO", eto);

			result = "eidresults";
		} else {
			request.setAttribute("eidSearchCommand", eidCommand);
			throw new EmployeeNotFoundException(eid);
		}
		return result;
	}

	@RequestMapping(value = "/eidsearch")
	protected String showSearchPage(Map<String, EidSearchCommand> model)
			throws ServletException {
		System.out.println("show search page");
		EidSearchCommand eidCommand = new EidSearchCommand();
		model.put("eidSearchCommand", eidCommand);
		return "eidsearch";
	}
}
