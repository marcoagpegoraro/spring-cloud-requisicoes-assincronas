package com.marcoagpegoraro.asyncdemo.controllers;

import com.marcoagpegoraro.asyncdemo.models.Info;
import com.marcoagpegoraro.asyncdemo.models.Music;
import com.marcoagpegoraro.asyncdemo.models.Quote;
import com.marcoagpegoraro.asyncdemo.models.UserResponse;
import com.marcoagpegoraro.asyncdemo.services.infos.InfosService;
import com.marcoagpegoraro.asyncdemo.services.musics.MusicsService;
import com.marcoagpegoraro.asyncdemo.services.quotes.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class UserController {

    @Autowired
    private InfosService infosService;
    @Autowired
    private MusicsService musicsService;
    @Autowired
    private QuotesService quotesService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getAllInfoUsers(@PathVariable final long id){
        final long startTime = System.currentTimeMillis();

        final Info infos = infosService.getInfos(id);

        final List<Music> musics = musicsService.getInfos(id);

        final List<Quote> quotes = quotesService.getInfos(id);

        final UserResponse user = UserResponse.builder()
                .name(infos.getName())
                .job(infos.getJob())
                .birthDate(infos.getBirthDate())
                .musics(musics)
                .quotes(quotes)
                .build();

        final long endTime = System.currentTimeMillis();
        final float secFinal = (endTime - startTime) / 1000F; System.out.println("Total: " + secFinal);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/async/{id}")
    public ResponseEntity<UserResponse> getAllInfoUsersAsync(@PathVariable final long id) throws ExecutionException, InterruptedException {
        final long startTime = System.currentTimeMillis();

        final CompletableFuture<Info> infosFuture =
                CompletableFuture.supplyAsync(() -> infosService.getInfos(id));
        final CompletableFuture<List<Music>> musicsFuture =
                CompletableFuture.supplyAsync(() -> musicsService.getInfos(id));
        final  CompletableFuture<List<Quote>> quotesFuture =
                CompletableFuture.supplyAsync(() -> quotesService.getInfos(id));

        final Info infos = infosFuture.get();
        final UserResponse user = UserResponse.builder()
                .name(infos.getName())
                .job(infos.getJob())
                .birthDate(infos.getBirthDate())
                .musics(musicsFuture.get())
                .quotes(quotesFuture.get())
                .build();

        final long endTime = System.currentTimeMillis();
        final float secFinal = (endTime - startTime) / 1000F; System.out.println("Total: " + secFinal);

        return ResponseEntity.ok(user);
    }
}