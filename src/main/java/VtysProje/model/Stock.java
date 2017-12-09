package VtysProje.model;

/**
 * Created by 12043 on 9.12.2017
 * part of project vtysProje
 */

public class Stock {
    private int id;
    private String name;
    private int productId;
    private int quantity;
    private int unitPrice;

    private Product product;

    public Stock() {
    }

    public Stock(int id, String name, int productId, int quantity, int unitPrice, Product product) {
        this.id = id;
        this.name = name;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
