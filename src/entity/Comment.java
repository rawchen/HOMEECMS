package entity;

import java.util.Date;

public class Comment {
    private int user_id;
    private int product_id;
    private Date comment_time;
    private String comment_content;

    public Comment(int user_id, int product_id, Date comment_time, String comment_content) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.comment_time = comment_time;
        this.comment_content = comment_content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "user_id=" + user_id +
                ", product_id=" + product_id +
                ", comment_time=" + comment_time +
                ", comment_content='" + comment_content + '\'' +
                '}';
    }
}
