package vladimir.homework.products;

public class ExceptionNoProduct extends RuntimeException {
	public ExceptionNoProduct() {
		super("No product found with this name");
	}
}
