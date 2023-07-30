/*Zhijian Chen
chen5340@brandeis.edu
10/28/2021
PA5
This program/class mainly focus on giving each car a speed the strength, 
and record the each car's status like damage, location, and if they are finished.
Known Bugs: unknown.
*/

package main;

public class RaceCar {
	private int speed;
	private int strength;
	private int position;
	private int originalspeed;
	private double location;
	private boolean finished;
	private boolean damaged;
	private boolean inpit;
	
	public RaceCar() {
		this.speed = 40;
		this.strength = 3;
		this.location = 0;
		this.position = 0;
		this.damaged = false;
		this.finished = false;
		this.inpit = false;
		
	}
	
	public RaceCar(int speed, int strength) {	
		setSpeed(speed);
		
		if (strength < 2) {
			this.strength = 2;
		}
		else if(strength > 4) {
			this.strength = 4;
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
		return "RaceCar " + sp + "/" + st;	
	
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
	
	public int getStrength() {
		return strength;
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
		//RaceCar R = new RaceCar(50, 3);
	    //System.out.println(R.toString());
	}
}
