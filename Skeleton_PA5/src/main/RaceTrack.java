/*Zhijian Chen
chen5340@brandeis.edu
10/28/2021
PA5
This program/class mainly focus on simulate the car racing platform, set up cars, 
ticks for rounds, collision check and calculate the score for the game.
Known Bugs: unknown.
*/

package main;

public class RaceTrack {
	private int tick;
	private int place;
	private int score;
	private int numofcar;
	private int numoffor;
	private int totalofnum;
	
	
	
	private RaceCar[] raceCarsintrack;
	private FormulaOne[] formulaOnesintrack;
	private PitStop pitStop;
	private FinishLine finished;
	
	

	/**
	 * DO NOT REMOVE THIS - you should be using this to log this track's events. For more see the assignment PDF / documentation for TrackLoggerB.java
	 */
	private TrackLoggerB logger;
	
	public RaceTrack() {
		logger = new TrackLoggerB(); // DO NOT REMOVE THIS LINE
		tick = 0;
		place = 1;
		score = 1000;
		
		
	}
	
	public void setCars(RaceCar[] racecars, FormulaOne[] formulaOnes) {
		this.raceCarsintrack = racecars;
		this.formulaOnesintrack = formulaOnes;
		pitStop = new PitStop(racecars, formulaOnes);
		finished = new FinishLine(racecars, formulaOnes);
		numofcar = raceCarsintrack.length;
		numoffor = formulaOnesintrack.length;
		totalofnum = numofcar + numoffor;
	}
	
	public void setCars(RaceCar[] racecars) {
		this.raceCarsintrack = racecars;
		pitStop = new PitStop(racecars);
		
	}
	
	public void tick() {

		tick++;
		logger.logNewTick();
		if(tick >= 2) {
			checkFinish();
		}
		checkCollision();
		
		
		
		//car move
		moving(raceCarsintrack);
		
		//formula move
		moving(formulaOnesintrack);
		
		//car enter pit
		checkPitStopdis(raceCarsintrack);
		
		//formula enter pit
		checkPitStopdis(formulaOnesintrack);
		
		//car exit pit
		outPit(raceCarsintrack);
		
		//formula exit pit
		outPit(formulaOnesintrack);
		
		
		checkFinish();
		

	}
	
