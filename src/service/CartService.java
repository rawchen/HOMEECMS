package service;

import entity.Cart;

import java.util.List;

public interface CartService {
    int findCartCountByUserId(int user_id);

    List<Cart> findCartListByUserId(int i);
}
