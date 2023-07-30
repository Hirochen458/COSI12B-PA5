package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.RaceCar;

class RaceCarTest {

	@Test
	void testRaceCarspeed() {
		RaceCar car1 = new RaceCar(50,10);
		assertEquals(car1.getSpeed(), 50);
		assertEquals(car1.getStrength(), 4);
		assertEquals(car1.getIsinpit(), false);
		assertEquals(car1.toString(), "RaceCar 50/4");
		
		RaceCar car2 = new RaceCar();
		assertEquals(car2.getSpeed(), 40);
		assertEquals(car2.getStrength(), 3);
		assertEquals(car2.getIsinpit(), false);
		assertEquals(car2.toString(), "RaceCar 40/3");
		
	}

}
