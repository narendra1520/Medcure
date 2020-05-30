package Model;

import java.util.List;

public class ListCompany {
    List<Company> companies;

    public ListCompany(List<Company> companies) {
        this.companies = companies;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
    
}
