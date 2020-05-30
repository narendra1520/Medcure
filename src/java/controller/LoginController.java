package controller;

import Dao.UserDao;
import Model.Login;
import Model.User;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    UserDao userdao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginpage(@ModelAttribute("formLog") Login login) {
        return "index";
    }

    @RequestMapping(value = "/loginProc", method = RequestMethod.POST)
    public String loginProcess(@ModelAttribute("formLog") Login login, HttpSession session, BindingResult br) {
        User user = userdao.validateUser(login);
        if (user == null) {
            br.rejectValue("username","2","username or password may wrong");
            return "index";
        } else {
            session.setAttribute("login", user.getName());
            return "redirect:/home";
        }
    }
}
