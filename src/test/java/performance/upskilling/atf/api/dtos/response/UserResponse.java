package performance.upskilling.atf.api.dtos.response;


public class UserResponse {
    private String id;
    private String balance;
    private String type;
    private String customerId;

    public UserResponse() {
    }

    public UserResponse(String id, String balance, String type, String customerId) {
        this.id = id;
        this.balance = balance;
        this.type = type;
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
