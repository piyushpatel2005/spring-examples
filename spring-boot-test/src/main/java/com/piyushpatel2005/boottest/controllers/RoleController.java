package com.piyushpatel2005.boottest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoleController {
    @RequestMapping("/roleadd")
    public String add() {
        int num = 10 / 0;
        return "add";
    }
}
