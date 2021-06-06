package com.dateupdate.com.springmvc.web;

import com.dateupdate.com.springmvc.model.Other;
import com.dateupdate.com.springmvc.service.api.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OtherHandler {

    @Autowired
    private OtherService otherService;

    @RequestMapping(value = "/user/gettjh/about/time" )
    @ResponseBody
    public List<Other> gettjh(
            @RequestParam( "timestart" ) String timestart,
            @RequestParam("timeout") String timeout){
        if (timestart == null || "".equals(timestart) || " ".equals(timestart) || timeout == null || "".equals(timeout) || " ".equals(timeout)){
            return null;
        }
        List<Other> a  = otherService.gettjh(timestart,timeout);
        return a;
    }

}
