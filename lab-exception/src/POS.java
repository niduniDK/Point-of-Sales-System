import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class POS {
    static Map<String,GroceryItem> itemMap = new HashMap<>();
    static ArrayList<String> itemCodes = new ArrayList<>();
    static ArrayList<Bill> bills = new ArrayList<>();

    public static void getItems(Bill bill) throws ItemCodeNotFoundException{
        Scanner sc1 = new Scanner(System.in);
        String itemcode = "00";
        while(!itemcode.equals( "-1")){
            System.out.println("Enter the item code(If all the items has been added enter -1): ");
            itemcode = sc1.nextLine();
            if(itemcode.equals("-1")) break;
            else if(!itemCodes.contains(itemcode)) throw new ItemCodeNotFoundException("Invalid item code");
            else bill.addItems(itemMap.get(itemcode));
        }
    }

    public static void main(String[] args) {
        GroceryItem item1 = new GroceryItem("001A","sugar",400,0.1,1,"2024-04-14","2024-12-24");
        itemMap.put("001A",item1); itemCodes.add("001A");
        GroceryItem item2 = new GroceryItem("002B","rice",180,0.1,1,"2024-04-14","2024-12-24");
        itemMap.put("002B",item2); itemCodes.add("002B");
        GroceryItem item3 = new GroceryItem("003C","oil",300,0.15,1,"2024-04-14","2024-12-24");
        itemMap.put("003C",item3); itemCodes.add("003C");
        GroceryItem item4 = new GroceryItem("004D","biscuit",500,0.2,400,"2024-04-14","2024-12-24");
        itemMap.put("004D",item4); itemCodes.add("004D");
        GroceryItem item5 = new GroceryItem("005E","cheese",600,0.1,200,"2024-04-14","2024-12-24");
        itemMap.put("005E",item5); itemCodes.add("005E");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the date: ");
        String date = sc.nextLine();
        System.out.println("Enter the branch: ");
        String branch = sc.nextLine();
        System.out.println("Enter cashier name: ");
        String cashier = sc.nextLine();

        int option = 0;
        try{
            FileOutputStream fout = new FileOutputStream("Bill.ser");
            ObjectOutputStream os = new ObjectOutputStream(fout);

            FileInputStream fin = new FileInputStream("Bill.ser");
            ObjectInputStream osIn = new ObjectInputStream(fin);

            while(option != -1){
                System.out.println("Enter the time: ");
                String time = sc.next();
                System.out.println("New bill or a pending bill? \n1.New Bill\n2.Pending Bill\nEnter -1 to quit the system");
                option = sc.nextInt();

                if(option==1){
                    System.out.println("Enter customer's name: ");
                    String customername = sc.next();
                    Customer customer = new Customer(customername);
                    Bill bill = new Bill(date, time, cashier, branch, customer);
                    try{
                        getItems(bill);
                    }catch(ItemCodeNotFoundException e){
                    }
                    bill.printBill();

                    try{
                        os.writeObject(bill);

                    }catch(Exception e){
                        //e.printStackTrace();
                    }

                }

                else if(option==2) {
                    try {
                        Object bill1 = osIn.readObject();
                        while(bill1 instanceof Bill){
                            bills.add((Bill) bill1);
                            bill1 = osIn.readObject();
                        }
                    }catch(Exception e){
                        //e.printStackTrace();
                    }

                    System.out.println("Enter bill id: ");
                    int billId = sc.nextInt();
                    boolean billFound = false;
                    for(Bill bill:bills){
                        if(billId == bill.getBillId()){
                            try{
                                getItems(bill);
                            }catch(ItemCodeNotFoundException e){

                            }
                            bill.printBill();
                            billFound = true;
                            break;
                        }
                    }
                    if(!billFound) System.out.println("Invalid bill id.");
                }

            }
            os.close();
            osIn.close();
        }catch(Exception e){

        }
    }
}