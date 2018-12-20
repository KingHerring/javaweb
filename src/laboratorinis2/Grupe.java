package laboratorinis2;

import java.util.ArrayList;
import java.util.Set;

public class Grupe implements Comparable<Grupe>{
	
	private String kodas;
	private ArrayList<Studentas> studentai = new ArrayList<>();
	private Set<Kursas> kursai;
	
	Grupe(){
		
	}

	Grupe(String kodas){
		
		this.kodas = kodas;
	}
	
	
	public Kursas GautiKursaPagalID(int kodas) throws Exception{
		for(Kursas k: kursai) {
			if(k.getKodas()==kodas) return k;
		}
		Exception ex = new Exception();
		throw(ex);
	}
	
	
	public String getKodas() {
		return kodas;
	}

	public void setKodas(String kodas) {
		this.kodas = kodas;
	}


	public ArrayList<Studentas> getStudentai() {
		return studentai;
	}
	
		
	public Set<Kursas> getKursai() {
		return kursai;
	}
	
	
	
	public void setStudentai(ArrayList<Studentas> studentai) {
		this.studentai = studentai;
	}

	public void setKursai(Set<Kursas> kursai) {
		this.kursai = kursai;
	}

	@Override
	public String toString() {
		return kodas;
	}



	@Override
	public int compareTo(Grupe g) {
		
		return kodas.compareTo(g.getKodas());
	}
}
