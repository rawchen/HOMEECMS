package service.impl;

import dao.AddressDao;
import dao.impl.AddressDaoImpl;
import entity.Address;
import service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDao dao = new AddressDaoImpl();

    @Override
    public List<Address> findAddressByUserId(int user_id) {
        return dao.findAddressByUserId(user_id);
    }
}
