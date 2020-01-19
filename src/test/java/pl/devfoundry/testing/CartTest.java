package pl.devfoundry.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

@DisplayName("Test cases for Cart")
class CartTest {

    @Disabled //ignorowanie testu
    @Test
    @DisplayName("Cart is able to process 1000 orders in 60 ms")
    void simulateLargeOrder() {

        //given
        Cart cart = new Cart();
        //when
        //then
        assertTimeout(Duration.ofMillis(60), cart::simulateLargeOrder);
    }
}