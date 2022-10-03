package pl.com.szymanski.store.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Product product;
    private Integer quantity;
    private Double sumPrice;

    public OrderDetails(Product product,Integer quantity,Double sumPrice){
        this.product = product;
        this.quantity = quantity;
        this.sumPrice = sumPrice;
    }
}
