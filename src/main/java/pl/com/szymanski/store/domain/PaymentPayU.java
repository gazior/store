package pl.com.szymanski.store.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "status_payment")
@Getter
@Setter
public class PaymentPayU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderId;
    private String extOrderId;
    private String status;
    private String redirectUri;

}
