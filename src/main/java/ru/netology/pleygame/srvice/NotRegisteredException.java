package ru.netology.pleygame.srvice;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {
        super("Игрок с именем " + playerName + " не найден");
    }
}
