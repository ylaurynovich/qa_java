package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getFoodReturnsValidValues() throws Exception{
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expected = List.of("Животные", "Птицы", "Рыба");

        List<String> actual = cat.getFood();

        assertEquals("eatMeat method returned wrong values",expected, actual);
    }

    @Test
    public void getSoundReturnsValidValue(){
        Cat cat = new Cat(feline);
        String expected = "Мяу";

        String actual = cat.getSound();

        assertEquals("getSound method returned wrong value", expected, actual);
    }


}
