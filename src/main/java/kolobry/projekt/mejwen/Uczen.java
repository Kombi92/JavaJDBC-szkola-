package kolobry.projekt.mejwen;


/**
 * Hello world!
 *
 */
public class Uczen {

	private long idUczen;
	private String imie;
	private String nazw;
	private String doswiadczenie;
	private long Lekcja;
	
	public Uczen(String imie, String nazw, String doswiadczenie,  long Lekcja) {
		
		this.imie = imie;
		this.nazw = nazw;
		this.doswiadczenie = doswiadczenie;	
		this.Lekcja = Lekcja;
		
	}
	
	public Uczen(String imie, String nazw,   long Lekcja) {
		
		this.imie = imie;
		this.nazw = nazw;
		this.Lekcja = Lekcja;
		
	}
	public Uczen(String imie, String nazw,  String doswiadczenie) {
		
		this.imie = imie;
		this.nazw = nazw;
		this.doswiadczenie = doswiadczenie;
		
	}
	
	public Uczen() {
	}

	public long getIdUczen() {
		return idUczen;
	}
	
	public void setIdUczen(long idUczen) {
		this.idUczen = idUczen;
	}
	
	public String getImie() {
		return imie;
	}
	
	public void setImie(String imie) {
		this.imie = imie;
	}
	
	public String getNazw() {
		return nazw;
	}
	
	public void setNazw(String nazw) {
		this.nazw = nazw;
	}
	
	public String getDosw() {
		return doswiadczenie;
	}
	
	public void setDosw(String doswiadczenie) {
		this.doswiadczenie = doswiadczenie;
	}
	
	public long getLekcja() {
		return Lekcja;
	}
	
	public void setLekcja(long Lekcja) {
		this.Lekcja = Lekcja;
	}
	
}
