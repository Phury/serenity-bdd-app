package be.phury.store;

public class Price extends Model {
	
	public static final Price ZERO = Price.parse("0.0");
	
	private final Double amount;
	private final String currency;
	
	public static Price parse(String price) {
		return new Price(Double.parseDouble(price), "EUR");
	}

	private static void checkCurrency(Price p1, Price p2) {
		if (! p1.getCurrency().equals(p2.getCurrency())) {
			throw new BusinessValidationException("currecnies for [] and [] do not match", p1, p2);
		}
	}
	
	public Price(Double amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public Double getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public Price add(Price price) {
		checkCurrency(this, price);
		return new Price(this.getAmount() + price.getAmount(), this.getCurrency());
	}
}
