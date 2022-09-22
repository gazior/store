package pl.com.szymanski.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.com.szymanski.store.domain.Product;
import pl.com.szymanski.store.repository.ProductRepository;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

}
