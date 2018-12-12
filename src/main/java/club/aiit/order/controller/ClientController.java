package club.aiit.order.controller;

import club.aiit.order.client.ProductClient;
import club.aiit.order.dto.CartDTO;
import club.aiit.order.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


/**
 * @Author: ghostxbh
 * @Date: 11/12/2018 15:41
 */
@RestController
@Slf4j
public class ClientController {

    //    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        /**
         * 第一种(直接使用RestTemplate，URL写死，不灵活，服务器集群不适合)
         */
        //RestTemplate restTemplate = new RestTemplate();
        //String response = restTemplate.getForObject("http://localhost:8081/msg", String.class);

        /**
         * 第二种(利用LoadBalancerClient通过应用获取url，然后使用RestTemplate)
         */
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/msg";
//        String response = restTemplate.getForObject(url, String.class);

        /**
         * 第三种(利用@LoadBalanced，可用restTemplate里使用应用名字，适合负载均衡)
         */
        //String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);

        /**
         * 使用@FeignClient实现远程访问
         */
        String response = productClient.productMsg();
        log.info("response={}", response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList() {
        List<Product> productList = productClient.listForOrder(Arrays.asList(1, 2));
        log.info("response=>{}", productList);
        return "ok";
    }

    @GetMapping("/decreaseStock")
    public String decreaseStock() {
        CartDTO cartDTO = new CartDTO(1,2);
        productClient.decreaseStock(Arrays.asList(cartDTO));
        log.info("response");
        return "ok";
    }
}
