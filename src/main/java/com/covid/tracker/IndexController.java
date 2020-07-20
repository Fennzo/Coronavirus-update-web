package com.covid.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController implements Runnable {

	@Autowired
	private WebScrap webscrap;

	@RequestMapping(value = "/")
	public String printTable(ModelMap model) throws InterruptedException {
		Thread alldata = new Thread(() -> {
			model.addAttribute("alldata", webscrap.getAllData());
		});
		alldata.start();
		Thread worldCases = new Thread(() -> {
			model.addAttribute("worldCases", webscrap.getWorldCases());
		});
		worldCases.start();
		Thread worldDeaths = new Thread(() -> {
			model.addAttribute("worldDeaths", webscrap.getWorldDeaths());
		});
		worldDeaths.start();
		Thread worldPop = new Thread(() -> {
			model.addAttribute("worldPop", webscrap.getWorldPop());
		});
		worldPop.start();

		alldata.join();
		worldCases.join();
		worldDeaths.join();
		worldPop.join();

		return "index";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
