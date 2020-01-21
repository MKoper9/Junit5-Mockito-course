package pl.devfoundry.homework;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {


    @Test
    void throwIllegalArgumentWhenXMoreThan100() {

        //given, when, then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(101, 0));
    }

    @Test
    void throwIllegalArgumentWhenYMoreThan100() {

        //given, when, then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(0, 101));
    }

    @Test
    void throwIllegalArgumentWhenXLessThan0() {

        //given, when, then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(-1, 0));
    }

    @Test
    void throwIllegalArgumentWhenYLessThan0() {

        //given, when, then
        assertThrows(IllegalArgumentException.class, () -> new Coordinates(0, -1));
    }

    @Test
    void copyShouldReturnObject() {

        //given
        Coordinates coordinates = new Coordinates(0,0);
        //when
        Coordinates copy=Coordinates.copy(coordinates,0,0);
        //then
        assertThat(copy, not(sameInstance(coordinates)));
        assertThat(copy, equalTo(coordinates));

    }

    @Test
    void IsCopyMethodShouldReturnAllCoordinates(){
        //given
        Coordinates coordinates = new Coordinates(0,0);
        //when
        Coordinates copy = Coordinates.copy(coordinates,10,12);
        //then
        assertThat(copy.getX(), is(10));
        assertThat(copy.getY(), is(12));
    }




}