package edu.miu.cs.cs425.service;

import edu.miu.cs.cs425.dto.ShippingDto;
import edu.miu.cs.cs425.exception.ShippingException;
import edu.miu.cs.cs425.model.ShippingDetails;

public interface ShippingService {

    public ShippingDetails setShippingDetails(Integer orderId, Integer shipperId, ShippingDetails shippingDetails) throws ShippingException;

    public ShippingDetails updateShippingAddress(Integer shippingId, ShippingDto shippingDTO)throws ShippingException;

    public void deleteShippingDetails(Integer shippingId)throws ShippingException;


}