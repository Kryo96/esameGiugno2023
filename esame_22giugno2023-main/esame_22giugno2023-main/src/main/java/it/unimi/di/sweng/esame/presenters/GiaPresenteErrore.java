package it.unimi.di.sweng.esame.presenters;

public class GiaPresenteErrore extends Errore {
    @Override
    public String ritornaErrore() {
        return "altra segnalazione già presente per questo tratto";
    }
}
