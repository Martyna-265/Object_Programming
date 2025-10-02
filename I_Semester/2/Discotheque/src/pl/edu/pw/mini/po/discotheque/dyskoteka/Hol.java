package pl.edu.pw.mini.po.discotheque.dyskoteka;

import java.util.LinkedHashSet;

import pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.Uczestnik;
import pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.ludzie_z_zewnatrz.CzlowiekZZewnatrz;
import pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.studenci.Student;
import pl.edu.pw.mini.po.discotheque.dyskoteka.uczestnicy.studenci.Studentka;

public class Hol {

	private LinkedHashSet<Uczestnik> uczestnicy; //ewentualnie linkedList

	public Hol() {
		this.uczestnicy = new LinkedHashSet<Uczestnik>();
		int i = 0;
		while (i<33) {
			uczestnicy.add(new Student());
			i++;
		}
		while (i<66) {
			uczestnicy.add(new Studentka());
			i++;
		}
		while (i<99) {
			uczestnicy.add(new CzlowiekZZewnatrz());
			i++;
		}
	}

	public LinkedHashSet<Uczestnik> getUczestnicy() {
		return uczestnicy;
	}
	
}