	public void checkCollision() {
		
		if(formulaOnesintrack == null) {
			for (int i = 0; i < raceCarsintrack.length; i++) {
				for (int o = i+1; o < raceCarsintrack.length; o++) {
					if (raceCarsintrack != null) {
						if (raceCarsintrack[i].getIsinpit() != true && raceCarsintrack[o].getIsinpit() != true) {
							if (raceCarsintrack[i].getLocation() % 100 == raceCarsintrack[o].getLocation() % 100) {
								if (raceCarsintrack[i].getDamaged() == false && raceCarsintrack[o].getDamaged() == false) {
							
									raceCarsintrack[i].setDamaged (true);
									raceCarsintrack[i].setIsinpit(true);
									raceCarsintrack[i].setSpeed(raceCarsintrack[i].speedAfterDamage());
									logger.logDamaged(raceCarsintrack[i]);
							
									raceCarsintrack[o].setDamaged (true);
									raceCarsintrack[o].setIsinpit(true);
									raceCarsintrack[o].setSpeed(raceCarsintrack[o].speedAfterDamage());
									logger.logDamaged(raceCarsintrack[o]);
								}
								else if (raceCarsintrack[i].getDamaged() == true && raceCarsintrack[o].getDamaged() == false) {
									raceCarsintrack[o].setDamaged (true);
									raceCarsintrack[o].setIsinpit(true);
									raceCarsintrack[o].setSpeed(raceCarsintrack[o].speedAfterDamage());
									logger.logDamaged(raceCarsintrack[o]);
								}
								else if (raceCarsintrack[i].getDamaged() == false && raceCarsintrack[o].getDamaged() == true) {
									raceCarsintrack[i].setDamaged (true);
									raceCarsintrack[i].setIsinpit(true);
									raceCarsintrack[i].setSpeed(raceCarsintrack[i].speedAfterDamage());
									logger.logDamaged(raceCarsintrack[i]);
								}
						
							}
						}
					}
					
					
				}
			}
		}
		
		if(formulaOnesintrack != null) {
			for (int u = 0; u < formulaOnesintrack.length; u++) {
				for (int y = u + 1; y < formulaOnesintrack.length; y++) {
					if (formulaOnesintrack[u].getIsinpit() != true && formulaOnesintrack[y].getIsinpit() != true) {
						if (formulaOnesintrack[u].getLocation() % 100 == formulaOnesintrack[y].getLocation() % 100) {
							if (formulaOnesintrack[u].getDamaged() == false && formulaOnesintrack[y].getDamaged() == false) {
								
								formulaOnesintrack[u].setDamaged (true);
								formulaOnesintrack[u].setIsinpit(true);
								formulaOnesintrack[u].setSpeed(formulaOnesintrack[u].speedAfterDamage());
								logger.logDamaged(formulaOnesintrack[u]);
							
								formulaOnesintrack[y].setDamaged (true);
								formulaOnesintrack[y].setIsinpit(true);
								formulaOnesintrack[y].setSpeed(formulaOnesintrack[y].speedAfterDamage());
								logger.logDamaged(formulaOnesintrack[y]);
							}
							else if (formulaOnesintrack[u].getDamaged() == true && formulaOnesintrack[y].getDamaged() == false) {
								formulaOnesintrack[y].setDamaged (true);
								formulaOnesintrack[y].setIsinpit(true);
								formulaOnesintrack[y].setSpeed(formulaOnesintrack[y].speedAfterDamage());
								logger.logDamaged(formulaOnesintrack[y]);
							}
							else if (formulaOnesintrack[u].getDamaged() == false && formulaOnesintrack[y].getDamaged() == true) {
								formulaOnesintrack[u].setDamaged (true);
								formulaOnesintrack[u].setIsinpit(true);
								formulaOnesintrack[u].setSpeed(formulaOnesintrack[u].speedAfterDamage());
								logger.logDamaged(formulaOnesintrack[u]);
							}
						
						}
					}
					
				}
			}
			if (raceCarsintrack != null) {
				for (int t = 0; t < raceCarsintrack.length; t++) {
					for (int r = 0; r < formulaOnesintrack.length; r++) {
						if (raceCarsintrack[t].getIsinpit() != true && formulaOnesintrack[r].getIsinpit() != true) {
							if (raceCarsintrack[t].getLocation() % 100 == formulaOnesintrack[r].getLocation() % 100) {
								if (raceCarsintrack[t].getDamaged() == false && formulaOnesintrack[r].getDamaged() == false) {
							
									raceCarsintrack[t].setDamaged (true);
									raceCarsintrack[t].setIsinpit (true);
									raceCarsintrack[t].setSpeed(raceCarsintrack[t].speedAfterDamage());
									logger.logDamaged(raceCarsintrack[t]);
							
									formulaOnesintrack[r].setDamaged (true);
									formulaOnesintrack[r].setIsinpit (true);
									formulaOnesintrack[r].setSpeed(formulaOnesintrack[r].speedAfterDamage());
									logger.logDamaged(formulaOnesintrack[r]);
								}
								else if (raceCarsintrack[t].getDamaged() == true && formulaOnesintrack[r].getDamaged() == false) {
									formulaOnesintrack[r].setDamaged (true);
									formulaOnesintrack[r].setIsinpit (true);
									formulaOnesintrack[r].setSpeed(formulaOnesintrack[r].speedAfterDamage());
									logger.logDamaged(formulaOnesintrack[r]);
								}
								else if (raceCarsintrack[t].getDamaged() == false && formulaOnesintrack[r].getDamaged() == true) {
									raceCarsintrack[t].setDamaged (true);
									raceCarsintrack[t].setIsinpit (true);
									raceCarsintrack[t].setSpeed(raceCarsintrack[t].speedAfterDamage());
									logger.logDamaged(raceCarsintrack[t]);
								}
						
							}
						
						}
					
					}
				}
		
		
			
			}
		}

	}
	
	public void run() {
		//throw new UnsupportedOperationException("not implemented yet");
		while (finished.finished(totalofnum) == false) {
			tick();
		} 
		
		calculatorScore(tick);

	}
	
	public int calculatorScore(int ticks) {
		//throw new UnsupportedOperationException("not implemented yet");
		score = score - 20*tick + 150*numofcar +100*numoffor;
		logger.logScore(score);
		return score;
	}
	
