package modelTest;

import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.model.Observer;
import org.junit.jupiter.api.Test;
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
    public void testRisolvi(){}

    @Test
    public void testNotify(){}


}
