package edu.miu.cs.cs425.serviceImpl;

import edu.miu.cs.cs425.dto.ShippingDto;
import edu.miu.cs.cs425.exception.ShippingException;
import edu.miu.cs.cs425.model.Orders;
import edu.miu.cs.cs425.model.Shipper;
import edu.miu.cs.cs425.model.ShippingDetails;
import edu.miu.cs.cs425.repository.OrderRepository;
import edu.miu.cs.cs425.repository.ShipperRepository;
import edu.miu.cs.cs425.repository.ShippingRepository;
import edu.miu.cs.cs425.service.ShippingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShippingServiceImpl implements ShippingService {

    private final ShippingRepository shippingRepository;

    private final OrderRepository orderRepository;

    private final ShipperRepository shipperRepository;

    @Override
    public ShippingDetails setShippingDetails(Integer orderId, Integer shipperId, ShippingDetails shippingDetails)
            throws ShippingException {
        if (shippingDetails == null)
            throw new ShippingException("ShippingDetails cannot be null");

        Orders existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new ShippingException("Order not found"));

        Shipper existingShipper = shipperRepository.findById(shipperId)
                .orElseThrow(() -> new ShippingException("Shipper not found"));

        // Save the ShippingDetails entity first
        shippingDetails.setOrders(existingOrder);
        shippingDetails.setShipper(existingShipper);
        shippingDetails = shippingRepository.save(shippingDetails);

        // Now update the Orders entity with the saved ShippingDetails
        existingOrder.setShippingDetails(shippingDetails);
        orderRepository.save(existingOrder);

        return shippingDetails;
    }


    @Override
    public ShippingDetails updateShippingAddress(Integer shippingId, ShippingDto shippingDTO) throws ShippingException {
        ShippingDetails existing = shippingRepository.findById(shippingId)
                .orElseThrow(() -> new ShippingException("Shipping detail not found"));

        existing.setState(shippingDTO.getState());
        existing.setAddress(shippingDTO.getAddress());
        existing.setCity(shippingDTO.getCity());
        existing.setPostalCode(shippingDTO.getPostalCode());
        return shippingRepository.save(existing);
    }

    @Override
    public void deleteShippingDetails(Integer shippingId) throws ShippingException {
        ShippingDetails existing = shippingRepository.findById(shippingId)
                .orElseThrow(() -> new ShippingException("Shipping detail not found"));

        shippingRepository.delete(existing);

    }

}