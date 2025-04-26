import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getMealType();
}

class VegetarianMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegetarian Meal";
    }
}

class VeganMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Vegan Meal";
    }
}

class KetoMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "Keto Meal";
    }
}

class HighProteinMeal implements MealPlan {
    @Override
    public String getMealType() {
        return "High-Protein Meal";
    }
}

class Meal<T extends MealPlan> {
    private String mealName;
    private T mealPlan;

    public Meal(String mealName, T mealPlan) {
        this.mealName = mealName;
        this.mealPlan = mealPlan;
    }

    public String getMealName() {
        return mealName;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public String toString() {
        return mealName + " - " + mealPlan.getMealType();
    }
}

class MealPlanGenerator {
    private List<Meal<? extends MealPlan>> meals = new ArrayList<>();

    public void addMeal(Meal<? extends MealPlan> meal) {
        meals.add(meal);
    }

    public List<Meal<? extends MealPlan>> getMeals() {
        return meals;
    }

    public static <T extends MealPlan> boolean validateMealPlan(Meal<T> meal) {
        return meal.getMealPlan() != null;
    }

    public static void displayMeals(List<Meal<? extends MealPlan>> meals) {
        for (Meal<? extends MealPlan> meal : meals) {
            System.out.println(meal);
        }
    }
}

public class PersonalizedMealPlan {
    public static void main(String[] args) {
        MealPlanGenerator generator = new MealPlanGenerator();

        Meal<VeganMeal> tofuStirFry = new Meal<>("Tofu Stir-Fry", new VeganMeal());
        Meal<KetoMeal> grilledChicken = new Meal<>("Grilled Chicken", new KetoMeal());
        Meal<VegetarianMeal> pastaSalad = new Meal<>("Pasta Salad", new VegetarianMeal());
        Meal<HighProteinMeal> proteinShake = new Meal<>("Protein Shake", new HighProteinMeal());

        if (MealPlanGenerator.validateMealPlan(tofuStirFry)) generator.addMeal(tofuStirFry);
        if (MealPlanGenerator.validateMealPlan(grilledChicken)) generator.addMeal(grilledChicken);
        if (MealPlanGenerator.validateMealPlan(pastaSalad)) generator.addMeal(pastaSalad);
        if (MealPlanGenerator.validateMealPlan(proteinShake)) generator.addMeal(proteinShake);

        System.out.println("Personalized Meal Plan:");
        MealPlanGenerator.displayMeals(generator.getMeals());
    }
}

