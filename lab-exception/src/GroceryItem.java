import java.io.Serializable;

public class GroceryItem implements Serializable {
    private double weight;
    private double price;
    private double discount;
    private String itemCode;
    private String name;
    private String dateOfManufacture;
    private String dateOfExpiry;

    public GroceryItem(String itemCode,String name, double price,double discount, double weight,String dateOfManufacture, String dateOfExpiry){
        this.itemCode = itemCode;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.weight = weight;
        this.dateOfManufacture = dateOfManufacture;
        this.dateOfExpiry = dateOfExpiry;
    }

    public double calculatePrice(){
        return price * (1-discount);
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getName() {
        return name;
    }

    public double getDiscount() {
        return discount;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setDateOfExpiry(String dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public void setDiscount(double discount) {
        if(discount>0 && discount<1) this.discount = discount;
        else this.discount = 0.1;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}