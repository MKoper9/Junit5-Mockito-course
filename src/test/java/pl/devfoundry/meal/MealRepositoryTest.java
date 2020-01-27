package pl.devfoundry.meal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.devfoundry.meal.Meal;
import pl.devfoundry.meal.MealRepository;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;


public class MealRepositoryTest {


    MealRepository mealRepository = new MealRepository();

    @BeforeEach
    void cleanUp() {
        mealRepository.getAllMeals().clear();
    }

    @Test
    void shouldBeAbleToAddMealToRepository() {
        //given

        Meal meal = new Meal(10, "Kebap");

        //when
        mealRepository.add(meal);

        //then
        assertThat(mealRepository.getAllMeals().get(0), is(meal));
    }

    @Test
    void shouldBeAbleToRemoveMealFromRepository() {
        //given
        Meal meal = new Meal(10, "Kebap");
        mealRepository.add(meal);

        //when
        mealRepository.delete(meal);

        //then
        assertThat(mealRepository.getAllMeals(), not(contains(meal)));
    }

    @Test
    void shouldBeAbleToFindMealByName() {
        //given
        Meal meal = new Meal(10, "Kebap");
        mealRepository.add(meal);

        //when
        List<Meal> result = mealRepository.findByName("Kebap");

        //then
        assertThat(result.size(),is(1));
    }

    @Test
    void shouldBeAbleToFindByPrice() {
        //given
        Meal meal = new Meal(10, "Kebap");
        mealRepository.add(meal);

        //when
        List<Meal> result = mealRepository.findByPrice(10);

        //then
        assertThat(result.size(),is(1));
    }
}
