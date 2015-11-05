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
	private final static long LEKCJA_1 = 1;
	
	private final static String RODZAJ_1 = "Narty";
	private final static String GODZ_1 = "30";
	
	@Test
	public void checkConnection(){
		assertNotNull(UczenManager.getConnection());
	
	}
	
	@Test
	public void checkAddingUczen(){

		Uczen uczen = new Uczen(IMIE_1, NAZWISKO_1, DOSW_1,LEKCJA_1);

		UczenManager.clearUczen();
		assertEquals(1,UczenManager.addUczen(uczen));
		
		List<Uczen> uczniowie = UczenManager.getAllUczen();
		Uczen UczenRetrieved = uczniowie.get(uczniowie.size()-1);
		
		assertEquals(IMIE_1, UczenRetrieved.getImie());
		assertEquals(NAZWISKO_1, UczenRetrieved.getNazw());
		assertEquals(DOSW_1, UczenRetrieved.getDosw());
		assertEquals(LEKCJA_1, UczenRetrieved.getLekcja());
	}
	
	@Test
	public void chcecAddingLekcja(){
		Lekcja lekcja = new Lekcja(RODZAJ_1, GODZ_1);
		
		//LekcjaManager.clearLekcja();
		assertEquals(1,LekcjaManager.addLekcja(lekcja));
		
		List<Lekcja> lekcje = LekcjaManager.getAllLekcja();
		Lekcja LekcjaRetrieved = lekcje.get(lekcje.size()-1); //bierze ostatni
		
		assertEquals(RODZAJ_1, LekcjaRetrieved.getRodzaj());
		assertEquals(GODZ_1, LekcjaRetrieved.getGodz());
		
	}
	
	

}