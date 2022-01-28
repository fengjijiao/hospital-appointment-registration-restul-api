package com.example.demo.o.vo;

import lombok.*;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode
public class ResultT<T extends List> {
    private T data;
    private int length;

    public ResultT(T data) {
        this.data = data;
        this.length = data.size();
    }
}
