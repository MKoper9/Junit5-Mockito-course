package pl.devfoundry.testing;

public class Account {

    private boolean active;
    private Address deafaultDeliveryAddress;

    public Account() {
        this.active = false;
    }

    public Account(Address deafaultDeliveryAddress) {
        this.deafaultDeliveryAddress = deafaultDeliveryAddress;
        if(deafaultDeliveryAddress!=null){
            activate();
        }else {
            this.active=false;
        }
    }

    public void activate(){
        this.active=true;
    }
    public boolean isActive(){
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
}
