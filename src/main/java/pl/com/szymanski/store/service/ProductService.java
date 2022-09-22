package pl.com.szymanski.store.service;

import org.springframework.stereotype.Service;
import pl.com.szymanski.store.domain.Product;
import pl.com.szymanski.store.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> showAll(){
        return productRepository.showAll();
    }

}
