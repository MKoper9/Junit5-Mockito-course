package pl.devfoundry.homework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void canUseIllegalexceptionInMethodMove(){
        //given
        Unit unit = new Unit(10);
        //when
        Exception exception = assertThrows(IllegalStateException.class,
                ()->unit.move(1,1));
        String exceptionMessage = exception.getMessage();
        //then
        assertTrue(exceptionMessage.contains("Unit cannot move that far"));
    }
    @Test
    void returnCoordinatesAfterMoveEquals20(){
        //given
        Unit unit = new Unit(30);
        //when
        unit.move(5,5);
        //then
        assertEquals(unit,20);
    }

}