package com.zp.web.controller;

import com.zp.web.mapper.TestPoMapper;
import com.zp.web.mapper.UserMapper;
import com.zp.web.po.TestPo;
import com.zp.web.po.User;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by Zhang Peng on 2016/9/26.
 */
@Controller
public class HomeController {

    private static Logger logger = Logger.getLogger(HomeController.class);

    @Autowired
    private UserMapper userDAO;
    @Autowired
    private TestPoMapper testDAO;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        logger.info("come in loginForm");
        model.addAttribute("user", new User());
        logger.info("loginForm");
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user")User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        logger.info("come in login");
        try {
            if (bindingResult.hasErrors()) {
                logger.info("bindingResult.hasErrors()");
                return "/login";
            }
            User user_db = userDAO.selectByName(user.getUserName());
            if(user_db != null && user_db.getPwd().equals(user.getPwd())){
                SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getUserName(), user.getPwd()));
                logger.info("登录成功！");
                return "/user";
            }
            redirectAttributes.addAttribute("message", "用户名或者密码错误！");
            logger.info("登录失败！");
            return "redirect:/login";
        } catch (AuthenticationException e) {
            redirectAttributes.addAttribute("message", "用户名或者密码错误！");
            logger.info("用户名或者密码错误！");
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(RedirectAttributes redirectAttributes) {
        SecurityUtils.getSubject().logout();
        redirectAttributes.addAttribute("message", "您已安全退出！");
        return "redirect:/login";
    }

    @RequestMapping(value = "/test")
    public String test(RedirectAttributes redirectAttribute){
        TestPo testPo = new TestPo();
        testPo.setParameter1("${parameter1}");
        testPo.setParameter2("${parameter2}");
        testPo.setParameter3("${parameter3}");
        testDAO.insert(testPo);
        return "";
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        return "/403";
    }

}
