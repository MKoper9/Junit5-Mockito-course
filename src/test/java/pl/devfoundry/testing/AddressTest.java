package pl.devfoundry.testing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class AddressTest {

    @ParameterizedTest
    @CsvSource({"Sezamkowa, 10","Wolna, 1","'Romka, Tomka, Atomka',13"})
    void givenAdressesShouldNOtToBeEmptyAddHaveProperNames(String street, String number){
        assertThat(street, notNullValue());
        assertThat(street, containsString("a"));
        assertThat(number, notNullValue());
        assertThat(number.length(),lessThan(8));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/addresses.csv")
    void givenAdressesFromFileShouldNOtToBeEmptyAddHaveProperNames(String street, String number){
        assertThat(street, notNullValue());
        assertThat(street, containsString("a"));
        assertThat(number, notNullValue());
        assertThat(number.length(),lessThan(8));
    }
}
