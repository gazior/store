package pl.com.szymanski.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.com.szymanski.store.domain.Cart;
import pl.com.szymanski.store.domain.Product;
import pl.com.szymanski.store.repository.ProductRepository;
import pl.com.szymanski.store.service.ProductService;

@Controller
public class CartController {

    private final Cart cart;
    private final ProductService productService;


    public CartController(Cart cart, ProductService productService) {
        this.cart = cart;
        this.productService = productService;
    }

    @RequestMapping("/cart/{id}")

    public String addToCart(@PathVariable Long id, Model model) {

        cart.getProducts().add(productService.findById(id));
        model.addAttribute("cart", cart);
        return "cartsucces";
    }

    @RequestMapping("/cart")
    public String showCart(Model model) {
        Long count = cart.getAllProduct().stream().count();
        Double total = cart.getAllProduct().stream().mapToDouble(Product::getPrice).sum();
        model.addAttribute("cart", cart.getAllProduct());
        model.addAttribute("count", count);
        model.addAttribute("total", total);
        return "cart";
    }
}
