package com.it.food.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
   @GetMapping("/main")
   public String main_page(Model model)
   {
	   model.addAttribute("main_content", "food/list");
	   return "main";
   }
   @GetMapping("/location/list")
   public String location_list(Model model)
   {
	   model.addAttribute("main_content", "location/list");
	   return "main";
   }
   @GetMapping("/nature/list")
   public String nature_list(Model model)
   {
	   model.addAttribute("main_content", "nature/list");
	   return "main";
   }
}
