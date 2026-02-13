package ru.netology.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void shouldPlayer1Win() {
        Game game = new Game();
        Player Vasya = new Player(10, "Vasya",120);
        Player Petya = new Player(11, "Petya",100);

        game.register(Vasya);
        game.register(Petya);

        int expected = 1;
        int actual = game.round("Vasya", "Petya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayer2Win() {
        Game game = new Game();
        Player Petya = new Player(11, "Petya",120);
        Player Vasya = new Player(10, "Vasya",100);

        game.register(Vasya);
        game.register(Petya);

        int expected = 2;
        int actual = game.round("Vasya", "Petya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldStreaghtsEqual() {
        Game game = new Game();
        Player Petya = new Player(11, "Petya",100);
        Player Vasya = new Player(10, "Vasya",100);

        game.register(Vasya);
        game.register(Petya);

        int expected = 0;
        int actual = game.round("Vasya", "Petya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFirstNotRegistred() {
        Game game = new Game();
        Player Petya = new Player(11, "Petya",100);
        game.register(Petya);

        Assertions.assertThrows(NotRegisteredException.class, () ->
            game.round("Vasya", "Petya"));
    }

    @Test
    public void shouldSecondNotRegistred() {
        Game game = new Game();
        Player Petya = new Player(11, "Petya",100);
        game.register(Petya);

        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Petya", "Vasya"));
    }
}
