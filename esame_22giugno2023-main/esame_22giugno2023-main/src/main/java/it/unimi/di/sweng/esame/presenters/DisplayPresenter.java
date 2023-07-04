package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Incidenti;
import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.model.Observable;
import it.unimi.di.sweng.esame.model.Observer;
import it.unimi.di.sweng.esame.views.DisplayView;
import org.jetbrains.annotations.Async;
import org.jetbrains.annotations.NotNull;

public class DisplayPresenter implements Observer {

    private final DisplayView viewRight;
    private Model model;
    private DisplayView viewLeft;
    public DisplayPresenter(Model m, DisplayView left, DisplayView right){
        model = m;
        viewLeft = left;
        viewRight = right;

        m.addObserver(this);
    }

    @Override
    public void update(@NotNull Observable model) {
        int i = 0;
        for (Incidenti inc: model.getIncidentiAperti()) {
            viewLeft.set(i, inc.toString());
            i++;
        }
        for(; i < viewLeft.size(); i++){
            viewLeft.set(i, "");
        }

        int j = 0;
        for(Incidenti enc: model.getIncidentiChiusi()){
            viewRight.set(j, enc.toString());
            j++;
        }

        for(; j < viewRight.size(); j++){
            viewRight.set(j, "");
        }




    }
}
