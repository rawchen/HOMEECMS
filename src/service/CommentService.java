package service;

import entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findCommentByProductId(int productId);

    void addComment(Comment comment);
}
