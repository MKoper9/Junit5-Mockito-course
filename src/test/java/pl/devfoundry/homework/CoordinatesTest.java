package pl.devfoundry.homework;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;

import javax.lang.model.type.ExecutableType;
import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {



    @Test
    void ReturnIllegalArgumentExceptionIfValuesAreLessThan0()
    {
        //given
        Coordinates coordinates = new Coordinates(-10,10);
        //when
        //then
        Exception exception=assertThrows(IllegalArgumentException.class,()->{coordinates.getX(); coordinates.getY();});


        String exceptedMessege = "Position can not be less than 0";
        assertTrue(exception.getMessage().contains(exceptedMessege));
    }

    @Test
    void sumOfMethodCopyCanBeEquals20()
    {
        //given
        Coordinates coordinates = new Coordinates(10,10);

        Coordinates coordinates1=Coordinates.copy(coordinates, 10, 10);
        //when
        assertEquals(coordinates.getX()+10,coordinates1.getX());
        assertEquals(coordinates.getY()+10,coordinates1.getY());
    }
    @Test
    void sumOfMethodCopyCannotBeEquals20()
    {
        //given
        Coordinates coordinates = new Coordinates(8,8);

        Coordinates coordinates1=Coordinates.copy(coordinates, 10, 10);
        //when
        assertNotEquals(coordinates.getX(),coordinates1.getX());
        assertNotEquals(coordinates.getY(),coordinates1.getY());
    }



}