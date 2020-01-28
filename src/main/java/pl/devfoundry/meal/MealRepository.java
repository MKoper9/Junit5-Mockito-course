package pl.devfoundry.meal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MealRepository {

    private List<Meal> meals = new ArrayList<>();

    public void add(Meal meal) {
        meals.add(meal);
    }

    public List<Meal> getAllMeals() {
        return meals;
    }

    public void delete(Meal meal) {
        meals.remove(meal);
    }

    public List<Meal> findByName(String mealName, boolean exactMatch) {

        List<Meal> result;

        if (exactMatch) {
            result = meals.stream()
                    .filter(meal -> meal.getName().equals(mealName))
                    .collect(Collectors.toList());
        } else {
            result = meals.stream()
                    .filter(meal -> meal.getName().startsWith(mealName))
                    .collect(Collectors.toList());
        }
        return result;
    }

    public List<Meal> findByPrice(int mealPrice) {
        return meals.stream()
                .filter(meal -> meal.getPrice() == mealPrice)
                .collect(Collectors.toList());
    }

    public List<Meal> findByPriceWithSorting(int mealPrice, PriceSortType priceSortType) {

        if (priceSortType == PriceSortType.ASCENDING) {
            return meals.stream()
                    .filter(meal -> meal.getPrice() > mealPrice)
                    .collect(Collectors.toList());
        } else if (priceSortType == PriceSortType.DESCENDING) {
            return meals.stream()
                    .filter(meal -> meal.getPrice() < mealPrice)
                    .collect(Collectors.toList());
        } else if (priceSortType == PriceSortType.EQUALS) {
            return meals.stream()
                    .filter(meal -> meal.getPrice() == mealPrice)
                    .collect(Collectors.toList());
        }else{
            return   null;
        }
    }

    public List<Meal> find(String mealName, int mealPrice, PriceSortType priceSortType, boolean exactMatch) {
        if (priceSortType == PriceSortType.ASCENDING) {
            return findByName(mealName,exactMatch).stream()
                    .filter(meal -> meal.getPrice() > mealPrice)
                    .collect(Collectors.toList());
        } else if (priceSortType == PriceSortType.DESCENDING) {
            return findByName(mealName,exactMatch).stream()
                    .filter(meal -> meal.getPrice() < mealPrice)
                    .collect(Collectors.toList());
        } else if (priceSortType == PriceSortType.EQUALS) {
            return findByName(mealName,exactMatch).stream()
                    .filter(meal -> meal.getPrice() == mealPrice)
                    .collect(Collectors.toList());
        }else{
            return   null;
        }
    }
}
