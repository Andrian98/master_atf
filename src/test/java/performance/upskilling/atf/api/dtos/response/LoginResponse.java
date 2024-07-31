package performance.upskilling.atf.api.dtos.response;


public class LoginResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String ssn;
    private Address address;

    // Default constructor
    public LoginResponse() {
    }

    public LoginResponse(Address address, String ssn, String phoneNumber, String lastName, String firstName, int id) {
        this.address = address;
        this.ssn = ssn;
        this.phoneNumber = phoneNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSsn() {
        return ssn;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }


}
