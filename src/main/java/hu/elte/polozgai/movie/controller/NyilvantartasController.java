package hu.elte.polozgai.movie.controller;


import hu.elte.polozgai.movie.model.Film;
import hu.elte.polozgai.movie.view.NyilvantartasView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author polozgai
 */
public class NyilvantartasController {
   
    private List<Film> nyilvantartasLista;
    private List<Film> keresesLista;
    private FunkcioController funkcioController;
    private NyilvantartasView nyilvantartasView;
    
    /**
     * Konstruktor.
     * {@link java.util.List} példányosítása a filmek tárolására.
     * {@link java.util.List} példányosítása a keresett filmek tárolására.
     * {@link hu.elte.progtech2.film.controller.FunkcioController} példányosítása.
     * {@link hu.elte.progtech2.film.view.NyilvantartasView} példányosítása.
     */
    public NyilvantartasController(){
        funkcioController=new FunkcioController();
        nyilvantartasLista=Film.init();
        keresesLista=new ArrayList<Film>();
        nyilvantartasView=new NyilvantartasView(this);
    }
    
    /**
     * Visszaadja a film listát.
     * @return {@link java.util.List}
     */
    public List<Film> getFilm(){
        return nyilvantartasLista;
    }
    
    /**
     * Visszadja a keresés által eredményezett listát
     * @return {@link java.util.List}
     */
    public List<Film> getKeresesLista(){
        return keresesLista;
    }

    /**
     * {@link NyilvantartasView} példányosítása és megjelítése.
     */
    public void show(){
        nyilvantartasView=new NyilvantartasView(this);
        nyilvantartasView.setVisible(true);
    }
    
    /**
     * Táblára történõ kattintás kezelése.
     * @param film {@link Film}
     */
    public void onTableClick(Film film){
        funkcioController.setFilm(film);
        funkcioController.show();
    }
    
    /**
     * Frissítés.
     */
    public void update(){
        nyilvantartasLista=new ArrayList<>();
        nyilvantartasLista=Film.init();
    }

    private void keresesCim(String cim){
        keresesLista.clear();
        for(int i=0;i<nyilvantartasLista.size();i++){
            if(nyilvantartasLista.get(i).getCim().contains(cim)){
                keresesLista.add(nyilvantartasLista.get(i));
            }
        }
    }

    private void keresesRendezo(String rendezo){
        keresesLista.clear();
        for(int i=0;i<nyilvantartasLista.size();i++){
            if(nyilvantartasLista.get(i).getRendezok().contains(rendezo)){
                keresesLista.add(nyilvantartasLista.get(i));
            }
        }
    }

    private void keresesFoszereplo(String foszereplo){
        keresesLista.clear();
        for(int i=0;i<nyilvantartasLista.size();i++){
            if(nyilvantartasLista.get(i).getFoszereplok().contains(foszereplo)){
                keresesLista.add(nyilvantartasLista.get(i));
            }
        }            
    }

    private void keresesEv(String ev){
        int ev2=0;
        try{
            ev2=Integer.parseInt(ev);
        }catch(NumberFormatException e){
            
        }
        keresesLista.clear();
        for(int i=0;i<nyilvantartasLista.size();i++){
            if(nyilvantartasLista.get(i).getMegjelenes()==ev2){
                keresesLista.add(nyilvantartasLista.get(i));
            }
        }               
    }

    private void keresesHossz(String hossz){
        int hossz2=0;
        try{
            hossz2=Integer.parseInt(hossz);
        }catch(NumberFormatException e){
            
        }
        keresesLista.clear();
        for(int i=0;i<nyilvantartasLista.size();i++){
            if(nyilvantartasLista.get(i).getHossz()==hossz2){
                keresesLista.add(nyilvantartasLista.get(i));
            }
        }        
    }

    private void keresesAdathordozo(String adathordozo){
        keresesLista.clear();
        for(int i=0;i<nyilvantartasLista.size();i++){
            if(nyilvantartasLista.get(i).getAdathordozoTipus().contains(adathordozo)){
                keresesLista.add(nyilvantartasLista.get(i));
            }
        }        
    }

    private void keresesEredeti(String eredeti){
        boolean eredeti2;
        try{
            eredeti2=Boolean.parseBoolean(eredeti);
        }catch(Exception e){
            eredeti2=false;
        }
        keresesLista.clear();
        for(int i=0;i<nyilvantartasLista.size();i++){
            if(nyilvantartasLista.get(i).isEredeti()==eredeti2){
                keresesLista.add(nyilvantartasLista.get(i));
            }
        }        
    }

    private void keresesVisszahozva(String visszahozva){
        boolean visszahozva2;
        try{
            visszahozva2=Boolean.parseBoolean(visszahozva);
        }catch(Exception e){
            visszahozva2=false;
        }
        keresesLista.clear();
        for(int i=0;i<nyilvantartasLista.size();i++){
            if(nyilvantartasLista.get(i).isVisszahozva()==visszahozva2){
                keresesLista.add(nyilvantartasLista.get(i));
            }
        }         
    }
    /**
     * Film keresése adott tulajdonság alapján.
     * @param bemenet {@link String}
     * @param mufajok {@link String}
     * @throws Exception Ha a keresés megszorításokat nem tartjuk be vagy üres az input.
     */
    public void kereses(String bemenet,String mufajok) throws Exception{
        if(bemenet==null || mufajok==null || bemenet.equals("")){
            throw new Exception("Egyik mezõ sem lehet üres. Tipp: nyomj ENTER-t");
        }
        if(bemenet.matches("true|false") && mufajok.matches("Eredeti|Kolcsonadott")){
            switch(mufajok){
                case "Eredeti" : keresesEredeti(bemenet); break;
                case "Kolcsonadott" : keresesVisszahozva(bemenet); break;
            }
        }else if(bemenet.matches("[0-9]+") && mufajok.matches("Megjelenes|Hossz")){
            switch(mufajok){
                case "Megjelenes" : keresesEv(bemenet); break;
                case "Hossz" : keresesHossz(bemenet); break;
            }
        }else if(!bemenet.matches("true|false") && !bemenet.matches("[0-9]+") && mufajok.matches("Rendezo|Foszereplo|Adathordozo tipus")){
            switch(mufajok){
                case "Rendezo": keresesRendezo(bemenet); break;
                case "Foszereplo": keresesFoszereplo(bemenet); break;
                case "Adathordozo tipus": keresesAdathordozo(bemenet); break;
            }
        }else if(!bemenet.matches("true|false") && mufajok.matches("Cim")){
            keresesCim(bemenet);
        }else{ 
            throw new Exception("Rossz értékeket adott meg\n. További segítség: Az Eredeti és Kolcsonadott mezõkre true vagy false szöveget adjon meg\n. A Megjelenés és Hossz mezõkre csak számokat\n. A Rendezo és Foszereplo és Adathordozo tipus -ra csak karaktereket\n. A Cim mezõre számokat és karaktereket is megadhat.");
        }
    }
    

    /**
     * Ha pánik van a nem eredeti filmek kölcsönzése.
     */
    public void panik() {
        for(int i=0;i<nyilvantartasLista.size();i++){
            if(nyilvantartasLista.get(i).isEredeti()==false){
                nyilvantartasLista.get(i).deleteFilmById(nyilvantartasLista.get(i).getId());
                nyilvantartasLista.get(i).deleteKolcsonzes(nyilvantartasLista.get(i).getId());
            }
        }
    }
}
