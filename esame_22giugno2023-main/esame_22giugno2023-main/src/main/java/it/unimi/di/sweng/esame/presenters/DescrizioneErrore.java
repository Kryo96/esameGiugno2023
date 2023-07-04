package it.unimi.di.sweng.esame.presenters;

public class DescrizioneErrore extends Errore{
    @Override
    public String ritornaErrore() {
        return "campo descrizione mancante";
    }
}
