package ru.netology.domain;

public class Radio {
    private int currentStation;
    private int firstStation = 0;
    private int lastStation = 9; // оставила переменную с номером последней станции, т.к. код уже до этого был под неё написан и соответствовал новым требованиям задачи
    private int stationsAmount = 10;
    private int currentVolume;
    private int minVolume = 0;
    private int maxVolume = 100;

    public Radio() {
    }

    public Radio(int stationsAmount) {
        this.stationsAmount = stationsAmount;
        lastStation = stationsAmount - 1;
    }

    // конструктор только для тестов на изменение уровня громкости
    public Radio(int currentVolume, int maxVolume) {
        this.currentVolume = currentVolume;
        this.maxVolume = maxVolume;
    }

    public int getFirstStation() {
        return firstStation;
    }

    public int getLastStation() {
        return lastStation;
    }

    public int getStationsAmount() {
        return stationsAmount;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation > stationsAmount - 1) {
            return;
        }
        if (currentStation < firstStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void nextStation() {
        if (currentStation < stationsAmount - 1) {
            currentStation++;
        } else {
            currentStation = firstStation;
        }
    }

    public void prevStation() {
        if (currentStation > firstStation) {
            currentStation--;
        } else {
            currentStation = stationsAmount - 1;
        }
    }

    public void increaseVolume() {
        if (currentVolume < maxVolume) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > minVolume) {
            currentVolume--;
        }
    }

}
