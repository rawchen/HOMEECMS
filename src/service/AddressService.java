package service;

import entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAddressByUserId(int user_id);

    Address findAddressByAddressId(int address_id);

    void addAddress(Address a);

    void delAddressById(int aid2);
}
