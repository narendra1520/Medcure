package controller;

import Dao.CompanyDao;
import Model.Company;
import Model.ListCompany;
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
public class CompanyController {

    @Autowired
    CompanyDao companyDao;

    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public String companypage(@ModelAttribute("formcom") Company company, Model model, HttpSession session) {
        if (session.getAttribute("login") != null) {
            List<Company> com = companyDao.getAllcompany();
            ListCompany list = new ListCompany(com);

            if (com != null) {
                model.addAttribute("companyList", list);
                return "company";
            } else {
                return "home";
            }
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/company/delete/{cm}", method = RequestMethod.GET)
    public String deletecm(@PathVariable int cm, @ModelAttribute("formcom") Company company, Model model, HttpSession session) {
        if (session.getAttribute("login") != null) {
            boolean d = companyDao.deleteCompany(cm);
            System.out.println("deleted");
            return "redirect:/company";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/addCompany", method = RequestMethod.POST)
    public String addcom(@ModelAttribute Company company, Model model, HttpSession session) {
        if (session.getAttribute("login") != null) {
            boolean d = companyDao.addCompany(company);
            System.out.println("added");
            return "redirect:/company";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/editCompany", method = RequestMethod.POST)
    public String editcom(@ModelAttribute Company company, Model model, HttpSession session) {
        if (session.getAttribute("login") != null) {
            boolean d = companyDao.updtaeCompany(company);
            System.out.println("editted");
            return "redirect:/company";
        } else {
            return "redirect:/login";
        }
    }
}
