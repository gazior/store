package pl.com.szymanski.store.web;

import org.springframework.web.bind.annotation.*;
import pl.com.szymanski.store.domain.*;
import pl.com.szymanski.store.service.OrderService;
import pl.com.szymanski.store.service.ProductService;

@RestController
public class RestExample {

    private final OrderService orderService;
    private final ProductService productService;

    public RestExample(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }

    @PutMapping(value = "/notify")
    @ResponseBody
    public void notifyPayU() {
            productService.saveProduct(new Product(null,"test",111d,"test"));
    }

    @PostMapping(value = "/notify")
    @ResponseBody
    public void notifyPayUPOST() {
        productService.saveProduct(new Product(null,"test",111d,"test"));
    }

    @GetMapping(value = "/rest")
    public Payu jsonorder() {
        Payu payU = new Payu();
        Buyer buyer = new Buyer();
        Product1 product1 = new Product1();
        Product1 product2 = new Product1();
        Product1 product3 = new Product1();
        Product1 product4 = new Product1();


        Order order = orderService.findOrderById(1L);

        buyer.setEmail(order.getAddress().getEmail());
        buyer.setLanguage("pl");
        buyer.setPhone("571411263");
        buyer.setFirstName(order.getAddress().getFirstName());
        buyer.setLastName(order.getAddress().getLastName());


        payU.setBuyer(buyer);
        //payU.setProducts(order.getOrderDetails());
        payU.setCurrencyCode("PLN");
        payU.setCustomerIp("127.0.0.1");
        payU.setNotifyUrl("https://localhost/continue");
        payU.setMerchantPosId("145227");
        payU.setTotalAmount(order.getSumPrice().toString());
        payU.setDescription("store");

        return payU;
    }
}
