package kolobry.projekt.mejwen;

public class Lekcja {
	
	private long idLekcja;
	private String rodzaj;
	private String ilosc_godzin;
	
	
	public Lekcja (String rodzaj, String ilosc_godzin) {
		
		this.rodzaj = rodzaj;
		this.ilosc_godzin = ilosc_godzin;
	}
	
	public long getIdLekcja() {
		return idLekcja;
	}
	public void setLekcja(long idLekcja) {
		this.idLekcja = idLekcja;
	}
	public String getRodzaj() {
		return rodzaj;
	}
	public void setName(String rodzaj) {
		this.rodzaj = rodzaj;
	}
	public String getGodz() {
		return ilosc_godzin;
	}
	public void setGodz(String ilosc_godzin) {
		this.ilosc_godzin = ilosc_godzin;
	}
	


}
