package Model;

import java.util.List;

public class ListPorduct {
    List<Product> products;

    public ListPorduct(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
}
