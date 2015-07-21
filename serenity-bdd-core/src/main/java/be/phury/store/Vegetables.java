package be.phury.store;

public class Vegetables extends Model implements Article {

	private final String name;
	private final Price price;
	
	public Vegetables(String name, Price price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public Price getPrice() {
		return price;
	}
}
