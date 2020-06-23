package dao;

import entity.Address;

import java.util.List;

public interface AddressDao {
    List<Address> findAddressByUserId(int user_id);
}
