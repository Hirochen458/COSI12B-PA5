/*Zhijian Chen
chen5340@brandeis.edu
10/28/2021
PA5
This program/class mainly focus on giving each car/formula a finish line, which means they don't 
need to run after they reached that distances. 
Known Bugs: unknown.
*/

package main;

public class FinishLine {
	private RaceCar[] racecarsfin;
	private FormulaOne[] formulaonesfin;
	private int totalofnum;
	private int count;
	
	
	
	public FinishLine(RaceCar[] raceCars, FormulaOne[] formulaOnes) {
		this.racecarsfin = new RaceCar[raceCars.length];
		this.formulaonesfin = new FormulaOne[formulaOnes.length];
		this.totalofnum = racecarsfin.length+formulaonesfin.length;
		
	}
		

	
	public void enterFinishLine(RaceCar racecarf) { 
		if (racecarf.getLocation() >= 1000) {
			racecarf.setFinished(true);
			for (int i = 0; i < racecarsfin.length; i++) {
				if(racecarsfin[i] == null) {
					racecarsfin[i] = racecarf;
				}
			}
			
		}
		
		
	}
	
	public void enterFinishLine(FormulaOne formulaf) {
		if (formulaf.getLocation() >= 1000) {
			formulaf.setFinished(true);
			for (int i = 0; i < formulaonesfin.length; i++) {
				if(formulaonesfin[i] == null) {
					formulaonesfin[i] = formulaf;
				}
			}
		}
	}
	
	public boolean finished(int totalofnum) {
		
		for (int i = 0; i< racecarsfin.length; i++) {
			if (racecarsfin[i] !=null) {
				count++;
			}
		}
		for (int i = 0; i< formulaonesfin.length; i++) {
			if (formulaonesfin[i] != null) {
				count++;
			}
		}
		
		if (totalofnum == count) {
			return true;
			
		}
		return false;
		
	}
	
	public static void main(String[] arg) {
		//FinishLine F = new FinishLine(RaceCar[] raceCars, FormulaOne[] formulaOnes);
	}
}
	
