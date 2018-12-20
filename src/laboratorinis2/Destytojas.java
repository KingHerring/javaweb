package laboratorinis2;

import java.util.ArrayList;
import java.util.Set;

public class Destytojas {
	
	private int kodas;
	private String vardas;
	private String pavarde;
	private Set<Kursas> kursai;
	
	Destytojas(){
		
	}
	
	Destytojas(String vardas, String pavarde){
		this.vardas = vardas;
		this.pavarde = pavarde;
	}
		
	
	public int getKodas() {
		return kodas;
	}


	public String getVardas() {
		return vardas;
	}


	public String getPavarde() {
		return pavarde;
	}
	
	
	public void setKodas(int kodas) {
		this.kodas = kodas;
	}


	public void setVardas(String vardas) {
		this.vardas = vardas;
	}


	public void setPavarde(String pavarde) {
		this.pavarde = pavarde;
	}


	public Set<Kursas> getKursai() {
		return kursai;
	}
	

	public void setKursai(Set<Kursas> kursai) {
		this.kursai = kursai;
	}

	@Override
	public String toString() {
		return vardas + " " + pavarde + " " + "["+ kodas + "]";
	}
	
	
}
