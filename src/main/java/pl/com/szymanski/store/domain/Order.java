package pl.com.szymanski.store.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pl.com.szymanski.store.domain.PayU.OrderDTO;
import pl.com.szymanski.store.domain.PayU.ProductDTO;
import pl.com.szymanski.store.domain.PayU.UserDTO;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@Component
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double sumPrice;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusOrder statusOrder;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "orders_order_details", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "order_detail_id"))
    private List<OrderDetails> orderDetails;

    public OrderDTO getAsDTO() {
        String notifyUrl = "http://localhost:8080/notify";
        String continueUrl = "http://localhost:8080/order/"+getId();
        String customerIp = "127.0.0.1";
        String merchantPosId = "300746";
        String description = "store";
        String currencyCode = "PLN";
        String totalAmount = String.valueOf(this.sumPrice*100);
        return new OrderDTO(notifyUrl,
                continueUrl,
                customerIp,
                merchantPosId,
                description,
                currencyCode,
                totalAmount.replace(".0",""),
                new UserDTO(user.getEmail(),"571411263",user.getFirstName(), user.getLastName(),"pl")
                , getOrderDetails().stream().map(p -> {
            ProductDTO product = new ProductDTO();
            product.setName(p.getProduct().getName());
            product.setUnitPrice(p.getProduct().getPrice().toString().replace(".0",""));
            product.setQuantity(p.getQuantity().toString());
            return product;
        }).collect(Collectors.toList()));
    }
}
