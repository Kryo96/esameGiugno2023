package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Model implements Observable{

    // struttura dati che comprenda motivo, id, km
    // Rendere struttura dati riordinabile
    // reference escaping

    private List<Incidenti> listaIncidenti = new ArrayList<>();
    private List<Incidenti> listaChiusi = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public String addToListaIncidenti(String data){
        if(listaIncidenti.size() < 8){
            return "pieno";
        }else if("altra condizione"){

        }else {
            String[] tmp = data.split(",");
            Incidenti incidente = new Incidenti(tmp[0], Integer.parseInt(tmp[1]), tmp[2]);
            listaIncidenti.add(incidente);
            notifyObservers();
            return "";
        }
    }

    public String chiudiSegnalazione(String data){

        return "";
    }

    @Override
    public void addObserver(@NotNull Observer obs) {
        observers.add(obs);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs: observers) {
            obs.update(this);
        }
    }

    @Override
    public @NotNull List<Incidenti> getIncidentiAperti() {
        return Collections.unmodifiableList(listaIncidenti);
    }

    @Override
    public @NotNull List<Incidenti> getIncidentiChiusi() {
        return Collections.unmodifiableList(listaChiusi);
    }
}
