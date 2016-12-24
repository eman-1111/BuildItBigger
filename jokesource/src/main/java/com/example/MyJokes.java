package com.example;

import java.util.Random;

public class MyJokes {
    public String funnyJoke(){
        String[] jokes = {
                "\nQ: Why did the boy bring a ladder to school?\n" +
                "\nA: He wanted to go to high school.",

                "\nQ: Where do pencils go for vacation?\n" +
                "\nA: Pencil-vania.",

                " \nQ: Why did the picture go to jail? \n" +
                "\nA: Because it was framed.",

                "\n Q: Why are frogs so happy? \n" +
                "\nA: They eat whatever bugs them",

                "\n Q: What do prisoners use to call each other?\n"+
                "\nA: Cell phones.\n"};

        int idx = new Random().nextInt(jokes.length);
        String randomJoke = (jokes[idx]);

        return randomJoke;
    }
}
