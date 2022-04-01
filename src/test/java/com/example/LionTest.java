package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)

public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void doesHaveManeMaleReturnsTrue() throws Exception{
        Lion lion = new Lion("Самец", feline);
        boolean expected = true;

        boolean actual = lion.doesHaveMane();

        assertEquals("doesHaveMane: male did not return true", expected, actual);
    }

    @Test
    public void doesHaveManeFemaleReturnsFalse() throws Exception{
        Lion lion = new Lion("Самка", feline);
        boolean expected = false;

        boolean actual = lion.doesHaveMane();

        assertEquals("doesHaveMane: female did not returned true", expected, actual);
    }

    @Test
    public void doesHaveManeThrowsException(){
        String expected = "Используйте допустимые значения пола животного - самей или самка";

        String actual = "";
        try{
            new Lion("other", feline);
        } catch (Exception e){
            actual = e.getMessage();
        }

        assertEquals("hasMane incorrect exception thrown", expected, actual);
    }

    @Test
    public void getKittensReturnsCorrectValue() throws Exception{
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(123);
        int expected = 123;

        int actual = lion.getKittens();

        assertEquals("incorrect number of kittens returned", expected, actual);
    }

    @Test
    public void getFoodReturnsCorrectValue() throws Exception{
        Lion lion = new Lion("Самка", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        List<String> actual = lion.getFood();

        assertEquals("getFood returned incorrect values", actual, expected);
    }

}
