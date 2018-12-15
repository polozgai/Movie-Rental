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
public class UjKolcsonzesControllerTest {
    
    public UjKolcsonzesControllerTest() {
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

    @Test (expected = Exception.class)
    public void testUjKolcsonzes() throws Exception{
        String kinek="";
        String mikor="";
        String lejarta="";
        UjKolcsonzesController controller=new UjKolcsonzesController();
        controller.ujKolcsonzes(kinek, mikor, lejarta);
    }
    
    @Test
    public void testUjKolcsonzes2() throws Exception{
        Film f=Film.create("elte", null, "elte", true, "elte", 0, 0, 0, "elte", true, 0);
        String kinek="Mate";
        String mikor="2018-09-09";
        String lejarta="2018-09-12";
        UjKolcsonzesController controller=new UjKolcsonzesController();
        controller.setFilm(f);
        controller.ujKolcsonzes(kinek, mikor, lejarta);
    }
    
    @Test
    public void testKinek(){
        String kinek="Mate";
        UjKolcsonzesController controller=new UjKolcsonzesController();
        assertEquals(controller.kinekUpdate(kinek), 1);
    }
    
    @Test
    public void testKinek2(){
        String kinek="gggg";
        UjKolcsonzesController controller=new UjKolcsonzesController();
        assertTrue(controller.kinekUpdate(kinek)>10);
    }
}
