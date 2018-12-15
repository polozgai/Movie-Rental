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
 * @author polozgai
 */
public class ModositasControllerTest {
    
    public ModositasControllerTest() {
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
    public void testEditFilm() throws Exception{
        ModositasController modositasController=new ModositasController();
        UjFilmController ujFilmController=new UjFilmController();
        ujFilmController.addFilm(300, "Edit", "Edit", "Edit", "0", "0", "DVD", "C:\\Users\\User\\Desktop\\kepek\\thor.jpg", true);
        modositasController.editFilm(300, "e", "e", "e", "0", "0", "e", "C:\\Users\\User\\Desktop\\kepek\\thor.jpg", true, "0", true);
        List<Film> lista=Film.init();
        Film film=null;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getId()==300){
                film=lista.get(i);
            }
        }
        assertEquals("e", film.getAdathordozoTipus());
        assertTrue(0<film.getBoritokep().length());
        assertEquals("e", film.getCim());
        assertEquals("e", film.getFoszereplok());
        assertEquals(0, film.getHanyszor());
        assertEquals(0, film.getHossz());
        assertEquals(0, film.getMegjelenes());
        assertEquals("e", film.getRendezok());
        assertEquals(true, film.isEredeti());
        assertEquals(true, film.isVisszahozva());
    }
    
    @Test (expected = Exception.class)
    public void testEditFilmEx() throws Exception{
        ModositasController modositasController=new ModositasController();
        UjFilmController ujFilmController=new UjFilmController();
        ujFilmController.addFilm(299, "Edit2", "Edit2", "Edit", "0", "0", "DVD", "C:\\Users\\User\\Desktop\\kepek\\thor.jpg", true);
        modositasController.editFilm(299, "e2", "e2", "e", "0", "0", "e", "C:\\Users\\User\\Desktop\\kepek", true, "0", true);
        List<Film> lista=Film.init();
        Film film=null;
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getId()==300){
                film=lista.get(i);
            }
        }
        assertEquals("e", film.getAdathordozoTipus());
        assertTrue(0<film.getBoritokep().length());
        assertEquals("e", film.getCim());
        assertEquals("e", film.getFoszereplok());
        assertEquals(0, film.getHanyszor());
        assertEquals(0, film.getHossz());
        assertEquals(0, film.getMegjelenes());
        assertEquals("e", film.getRendezok());
        assertEquals(true, film.isEredeti());
        assertEquals(true, film.isVisszahozva());
    }
}
