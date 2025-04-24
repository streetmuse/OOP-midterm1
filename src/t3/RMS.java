package t3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RMS {
    private List<Recipe> storage = new ArrayList<Recipe>();
    private Map<Recipe, List<Rating>> ratings = new HashMap<>();

    public void addRecipe(Recipe recipe) {
        storage.add(recipe);
    }

    public boolean removeRecipe(Recipe recipe) {
        boolean removed = false;
        for (int i = 0; i < storage.size(); i++) {
            Recipe r = storage.get(i);
            if (r.getName().equals(recipe.getName()) && r.getAuthor().equals(recipe.getAuthor())) {
                storage.remove(i);
                ratings.remove(r);
                removed = true;
                break;
            }
        }
        return removed;
    }

    public void printStorage() {
        if (storage.isEmpty()) {
            System.out.println("The storage is empty");
        } else {
            for (Recipe r: storage) {
                System.out.println(r.getAuthor() + ", " + r.getName());
                System.out.println("Ingredients:");
                for (String ingredient : r.getIngredients()) {
                    System.out.println("- " + ingredient);
                }
                System.out.println("Instructions: " + r.getInstructions());

                if (ratings.containsKey(r)) {
                    System.out.println("Average Rating: " + getAverageRating(r) + "/5");
                }
                System.out.println();
            }
        }
    }

    public void rateRecipe(Recipe recipe, int rating, String userName) {
        if (rating < 1 || rating > 5) {
            System.out.println("Rating must be between 1 and 5");
            return;
        }

        boolean recipeExists = false;
        for (Recipe r : storage) {
            if (r.getName().equals(recipe.getName()) && r.getAuthor().equals(recipe.getAuthor())) {
                recipeExists = true;
                break;
            }
        }

        if (!recipeExists) {
            System.out.println("Recipe not found in the system");
            return;
        }

        if (!ratings.containsKey(recipe)) {
            ratings.put(recipe, new ArrayList<>());
        }

        ratings.get(recipe).add(new Rating(userName, rating));
        System.out.println("Rating added successfully");
    }

    public double getAverageRating(Recipe recipe) {
        if (!ratings.containsKey(recipe) || ratings.get(recipe).isEmpty()) {
            return 0;
        }

        List<Rating> recipeRatings = ratings.get(recipe);
        double sum = 0;
        for (Rating r : recipeRatings) {
            sum += r.getRating();
        }

        return sum / recipeRatings.size();
    }

    public void printTopRatedRecipes() {
        if (storage.isEmpty() || ratings.isEmpty()) {
            System.out.println("No rated recipes available");
            return;
        }

        List<Recipe> sortedRecipes = new ArrayList<>(storage);
        sortedRecipes.sort((r1, r2) -> Double.compare(getAverageRating(r2), getAverageRating(r1)));

        System.out.println("Top Rated Recipes:");
        for (Recipe r : sortedRecipes) {
            double avgRating = getAverageRating(r);
            if (avgRating > 0) {
                System.out.println(r.getName() + " by " + r.getAuthor() + " - Rating: " + avgRating + "/5");
            }
        }
    }
}

class Rating {
    private String userName;
    private int rating;

    public Rating(String userName, int rating) {
        this.userName = userName;
        this.rating = rating;
    }

    public String getUserName() {
        return userName;
    }

    public int getRating() {
        return rating;
    }
}