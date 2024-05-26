package pl.edu.pw.mini.po.asteroidy.informacje.visitor;

import java.util.Collections;
import java.util.TreeSet;

import pl.edu.pw.mini.po.asteroidy.informacje.InformacjeOgolne;
import pl.edu.pw.mini.po.asteroidy.informacje.InformacjeSzczegolowe;

public class GetInformacjeVisitor implements InformacjeVisitor {

	private TreeSet<InformacjeOgolne> niebezpieczneAsteroidy = new TreeSet<InformacjeOgolne>(Collections.reverseOrder());
	
	@Override
	public void visitInformacjeSzczegolowe(InformacjeSzczegolowe asteroida) {
		niebezpieczneAsteroidy.add(asteroida);
	}

	public TreeSet<InformacjeOgolne> getNiebezpieczneAsteroidy() {
		return niebezpieczneAsteroidy;
	}

}
