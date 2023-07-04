package modelTest;

import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.model.Observer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TestModel {


    @Test
    public void testAddrecord(){
        Model sut = new Model();

        sut.addToListaIncidenti("A4,15,incidente");

        assertThat(sut.getIncidentiAperti().get(0).toString()).isEqualTo("incidente sulla A4 al km 15");
    }

    @Test
    public void testAddDoppio(){
        Model sut = new Model();
        sut.addToListaIncidenti("A4,15,Incidente");
        sut.addToListaIncidenti("A4,15,Incidente");
        sut.addToListaIncidenti("A4,22,coda");

        assertThat(sut.getIncidentiAperti().size()).isEqualTo(2);

    }

    @Test
    public void testRimuovi(){
        Model sut = new Model();
        sut.addToListaIncidenti("A4,15,Incidente");
        sut.addToListaIncidenti("A4,22,coda");
        sut.chiudiSegnalazione("A4,15");
        assertThat(sut.getIncidentiAperti().size()).isEqualTo(1);
        assertThat(sut.getIncidentiChiusi().size()).isEqualTo(1);
        assertThat(sut.getIncidentiAperti().get(0).toString()).isEqualTo("coda sulla A4 al km 22");
        assertThat(sut.getIncidentiChiusi().get(0).toString()).isEqualTo("Incidente sulla A4 al km 15");

    }

    @Test
    public void testNotify(){
        Model sut = new Model();
        Observer obs = Mockito.mock(Observer.class);
        sut.addObserver(obs);

        sut.addToListaIncidenti("A4,22,coda");

        verify(obs, times(1)).update(sut);
    }


}
