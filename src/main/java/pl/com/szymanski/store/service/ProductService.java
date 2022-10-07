package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.Product;

import java.util.List;

@Service
public interface ProductService {

    public List<Product> findAllProducts();

    public Product findById(Long id);
    void saveProduct(Product product);

    List<Product> findByNameEqualsIgnoreCase(String name);

}
