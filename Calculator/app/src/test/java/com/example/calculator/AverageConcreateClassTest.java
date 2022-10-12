package com.example.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AverageConcreateClassTest {

    Average average = Mockito.mock(Average.class);

    AverageConcreateClass averageConcreateClass = new AverageConcreateClass(average);

    @Test

    public void TestAverage() {
//dummy data

        Mockito.when(average.firstNumber()).thenReturn(500);
        Mockito.when(average.secoundNumber()).thenReturn(10);

        Assert.assertEquals(50, averageConcreateClass.getAverageOfMarks());

    }
}