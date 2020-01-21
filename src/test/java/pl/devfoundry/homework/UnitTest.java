package pl.devfoundry.homework;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UnitTest {

    @Test
    void unitCannotMoveWithoutFuel(){
        //given
        Unit unit = new Unit(new Coordinates(0,0),10,10);
        //when
        //then
        assertThrows(IllegalStateException.class,()->unit.move(10,10));
    }

    @Test
    void moveMethodReturnObject(){
        //given
        Unit unit = new Unit(new Coordinates(10,10),100,10);
        //when
        //then
        assertThat(unit, not(sameInstance(unit.move(10,10))));
    }
    @Test
    void unitLoseFuelWhenItIsMoving(){
        //given
        Unit unit = new Unit(new Coordinates(0,0),100,10);
        //when
        unit.move(10,10);
        //then
        assertEquals(unit.getFuel(),80);
    }
    @Test
    void unitShouldReturnNewCoordinates(){
        //given
        Unit unit = new Unit(new Coordinates(0,0),10,10);
        //when
        Coordinates newCoordinates = unit.move(2,2);
        //then
        assertThat(newCoordinates,equalTo(new Coordinates(2,2)));
    }

    @Test
    void unitCannotTankFuelAboveMax(){
        //given
        Unit unit = new Unit(new Coordinates(0,0),100,10);
        //when
        unit.tankUp();
        //then
        assertThat(unit.getFuel(), is(100));
    }
    @Test
    void unitCannotLoadCargoAboveMax(){
        //given
        Unit unit = new Unit(new Coordinates(0,0),10,10);
        //when
        //then
        assertThrows(IllegalStateException.class,()->unit.loadCargo(new Cargo("Kartofle",11)));
    }
    @Test
    void unitCanLoadCargo(){
        //given
        Unit unit = new Unit(new Coordinates(0,0),10,10);
        //when
        Cargo cargo = new Cargo("Bulki", 5);
        unit.loadCargo(cargo);
        //then
        assertEquals(unit.getLoad(),5);
    }
    @Test
    void unitCanUnloadCargo(){
        //given
        Unit unit = new Unit(new Coordinates(0,0),10,10);
        //when
        Cargo cargo = new Cargo("Bulki", 5);
        Cargo cargo1 = new Cargo("Drzewo", 2);
        unit.loadCargo(cargo);
        unit.loadCargo(cargo1);
        unit.unloadCargo(cargo);
        //then
        assertEquals(unit.getLoad(),2);
    }
    @Test
    void unitCanUnloadAllCargo(){
        //given
        Unit unit = new Unit(new Coordinates(0,0),10,10);
        //when
        Cargo cargo = new Cargo("Bulki", 5);
        Cargo cargo1 = new Cargo("Drzewo", 2);
        unit.loadCargo(cargo);
        unit.loadCargo(cargo1);
        unit.unloadAllCargo();
        //then
        assertThat(unit.getLoad(),is(0));
    }







}