package com.marcoagpegoraro.asyncdemo.services.infos;

import com.marcoagpegoraro.asyncdemo.models.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class InfosService {

    @Autowired
    InfosClient client;

    @Async
    public Info getInfos(final long id){
        return client.getInfos(id).getBody();
    }
}
