package dao;

import entity.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> findCommentByProductId(int productId);

    void addComment(Comment comment);
}
