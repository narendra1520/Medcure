package Model;

public class Product {

//  @NotEmpty(message="reuired")
  private String productname;
  private int id;
//  @Size(min=6,max=15,message = "Size not matched")
  private float priceperunit;
  private String company;
  private String category;
  private int quantity;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPriceperunit() {
        return priceperunit;
    }

    public void setPriceperunit(float priceperunit) {
        this.priceperunit = priceperunit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
  
    
  
}
