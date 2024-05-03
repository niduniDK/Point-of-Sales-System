import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bill implements Serializable {
    private List<GroceryItem> items = new ArrayList<>();
    private double totalPrice = 0;
    private double totalDiscount = 0;
    private String date;
    private String time;
    private Customer customer;
    private String cashierName;
    private String branch;
    private static int billId = 0;
    private final int id;

    public Bill(String date, String time, String cashierName, String branch, Customer customer){
        this.date = date;
        this.time = time;
        this.cashierName = cashierName;
        this.branch = branch;
        this.customer = customer;
        billId++;
        id = billId;
    }

    public double calcTotal(){
        for(GroceryItem item : items){
            totalPrice += item.calculatePrice();
        }
        return totalPrice;
    }

    public double calcDiscount(){
        for(GroceryItem item: items){
            totalDiscount += item.getPrice() * item.getDiscount();
        }
        return totalDiscount;
    }

    public void addItems(GroceryItem item){
        items.add(item);
    }

    public void printBill(){
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tINCREDIBLES");
        System.out.println("==============================================================================================================");
        System.out.println("Cashier: "+ cashierName);

        if(customer.isRegistered()) System.out.println("Customer: "+ customer.getName());
        System.out.println();

        System.out.println("Item Code\t\t\t\t"+"Item Name\t\t\t\t"+"Unit Price\t\t\t\t"+"Quantity\t\t\t\t"+"Discount\t\t\t\t"+"Net Price\t\t\t\t");
        System.out.println();

        for(GroceryItem item: items) {
            System.out.println(item.getItemCode() + "\t\t\t\t\t" + item.getName() + "\t\t\t\t\t" + item.getPrice() + "\t\t\t\t\t" + item.getWeight() + "\t\t\t\t\t" + item.getDiscount() + "\t\t\t\t\t" + item.calculatePrice());
        }
        System.out.println();

        System.out.println("Total \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+this.calcTotal());
        System.out.println("Total Discount \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+this.calcDiscount());
        System.out.println();
        System.out.println(date);
        System.out.println(time);

        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\tThank You. Come again!!!!");
        System.out.println("=================================================================================================================");
    }

    public int getBillId(){
        return id;
    }
}