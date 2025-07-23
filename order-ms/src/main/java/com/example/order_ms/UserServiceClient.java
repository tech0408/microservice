package com.example.order_ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserServiceClient {

    private final WebClient webClient;

    @Autowired
    public UserServiceClient(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl("http://USER-SERVICE").build(); // use Eureka service name.
    }

    public String getUser(Long userId){

        return webClient.get()
                .uri("/users/{id}",userId)
                .retrieve()
                .bodyToMono(String.class)
                .block(); //blocking call since using synchronous example here.
    }
}
