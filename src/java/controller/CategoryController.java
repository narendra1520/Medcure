package controller;

import Dao.CategoryDao;
import Model.Category;
import Model.ListCategory;
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
public class CategoryController {

    @Autowired
    CategoryDao categoryDao;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String companypage(@ModelAttribute("formcat") Category category, Model model, HttpSession session) {

        if (session.getAttribute("login") != null) {
            List<Category> cat = categoryDao.getAllcategory();
            ListCategory list = new ListCategory(cat);

            if (cat != null) {
                model.addAttribute("categoryList", list);
                return "category";
            } else {
                return "home";
            }
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/category/delete/{ct}", method = RequestMethod.GET)
    public String deletect(@PathVariable int ct, @ModelAttribute("formcat") Category category, Model model, HttpSession session) {
        if (session.getAttribute("login") != null) {
            boolean d = categoryDao.deleteCategory(ct);
            System.out.println("deleted");
            return "redirect:/category";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String editcat(@ModelAttribute Category category, Model model, HttpSession session) {
        if (session.getAttribute("login") != null) {
            boolean d = categoryDao.addCategoory(category);
            System.out.println("added");
            return "redirect:/category";
        } else {
            return "redirect:/login";
        }
    }
}
