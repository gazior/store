package pl.com.szymanski.store.web;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.com.szymanski.store.domain.PayU.ResponsePayU;
import pl.com.szymanski.store.service.PaymentPayUService;

@Controller
public class PayUController {

    private final RestTemplate restTemplate;

    private final PaymentPayUService paymentPayUService;

    public PayUController(RestTemplate restTemplate, PaymentPayUService paymentPayUService) {
        this.restTemplate = restTemplate;
        this.paymentPayUService = paymentPayUService;
    }

    @GetMapping(value = "/continue/{id}")
    @ResponseBody
    public ResponseEntity<String> acceptedPayment(@PathVariable String id) {


        HttpEntity<String> entity = new HttpEntity<>("parameters", setHeaders());

        ResponseEntity<String> response = restTemplate
                .exchange("https://secure.snd.payu.com/api/v2_1/orders/" + paymentPayUService.findByExtOrderIdIs(id).getOrderId(),
                        HttpMethod.GET,
                        entity,
                        String.class);

        return response;

    }

    @GetMapping(value = "/continue/order/{id}")
    //@ResponseBody
    public ResponseEntity<ResponsePayU> acceptedPayment1(@PathVariable String id) {

        HttpEntity<String> entity = new HttpEntity<>("parameters", setHeaders());

        ResponseEntity<ResponsePayU> response = restTemplate
                .exchange("https://secure.snd.payu.com/api/v2_1/orders/" + paymentPayUService.findByExtOrderIdIs(id).getOrderId(),
                        HttpMethod.GET,
                        entity,
                        ResponsePayU.class);

        return response;

    }

    private HttpHeaders setHeaders() {

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("d9a4536e-62ba-4f60-8017-6053211d3f47");
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
