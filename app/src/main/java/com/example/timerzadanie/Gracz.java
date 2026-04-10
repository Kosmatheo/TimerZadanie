package com.example.timerzadanie;

import android.os.CountDownTimer;
import android.widget.Button;

public class Gracz {
    private int liczbaSekund;
    private boolean czyAktywny;
    private CountDownTimer countDownTimer;
    private Button button;

    public Gracz(boolean czyAktywny, Button button) {
        this.czyAktywny = czyAktywny;
        this.button = button;
        liczbaSekund = 100;
        if(czyAktywny) {
            uruchomZegar();
        }
    }
    public void odwrocAktywny(){
        czyAktywny = !czyAktywny;
        if(czyAktywny){
            uruchomZegar();
        }
        else{
            zatrzymjZegar();
        }
    }

    private void uruchomZegar(){
        countDownTimer = new CountDownTimer(liczbaSekund*1000,1000) {
            @Override
            public void onFinish() {

            }

            @Override
            public void onTick(long l) {
                liczbaSekund = (int)l/1000;
                if(liczbaSekund != 0) {
                    button.setText(wyswietlLadnie(liczbaSekund));
                }
                else{
                    button.setText("przegrałeś");
                }
            }
        };
        countDownTimer.start();
    }
    private void zatrzymjZegar(){
        countDownTimer.cancel();
    }
    private String wyswietlLadnie(int liczbaSekund){
        int sek = liczbaSekund%60;
        int min = (liczbaSekund/60)%60;
        return String.format("%02d:%02d" , min , sek);
    }
}
