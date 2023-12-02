package org.example.reflection.controller;

import org.example.reflection.annotation.Controller;
import org.example.reflection.annotation.RequestMapping;
import org.example.reflection.annotation.RequestMethod;

@Controller
public class MemberController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String join() {
        return "join";
    }

}
