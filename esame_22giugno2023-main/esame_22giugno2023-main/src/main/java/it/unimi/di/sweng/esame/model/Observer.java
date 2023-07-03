package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

public interface Observer {

    void update(@NotNull Observable model);
}