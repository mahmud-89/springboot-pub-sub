package com.example.springbootexercise.rqueue.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentRequestBody implements RQBaseObject{
    private String name;
    private int age;
}