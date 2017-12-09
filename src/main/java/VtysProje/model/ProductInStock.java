package VtysProje.model;

/**
 * Created by 12043 on 9.12.2017
 * part of project vtysProje
 */

public class ProductInStock {
    private int id;
    private int product_id;
    private int serialNumber;
    private boolean defectiveStatus;

    public ProductInStock() {
    }

    public ProductInStock(int id, int product_id, int serialNumber, boolean defectiveStatus) {
        this.id = id;
        this.product_id = product_id;
        this.serialNumber = serialNumber;
        this.defectiveStatus = defectiveStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isDefectiveStatus() {
        return defectiveStatus;
    }

    public void setDefectiveStatus(boolean defectiveStatus) {
        this.defectiveStatus = defectiveStatus;
    }
}
