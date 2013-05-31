package com.bugsprod.geektic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GeekController {
	
	@Autowired
	private GeekService gServ;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(ModelMap model){
		return "index";
	}
	
	@RequestMapping(value="/geeks", method=RequestMethod.GET)
	public String list(ModelMap model){
		List<Geek> list = gServ.getAllGeeks();
		model.addAttribute("geeks", list);
		return "listGeeks";
	}
	
	@RequestMapping(value="/geeksTest", method=RequestMethod.GET)
	public String listTest(ModelMap model){
		List<Geek> list = gServ.searchGeeks(true, "java", null);
		//List<Geek> list = gServ.searchGeeksByGender(true);
		model.addAttribute("geeks", list);
		return "listGeeks";
	}

}
