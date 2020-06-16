package entity;

public class Category {
	private String category_name;
	private int category_parentid;

	public Category(String category_name, int category_parentid) {
		this.category_name = category_name;
		this.category_parentid = category_parentid;
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
				"category_name='" + category_name + '\'' +
				", category_parentid=" + category_parentid +
				'}';
	}
}
