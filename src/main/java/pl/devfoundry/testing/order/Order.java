package pl.devfoundry.testing.order;

import pl.devfoundry.meal.Meal;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private OrderStatus orderStatus;
    private List<Meal> meals = new ArrayList<>();


    public void changeOrderStatus(OrderStatus orderStatus){
        this.orderStatus=orderStatus;
    }

    int totalPrice(){
        int sum= this.meals.stream().mapToInt(meal->meal.getPrice()).sum();
        if(sum<0)
        {
            throw  new IllegalStateException("Pricelimit exceeded");
        }else{
            return sum;
        }
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void addMealToOrder(Meal meal) {
        this.meals.add(meal);
    }

    public void removeMealFromOrder(Meal meal) {
        this.meals.remove(meal);
    }

    public List<Meal> getMeals() {
        return meals;
    }

    void cancel() {
        this.meals.clear();
    }

    @Override
    public String toString() {
        return "Order{" +
                "meals=" + meals +
                '}';
    }

}


