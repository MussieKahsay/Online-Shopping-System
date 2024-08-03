package edu.miu.cs.cs425.service;



import java.util.List;
import edu.miu.cs.cs425.dto.ProductDto;
import edu.miu.cs.cs425.exception.ProductException;
import edu.miu.cs.cs425.model.Product;

public interface ProductService {

    public Product addProduct(Product products)throws ProductException;

    public Product updateProduct(Integer productId, ProductDto product)throws ProductException;

    public List<Product> getProductByName(String name)throws ProductException;

    public List<Product> getAllProduct(String keyword, String sortDirection, String sortBy)throws ProductException;

    public List<Product> getProductByCategory(String catagory) throws ProductException;

    public void removeProduct(Integer productId)throws ProductException;

    public Product getSingleProduct(Integer productId);
}

