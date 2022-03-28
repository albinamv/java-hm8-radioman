package ru.netology.domain;

public class Radio {
    private int currentStation;
    private int firstStation = 0;
    private int lastStation = 9;
    private int currentVolume;
    private int minVolume = 0;
    private int maxVolume = 100;

    public Radio() {
    }

    public Radio(int stationsAmount) { // заменила название параметра на amount, т.к. по-моему он лучше отображает своё значение (лучше, чем lastStation — всё таки это НОМЕР последней станции)
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
        if (currentStation > lastStation) {
            return;
        }
        if (currentStation < firstStation) {
            return;
        }
        this.currentStation = currentStation;
    }

    public void nextStation() {
        if (currentStation < lastStation) {
            currentStation++;
        } else {
            currentStation = firstStation;
        }
    }

    public void prevStation() {
        if (currentStation > firstStation) {
            currentStation--;
        } else {
            currentStation = lastStation;
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
