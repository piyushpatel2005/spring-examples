package com.piyushpatel2005.boottest.controllers;

import com.piyushpatel2005.boottest.domains.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @RequestMapping("add")
    public String toAdd(User user) {
        int num = 10 / 0;
        return "add";
    }

    @RequestMapping("update")
    public String update() {
        String name = null;
        name = name.toLowerCase(); // throws NullPointerException
        return "update";
    }

//    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
//    public ModelAndView handleArithmeticException(Exception e) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("exception", e.toString());
//        modelAndView.setViewName("mathError");
//        return modelAndView;
//    }
//
//    @ExceptionHandler(value = {java.lang.NullPointerException.class})
//    public ModelAndView handleNullPointerException(Exception e) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("exception", e.toString());
//        modelAndView.setViewName("nullPointerError");
//        return modelAndView;
//    }

    @RequestMapping("addUser")
    public String add(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }
        System.out.println("Save user = " + user);
        return "success";
    }
}
