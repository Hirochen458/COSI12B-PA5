/*Zhijian Chen
chen5340@brandeis.edu
10/28/2021
PA5
This program/class mainly focus letting the every damaged race car enter the pit stop, 
 and repair for two ticks.
Known Bugs: unknown.
*/

package main;

public class PitStop {
	private RaceCar[] racecarsinpit;
	private FormulaOne[] formulaOnesinpit;
	
	public PitStop(RaceCar[] raceCars, FormulaOne[] formulaOnes) {
		this.racecarsinpit = new RaceCar[raceCars.length];
		this.formulaOnesinpit = new FormulaOne[formulaOnes.length];
		
	}
	
	
	public PitStop(RaceCar[] raceCars) {
		this.racecarsinpit = new RaceCar[raceCars.length];	
		
    }
	
		
	

	public void enterPitStop(RaceCar car) { // TODO you can add parameters here!
		car.setPit(2);
		for (int i = 0; i < racecarsinpit.length; i++) {
			if(racecarsinpit[i] == null) {
				racecarsinpit[i] = car;
				i = racecarsinpit.length;
			}
		}
		
	}
	public void enterPitStop(FormulaOne formula) { // TODO you can add parameters here!
		
		formula.setPit(2);
		for (int i = 0; i < formulaOnesinpit.length; i++) {
			if(formulaOnesinpit[i] == null) {
				formulaOnesinpit[i] = formula;
				i = formulaOnesinpit.length;
			}
		}
		
	}
	
	public void exitPitStop(RaceCar car) {
		for (int i = 0; i < racecarsinpit.length; i++) {
			if (racecarsinpit[i] == car ){
				car.setDamaged(false);
				if (car.getLocation() % 100 != 75) {
					car.setLocation((int)(car.getLocation()/100 +75));
					car.setSpeed(car.speedAfterFix());
				}
				racecarsinpit[i] = null;
				
			}
		}
		
	}
	
	public void exitPitStop(FormulaOne formula) {
		for (int i = 0; i < formulaOnesinpit.length; i++) {
			if (formulaOnesinpit[i] == formula ){
				formula.setDamaged(false);
				if (formula.getLocation() % 100 != 75) {
					formula.setLocation((int)(formula.getLocation()/100 +75));
					formula.setSpeed(formula.speedAfterFix());
				}
				formulaOnesinpit[i] = null;
				
			}
		}
		
	}
	
}
