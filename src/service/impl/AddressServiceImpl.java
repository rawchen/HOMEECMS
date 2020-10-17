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

    @Override
    public Address findAddressByAddressId(int address_id) {
        return dao.findAddressByAddressId(address_id);
    }

    @Override
    public void addAddress(Address a) {
        dao.addAddress(a);
    }

    @Override
    public void delAddressById(int aid2) {
        dao.delAddressById(aid2);
    }
}
