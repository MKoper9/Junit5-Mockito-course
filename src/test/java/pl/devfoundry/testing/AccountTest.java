package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
