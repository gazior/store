package pl.com.szymanski.store.web;

import org.springframework.web.bind.annotation.*;
import pl.com.szymanski.store.domain.*;
import pl.com.szymanski.store.domain.PayU.Buyer;
import pl.com.szymanski.store.domain.PayU.ResponsePayU;
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
    public void notifyPayUPOST(@RequestParam ResponsePayU responsePayU) {
        System.out.println(responsePayU);
        System.out.println("notify działa");
        productService.saveProduct(new Product(null,"test",111d,"test"));
    }

}
