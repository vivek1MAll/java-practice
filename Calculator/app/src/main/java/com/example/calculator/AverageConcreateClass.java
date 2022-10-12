package com.example.calculator;

public class AverageConcreateClass {

    Average average;

    public AverageConcreateClass(Average average) {
        this.average = average;
    }

    public int getAverageOfMarks(){
        return average.firstNumber()/ average.secoundNumber();
    }

}
