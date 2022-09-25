package pl.com.szymanski.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.com.szymanski.store.domain.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    public List<Product> findAll();
    public Product findProductById(Long id);
    List<Product> findProductByIdIn(List<Long> products);

}
