package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Observable {

    void addObserver(@NotNull Observer obs);
    void notifyObservers();

    @NotNull List<Incidenti> getIncidentiAperti ();
    @NotNull List<Incidenti> getIncidentiChiusi ();

}
