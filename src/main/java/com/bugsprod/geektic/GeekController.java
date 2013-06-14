package com.bugsprod.geektic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GeekController {

	@Autowired
	private GeekService gServ;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<String> inters = new ArrayList<String>();
		for (Interest inter : gServ.getAllInterest()) {
			inters.add("\"" + inter.toString() + "\"");
		}
		model.addAttribute("interests", inters);
		List<String> cities = new ArrayList<String>();
		for (City city : gServ.getAllCities()) {
			cities.add("\"" + city.toString() + "\"");
		}
		model.addAttribute("cities", cities);
		return "index";
	}

	@RequestMapping(value = "/geeks", method = RequestMethod.GET)
	public String list(ModelMap model) throws IOException {
		List<Geek> list = gServ.getAllGeeks();
		model.addAttribute("geeks", list);
		return "listGeeks";
	}

	@RequestMapping(value = "/searchGeeks", method = RequestMethod.GET)
	public String list(HttpServletRequest request, ModelMap model,
			HttpServletResponse response) throws IOException {
		List<Geek> list = gServ.findGeeks(request.getParameter("gender"),
				request.getParameter("centerOfInterest"),
				request.getParameter("cities"));
		if (request.getParameter("gender") == null) {
			model.addAttribute("gender", "false");
		}
		model.addAttribute("geeks", list);
		model.addAttribute("gender", request.getParameter("gender"));
		return "listGeeks";
	}

	@RequestMapping(value = "/detailsGeek", method = RequestMethod.GET)
	public String details(HttpServletRequest request, ModelMap model,
			HttpServletResponse response) throws IOException {
		Geek geek = gServ
				.findGeekById(Long.valueOf(request.getParameter("id")));
		model.addAttribute("geek", geek);
		return "detailsGeek";
	}

}
