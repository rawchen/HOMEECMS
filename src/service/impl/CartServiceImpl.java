package service.impl;

import dao.CartDao;
import dao.impl.CartDaoImpl;
import entity.Cart;
import service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    private CartDao dao = new CartDaoImpl();

    @Override
    public int findCartCountByUserId(int user_id) {
        return dao.findCartCountByUserId(user_id);
    }

    @Override
    public List<Cart> findCartListByUserId(int i) {
        return dao.findCartListByUserId(i);
    }
}
