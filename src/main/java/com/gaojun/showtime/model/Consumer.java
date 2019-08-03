package com.gaojun.showtime.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class Consumer implements Serializable {

    private Long id;

    private String name;

    private Integer age;
}
