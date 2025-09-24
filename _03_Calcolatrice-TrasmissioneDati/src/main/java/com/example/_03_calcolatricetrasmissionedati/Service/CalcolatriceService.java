package com.example._03_calcolatricetrasmissionedati.Service;

import org.springframework.stereotype.Service;

@Service
public class CalcolatriceService {
    public float add(float a, float b){
        return a+b;
    }

    public float sub(float a, float b){
        return a-b;
    }

    public float mul(float a, float b){
        return a*b;
    }

    public float div(float a, float b){
        if(b==0){
            throw new ArithmeticException("Hai messo 0 al denominatore");
        }
        return a/b;
    }
}