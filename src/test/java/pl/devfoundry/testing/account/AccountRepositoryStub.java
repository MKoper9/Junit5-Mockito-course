package pl.devfoundry.testing.account;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class AccountRepositoryStub implements AccountRepository{


    @Override
    public List<Account> getAllAccounts() {
        Address address1 = new Address("Wolna","1");
        Account account1 = new Account(address1);

        Account account2 = new Account();

        Address address3 = new Address("Kościuszki","170");
        Account account3 = new Account(address1);

        return Arrays.asList(account1,account2,account3);


    }
}
