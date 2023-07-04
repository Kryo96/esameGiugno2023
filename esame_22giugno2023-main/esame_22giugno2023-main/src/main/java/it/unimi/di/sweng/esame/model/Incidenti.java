package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class Incidenti implements Comparable<Incidenti> {
    private final String id;
    private final int km;
    private final String motivazione;

    public Incidenti(String id, int km, String motivazione) {
        this.id = id;
        this.km = km;
        this.motivazione = motivazione;
    }

    @Override
    public int compareTo(@NotNull Incidenti o) {
        return 0;
    }

    public String id() {
        return id;
    }

    public int km() {
        return km;
    }

    public String motivazione() {
        return motivazione;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Incidenti) obj;
        return Objects.equals(this.id, that.id) &&
                this.km == that.km &&
                Objects.equals(this.motivazione, that.motivazione);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, km, motivazione);
    }

    @Override
    public String toString() {
        return this.motivazione + " sulla "  + this.id + " al Km " + this.km;
    }

}
