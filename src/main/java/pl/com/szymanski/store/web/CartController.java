package pl.com.szymanski.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.com.szymanski.store.domain.Cart;
import pl.com.szymanski.store.domain.CartItem;
import pl.com.szymanski.store.domain.Product;
import pl.com.szymanski.store.service.ProductService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

        cart.addToCart(new CartItem(productService.findById(id), 1));
        model.addAttribute("cart", cart);
        return "cartsucces";
    }

    @RequestMapping("/cart")
    public String showCart(Model model) {

        model.addAttribute("cart", cart.getCartItems());
        model.addAttribute("count", cart.getCartItems().stream().mapToInt(CartItem::getQuantity).sum());
        model.addAttribute("total", cart.getCartItems().stream().mapToDouble(p -> p.getProduct().getPrice() * p.getQuantity()).sum());
        return "cart";
    }

    @RequestMapping("/cart/remove/{id}")
    public String removeItem(@PathVariable int id) {
        cart.getCartItems().remove(id);
        return "redirect:/cart";
    }

    @GetMapping("cart/add")
    public String addQuantity(@RequestParam String product,@RequestParam Integer quantity ) {

        cart.getCartItems()
                .stream()
                .filter(p -> Objects.equals(p.getProduct().getName(), product))
                .forEach(p -> p.setQuantity(quantity));

        return "redirect:/cart";
    }

    @RequestMapping("/dupa")
    @ResponseBody
    public List<CartItem> show() {
        return cart.getCartItems();
    }
}
