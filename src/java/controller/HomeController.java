package controller;

import Dao.ProductDao;
import Model.ListPorduct;
import Model.Product;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    ProductDao productDao;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homepage(Model model, HttpSession session) {

        if (session.getAttribute("login") != null) {
            List<Product> pro = productDao.getAllproduct();
            ListPorduct list = new ListPorduct(pro);
            model.addAttribute("productsList", list);
            return "home";
        } else {
            return "redirect:/login";
        }
    }
}
