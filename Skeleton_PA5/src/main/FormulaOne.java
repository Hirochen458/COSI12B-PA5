/*Zhijian Chen
chen5340@brandeis.edu
10/28/2021
PA5
This program/class mainly focus on giving each formula a speed the strength, 
and record the each formula's status like damage, location, and if they are finished.
Known Bugs: unknown.
*/

package main;

public class FormulaOne {
	private int speed;
	private int strength;
	private int position;
	private int originalspeed;
	private double location;
	private boolean finished;
	private boolean damaged;
	private boolean inpit;

	public FormulaOne() {
		this.speed = 50;
		this.strength = 4;
		this.location = 0;
		this.position = 0;
		this.damaged = false;
		this.finished = false;
		this.inpit = false;

	}
	
	public FormulaOne(int speed, int strength) {
		setSpeed(speed);
		if (strength < 3) {
			this.strength = 3;
		}
		else if(strength > 5) {
			this.strength = 5;
		}
		else {
			this.strength = strength;
		}
		originalspeed = speed;

	}
	
	public double getLocation() {
		//throw new UnsupportedOperationException("not implemented yet");
		return location;
	}
	
	public String toString() {
		//throw new UnsupportedOperationException("not implemented yet");
		String sp = String.valueOf(speed);
		String st = String.valueOf(strength);
		return "FormulaOne " + sp + "/" + st;
	}
	
	public int getSpeed() {
		return speed;
		
	}
	
	public int speedAfterDamage() {
		return speed - (strength * 5);
		
	}
	public int speedAfterFix() {
		return originalspeed;
		
	}
	
	public void moving(int move) {
		location = location + move;
		
	}
	
	public boolean getDamaged() {
		return damaged;
	}
	
	public boolean getFinished() {
		return finished;
	}
	
	public void setPit(int position) {
		this.position = position;
		if (position == 0) {
			speed = originalspeed;
		}
	
	}
	
	public int getPit() {
		return position;
	}
	
	public void setSpeed(int speed) {
		if (speed >= 55) {
			this.speed = 55;
		}
		else if(speed<= 30) {
			this.speed = 30;
		}
		else {
			this.speed = speed;
		}
	}
		

	
	public void setLocation(double location) {
		this.location = location;
		
	}
	
	public void setDamaged(boolean damaged) {
		this.damaged = damaged;
	}
	
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	public void setIsinpit(boolean inpit) {
		this.inpit = inpit;
	}
	
	public boolean getIsinpit() {
		return inpit;
	}
	
	public static void main(String[] args) {
		//FormulaOne R = new FormulaOne();
	    //System.out.println(R.toString());
	}
	
}
