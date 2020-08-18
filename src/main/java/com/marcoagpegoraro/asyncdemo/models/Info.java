package com.marcoagpegoraro.asyncdemo.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Info {
    private String name;
    private String job;
    private LocalDate birthDate;
}
