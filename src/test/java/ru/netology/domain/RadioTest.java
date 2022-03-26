package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void shouldInitializeRadio() {
        Radio item = new Radio();

        // проверяем, что все поля объекта инициализировались с нужными значениями
        assertEquals(0, item.getCurrentStation());
        assertEquals(0, item.getCurrentVolume());
        assertEquals(0, item.getFirstStation());
        assertEquals(9, item.getLastStation());
        assertEquals(0, item.getMinVolume());
        assertEquals(10, item.getMaxVolume());
    }

    @Test
    void shouldSetStationBelowRange() {
        Radio item = new Radio();

        int station = -1;
        int expected = 0;

        item.setCurrentStation(station);
        int actual = item.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSetStationInRange() {
        Radio item = new Radio();

        int station = 4;
        int expected = 4;

        item.setCurrentStation(station);
        int actual = item.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSetStationAboveRange() {
        Radio item = new Radio();

        int station = 89;
        int expected = 0;

        item.setCurrentStation(station);
        int actual = item.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSwitchToNextStation() {
        Radio item = new Radio();

        int expected = 1;

        item.nextStation();
        int actual = item.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSwitchToFirstStation() {
        Radio item = new Radio();

        int expected = item.getFirstStation();

        item.setCurrentStation(item.getLastStation());
        item.nextStation();

        int actual = item.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSwitchToPrevStation() {
        Radio item = new Radio();

        int station = 5;
        int expected = 4;

        item.setCurrentStation(station);
        item.prevStation();

        int actual = item.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSwitchToLastStation() {
        Radio item = new Radio();

        int expected = item.getLastStation();
        item.prevStation();

        int actual = item.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldIncreaseVolume() {
        Radio item = new Radio();

        int expected = 1;
        item.increaseVolume();

        int actual = item.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void shouldDecreaseVolume() {
        Radio item = new Radio();

        int expected = 4;

        for (int i = 0; i < 5; i++) {
            item.increaseVolume();
        }

        item.decreaseVolume();

        int actual = item.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotDecreaseMinimumVolume() {
        Radio item = new Radio();

        int expected = item.getMinVolume();
        item.decreaseVolume();

        int actual = item.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotIncreaseMaximumVolume() {
        Radio item = new Radio();

        int maxVolume = item.getMaxVolume();
        int expected = maxVolume;

        for (int i = 0; i <= maxVolume; i++) {
            item.increaseVolume();
        }

        int actual = item.getCurrentVolume();

        assertEquals(expected, actual);
    }
}