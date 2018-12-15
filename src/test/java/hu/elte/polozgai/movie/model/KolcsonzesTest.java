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
public class KolcsonzesTest {
    
    public KolcsonzesTest() {
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
    public void createTest() {
        Kolcsonzes k=Kolcsonzes.create(0, 0, 0, null, null);
        assertEquals(k.getBaratId(), 0);
        assertEquals(k.getId(), 0);
        assertEquals(k.getFilmId(), 0);
        assertEquals(k.getLejarat(), null);
        assertEquals(k.getMikor(), null);
    }
    
    @Test
    public void initTest(){
        List<Kolcsonzes> lista=Kolcsonzes.init();
        assertTrue(lista.size()>0);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void initSizeTest(){
        List<Kolcsonzes> lista=Kolcsonzes.init();
        lista.get(100);
    }
}
