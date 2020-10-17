package service.impl;

import dao.CommentDao;
import dao.impl.CommentDaoImpl;
import entity.Comment;
import service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentDao dao = new CommentDaoImpl();

    @Override
    public List<Comment> findCommentByProductId(int productId) {
        return dao.findCommentByProductId(productId);
    }

    @Override
    public void addComment(Comment comment) {
        dao.addComment(comment);
    }
}
