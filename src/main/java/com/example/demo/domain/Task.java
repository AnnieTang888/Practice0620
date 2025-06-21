package com.example.demo.domain;

import lombok.Data;

@Data
public class Task {
    private int id;
    private String title;
    private String description;
    private String status;
}

