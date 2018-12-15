package hu.elte.polozgai.movie.model;

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
public class FilmTest {
    
    public FilmTest() {
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
    public void testCreate() {
        Film f=Film.create("elte", null, "elte", true, "elte", 0, 0, 0, "elte", true, 0);
        assertEquals(f.getCim(), "elte");
        assertEquals(f.getAdathordozoTipus(), "elte");
        assertEquals(f.getBoritokep(), null);
        assertEquals(f.getFoszereplok(), "elte");
        assertEquals(f.getHanyszor(), 0);
        assertEquals(f.getHossz(), 0);
        assertEquals(f.getId(), 0);
        assertEquals(f.getMegjelenes(), 0);
        assertEquals(f.isEredeti(), true);
        assertEquals(f.isVisszahozva(), true);
    }
    
    @Test
    public void initTest(){
        List<Film> lista=Film.init();
        assertTrue(lista.size()>0);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void initSizeTest(){
        List<Film> lista=Film.init();
        lista.get(100);
    }
}
