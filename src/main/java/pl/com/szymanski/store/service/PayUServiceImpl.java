package pl.com.szymanski.store.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.com.szymanski.store.domain.PayU.OrderDTO;
import pl.com.szymanski.store.domain.PayU.Response;
import pl.com.szymanski.store.domain.PayU.ResponsePayU;

import java.util.Objects;

@Service
public class PayUServiceImpl implements PayuService<Response> {

    private final RestTemplate restTemplate;
    private final OrderService orderService;

    private final PaymentPayUService paymentPayUService;

    public PayUServiceImpl(RestTemplate restTemplate, OrderService orderService, PaymentPayUService paymentPayUService) {
        this.restTemplate = restTemplate;
        this.orderService = orderService;
        this.paymentPayUService = paymentPayUService;
    }

    @Override
    public ResponseEntity<Response> RequestPayU(Long id) {

        OrderDTO order = orderService.findOrderById(id).get().getAsDTO();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("d9a4536e-62ba-4f60-8017-6053211d3f47");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<OrderDTO> request = new HttpEntity<>(order, headers);

        return restTemplate.postForEntity("https://secure.snd.payu.com/api/v2_1/orders", request, Response.class);
    }

    @Override
    public String ResponsePaymentPayU(String id) {


        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("d9a4536e-62ba-4f60-8017-6053211d3f47");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<ResponsePayU> response = restTemplate
                .exchange("https://secure.snd.payu.com/api/v2_1/orders/" + paymentPayUService.findByExtOrderIdIs(id).getOrderId(),
                        HttpMethod.GET,
                        entity,
                        ResponsePayU.class);

        return Objects.requireNonNull(response.getBody())
                .getOrders()
                .get(0)
                .getStatus();
    }
}
