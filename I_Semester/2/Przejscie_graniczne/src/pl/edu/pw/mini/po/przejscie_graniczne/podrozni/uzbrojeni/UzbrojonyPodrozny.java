package pl.edu.pw.mini.po.przejscie_graniczne.podrozni.uzbrojeni;

import java.util.Random;
import java.util.Set;

import pl.edu.pw.mini.po.przejscie_graniczne.podrozni.Podrozny;

public abstract class UzbrojonyPodrozny extends Podrozny {

	private static final Random random = new Random();
	
	private boolean uzbrojony;
	
	public UzbrojonyPodrozny(int unikalneId) {
		super(unikalneId, random.nextInt(35, 76));
		this.uzbrojony = random.nextBoolean();
	}

}
