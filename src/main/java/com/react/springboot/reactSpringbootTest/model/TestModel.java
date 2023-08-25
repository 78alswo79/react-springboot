package com.react.springboot.reactSpringbootTest.model;

import jakarta.persistence.*;
import org.springframework.context.annotation.Bean;

@Entity
@Table (name = "test")
public class TestModel {

//  intelij 게터세서 단축키 alt + insert
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "text")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
