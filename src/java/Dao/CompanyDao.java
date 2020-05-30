package Dao;

import Model.Company;
import java.util.List;

public interface CompanyDao {
  List<Company> getAllcompany();
  Company getcompany(int id);
  boolean deleteCompany(int id);
  boolean updtaeCompany(Company company);
  boolean addCompany(Company company);
}
