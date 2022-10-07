package pl.com.szymanski.store.web;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.com.szymanski.store.domain.SearchProduct;
import pl.com.szymanski.store.service.ProductService;

import java.util.List;

@Controller
public class SearchController {

    private final ProductService productService;

    public SearchController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/search")
    public String searchGET(@RequestParam String name, @NotNull Model model) {

        model.addAttribute("products", productService.findByNameEqualsIgnoreCase(name));
        return "searchResults";
    }

}
