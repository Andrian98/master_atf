package performance.upskilling.atf.api.dtos.response;


public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Address() {
    }

    public Address(String zipCode, String state, String city, String street) {
        this.zipCode = zipCode;
        this.state = state;
        this.city = city;
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }
}
