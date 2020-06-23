package service;

import entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAddressByUserId(int user_id);
}
