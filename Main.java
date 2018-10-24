package WashingMachines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws TemperatureException {
		
		Whirpool whirpool = new Whirpool(MakersWashingMachines.WHIRPOOL);
		Beko beko = new Beko(MakersWashingMachines.BEKO);
		Amica amica = new Amica(MakersWashingMachines.AMICA);
		
		List<WashingMachine> allWashingMachines = new ArrayList<>();
		
		allWashingMachines.add(whirpool);
		allWashingMachines.add(beko);
		allWashingMachines.add(amica);
		
		System.out.println(" 1 - Initial settings od washing machines");
		System.out.println(whirpool.showStatus());
		System.out.println(beko.showStatus());
		System.out.println(amica.showStatus());
		System.out.println();
		
		System.out.println(" 2 - After choosing the settings");
		whirpool.setWashingProgram(25);
		try {
			whirpool.setWashingTemp(88.5);
		} catch (TemperatureException tempE) {
			tempE.getMessage();
		}
		whirpool.setWashingSpeed(545);
		System.out.println(whirpool.showStatus());
		
		beko.setWashingProgram(7);
		try {
			beko.setWashingTemp(44.3);
		} catch (TemperatureException tempE) {
			tempE.getMessage();
		}
		beko.setWashingSpeed(1100);
		System.out.println(beko.showStatus());
		
		amica.setWashingProgram(20);
		try {
			amica.setWashingTemp(63.2);
		} catch (TemperatureException tempE) {
			tempE.getMessage();
		}
		amica.setWashingSpeed(-100);
		System.out.println(amica.showStatus());
		System.out.println();
		
		System.out.println(" 3 - After changing the settings (next program, temperature down, speed up)");
		whirpool.nextWashingProgram();
		whirpool.washingTempDown();
		whirpool.washingSpeedUp();
		System.out.println(whirpool.showStatus());
		
		beko.nextWashingProgram();
		beko.washingTempDown();
		beko.washingSpeedUp();
		System.out.println(beko.showStatus());
		
		amica.nextWashingProgram();
		amica.washingTempDown();
		amica.washingSpeedUp();
		System.out.println(amica.showStatus());
		System.out.println();
		
		System.out.println(" 4 - After changing the settings (previus program, temperature up, speed down)");
		whirpool.previusWashingProgram();
		whirpool.washingTempUp();
		whirpool.washingSpeedDown();
		System.out.println(whirpool.showStatus());
		
		beko.previusWashingProgram();
		beko.washingTempUp();
		beko.washingSpeedDown();
		System.out.println(beko.showStatus());
		
		amica.previusWashingProgram();
		amica.washingTempUp();
		amica.washingSpeedDown();
		System.out.println(amica.showStatus());
		System.out.println();
		
		System.out.println(" 5 - Washing machines before sorting: ");
		allWashingMachines.stream()
				.forEach(maker -> {
					System.out.println(maker.getMakerWashingMachine());
				});
		System.out.println();
		System.out.println(" 6 - Washing machines after sorting: ");
		Collections.sort(allWashingMachines, new Comparator<WashingMachine>() {
			@Override
			public int compare(WashingMachine wm1, WashingMachine wm2) {
				return wm1.getMakerWashingMachine()
						.toString()
						.compareTo(wm2.getMakerWashingMachine()
								.toString());
			}
		});
		allWashingMachines.stream()
				.forEach(maker -> {
					System.out.println(maker.getMakerWashingMachine());
				});
	}
}