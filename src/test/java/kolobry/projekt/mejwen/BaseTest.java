package kolobry.projekt.mejwen;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kolobry.projekt.manager.UczenManager;
import kolobry.projekt.mejwen.Uczen;
import kolobry.projekt.mejwen.Lekcja;
import kolobry.projekt.manager.LekcjaManager;

public class BaseTest {
	
	
	UczenManager UczenManager = new UczenManager();
	LekcjaManager LekcjaManager = new LekcjaManager();
	
	private final static String IMIE_1 = "Zenek";
	private final static String NAZWISKO_1 = "zly";
	private final static String DOSW_1 = "Podstawowy";
	//private final static long LEKCJA_1 = 13;
	
	private final static String RODZAJ_1 = "Narty";
	private final static String GODZ_1 = "30";
	
	@Test
	public void checkConnection(){
		assertNotNull(UczenManager.getConnection());
	
	}
	
	@Test
	public void checkAddingUczen(){

		Uczen uczen = new Uczen(IMIE_1, NAZWISKO_1, DOSW_1);

		//UczenManager.clearUczen();
		//assertEquals(1,UczenManager.addUczen1(uczen));
		UczenManager.addUczen1(uczen);
		
		List<Uczen> uczniowie = UczenManager.getAllUczen();
		Uczen UczenRetrieved = uczniowie.get(uczniowie.size()-1);
		
		assertEquals(IMIE_1, UczenRetrieved.getImie());
		assertEquals(NAZWISKO_1, UczenRetrieved.getNazw());
		assertEquals(DOSW_1, UczenRetrieved.getDosw());
		
	}
	
	@Test
	public void checkAddingLekcja(){
		Lekcja lekcja = new Lekcja(RODZAJ_1, GODZ_1);
		
		//LekcjaManager.clearLekcja();
		assertEquals(1,LekcjaManager.addLekcja(lekcja));
		
		List<Lekcja> lekcje = LekcjaManager.getAllLekcja();
		Lekcja LekcjaRetrieved = lekcje.get(lekcje.size()-1); //bierze ostatni
		
		assertEquals(RODZAJ_1, LekcjaRetrieved.getRodzaj());
		assertEquals(GODZ_1, LekcjaRetrieved.getGodz());
		
	}
	
	@Test
	public void checkDrop(){
				  
        Uczen uczen1 = new Uczen();
        Uczen uczen2 = new Uczen();
        Lekcja lekcja1 = new Lekcja("snowboard","20");
       
        uczen1.setImie("Juzek"); uczen1.setNazw("fajny"); uczen1.setDosw("brak"); uczen1.setLekcja(1);
        uczen2.setImie("marcin"); uczen2.setNazw("lool"); uczen2.setDosw("duze"); uczen2.setLekcja(2);
      
        LekcjaManager.addLekcja(lekcja1);
        assertEquals(1,UczenManager.addUczen(uczen1));
        assertEquals(1,UczenManager.addUczen(uczen2));

        List<Lekcja> lekcje = LekcjaManager.getAllLekcja();
		List<Uczen> uczniowie = UczenManager.getAllUczen();
		
       int x =uczniowie.size();
       int y = lekcje.size();
       
       UczenManager.clearUczen(uczniowie.get(x - 1).getIdUczen());
       UczenManager.clearUczen(uczniowie.get(x - 2).getIdUczen());
       LekcjaManager.clearLekcja(lekcje.get(y - 1).getIdLekcja());
       uczniowie = UczenManager.getAllUczen();
       lekcje = LekcjaManager.getAllLekcja();
       assertEquals(x-2,uczniowie.size());
       assertEquals(y-1,lekcje.size());
		
        
	}
	
	@Test
	public void checkUpdate(){
		
		Lekcja lekcja =LekcjaManager.getLekcjaById(1);
		String noweGodz = "50";
		lekcja.setGodz(noweGodz);
		LekcjaManager.updateLekcja(lekcja);
		Lekcja lekcja2 = LekcjaManager.getLekcjaByGodziny("50");
		assertEquals(lekcja.getIdLekcja(),lekcja2.getIdLekcja());
	}
	
	@Test
	public void checkRelations(){
	 
         Uczen uczen = new Uczen("ja","tez","dobry");
         Lekcja lekcja = new Lekcja("narty","10");
         
         uczen.setLekcja(lekcja.getIdLekcja());
                
         assertEquals(uczen.getLekcja(),lekcja.getIdLekcja());
	}

	/*@Test
	public void checkRealtionDelete(){
	
		 
         Lekcja lekcja = new Lekcja("narty","10");
         lekcja.setLekcja(190);
         
         LekcjaManager.addLekcjaID(lekcja);
         Uczen uczen = new Uczen("ja","tez","dobry",lekcja.getIdLekcja());
         
         UczenManager.addUczen(uczen);
         
         LekcjaManager.clearLekcja1(190);
         
         assertNull(LekcjaManager.getLekcjaById(190));
         assertNull(UczenManager.getUczenById(uczen.getIdUczen()).getLekcja());
         
         
	}*/
	
	// POBRANIE X NALEZACYCH Y
	
	@Test
	public void checkExistingRelation(){
		
		UczenManager.clearUczen();
		
		Lekcja lekcja;
		
		if( LekcjaManager.getLekcjaById(99) == null){
			
		 lekcja = new Lekcja("narty","10");
		 lekcja.setLekcja(99);
		 LekcjaManager.addLekcjaID(lekcja);
		 }
		else{
			 lekcja = LekcjaManager.getLekcjaById(99);
		}
		
		 Uczen uczen = new Uczen("ja","tez","dobry",lekcja.getIdLekcja());
		 Uczen uczen1 = new Uczen("ja","tez","dobry",lekcja.getIdLekcja());
		 Uczen uczen2 =new Uczen ("ja","tez","dobry",1);
		
		UczenManager.addUczen(uczen);
		UczenManager.addUczen(uczen1);
		UczenManager.addUczen(uczen2);
		
		List<Uczen> uczniowie = UczenManager.getAllUczenByLekcja(lekcja.getIdLekcja());
		
		assertEquals(uczniowie.size(),2);
		
	}
	
	
	
}