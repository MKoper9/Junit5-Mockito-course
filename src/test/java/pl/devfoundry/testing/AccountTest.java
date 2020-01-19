package pl.devfoundry.testing;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AccountTest {

    @Test
    void newAccoundShoulddoNotActiveAfterCreation(){
        //given - wstepne zalozenia testu
        Account newAccount = new Account();
        //then - umieszczamy asercje
        assertFalse(newAccount.isActive(), "Check if new account is active");
        assertThat(newAccount.isActive(),equalTo(false));

    }

    @Test
    void accountShouldbeActiveAfterActivation(){
        //given
        Account newAccount = new Account();
        //when - wykonywane sa opercaje ktore chcemy przetestowac
        newAccount.activate();
        //then
        assertTrue(newAccount.isActive());
        assertThat(newAccount.isActive(),equalTo(true));
    }

    @Test
    void nowlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet(){
        //given
        Account account = new Account();

        //when
        Address address = account.getDeafaultDeliveryAddress();

        //then
        assertNull(address);
        assertThat(address,nullValue());
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
        assertThat(defaultAddress,is(notNullValue()));

    }

    @RepeatedTest(10)
    @Test
    void newAccountWithNotNullAddressShouldBeActive(){
        //given
        Address address = new Address("Wolna","1");

        //when
        Account account = new Account(address);

        //then
        //(warunek który musi być spełniony aby wykonałą się metoda testowa, metoda testowa)
        assumingThat(address!=null,() -> {
            assertTrue(account.isActive());
        });
    }
}

