package it.unimi.di.sweng.esame.presenters;

import org.jetbrains.annotations.NotNull;

public class ErroreFattoriaInserisci {


    Errore build (@NotNull String data){
      if (data.split(",").length < 3 ) {
            return  new DescrizioneErrore();
        } else if (isNotANumber(data.split(",")[1])) {
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
