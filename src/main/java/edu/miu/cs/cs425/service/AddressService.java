package edu.miu.cs.cs425.service;

import edu.miu.cs.cs425.exception.AddressException;
import edu.miu.cs.cs425.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AddressService {

    public Address addAddressToUser(Integer userId, Address address) throws AddressException;

    public Address updateAddress( Address address,Integer addressId) throws AddressException ;

    public void   removeAddress(Integer addressId)throws AddressException;

    public List<Address> getAllUserAddress(Integer userId)throws AddressException;

}