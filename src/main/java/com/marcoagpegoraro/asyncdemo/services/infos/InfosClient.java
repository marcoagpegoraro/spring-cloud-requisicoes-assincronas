package com.marcoagpegoraro.asyncdemo.services.infos;

import com.marcoagpegoraro.asyncdemo.models.Info;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "info", url = "http://localhost:3002")
public interface InfosClient {
    @GetMapping("/{id}")
    ResponseEntity<Info> getInfos(@PathVariable final long id);
}