	public void checkFinish() {
		if(formulaOnesintrack == null) {
			for (int i = 0; i < raceCarsintrack.length; i++) {
			    if (raceCarsintrack[i] != null && raceCarsintrack[i].getLocation() >= 1000) {
				    finished.enterFinishLine(raceCarsintrack[i]);
				    logger.logFinish(raceCarsintrack[i], place);
				    place ++;
				    raceCarsintrack[i].setFinished(true);;
				    raceCarsintrack[i] = null;
				
			    }
		    }
			
		}else {
			for (int i = 0; i < raceCarsintrack.length; i++) {
			    if (raceCarsintrack[i]!= null && raceCarsintrack[i].getLocation() >= 1000) {
				    finished.enterFinishLine(raceCarsintrack[i]);
				    logger.logFinish(raceCarsintrack[i], place);
				    place ++;
				    raceCarsintrack[i].setFinished(true);;
				    raceCarsintrack[i] = null;
				
			    }
		    }
			for (int o = 0; o < formulaOnesintrack.length; o++) {
			    if (formulaOnesintrack[o] != null && formulaOnesintrack[o].getLocation() >= 1000) {
				    finished.enterFinishLine(formulaOnesintrack[o]);
				    logger.logFinish(formulaOnesintrack[o], place);
				    place ++;
				    formulaOnesintrack[o].setFinished(true);
				    formulaOnesintrack[o] = null;
				
			    }
		    }
		}
	}
	public void checkPitStopdis(RaceCar[] raceCars) {
			
		for (int i = 0; i < raceCars.length; i++) {
			if (raceCars[i].getDamaged() == true) {
				if (raceCars[i].getLocation() % 100 >= 75) {
					logger.logEnterPit(raceCars[i]);
					pitStop.enterPitStop(raceCars[i]);
					
					raceCars[i].setSpeed(0);
				}
			}
		}
		
	}
	
	public void checkPitStopdis(FormulaOne[] formula) {
		for (int o = 0; o < formula.length; o++) {
			
		    if (formula[o].getDamaged() == true) {
				if(formula[o].getLocation() % 100 >= 75) {
					logger.logEnterPit(formula[o]);
					pitStop.enterPitStop(formula[o]);
					
					formula[o].setSpeed(0);
				}
			}
		}

	}
	
	public void moving(RaceCar[] raceCars) {
        for (int i = 0; i < raceCars.length; i++) {
        	raceCars[i].moving(raceCars[i].getSpeed());
			raceCars[i].setLocation(raceCars[i].getLocation());
		}
	}
	
	public void moving(FormulaOne[] formula) {
		for (int i = 0; i < formula.length; i++) {
			formula[i].moving(formula[i].getSpeed());
			formula[i].setLocation(formula[i].getLocation());
		}
	}
	
	public void outPit(RaceCar[] raceCars) {
		for (int i = 0; i < raceCars.length; i++) {
			if(raceCars[i].getIsinpit() == true){
				pitStop.exitPitStop(raceCars[i]);
				logger.logExitPit(raceCars[i]);
			}
			
		}
		
		for (int o = 0; o < raceCars.length; o++) {
			if (raceCars[o].getIsinpit() == true) {
				if (raceCars[o].getPit() == 2) {
					raceCars[o].setPit(1);
				}
				else if (raceCars[o].getPit() == 1) {
					raceCars[o].setPit(0);
				}
			}
			
			//raceCars[o].setPit(0);
		}
		
	}
	
	public void outPit(FormulaOne[] formula) {
		for (int i = 0; i < formula.length; i++) {
			if (formula[i].getIsinpit() == true){
				pitStop.exitPitStop(formula[i]);
				logger.logExitPit(formula[i]);
			}
			
		}
		for (int o = 0; o < formula.length; o++) {
			if (formula[o].getIsinpit() == true) {
				if(formula[o].getPit() == 2) {
					formula[o].setPit(1);
				}
				else if (formula[o].getPit() == 1) {
					formula[o].setPit(0);
				}
			}
			
			//formula[o].setPit(0);
		}
	}
	
	/**
	 * This method returns the logger instance used by this RaceTrack. You <b>SHOULD NOT</b> be using this method. 
	 * @return logger with this track's events 
	 */
	public TrackLoggerB getLogger() {
		return logger;
	}

}
