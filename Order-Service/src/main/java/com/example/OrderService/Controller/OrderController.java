package com.example.OrderService.Controller;

import com.example.OrderService.ExtrenalClasses.Product;
import com.example.OrderService.Model.Order;
import com.example.OrderService.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/order-service")
public class OrderController {


@Autowired
WebClient.Builder webClientBuilder;
    @Autowired
    OrderService orderService;

    @PostMapping("/orderItem")
    public void orderItem(@RequestBody Order order){
        System.out.println("id:"+order.getProductId());
       Product product= webClientBuilder.build().post()
                        .uri("http://www.localhost:8901/product-service/checkProduct/"+order.getProductId())
                                .retrieve()
                                        .bodyToMono(Product.class)
                                                .block();


        System.out.println("From order Service after webclient call with productname:"+product.getName());
//        orderService.saveOrder(order);

    }
    @GetMapping("/allOrders")
    public List<Order> allOrders(){

        return orderService.getAllOrders();
    }


}
