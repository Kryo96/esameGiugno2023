package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Model implements Observable{

    // struttura dati che comprenda motivo, id, km
    // Rendere struttura dati riordinabile
    // reference escaping

    private CopyOnWriteArrayList<Incidenti> listaIncidenti = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Incidenti> listaChiusi = new CopyOnWriteArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public Model(){
    }

    public int addToListaIncidenti(String data){
        if(listaIncidenti.size() < 8) {
            String[] tmp = data.split(",");
            Incidenti incidente = new Incidenti(tmp[0], Integer.parseInt(tmp[1]), tmp[2]);

            if(!listaIncidenti.contains(incidente)){
                listaIncidenti.add(incidente);
                notifyObservers();
            }else{
                return -2;
            }
        }else{
            return -1;
        }
        return 0;
    }

    public int chiudiSegnalazione(String data){
        boolean checkCampi = false;
        for (Incidenti s: listaIncidenti) {
            if(s.id().equals(data.split(",")[0]) && s.km() == Integer.parseInt(data.split(",")[1])){
                checkCampi = true;
                listaChiusi.add(s);
                listaIncidenti.remove(s);
                notifyObservers();
            }
        }
        if(!checkCampi)
            return -3;
        return 0;
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
