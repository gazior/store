package pl.com.szymanski.store.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.com.szymanski.store.domain.*;

import java.util.Arrays;

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
    public ResponseEntity<Response> RequestPayU(Payu payU, Buyer buyer, Product1 product1, Long id) {

        Order order = orderService.findOrderById(id);

        buyer.setEmail(order.getAddress().getEmail());
        buyer.setLanguage("pl");
        buyer.setPhone("654111654");
        buyer.setFirstName(order.getAddress().getFirstName());
        buyer.setLastName(order.getAddress().getLastName());

        product1.setName("test");
        product1.setQuantity("1");
        product1.setUnitPrice("2000");

        payU.setBuyer(buyer);
        payU.setProducts(Arrays.asList(product1));
        payU.setCurrencyCode("PLN");
        payU.setCustomerIp("127.0.0.1");
        //payU.setExtOrderId(id+"");
        payU.setNotifyUrl("http://localhost:8080/notify");
        payU.setContinueUrl("http://localhost:8080/order/" + id);
        payU.setMerchantPosId("300746");
        payU.setTotalAmount(order.getSumPrice().intValue() + "0");
        payU.setDescription("store");

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("d9a4536e-62ba-4f60-8017-6053211d3f47");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Payu> request = new HttpEntity<>(payU, headers);

        return restTemplate.postForEntity("https://secure.snd.payu.com/api/v2_1/orders", request, Response.class);
    }

    @Override
    public String ResponsePaymentPayU(String id) {


        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("d9a4536e-62ba-4f60-8017-6053211d3f47");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<String> response = restTemplate
                .exchange("https://secure.snd.payu.com/api/v2_1/orders/" + paymentPayUService.findByExtOrderIdIs(id).getOrderId(),
                        HttpMethod.GET,
                        entity,
                        String.class);

        return response.getStatusCode().toString();
    }
}
