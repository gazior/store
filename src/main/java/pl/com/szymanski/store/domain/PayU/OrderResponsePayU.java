package pl.com.szymanski.store.domain.PayU;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class OrderResponsePayU{

    private String orderId;
    private String orderCreateDate;
    private String notifyUrl;
    private String customerIp;
    private String merchantPosId;
    private String description;
    private String currencyCode;
    private String totalAmount;
    private UserDTO buyer;
    private PayMethod payMethod;
    private String status;
    private List<ProductDTO> products;



}
