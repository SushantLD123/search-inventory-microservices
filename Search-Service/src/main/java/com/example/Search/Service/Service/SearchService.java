package com.example.Search.Service.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.Search.Service.dto.ProductDTO;

@Service
public class SearchService {

    private final WebClient webClient;

    public SearchService(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<String> cheapProducts() {

        ProductDTO[] products = webClient.get()
                .uri("http://localhost:8080/products")
                .retrieve()
                .bodyToMono(ProductDTO[].class)
                .block();

        if (products == null) {
            return Collections.emptyList();
        }

        return Arrays.stream(products)
                .filter(p -> p.getPrice() < 50)
                .map(ProductDTO::getName)
                .sorted()
                .collect(Collectors.toList()); 
    }
}
