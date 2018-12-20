package pac;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import laboratorinis2.AktyvumoBaluSistema;
import laboratorinis2.Destytojas;
import laboratorinis2.Kursas;
import laboratorinis2.Studentas;
import laboratorinis2.Uzduotis;


@Controller
public class HelloController{

	@RequestMapping("/destytojai")
	@ResponseBody
		public String resp() {
		AktyvumoBaluSistema abs = new AktyvumoBaluSistema();
		ArrayList<Destytojas> destytojai = abs.getDestytojai();
		String sarasas = "";
		for(Destytojas d: destytojai) {
			sarasas+=d+"<br/>";
		}
		
			return "destytoju sarasas:<br/>" + sarasas;
	}
	
	@RequestMapping("/studentai")
	//@ResponseBody
		public ModelAndView studentai() {
		AktyvumoBaluSistema abs = new AktyvumoBaluSistema();
		ArrayList<Studentas> studentai = abs.getStudentai();
		String sarasas = "";
		for(Studentas s: studentai) {
			sarasas+=s+"<br/>";
		}
			ModelAndView m = new ModelAndView("hello");
			return m.addObject("msg",sarasas);
	}
	
	
	
	@RequestMapping("/kursai/{studento_id}")
		public ModelAndView kursai(@PathVariable int studento_id) {
		
			try {
				AktyvumoBaluSistema abs = new AktyvumoBaluSistema();
				Studentas studentas = abs.GautiStudentaPagalID(studento_id);
				Set<Kursas> kursai = studentas.getGrupe().getKursai();
				String sarasas = "";
				for(Kursas k: kursai) {
					sarasas+=k+"<br/>";
				}
				ModelAndView m = new ModelAndView("hello");
				return m.addObject("msg",sarasas);
			}catch(Exception ex) {
				System.out.println(ex);
			}
			return null;
			
		}
	
	@RequestMapping("/uzduotys/{kurso_id}")
	public ModelAndView uzduotys(@PathVariable int kurso_id) {
		try {
			AktyvumoBaluSistema abs = new AktyvumoBaluSistema();
			Set<Uzduotis> uzduotys = abs.GautiKursaPagalID(kurso_id).getUzduotys();
			String sarasas = "";
			for(Uzduotis u: uzduotys) {
				sarasas+=u+"<br/>";
			}
			ModelAndView m = new ModelAndView("hello");
			return m.addObject("msg",sarasas);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return null;
	}
	
	@RequestMapping("/aprasymas/{uzduoties_id}")
	@ResponseBody
	public String aprasymas(@PathVariable int uzduoties_id) {
		try {
			AktyvumoBaluSistema abs = new AktyvumoBaluSistema();
			Uzduotis uzduotis = abs.GautiUzduotiPagalID(uzduoties_id);
			String jsonInString = "";
			ObjectMapper mapper = new ObjectMapper();
			jsonInString = mapper.writeValueAsString(uzduotis);
			return jsonInString;
			//ModelAndView m = new ModelAndView("hello");
			//return m.addObject("msg",uzduotis.GautiAprasyma());
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return null;
	}
	
	
	@RequestMapping(value="pateiktidarba/{studento_id}/{uzduoties_id}/{sprendimas}", method = RequestMethod.GET)
	@ResponseBody
	public String pateiktiDarba(@PathVariable int studento_id, @PathVariable int uzduoties_id, @PathVariable String sprendimas)
	{
		AktyvumoBaluSistema abs = new AktyvumoBaluSistema();
		abs.PridetiAtliktaDarba(studento_id, uzduoties_id, sprendimas);
		return "Darbas pateiktas";
	}
	
	@RequestMapping("/destytojai/{id}")
	@ResponseBody
		public String resp(@PathVariable int id) {
			return "destytojo, kurio id yra " + id + " informacija:";
	}

}
