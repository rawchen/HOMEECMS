package entity;

public class Cart {
	private int product_id;
	private int user_id;
	private String product_name;
	private String product_price;
	private String product_quantity;
	private String product_style;
	private String product_photo;

	public Cart(int product_id, int user_id, String product_name, String product_price, String product_quantity, String product_style, String product_photo) {
		this.product_id = product_id;
		this.user_id = user_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.product_style = product_style;
		this.product_photo = product_photo;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_price() {
		return product_price;
	}

	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}

	public String getProduct_quantity() {
		return product_quantity;
	}

	public void setProduct_quantity(String product_quantity) {
		this.product_quantity = product_quantity;
	}

	public String getProduct_style() {
		return product_style;
	}

	public void setProduct_style(String product_style) {
		this.product_style = product_style;
	}

	public String getProduct_photo() {
		return product_photo;
	}

	public void setProduct_photo(String product_photo) {
		this.product_photo = product_photo;
	}

	@Override
	public String toString() {
		return "Cart{" +
				"product_id=" + product_id +
				", user_id=" + user_id +
				", product_name='" + product_name + '\'' +
				", product_price='" + product_price + '\'' +
				", product_quantity='" + product_quantity + '\'' +
				", product_style='" + product_style + '\'' +
				", product_photo='" + product_photo + '\'' +
				'}';
	}
}

