package pl.edu.pw.mini.po.kebaby.processor;

import java.util.LinkedList;
import java.util.List;

import pl.edu.pw.mini.po.kebaby.KebabNaTalerzu;
import pl.edu.pw.mini.po.kebaby.wartosci.Mieso;
import pl.edu.pw.mini.po.kebaby.wartosci.Rozmiar;

public class KebabNaTalerzuVisitor implements KebabVisitor {

	List<KebabNaTalerzu> kebabyNaTalerzu = new LinkedList<KebabNaTalerzu>();

	@Override
	public void kebabNaTalerzuVisit(KebabNaTalerzu kebabNaTalerzu) {
		if ((kebabNaTalerzu.getRozmiar() != Rozmiar.S) & (kebabNaTalerzu.getMieso() == Mieso.kurczak)) {
			kebabyNaTalerzu.add(kebabNaTalerzu);
		}
	}

	public List<KebabNaTalerzu> getKebabyNaTalerzu() {
		return kebabyNaTalerzu;
	}

}
