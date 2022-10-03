package pl.com.szymanski.store.domain.PayU;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePayU {

    private List<OrderResponsePayU> orders;
    private Status status;
    private List<Properties> properties;
}
