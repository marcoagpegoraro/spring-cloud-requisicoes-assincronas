package com.marcoagpegoraro.asyncdemo.services.musics;

import com.marcoagpegoraro.asyncdemo.models.Music;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "music", url = "http://localhost:3001")
public interface MusicsClient {
    @GetMapping("/{id}")
    ResponseEntity<List<Music>> getMusics(@PathVariable final long id);
}
