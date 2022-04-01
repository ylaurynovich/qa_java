package com.example;

import com.example.Feline;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.assertEquals;

import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class FelineTest {

    @Test
    public void eatMeatReturnsCorrectValue() throws Exception{
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        List<String> actual = feline.eatMeat();

        assertEquals("eatMeat returned incorrect value", expected, actual);
    }

    @Test
    public void getFamilyReturnsFeline() throws Exception{
        Feline feline = new Feline();
        String expected = "Кошачьи";

        String actual = feline.getFamily();

        assertEquals("getFamily did not returned feline", expected, actual);
    }

    @Test
    @Parameters({"-123456789", "0", "123456789"})
    public void getKittensWithArgumentReturnsIt(int kittensCount){
        Feline feline = new Feline();

        int actual = feline.getKittens(kittensCount);

        assertEquals("getKittens did not returned correct argument sent",kittensCount, actual);

    }

    @Test
    public void getKittensWithNoArgumentsReturns1(){
        Feline feline = new Feline();
        int expected = 1;

        int actual = feline.getKittens();

        assertEquals("getKittens did not returned 1 with no argument sent", expected, actual);
    }

}
