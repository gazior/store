package pl.com.szymanski.store.web;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import pl.com.szymanski.store.domain.*;
import pl.com.szymanski.store.service.OrderService;
import pl.com.szymanski.store.service.PaymentPayUService;
import pl.com.szymanski.store.service.PayuService;

@Controller
public class RestApiController {

    private final OrderService orderService;
    private final RestTemplate restTemplate;

    private final PaymentPayUService paymentPayUService;

    private final PayuService payuService;

    public RestApiController(OrderService orderService, RestTemplate restTemplate, PaymentPayUService paymentPayUService, PayuService payuService) {
        this.orderService = orderService;
        this.restTemplate = restTemplate;
        this.paymentPayUService = paymentPayUService;
        this.payuService = payuService;
    }

    @GetMapping(value = "/api/{id}")

    public ResponseEntity<Response> json(@PathVariable Long id) {

        ResponseEntity<Response> response = payuService.RequestPayU(new Payu(), new Buyer(), new Product1(), id);

        PaymentPayU paymentPayU = new PaymentPayU();
        paymentPayU.setExtOrderId(String.valueOf(id));
        paymentPayU.setOrderId(response.getBody().getOrderId());
        paymentPayU.setRedirectUri(response.getBody().getRedirectUri());
        paymentPayU.setStatus(response.getStatusCode().toString());
        paymentPayUService.save(paymentPayU);

        return response;
    }
}