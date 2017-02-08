package com.zp.web.controller;

import com.zp.web.mapper.UserMapper;
import com.zp.web.po.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Zhang Peng on 2016/9/26.
 */
@Controller
public class UserControler {
    private static Logger logger = Logger.getLogger(UserControler.class);
    @Autowired
    private UserMapper userDAO;

    @RequestMapping("/user/showUser")
    public String toIndex(HttpServletRequest request,Model model){
        Long userId = Long.parseLong(request.getParameter("id"));
        User user = userDAO.selectByPrimaryKey(userId);
        model.addAttribute("user", user);
        return "showUser";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "";
    }
    @RequestMapping("/user/del")
    public String del(){
        return "";
    }
    @RequestMapping("/user/edit")
    public String edit(){
        return "";
    }
    @RequestMapping("/user/query")
    public String query(){
        return "";
    }
}
