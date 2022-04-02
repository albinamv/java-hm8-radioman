package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void shouldInitNumOfFirstStation() {
        Radio item = new Radio();

        int expected = 0;
        int actual = item.getFirstStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldInitNumOfLastStation() {
        Radio item = new Radio(15);

        int expected = 14;
        int actual = item.getLastStation();

        assertEquals(expected, actual);
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
        Radio item = new Radio(15);

        int station = 4;
        int expected = 4;

        item.setCurrentStation(station);
        int actual = item.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSetStationAboveRange() {
        Radio item = new Radio(15);

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
        Radio item = new Radio(15);

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
        Radio item = new Radio(50, 100);
        int expected = 49;

        item.decreaseVolume();
        int actual = item.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotDecreaseMinimumVolume() {
        Radio item = new Radio();

        int expected = 0;
        item.decreaseVolume();

        int actual = item.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotIncreaseMaximumVolume() {
        Radio item = new Radio(100, 100);

        int expected = 100;
        item.increaseVolume();

        int actual = item.getCurrentVolume();

        assertEquals(expected, actual);
    }
}