package entity;

public class CATEGORY {
	private int CATE_ID;
	private String CATE_NAME;
	private int CATE_PARENT_ID;
	
	public CATEGORY(int cATE_ID, String cATE_NAME, int cATE_PARENT_ID) {
		super();
		CATE_ID = cATE_ID;
		CATE_NAME = cATE_NAME;
		CATE_PARENT_ID = cATE_PARENT_ID;
	}

	public int getCATE_ID() {
		return CATE_ID;
	}

	public void setCATE_ID(int cATE_ID) {
		CATE_ID = cATE_ID;
	}

	public String getCATE_NAME() {
		return CATE_NAME;
	}

	public void setCATE_NAME(String cATE_NAME) {
		CATE_NAME = cATE_NAME;
	}

	public int getCATE_PARENT_ID() {
		return CATE_PARENT_ID;
	}

	public void setCATE_PARENT_ID(int cATE_PARENT_ID) {
		CATE_PARENT_ID = cATE_PARENT_ID;
	}
	
	
}
