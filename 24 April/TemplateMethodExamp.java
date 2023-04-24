abstract class Beverage {
	// This is the template method that defines the algorithm for making a beverage
	public final void prepareBeverage() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}

	protected void boilWater() {
		System.out.println("Boiling water...");
	}

	// This is an abstract method that subclasses must implement to brew the
	// specific type of beverage
	protected abstract void brew();

	protected void pourInCup() {
		System.out.println("Pouring beverage into cup...");
	}

	// This is a hook that subclasses can override to provide additional
	// functionality
	protected void addCondiments() {
	}
}

class Coffee extends Beverage {
	@Override
	protected void brew() {
		System.out.println("Brewing coffee...");
	}

	@Override
	protected void addCondiments() {
		System.out.println("Adding sugar and milk...");
	}
}

class Tea extends Beverage {
	@Override
	protected void brew() {
		System.out.println("Steeping tea...");
	}

	@Override
	protected void addCondiments() {
		System.out.println("Adding lemon...");
	}
}

public class TemplateMethodExamp {
	public static void main(String[] args) {
		Coffee coffee = new Coffee();
		coffee.prepareBeverage();

		System.out.println();

		Tea tea = new Tea();
		tea.prepareBeverage();
	}
}

/*
 * In this example, we have an abstract Beverage class that defines the template
 * method prepareBeverage(), which calls other methods boilWater(), brew(),
 * pourInCup(), and addCondiments(). These methods are implemented by the
 * subclasses, Coffee and Tea, to provide their own beverage preparation logic.
 * The addCondiments() method is a hook that the subclasses can override to
 * provide additional functionality. Finally, we have a main method that creates
 * instances of the Beverage subclasses and prepares their respective beverages
 * using the template method.
 * 
 * 
 */
