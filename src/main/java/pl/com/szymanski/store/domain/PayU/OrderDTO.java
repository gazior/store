package pl.com.szymanski.store.domain.PayU;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    ;
    private String notifyUrl;
    private String customerIp;
    private String continueUrl;
    private String merchantPosId;
    private String description;
    private String currencyCode;
    private String totalAmount;
    private UserDTO buyer;
    private List<ProductDTO> products;

    public OrderDTO(String notifyUrl,  String continueUrl,String customerIp, String merchantPosId, String description, String currencyCode, String totalAmount, UserDTO buyer, List<ProductDTO> orderDetails) {
        this.notifyUrl = notifyUrl;
        this.continueUrl = continueUrl;
        this.customerIp = customerIp;
        this.merchantPosId = merchantPosId;
        this.description = description;
        this.currencyCode = currencyCode;
        this.totalAmount = totalAmount;
        this.buyer = buyer;
        this.products = orderDetails;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "notifyUrl='" + notifyUrl + '\'' +
                ", merchantPostId='" + merchantPosId + '\'' +
                ", description='" + description + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                ", totalAmount=" + totalAmount +
                ", buyer=" + buyer +
                ", products=" + products +
                '}';
    }
}
