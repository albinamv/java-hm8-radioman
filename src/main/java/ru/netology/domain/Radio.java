package ru.netology.domain;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class Radio {
    private int currentStation;
    private int firstStation = 0;
    private int lastStation = 9; // оставила переменную с номером последней станции, т.к. код уже до этого был под неё написан и соответствовал новым требованиям задачи
    private int stationsAmount = 10;
    private int currentVolume;
    private int minVolume = 0;
    private int maxVolume = 100;

    public Radio(int stationsAmount) {
        this.stationsAmount = stationsAmount;
        lastStation = stationsAmount - 1;
    }

    // конструктор только для тестов на изменение уровня громкости
    public Radio(int currentVolume, int maxVolume) {
        this.currentVolume = currentVolume;
        this.maxVolume = maxVolume;
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
