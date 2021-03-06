package be.phury.integration.bdd.stories.store;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import be.phury.store.Price;
import be.phury.store.Store;

public class ComputeTotalCostOfItemsStory {
	private Store store = new Store();
	private String goods;
	
	@Given("that I add $fruit with $fruitPrice")
	public void givenThatIAddfruitWithfruitPrice(
			@Named("fruit") String fruit,
			@Named("fruitPrice") String fruitPrice) {
		store.addFruit(fruit, fruitPrice);
	}

	@Given("that I add a $vegetable with $vegetablePrice")
	public void givenThatIAddAvegetableWithvegetablePrice(
			@Named("vegetable") String vegetable,
			@Named("vegetablePrice") String vegetablePrice) {
		store.addVegetable(vegetable, vegetablePrice);
	}

	@When("I sell $goods")
	public void whenISellgoods(@Named("goods") String goods) {
		this.goods = goods;
	}

	@Then("the total cost should be $total")
	public void thenTheTotalCostShouldBetotal(@Named("total") String total) {
		Assert.assertEquals(Price.parse(total), store.getTotal(goods));
	}
}
