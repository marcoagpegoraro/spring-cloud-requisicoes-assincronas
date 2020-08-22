package com.marcoagpegoraro.asyncdemo.services.musics;

import com.marcoagpegoraro.asyncdemo.models.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicsService {

    @Autowired
    MusicsClient client;

    @Async
    public List<Music> getInfos(final long id) {
        return client.getMusics(id).getBody();
    }
}
