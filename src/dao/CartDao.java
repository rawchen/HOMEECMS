package dao;

import entity.Cart;

import java.util.List;

public interface CartDao {
    int findCartCountByUserId(int user_id);

    List<Cart> findCartListByUserId(int i);

    void addCart(Cart cart);
}
