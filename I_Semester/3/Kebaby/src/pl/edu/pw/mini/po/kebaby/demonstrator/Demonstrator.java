package pl.edu.pw.mini.po.kebaby.demonstrator;

import java.util.List;

import pl.edu.pw.mini.po.kebaby.Kebab;
import pl.edu.pw.mini.po.kebaby.parser.KebabParser;
import pl.edu.pw.mini.po.kebaby.parser.NieznaneMiesoException;
import pl.edu.pw.mini.po.kebaby.processor.KebabProcessor;

public class Demonstrator {

	public static void main(String[] args) {
		try {
			List<Kebab> kebaby = KebabParser.parseKebabs();
			System.out.println(KebabProcessor.getSmallTellerKebabs(kebaby));
			System.out.println();
			KebabProcessor.getSummary(kebaby);
		} catch (NieznaneMiesoException e) {
			e.printStackTrace();
		}

	}

}
