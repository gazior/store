package pl.com.szymanski.store.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;


@AllArgsConstructor
@NoArgsConstructor
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    private List<CartItem> cartItems = new ArrayList<>();

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addToCart(CartItem cartItem) {
        Optional<CartItem> foundItem = findItem(cartItem);
        foundItem.
                ifPresentOrElse(item -> item.addQuantity(cartItem.getQuantity()),
                        () -> cartItems.add(cartItem));
    }

    public Optional<CartItem> findItem(CartItem item) {
        return cartItems
                .stream()
                .filter(p -> p.getProduct().getId() == item.getProduct().getId())
                .findFirst();
    }

    public Integer sum(){
        return getCartItems().stream().mapToInt(CartItem::getQuantity).sum();
    }

    public Double total(){
        return getCartItems().stream().mapToDouble(p -> p.getProduct().getPrice() * p.getQuantity()).sum();
    }
}

