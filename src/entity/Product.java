package entity;

public class Product {
	private int product_id;
	private String product_name;
	private String product_info;
	private int product_price;
	private int product_stock;
	private int product_fid;
	private int product_cid;
	private String product_photo;
	private String product_style;
	private int product_sales;

	public Product(){

	}

	public Product(String product_name, String product_info, int product_price, int product_stock, int product_fid, int product_cid, String product_photo, String product_style, int product_sales) {
		this.product_name = product_name;
		this.product_info = product_info;
		this.product_price = product_price;
		this.product_stock = product_stock;
		this.product_fid = product_fid;
		this.product_cid = product_cid;
		this.product_photo = product_photo;
		this.product_style = product_style;
		this.product_sales = product_sales;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_info() {
		return product_info;
	}

	public void setProduct_info(String product_info) {
		this.product_info = product_info;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getProduct_stock() {
		return product_stock;
	}

	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}

	public int getProduct_fid() {
		return product_fid;
	}

	public void setProduct_fid(int product_fid) {
		this.product_fid = product_fid;
	}

	public int getProduct_cid() {
		return product_cid;
	}

	public void setProduct_cid(int product_cid) {
		this.product_cid = product_cid;
	}

	public String getProduct_photo() {
		return product_photo;
	}

	public void setProduct_photo(String product_photo) {
		this.product_photo = product_photo;
	}

	public String getProduct_style() {
		return product_style;
	}

	public void setProduct_style(String product_style) {
		this.product_style = product_style;
	}

	public int getProduct_sales() {
		return product_sales;
	}

	public void setProduct_sales(int product_sales) {
		this.product_sales = product_sales;
	}

	@Override
	public String toString() {
		return "Product{" +
				"product_name='" + product_name + '\'' +
				", product_info='" + product_info + '\'' +
				", product_price=" + product_price +
				", product_stock=" + product_stock +
				", product_fid=" + product_fid +
				", product_cid=" + product_cid +
				", product_photo='" + product_photo + '\'' +
				", product_style='" + product_style + '\'' +
				", product_sales=" + product_sales +
				'}';
	}
}
