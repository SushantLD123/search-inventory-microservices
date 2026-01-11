package com.example.Search.Service.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Search.Service.Service.SearchService;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService service;

    public SearchController(SearchService service) {
        this.service = service;
    }

    @GetMapping("/cheap")
    public List<String> getCheapProducts() {
        return service.cheapProducts();
    }
}
