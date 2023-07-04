package it.unimi.di.sweng.esame.presenters;

import org.jetbrains.annotations.NotNull;

public class ErroreFattoriaChiusi {
    Errore build (@NotNull String data){

        if (isNotANumber(data.split(",")[1])){
            return new CampoNumericoErrore();
        }else{
            return new NessunErrore();
        }
    }

    private boolean isNotANumber(String s) {
        try{
            Integer.parseInt(s);
            return false;
        }catch (NumberFormatException e){
            return true;
        }
    }
}
