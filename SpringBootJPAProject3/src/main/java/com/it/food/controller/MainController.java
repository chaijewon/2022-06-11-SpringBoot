package com.it.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.it.food.dao.*;
import com.it.food.entity.*;
@Controller
public class MainController {
   @Autowired
   private LocationDAO ldao;
   
   @Autowired
   private NatureDAO ndao;
	
   @GetMapping("/main")
   public String main_page(Model model)
   {
	   model.addAttribute("main_content", "food/list");
	   return "main";
   }
   @GetMapping("/location/list")
   public String location_list(Model model)
   {
	   List<LocationEntity> list=ldao.findAll();
	   model.addAttribute("list", list);
	   model.addAttribute("main_content", "location/list");
	   return "main";
   }
   @GetMapping("/nature/list")
   public String nature_list(Model model)
   {
	   List<NatureEntity> list=ndao.findAll();
	   model.addAttribute("list", list);
	   model.addAttribute("main_content", "nature/list");
	   return "main";
   }
}
