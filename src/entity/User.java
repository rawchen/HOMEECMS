package entity;

public class User {

	private int user_id;
	private String user_name;
	private String user_nickname;
	private String user_password;
	private String user_sex;
	private String user_vip;
	private String user_viptime;
	private String user_status;
	private String user_photo;

	public User() {

	}

	public User(String user_name, String user_nickname, String user_password, String user_sex, String user_vip, String user_viptime, String user_status, String user_photo) {
		this.user_name = user_name;
		this.user_nickname = user_nickname;
		this.user_password = user_password;
		this.user_sex = user_sex;
		this.user_vip = user_vip;
		this.user_viptime = user_viptime;
		this.user_status = user_status;
		this.user_photo = user_photo;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}

	public String getUser_vip() {
		return user_vip;
	}

	public void setUser_vip(String user_vip) {
		this.user_vip = user_vip;
	}

	public String getUser_viptime() {
		return user_viptime;
	}

	public void setUser_viptime(String user_viptime) {
		this.user_viptime = user_viptime;
	}

	public String getUser_status() {
		return user_status;
	}

	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}

	public String getUser_photo() {
		return user_photo;
	}

	public void setUser_photo(String user_photo) {
		this.user_photo = user_photo;
	}

	@Override
	public String toString() {
		return "User{" +
				"user_id=" + user_id +
				", user_name='" + user_name + '\'' +
				", user_nickname='" + user_nickname + '\'' +
				", user_password='" + user_password + '\'' +
				", user_sex='" + user_sex + '\'' +
				", user_vip='" + user_vip + '\'' +
				", user_viptime='" + user_viptime + '\'' +
				", user_status='" + user_status + '\'' +
				", user_photo='" + user_photo + '\'' +
				'}';
	}
}
