package com.marcoagpegoraro.asyncdemo.services.quotes;

import com.marcoagpegoraro.asyncdemo.models.Quote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "quote",
        url = "http://localhost:3003")
public interface QuotesClient {
    @GetMapping("/{id}")
    ResponseEntity<List<Quote>> getQuotes(
            @PathVariable final Long id);
}
