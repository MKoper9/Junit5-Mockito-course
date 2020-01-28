package pl.devfoundry.meal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void shouldBeAbleToFindMealByExactName() {
        //given
        Meal meal = new Meal(10, "Kebap");
        Meal meal2 = new Meal(10, "Kanapka");
        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> result = mealRepository.findByName("Kebap", true);

        //then
        assertThat(result.size(), is(1));
    }

    @Test
    void shouldBeAbleToFindMealByStartingLetters() {
        //given
        Meal meal = new Meal(10, "Kebap");
        Meal meal2 = new Meal(10, "Kanapka");
        mealRepository.add(meal);
        mealRepository.add(meal2);

        //when
        List<Meal> result = mealRepository.findByName("K", false);

        //then
        assertThat(result.size(), is(2));
    }

    @Test
    void shouldBeAbleToFindByPrice() {
        //given
        Meal meal = new Meal(10, "Kebap");
        mealRepository.add(meal);

        //when
        List<Meal> result = mealRepository.findByPrice(10);

        //then
        assertThat(result.size(), is(3));
    }

    @Test
    void shouldBeAbleToFindByPriceWithSortingWithAscending() {
        //given
        Meal meal = new Meal(10, "Kebap");
        Meal meal2 = new Meal(1, "Lizak");
        Meal meal3 = new Meal(20, "Pizza");
        mealRepository.add(meal);
        mealRepository.add(meal2);
        mealRepository.add(meal3);

        //when
        List<Meal> result = mealRepository.findByPriceWithSorting(7, PriceSortType.ASCENDING);

        //then
        assertThat(result.size(), is(2));
        System.out.println(result);
    }

    @Test
    void shouldBeAbleToFindByPriceWithSortingWithDescending() {
        //given
        Meal meal = new Meal(10, "Kebap");
        Meal meal2 = new Meal(1, "Lizak");
        Meal meal3 = new Meal(20, "Pizza");
        mealRepository.add(meal);
        mealRepository.add(meal2);
        mealRepository.add(meal3);

        //when
        List<Meal> result = mealRepository.findByPriceWithSorting(11, PriceSortType.DESCENDING);

        //then
        assertThat(result.size(), is(2));
        System.out.println(result);
    }

    @Test
    void shouldBeAbleToFindByPriceWithSortingWithEquals() {
        //given
        Meal meal = new Meal(10, "Kebap");
        Meal meal2 = new Meal(3, "Piwo");
        Meal meal3 = new Meal(20, "Pizza");
        Meal meal4 = new Meal(1, "Pianka");
        mealRepository.add(meal);
        mealRepository.add(meal2);
        mealRepository.add(meal3);
        mealRepository.add(meal4);

        //when
        List<Meal> result = mealRepository.find("Pizza", 2, PriceSortType.ASCENDING,true);

        //then
        assertThat(result.size(), is(1));
        System.out.println(result);
    }

    @Test
    void shouldBeAbleToFindByPriceWithSortingEqualsAndName() {
        Meal meal = new Meal(10, "Kebap");
        Meal meal2 = new Meal(1, "Lizak");
        Meal meal3 = new Meal(20, "Pizza");
        mealRepository.add(meal);
        mealRepository.add(meal2);
        mealRepository.add(meal3);

        //when
        List<Meal> result = mealRepository.findByPriceWithSorting(20, PriceSortType.EQUALS);

    }
}

