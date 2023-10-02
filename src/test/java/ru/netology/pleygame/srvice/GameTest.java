package ru.netology.pleygame.srvice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void shouldPlayer1Win() {
        Player Masha = new Player(1, "Маша", 80);
        Player Dasha = new Player(2, "Даша", 63);
        Game game = new Game();

        game.register(Masha);
        game.register(Dasha);
        int actual = game.round("Маша", "Даша");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayer2Win() {
        Player Masha = new Player(1, "Маша", 80);
        Player Misha = new Player(2, "Миша", 93);
        Game game = new Game();

        game.register(Masha);
        game.register(Misha);
        int actual = game.round("Маша", "Миша");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNoWin() {
        Player Sasha = new Player(1, "Саша", 93);
        Player Misha = new Player(2, "Миша", 93);
        Game game = new Game();

        game.register(Sasha);
        game.register(Misha);
        int actual = game.round("Саша", "Миша");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetNotRegisteredExceptionPlayer1() {
        Player Sasha = new Player(1, "Саша", 93);
        Player Misha = new Player(2, "Миша", 93);
        Game game = new Game();

        game.register(Sasha);
        game.register(Misha);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Даша", "Саша")
        );
    }

    @Test
    public void shouldGetNotRegisteredExceptionPlayer() {
        Player Sasha = new Player(1, "Саша", 93);
        Player Misha = new Player(2, "Миша", 93);
        Game game = new Game();

        game.register(Sasha);
        game.register(Misha);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Саша", "Даша")
        );
    }
}
