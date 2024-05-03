public class ItemCodeNotFoundException extends Exception{
    public ItemCodeNotFoundException(String message){
        super(message);
        System.out.println(message);
    }
}