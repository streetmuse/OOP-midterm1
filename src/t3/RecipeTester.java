package t3;

public class RecipeTester {
    public static void main(String[] args) {
        Recipe r1 = new Recipe();
        r1.setName("Chocolate Chip Cookies");
        r1.setAuthor("Julia Child");
        r1.addIngredient("2 1/4 cups flour");
        r1.addIngredient("1 tsp baking soda");
        r1.addIngredient("1 cup butter");
        r1.addIngredient("3/4 cup sugar");
        r1.addIngredient("2 cups chocolate chips");
        r1.setInstructions("Mix dry ingredients. Cream butter and sugar. Combine and add chocolate chips. Bake at 375F for 10 minutes.");

        Recipe r2 = new Recipe();
        r2.setName("Tomato Pasta");
        r2.setAuthor("Jamie Oliver");
        r2.addIngredient("500g pasta");
        r2.addIngredient("400g tomatoes");
        r2.addIngredient("2 cloves garlic");
        r2.addIngredient("Fresh basil");
        r2.addIngredient("Olive oil");
        r2.setInstructions("Boil pasta. Sauté garlic in olive oil. Add tomatoes and simmer. Mix with pasta and garnish with basil.");

        Recipe r3 = new Recipe();
        r3.setName("Classic Pancakes");
        r3.setAuthor("Gordon Ramsay");
        r3.addIngredient("1 cup flour");
        r3.addIngredient("2 eggs");
        r3.addIngredient("1 cup milk");
        r3.addIngredient("2 tbsp sugar");
        r3.addIngredient("1 tsp baking powder");
        r3.setInstructions("Mix all ingredients. Heat pan. Pour batter and cook until bubbles form, then flip.");

        RMS rms = new RMS();
        rms.addRecipe(r1);
        rms.addRecipe(r2);
        rms.addRecipe(r3);

        rms.rateRecipe(r1, 4, "User1");
        rms.rateRecipe(r1, 5, "User2");
        rms.rateRecipe(r2, 3, "User1");
        rms.rateRecipe(r2, 2, "User3");
        rms.rateRecipe(r3, 5, "User2");
        rms.rateRecipe(r3, 5, "User3");

        rms.printStorage();

        rms.printTopRatedRecipes();

        rms.removeRecipe(r1);
        System.out.println("\nAfter removing Chocolate Chip Cookies:");
        rms.printStorage();
        rms.printTopRatedRecipes();
    }
}