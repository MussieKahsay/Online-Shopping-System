package edu.miu.cs.cs425.service;


import edu.miu.cs.cs425.exception.ShipperException;
import edu.miu.cs.cs425.model.Shipper;

import java.util.List;

public interface ShipperService {

    public void deleteShipperById(Integer id) throws ShipperException;

    public Shipper saveShipper(Shipper shipper) throws ShipperException;

    public Shipper getShipperById(Integer id) throws ShipperException;

    public List<Shipper> getAllShippers() throws ShipperException;

}