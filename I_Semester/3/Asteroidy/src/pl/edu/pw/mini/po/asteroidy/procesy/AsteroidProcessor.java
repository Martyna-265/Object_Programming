package pl.edu.pw.mini.po.asteroidy.procesy;

import java.util.TreeSet;

import pl.edu.pw.mini.po.asteroidy.informacje.InformacjeOgolne;
import pl.edu.pw.mini.po.asteroidy.informacje.visitor.GetInformacjeVisitor;

public class AsteroidProcessor {

	public TreeSet<InformacjeOgolne> getDangerousAsteroidsOnly(TreeSet<InformacjeOgolne> asteroidy) {
		GetInformacjeVisitor getInformacjeVisitor = new GetInformacjeVisitor();
		for (InformacjeOgolne asteroida : asteroidy) {
//			if (asteroida instanceof InformacjeSzczegolowe) {
//				niebezpieczneAsteroidy.add(asteroida);
//			}
			asteroida.apply(getInformacjeVisitor);
		}
		TreeSet<InformacjeOgolne> niebezpieczneAsteroidy = getInformacjeVisitor.getNiebezpieczneAsteroidy();
		return niebezpieczneAsteroidy;
	}
	
}
