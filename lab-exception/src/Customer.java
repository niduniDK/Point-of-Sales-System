import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private boolean isRegistered;

    public Customer(String name){
        this.name = name;
        isRegistered = true;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public String getName() {
        return name;
    }
}
