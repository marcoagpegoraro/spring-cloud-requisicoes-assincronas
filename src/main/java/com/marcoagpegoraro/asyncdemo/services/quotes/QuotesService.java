package com.marcoagpegoraro.asyncdemo.services.quotes;

import com.marcoagpegoraro.asyncdemo.models.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotesService {

    @Autowired
    QuotesClient client;

    @Async
    public List<Quote> getInfos(final long id){
        return client.getQuotes(id).getBody();
    }
}
