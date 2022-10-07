package pl.com.szymanski.store.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.com.szymanski.store.domain.PayU.OrderDTO;
import pl.com.szymanski.store.domain.PayU.ResponsePayU;
import pl.com.szymanski.store.service.OrderService;

@RestController
public class PayUApiController {

    private final OrderService orderService;

    public PayUApiController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping(value = "/rest/order/{id}")
    public OrderDTO getOrder(@PathVariable Long id) {

        return orderService.findOrderById(id).get().getAsDTO();

    }
}
