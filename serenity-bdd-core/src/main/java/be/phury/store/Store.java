package be.phury.store;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Store {
	
	private static final Logger LOG = LoggerFactory.getLogger(Store.class);
	
	private List<Article> articles = new LinkedList<>();

	public void addFruit(String name, String price) {
		addArticle(new Fruit(name, Price.parse(price)));
	}
	
	public void addVegetable(String name, String price) {
		addArticle(new Vegetables(name, Price.parse(price)));
	}

	public void addArticle(Article article) {
		LOG.debug("adding article [%s]", article);
		articles.add(article);
	}
	
	public Price getTotal(String goods) {
		Price total = Price.ZERO;
		for (String good : goods.split(",")) {
			Article article = findArticleByName(good.trim());
			if (article == null) throw new NullPointerException("article ["+good.trim()+"] not found");
			total = total.add(article.getPrice());
		}
		return total;
	}

	private Article findArticleByName(String name) {
		for (Article a : articles) if (a.getName().equals(name)) return a;
		return null;
	}
}
