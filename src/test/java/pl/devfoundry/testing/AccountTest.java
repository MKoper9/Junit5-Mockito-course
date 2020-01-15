package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void newAccoundShoulddoNotActiveAfterCreation(){
        //given - wstepne zalozenia testu
        Account newAccount = new Account();
        //then - umieszczamy asercje
        assertFalse(newAccount.isActive(), "Check if new account is active");
    }

    @Test
    void accountShouldbeActiveAfterActivation(){
        //given
        Account newAccount = new Account();
        //when - wykonywane sa opercaje ktore chcemy przetestowac
        newAccount.activate();
        //then
        assertTrue(newAccount.isActive());
    }

    @Test
    void nowlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet(){
        //given
        Account account = new Account();

        //when
        Address address = account.getDeafaultDeliveryAddress();

        //then
        assertNull(address);
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet(){
        //given
        Address address = new Address("Krakowska", "132");
        Account account = new Account();
        account.setDeafaultDeliveryAddress(address);

        //when
        Address defaultAddress = account.getDeafaultDeliveryAddress();

        //then
        assertNotNull(defaultAddress);
    }
}
