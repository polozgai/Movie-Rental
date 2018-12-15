package hu.elte.polozgai.movie.controller;

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
public class NyilvantartasControllerTest {
    
    
    public NyilvantartasControllerTest() {

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
    public void testKeresesEv() throws Exception{
        NyilvantartasController controller=new NyilvantartasController();
        controller.kereses("2018", "Megjelenes");
        assertTrue(controller.getKeresesLista().size()>0);
    }
    
    @Test (expected = Exception.class)
    public void testKeresesEvEx() throws Exception{
        NyilvantartasController controller=new NyilvantartasController();
        controller.kereses("2018", "Eredeti");
        assertTrue(controller.getKeresesLista().size()>0);
    }
    
    @Test (expected = Exception.class)
    public void testKeresesFoszereploEx() throws Exception{
        NyilvantartasController controller=new NyilvantartasController();
        controller.kereses("2018", "Foszereplo");
        assertTrue(controller.getKeresesLista().size()>0);
    }
    
    @Test (expected = Exception.class)
    public void testKeresesKolcsonadottEx() throws Exception{
        NyilvantartasController controller=new NyilvantartasController();
        controller.kereses("2018", "Kolcsonadott");
        assertTrue(controller.getKeresesLista().size()>0);
    }
    
    @Test (expected = Exception.class)
    public void testKeresesEvEx2() throws Exception{
        NyilvantartasController controller=new NyilvantartasController();
        controller.kereses("ddd", "Megjelenes");
        assertTrue(controller.getKeresesLista().size()>0);
    }
    
    @Test (expected = Exception.class)
    public void testKeresesEx2() throws Exception{
        NyilvantartasController controller=new NyilvantartasController();
        controller.kereses("ddd", "");
        assertTrue(controller.getKeresesLista().size()>0);
    }
    
    @Test (expected = Exception.class)
    public void testKeresesEx() throws Exception{
        NyilvantartasController controller=new NyilvantartasController();
        controller.kereses("", "");
        assertTrue(controller.getKeresesLista().size()>0);
    }
    
    @Test
    public void testKeresesCim() throws Exception{
        NyilvantartasController controller=new NyilvantartasController();
        controller.kereses("Thor", "Cim");
        assertTrue(controller.getKeresesLista().size()>0);
    }
    
    @Test
    public void testEredeti() throws Exception{
        NyilvantartasController controller=new NyilvantartasController();
        controller.kereses("true", "Eredeti");
        assertTrue(controller.getKeresesLista().size()>0);
    }
    
    @Test
    public void testRendezo() throws Exception{
        NyilvantartasController controller=new NyilvantartasController();
        controller.kereses("Steven", "Rendezo");
        assertTrue(controller.getKeresesLista().size()>0);
    }
    
    @Test (expected = Exception.class)
    public void testRendezoEx() throws Exception{
        NyilvantartasController controller=new NyilvantartasController();
        controller.kereses("true", "Rendezo");
        assertTrue(controller.getKeresesLista().size()>0);
    }
}
