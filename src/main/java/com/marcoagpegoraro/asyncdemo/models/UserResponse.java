package com.marcoagpegoraro.asyncdemo.models;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String name;
    private String job;
    private LocalDate birthDate;
    private List<Music> musics;
    private List<Quote> quotes;
}
