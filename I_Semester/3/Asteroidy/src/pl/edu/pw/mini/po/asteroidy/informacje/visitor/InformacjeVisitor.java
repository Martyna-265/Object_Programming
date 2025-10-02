package pl.edu.pw.mini.po.asteroidy.informacje.visitor;

import pl.edu.pw.mini.po.asteroidy.informacje.InformacjeSzczegolowe;

public interface InformacjeVisitor {
	void visitInformacjeSzczegolowe(InformacjeSzczegolowe asteroida);
}
