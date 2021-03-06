package pl.devfoundry.homework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UnitServiceTest {

    @Mock
    CargoRepository cargoRepository;
    @Mock
    UnitRepository unitRepository;
    @InjectMocks
    UnitService unitService;

    @Test
    void addCargoByName() {
        //given
        Unit unit = new Unit(new Coordinates(0, 0), 20, 20);
        Cargo cargo = new Cargo("masło", 5);

        given(cargoRepository.findCargoByName("masło")).willReturn(Optional.of(cargo));
        //when
        unitService.addCargoByName(unit, "masło");

        //then
        verify(cargoRepository).findCargoByName("masło");
        assertThat(unit.getLoad(), is(5));
        assertThat(unit.getCargo().get(0), equalTo(cargo));
    }

    @Test
    void shouldCargoThrowException() {
        //given
        Unit unit = new Unit(new Coordinates(0,0),10,10);
        Cargo cargo = new Cargo("masło", 9);

        given(cargoRepository.findCargoByName("masło")).willReturn(Optional.empty());

        //when
        //then
        assertThrows(NoSuchElementException.class, ()->unitService.addCargoByName(unit, "masło"));
    }
    @Test
    void shouldMethodGetUnitOnThrowException(){
        //given
        Coordinates coordinates = new Coordinates(0,0);
        given(unitRepository.getUnitByCoordinates(coordinates)).willReturn(null);
        //when
        //then
        assertThrows(NoSuchElementException.class,() -> unitService.getUnitOn(coordinates));

    }

    @Test
    void shouldMethodGetUnitReturnNewUnit(){
        //given

        Coordinates coordinates = new Coordinates(0,0);
        Unit unit = new Unit(coordinates,10,10);
        given(unitRepository.getUnitByCoordinates(coordinates)).willReturn(unit);
        //when
        Unit unitResult=unitService.getUnitOn(coordinates);
        //then
        verify(unitRepository).getUnitByCoordinates(coordinates);
        assertThat(unitResult,sameInstance(unit));
    }


}