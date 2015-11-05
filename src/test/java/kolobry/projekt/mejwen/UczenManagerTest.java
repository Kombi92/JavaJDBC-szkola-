package kolobry.projekt.mejwen;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kolobry.projekt.manager.UczenManager;
import kolobry.projekt.mejwen.Uczen;

public class UczenManagerTest {
	
	
	UczenManager UczenManager = new UczenManager();
	
	private final static String IMIE_1 = "Zenek";
	private final static String NAZWISKO_1 = "zly";
	private final static String DOSW_1 = "Podstawowy";
	private final static long LEKCJA_1 = 1;
	
	@Test
	public void checkConnection(){
		assertNotNull(UczenManager.getConnection());
	
	}
	
		@Test
		public void checkAdding(){
	
			Uczen uczen = new Uczen(IMIE_1, NAZWISKO_1, DOSW_1,LEKCJA_1);
	
			UczenManager.clearUczen();
			assertEquals(1,UczenManager.addUczen(uczen));
			
			List<Uczen> uczniowie = UczenManager.getAllUczen();
			Uczen UczenRetrieved = uczniowie.get(0);
			
			assertEquals(IMIE_1, UczenRetrieved.getImie());
			assertEquals(NAZWISKO_1, UczenRetrieved.getNazw());
			assertEquals(DOSW_1, UczenRetrieved.getDosw());
			assertEquals(LEKCJA_1, UczenRetrieved.getLekcja());
		}
	
	
	
	
	

}