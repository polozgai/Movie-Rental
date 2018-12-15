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
public class FunkcioControllerTest {
    
    public FunkcioControllerTest() {
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
    public void testOnTorlesClick() throws Exception{
        FunkcioController funkcioController=new FunkcioController();
        Film f=Film.create("elte", null, "elte4", true, "elte", 0, 0, 0, "elte", false, 300);
        funkcioController.setFilm(f);
        UjFilmController ujfilmController=new UjFilmController();
        ujfilmController.addFilm(300, f.getCim(), f.getRendezok(), f.getFoszereplok(), Integer.toString(f.getMegjelenes()), Integer.toString(f.getHossz()), f.getAdathordozoTipus(), "C:\\Users\\User\\Desktop\\kepek\\thor.jpg", true);
        List<Film> filmLista=Film.init();
        int size=filmLista.size();
        funkcioController.onTorlesClick();
        filmLista=Film.init();
        int size2=filmLista.size();
        assertTrue(size>size2);
    }
    
    @Test (expected = Exception.class)
    public void testOnTorlesClickEx() throws Exception{
        FunkcioController funkcioController=new FunkcioController();
        Film f=Film.create("elte", null, "elte3", true, "elte", 0, 0, 0, "elte", true, 299);
        funkcioController.setFilm(f);
        UjFilmController ujfilmController=new UjFilmController();
        ujfilmController.addFilm(299, f.getCim(), f.getRendezok(), f.getFoszereplok(), Integer.toString(f.getMegjelenes()), Integer.toString(f.getHossz()), f.getAdathordozoTipus(), "C:\\Users\\User\\Desktop\\kepek\\thor.jpg", true);
        funkcioController.onTorlesClick();
    }
    
    @Test (expected = Exception.class)
    public void testOnVisszaVeszClickEx() throws Exception{
        FunkcioController funkcioController=new FunkcioController();
        Film f=Film.create("elte", null, "elte2", true, "elte", 0, 0, 0, "elte", false, 298);
        funkcioController.setFilm(f);
        UjFilmController ujfilmController=new UjFilmController();
        ujfilmController.addFilm(298, f.getCim(), f.getRendezok(), f.getFoszereplok(), Integer.toString(f.getMegjelenes()), Integer.toString(f.getHossz()), f.getAdathordozoTipus(), "C:\\Users\\User\\Desktop\\kepek\\thor.jpg", true);
        funkcioController.onVisszaveszClick();
    }
    
    @Test
    public void testOnVisszaVeszClick() throws Exception{
        FunkcioController funkcioController=new FunkcioController();
        ModositasController modositasController=new ModositasController();
        Film f=Film.create("elte", null, "elte", true, "elte", 0, 0, 0, "elte", true, 297);
        funkcioController.setFilm(f);
        UjFilmController ujfilmController=new UjFilmController();
        ujfilmController.addFilm(297, f.getCim(), f.getRendezok(), f.getFoszereplok(), Integer.toString(f.getMegjelenes()), Integer.toString(f.getHossz()), f.getAdathordozoTipus(), "C:\\Users\\User\\Desktop\\kepek\\thor.jpg", true);
        funkcioController.update();
        modositasController.editFilm(297, f.getCim(), f.getRendezok(), f.getFoszereplok(), Integer.toString(f.getMegjelenes()), Integer.toString(f.getHossz()), f.getAdathordozoTipus(), "C:\\Users\\User\\Desktop\\kepek\\thor.jpg", true, "1", false);
        funkcioController.onVisszaveszClick();
    }
}
