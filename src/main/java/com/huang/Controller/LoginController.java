package com.huang.Controller;
import com.huang.Bean.ResponseMessageBean;
import com.huang.Bean.User;
import com.huang.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.applet.AppletContext;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    ResponseMessageBean responseMessageBean;

    @RequestMapping(value = "/login")
    public String Login(String username, String password, Model model,HttpSession session){
        List<User> users = userService.selectUser(username,password);
        if (users.isEmpty()){
            //model.addAttribute("ResponseMessage",ResponseMessageBean.Handlefailure().addresponseData("msg","用户名或密码错误请重新输入"));
            model.addAttribute("MESSAGE","用户名或密码错误请重新输入");
            return "redirect:/index.jsp";
        }else {
            session.setAttribute("LOGIN_USER",users.get(0));
            return "list";
        }
    }
}
