package pl.devfoundry.testing;

public class Account {

    private boolean active;
    private Address deafaultDeliveryAddress;
    private String email;

    public Account() {
        this.active = false;
    }

    public Account(Address deafaultDeliveryAddress) {
        this.deafaultDeliveryAddress = deafaultDeliveryAddress;
        if (deafaultDeliveryAddress != null) {
            activate();
        } else {
            this.active = false;
        }
    }


    public void activate() {
        this.active = true;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Address getDeafaultDeliveryAddress() {
        return deafaultDeliveryAddress;
    }

    public void setDeafaultDeliveryAddress(Address deafaultDeliveryAddress) {
        this.deafaultDeliveryAddress = deafaultDeliveryAddress;
    }

    public void setEmail(String email) {

        if (email.matches("^[A-Za-z0-9._%]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            this.email = email;
        }else{
            throw new IllegalArgumentException("Wrong email format");
        }
    }
}
