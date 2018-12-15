package hu.elte.polozgai.movie.controller;

import hu.elte.polozgai.movie.model.Film;
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
public class KolcsonzesekControllerTest {
    
    public KolcsonzesekControllerTest() {
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
    public void testKeresesNev(){
        KolcsonzesekController controller=new KolcsonzesekController();
        String s="Mate";
        controller.update();
        controller.keresesNev(s);
        assertTrue(controller.getKeresesLista().size()>0);
    }
    
    @Test
    public void testKeresesNev2(){
        KolcsonzesekController controller=new KolcsonzesekController();
        String s="";
        controller.update();
        controller.keresesNev(s);
        assertTrue(controller.getKeresesLista().isEmpty());
    }
    
    @Test
    public void testUpdate() throws Exception{
        KolcsonzesekController controller=new KolcsonzesekController();
        controller.update();
        int size=controller.getKolcsonzesekLista().size();
        UjKolcsonzesController ujKolcsonController=new UjKolcsonzesController();
        Film f=Film.create("elte", null, "elte", true, "elte", 0, 0, 0, "elte", true, 0);
        ujKolcsonController.setFilm(f);
        ujKolcsonController.ujKolcsonzes("Mate", "2018-05-06", "2018-06-09");
        controller.update();
        int size2=controller.getKolcsonzesekLista().size();
        assertTrue(size<size2);
    }
}
