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
 * @author polozgai
 */
public class BaratTest {
    
    
    public BaratTest() {
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
        Barat b1=Barat.create(0, "Mate");
        int i=0;
        String s="Mate";
        assertEquals(s, b1.getNev());
        assertEquals(i, b1.getId());
    }
    
    @Test
    public void testInit(){
        List<Barat> lista=Barat.init();
        assertTrue(lista.size()>0);
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testListaSize(){
        List<Barat> lista=Barat.init();
        lista.get(100);
    }
}
