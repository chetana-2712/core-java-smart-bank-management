package smartbankmanagement.model;

public class Customer {

    private int customerId;
    private String name;
    private String mobile;
    private String email;
    private String address;

    public Customer(int customerId, String name, String mobile, String email, String address) {
        this.customerId = customerId;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\nCustomer ID : " + customerId +
                "\nName : " + name +
                "\nMobile : " + mobile +
                "\nEmail : " + email +
                "\nAddress : " + address;
    }
}