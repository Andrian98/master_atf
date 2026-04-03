package performance.upskilling.atf.api.dtos.response;

//TODO Before going to assessment remove all the comments and the unused code
public class UserResponse {
    private int id;
    private double balance;
    private String type;
    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }


    @Override
    public String toString() {
        return "User Response" +
                " id: " + id
                + ", balance: " + balance
                + ", type: " + type
                + ", customerId: " + customerId;
    }
}
