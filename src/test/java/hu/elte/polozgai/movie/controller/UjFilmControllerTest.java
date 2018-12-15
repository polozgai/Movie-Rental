package hu.elte.polozgai.movie.controller;

import hu.elte.polozgai.movie.model.Film;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class UjFilmControllerTest {
    
    public UjFilmControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddFilm() throws Exception{
        int id=200;
        String cim="elte";
        String rendezo="elte";
        String szereplo="elte";
        String ev="2018";
        String hossz="50";
        String adathordozo="DVD";
        String blob="C:\\Users\\User\\Desktop\\kepek\\thor.jpg";
        boolean eredeti=true;
        
        UjFilmController controller=new UjFilmController();
        controller.addFilm(id, cim, rendezo, szereplo, ev, hossz, adathordozo, blob, eredeti);
        
        List<Film> filmLista=Film.init();
        for(int i=0;i<filmLista.size();i++){
            if(filmLista.get(i).getCim().equals(cim)){
                assertTrue(true);
            }
        }
    }
    
    @Test (expected = Exception.class)
    public void testAddFilmEx() throws Exception{
        int id=199;
        String cim="elte";
        String rendezo="elte";
        String szereplo="elte";
        String ev="2018";
        String hossz="50";
        String adathordozo="DVD";
        String blob="C:\\Users\\User\\Desktop\\kepek\\thor.jpg";
        boolean eredeti=true;

        UjFilmController controller=new UjFilmController();

        controller.addFilm(id, cim, rendezo, szereplo, ev, hossz, adathordozo, blob, eredeti);
    }
    
    
    @Test (expected = Exception.class)
    public void testAddFilmEx2() throws Exception{
        int id=300;
        String cim="";
        String rendezo="elte2";
        String szereplo="elte2";
        String ev="1";
        String hossz="50";
        String adathordozo="DVD";
        String blob="C:\\Users\\User\\Desktop\\kepek\\thor.jpg";
        boolean eredeti=true;

        UjFilmController controller=new UjFilmController();

        controller.addFilm(id, cim, rendezo, szereplo, ev, hossz, adathordozo, blob, eredeti);
    }
    
    @Test (expected = Exception.class)
    public void testAddFilmEx3() throws Exception{
        int id=201;
        String cim="elte3";
        String rendezo="elte3";
        String szereplo="elte3";
        String ev="sddd";
        String hossz="50";
        String adathordozo="DVD";
        String blob="C:\\Users\\User\\Desktop\\kepek\\thor.jpg";
        boolean eredeti=true;

        UjFilmController controller=new UjFilmController();

        controller.addFilm(id, cim, rendezo, szereplo, ev, hossz, adathordozo, blob, eredeti);
    }
    
}
