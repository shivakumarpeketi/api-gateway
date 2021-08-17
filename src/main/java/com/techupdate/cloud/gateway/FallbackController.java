package com.techupdate.cloud.gateway;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/orderServiceFallback")
    public Mono<String> orderServiceFallback(){
        return Mono.just("It seems to be Order service down now, please try again later");
    }

    @RequestMapping("/paymentServiceFallback")
    public Mono<String> paymentServiceFallback(){
        return Mono.just("It seems to be Payment service down now, please try again later");
    }

    public static void main(String[] args) {
        short pre1 = 0;
        short pre2 = 0;
        Short W1 = Short.valueOf((short) 0);
        Short W2 = Short.valueOf((short) 0);
        System.out.println("pre1 to pre2: " +( pre1 == pre2));
        System.out.println("pre1 to pre1: " +( pre1 == pre1));
        System.out.println("W1 to W1: " +( W1 == W1));
        System.out.println("W1 to W2: " +( W1 == W2));
        System.out.println("pre1 to W1: " +( pre1 == W2.shortValue()));
    }
}
