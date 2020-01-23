package pl.devfoundry.testing;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class OrderBackupTest {

    private static OrderBackup orderBackup;

    //BeforeAll jest przed BefaorEach
    @BeforeAll //metody pod ta adnotacja musza byc statyczne
    static void setup() throws IOException {
        orderBackup=new OrderBackup();
        orderBackup.createFile();
    }

    @Tag("Fries")
    @Test
    void backupOrderWithOneMeal() throws IOException {
        //given
        Meal meal = new Meal(7,"Fries");
        Order order = new Order();
        order.addMealToOrder(meal);

        //when
        orderBackup.backupOrder(order);

        //then
        System.out.println("Order: "+order.toString()+" backed up.");

    }
    @AfterAll //AfterAll jest po AfterEach
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }

}
