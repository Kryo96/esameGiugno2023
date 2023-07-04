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
        ErroreFattoriaInserisci efi = new ErroreFattoriaInserisci();
        Errore check;

        if(text1.equals("Segnala")){
             check = efi.build(text2);
            if(!check.ritornaErrore().equals("k")){
                view.showError(check.ritornaErrore());
            }else{
               int tmp = model.addToListaIncidenti(text2);
                if(!parseActionReturn(tmp).equals("k")){
                    view.showError(parseActionReturn(tmp));
                }else{
                    view.showSuccess();
                }

            }
        }else{
            ErroreFattoriaChiusi efc = new ErroreFattoriaChiusi();
            check = efc.build(text2);
            if(!check.ritornaErrore().equals("k")){
                view.showError(check.ritornaErrore());
            }else{
                 int tmp = model.chiudiSegnalazione(text2);
                 if(!parseActionReturn(tmp).equals("k")){
                     view.showError(parseActionReturn(tmp));
                 }else{
                     view.showSuccess();
                 }

                }
            }
        }


        public static String parseActionReturn(int a){
            if(a == -2){
                return "altra segnalazione già presente per questo tratto";
            } else if (a == -3) {
                return "segnalazione non presente per questo tratto";
            }else if (a == -1){
                return "lista piena";
            }else{
                return "k";
            }
        }
    }
