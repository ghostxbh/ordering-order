package club.aiit.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @Author: ghostxbh
 * @Date: 11/12/2018 15:41
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;
//    @Autowired
//    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        /**
         * 第一种(直接使用RestTemplate，URL写死，不灵活，服务器集群不适合)
         */
        RestTemplate restTemplate = new RestTemplate();
        //String response = restTemplate.getForObject("http://localhost:8081/msg", String.class);

        /**
         * 第二种(利用LoadBalancerClient通过应用获取url，然后使用RestTemplate)
         */
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/msg";
        String response = restTemplate.getForObject(url, String.class);

        /**
         * 第三种(利用@LoadBalanced，可用restTemplate里使用应用名字，适合负载均衡)
         */
        //String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        log.info("response={}", response);
        return response;
    }
}
