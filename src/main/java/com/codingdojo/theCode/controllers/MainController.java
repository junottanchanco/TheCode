package com.codingdojo.theCode.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class MainController {
	@RequestMapping("")
	public String index(HttpSession session, @ModelAttribute("error") String error) {
		session.setAttribute("error", error);
		session.setAttribute("correct", "false");
		return "index.jsp";
	}
	@RequestMapping(path="", method=RequestMethod.POST)
	public String guess(HttpSession session, @RequestParam("guess") String guess, RedirectAttributes redirectAttributes) {
		if(guess.equals("bushido")) {
			session.removeAttribute("error");
			session.setAttribute("correct", "true");
			return "redirect:/theCode";
		}else {
			redirectAttributes.addFlashAttribute("error", "Magensayo ka nang mas mabuti!");
			return "redirect:/";
		}
	}
	@RequestMapping("/theCode")
	public String correct(HttpSession session, RedirectAttributes redirectAttributes) {
		System.out.println(session.getAttribute("error"));
		if(session.getAttribute("correct") == "true") {
			return "code.jsp";
		}else {
			redirectAttributes.addFlashAttribute("error", "NO CODE NO ENTRY!");
			return "redirect:/";
		}
	}
}
