/*
 * DemoController.java
 * Copyright 2016 Diligenta.
 * All rights reserved.
 *
 */
package test.HAndM.solution.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import test.HAndM.solution.DTO.SortedDataDetails;
import test.HAndM.solution.service.SortService;

/**
 * DemoController.java
 */

@Controller
public class SortController {
	@Autowired
	SortService sortService;

	public final static Logger LOGGER = LoggerFactory.getLogger(SortController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPageOne() {
		LOGGER.debug("Inside input page page Method....");
		return "input-page";
	}

	@RequestMapping(value = "/backBtn", method = RequestMethod.POST)
	public String backToLogin() {
		LOGGER.debug("Inside backToLogin Method....");
		return "input-data-page";
	}

	@RequestMapping(value = "/sortData", method = RequestMethod.POST)
	public ModelAndView sortTheData(@RequestParam("inputData") final String inputData, final Model model) {
		LOGGER.debug("Inside sort input page Method....");
		LOGGER.debug("input data received :{}", inputData);
		SortedDataDetails sortedData;
		sortedData = sortService.sortNumbers(inputData);
		// details.setInputVal("12 34 2 1");
		// details.setSortedVal("1 2 3 4");
		// sortService.save(details);
		LOGGER.debug("sored data :{}", sortedData.toString());
		model.addAttribute("success", "true");
		model.addAttribute("details", sortedData);
		// return "input-data-page";
		return new ModelAndView("/sorted-output");
	}

	@RequestMapping(value = "/persistData", method = RequestMethod.POST)
	public String persistTheData(@RequestParam("inputData") final String inputData,
			@RequestParam("sortedData") final String sortedData, final Model model) {
		LOGGER.debug("Inside persistTheData Method....");
		LOGGER.debug("data received to save:input data{}, sorted data:{}", inputData, sortedData);
		// model.addAttribute("sortedData", inputData);
		final SortedDataDetails details = new SortedDataDetails();
		// details.setInputVal("12 34 2 1");
		// details.setSortedVal("1 2 3 4");
		details.setInputVal(inputData);
		details.setSortedVal(sortedData);
		sortService.save(details);
		model.addAttribute("save-success", "true");
		model.addAttribute("details", details);
		// return "input-data-page";
		return "sorted-output";
	}

	@RequestMapping(value = "showData", method = RequestMethod.POST)
	public String showTheData(final Model model) {
		LOGGER.debug("Inside showTheData page Method....");

		List<SortedDataDetails> showList;
		// showList = new ArrayList<>();
		// for (int i = 0; i < 5; i++) {
		// final SortedDataDetails details = new SortedDataDetails();
		// details.setDetailsId(i);
		// details.setInputVal("input " + i);
		// details.setSortedVal("sorted " + i);
		// showList.add(details);
		// }

		showList = sortService.getAllSavedEntries();
		LOGGER.debug("atad received list size :{}", showList.size());
		model.addAttribute("sortedDataList", showList);

		return "show-data-page";
	}

}
