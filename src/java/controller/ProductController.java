package controller;

import Dao.ProductDao;
import Model.ListPorduct;
import Model.Product;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    ProductDao productDao;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String productpage(@ModelAttribute("formprd") Product product, Model model, HttpSession session) {
        if (session.getAttribute("login") != null) {
            List<Product> pro = productDao.getAllproduct();
            ListPorduct list = new ListPorduct(pro);

            List<String> cat = productDao.getcatgeory();
            List<String> com = productDao.getCompany();
            if (pro != null) {
                model.addAttribute("productsList", list);
                model.addAttribute("categoryList", cat);
                model.addAttribute("companyList", com);
                return "product";
            } else {
                return "home";
            }
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/product/delete/{pr}", method = RequestMethod.GET)
    public String deletePr(@PathVariable int pr, @ModelAttribute("formprd") Product product, Model model, HttpSession session) {
        if (session.getAttribute("login") != null) {
            boolean d = productDao.deleteProduct(pr);
            System.out.println("deleted");
            return "redirect:/product";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addprod(@ModelAttribute Product product, Model model, HttpSession session) {
        if (session.getAttribute("login") != null) {
            boolean d = productDao.addProduct(product);
            System.out.println("added");
            return "redirect:/product";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/editProduct", method = RequestMethod.POST)
    public String editprod(@ModelAttribute Product product, Model model, HttpSession session) {
        if (session.getAttribute("login") != null) {
            boolean d = productDao.updateProduct(product);
            System.out.println("editted");
            return "redirect:/product";
        } else {
            return "redirect:/login";
        }
    }
}
