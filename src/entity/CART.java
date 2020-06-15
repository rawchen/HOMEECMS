package entity;

public class CART {
	public int cart_id;
	public String cart_p_filename;
	public String cart_p_name;
	public int cart_p_price;
	public int cart_quantity;
	public int cart_p_stock;
	public int cart_p_id;
	public String cart_u_id;
	public int cart_valid;
	public CART(int cart_id, String cart_p_filename,
				String cart_p_name, int cart_p_price, int cart_quantity,
				int cart_p_stock, int cart_p_id, String cart_u_id, int cart_valid) {
		super();
		this.cart_id = cart_id;
		this.cart_p_filename = cart_p_filename;
		this.cart_p_name = cart_p_name;
		this.cart_p_price = cart_p_price;
		this.cart_quantity = cart_quantity;
		this.cart_p_stock = cart_p_stock;
		this.cart_p_id = cart_p_id;
		this.cart_u_id = cart_u_id;
		this.cart_valid = cart_valid;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public String getCart_p_filename() {
		return cart_p_filename;
	}
	public void setCart_p_filename(String cart_p_filename) {
		this.cart_p_filename = cart_p_filename;
	}
	public String getCart_p_name() {
		return cart_p_name;
	}
	public void setCart_p_name(String cart_p_name) {
		this.cart_p_name = cart_p_name;
	}
	public int getCart_p_price() {
		return cart_p_price;
	}
	public void setCart_p_price(int cart_p_price) {
		this.cart_p_price = cart_p_price;
	}
	public int getCart_quantity() {
		return cart_quantity;
	}
	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}
	public int getCart_p_stock() {
		return cart_p_stock;
	}
	public void setCart_p_stock(int cart_p_stock) {
		this.cart_p_stock = cart_p_stock;
	}
	public int getCart_p_id() {
		return cart_p_id;
	}
	public void setCart_p_id(int cart_p_id) {
		this.cart_p_id = cart_p_id;
	}
	public String getCart_u_id() {
		return cart_u_id;
	}
	public void setCart_u_id(String cart_u_id) {
		this.cart_u_id = cart_u_id;
	}
	public int getCart_valid() {
		return cart_valid;
	}
	public void setCart_valid(int cart_valid) {
		this.cart_valid = cart_valid;
	}
	
	
	
}
