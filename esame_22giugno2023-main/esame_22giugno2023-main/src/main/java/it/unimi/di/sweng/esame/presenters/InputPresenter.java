package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.views.CentralStationView;

public class InputPresenter implements Presenter {
    private Model model;
    private CentralStationView view;


    public InputPresenter(Model m, CentralStationView v){
        model = m;
        this.view = v;
        v.addHandlers(this);
    }


    @Override
    public void action(String text1, String text2) {
        ErroreFattoriaInserisci efc = new ErroreFattoriaInserisci();
        Errore check;

        if(text1.equals("Segnala")){
             check = efc.build(text2);
            if(!check.ritornaErrore().equals("k")){
                view.showError(check.ritornaErrore());
            }else{

               int tmp = model.addToListaIncidenti(text2);
               check = efc.build(Integer.toString(tmp));
               if(!check.ritornaErrore().equals("k")){
                   view.showError(check.ritornaErrore());
               }else{
                   view.showSuccess();
               }

            }
        }else{



        }

    }
}
