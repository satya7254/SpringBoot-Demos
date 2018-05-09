package com.satya.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.satya.springboot.config.ServerProperties;

@Controller
public class ServerPropertiesController{

	 @Autowired
	 private ServerProperties serverProperties;
	 
    @RequestMapping("/serverpro")
    public String home(Model model){
        model.addAttribute("serverproperties", serverProperties);
        return "serverpropertiesView";
    }

}
