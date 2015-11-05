package kolobry.projekt.mejwen;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kolobry.projekt.manager.UczenManager;
import kolobry.projekt.mejwen.Uczen;
import kolobry.projekt.mejwen.Lekcja;
import kolobry.projekt.manager.LekcjaManager;

public class Testy {
	
	
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

		UczenManager.clearUczen();
		assertEquals(1,UczenManager.addUczen1(uczen));
		
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
       
        uczen1.setImie("Juzek"); uczen1.setNazw("fajny"); uczen1.setDosw("brak"); uczen1.setLekcja(4);
        uczen2.setImie("marcin"); uczen2.setNazw("lool"); uczen2.setDosw("duze");uczen2.setLekcja(6);
      
        
        assertEquals(1,UczenManager.addUczen(uczen1));
        assertEquals(1,UczenManager.addUczen(uczen2));
        LekcjaManager.addLekcja(lekcja1);
      
        List<Lekcja> lekcje = LekcjaManager.getAllLekcja();
		List<Uczen> uczniowie = UczenManager.getAllUczen();
       
		
		//assertTrue(uczniowie.contains(uczen1));
        //assertTrue(uczniowie.contains(uczen2));
		
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
		Lekcja lekcja =LekcjaManager.getLekcjaById(13);
		String noweGodz = "50";
				lekcja.setGodz(noweGodz);
		LekcjaManager.updateLekcja(lekcja);
		Lekcja lekcja2 = LekcjaManager.getLekcjaByGodziny("50");
		assertEquals(lekcja.getIdLekcja(),lekcja2.getIdLekcja());
	}

}