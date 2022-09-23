package pl.com.szymanski.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.com.szymanski.store.service.ProductService;

@Controller
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping(value = "/products")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.findAllProducts());
        return "products";
    }

}
