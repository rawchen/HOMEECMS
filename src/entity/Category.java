package entity;

public class Category {
	private int category_id;
	private String category_name;
	private int category_parentid;

	public Category(){

	}

	public Category(String category_name, int category_parentid) {
		this.category_name = category_name;
		this.category_parentid = category_parentid;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public int getCategory_parentid() {
		return category_parentid;
	}

	public void setCategory_parentid(int category_parentid) {
		this.category_parentid = category_parentid;
	}

	@Override
	public String toString() {
		return "Category{" +
				"category_id=" + category_id +
				", category_name='" + category_name + '\'' +
				", category_parentid=" + category_parentid +
				'}';
	}
}
