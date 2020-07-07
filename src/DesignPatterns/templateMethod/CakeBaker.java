package DesignPatterns.templateMethod;

public abstract class CakeBaker {

    // ...

    public final Cake bakeCake() {
        buyIngredients();
        followRecipe();
        insertToOven();

        return new Cake();
    }

    public abstract void buyIngredients();
    public abstract void followRecipe();
    public abstract void insertToOven();

    // ...
}
