package pl.devfoundry.testing.cart;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.devfoundry.testing.Meal;
import pl.devfoundry.testing.cart.Cart;
import pl.devfoundry.testing.order.Order;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
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

    @Test
    void cartShouldNotToBeEpmtyAfterAddingOrderToCard(){
        //given
        Order order = new Order();
        Cart cart = new Cart();

        //when
        cart.addOrderToCart(order);

        //then
        //jeden warunek jest spelniony
        assertThat(cart.getOrders(), anyOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        //wszyttkie warunki sa spelnione
        assertThat(cart.getOrders(), allOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        //musza byc spelnione wszystkie warunki
        assertAll("Thisis a group of assertions for cart",
          () -> assertThat(cart.getOrders(), notNullValue()),
          () -> assertThat(cart.getOrders(),hasSize(1)),
          () -> assertThat(cart.getOrders(),is(not(empty()))),
          () -> assertThat(cart.getOrders(),is(not(emptyCollectionOf(Order.class)))),
          () -> {
              List<Meal>mealList=cart.getOrders().get(0).getMeals();
            assertThat(cart.getOrders().get(0).getMeals(),empty());}
        );
    }
}