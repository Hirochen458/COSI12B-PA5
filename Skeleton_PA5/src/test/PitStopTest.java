package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.PitStop;
import main.RaceCar;
import main.FormulaOne;

class PitStopTest {
	RaceCar car1 = new RaceCar();
	

	@Test

	void pittest() {
		
		RaceCar car1 = new RaceCar(40, 3);
		FormulaOne for1 = new FormulaOne(50,4);
		PitStop pitStop = new PitStop(car1, for1);
		
		assertFalse(car1.getIsinpit());
		pitStop.enterPitStop(car1);
		assertTrue(car1.getIsinpit());
		assertFalse(car1.getDamaged());
		
		assertFalse(for1.getIsinpit());
		pitStop.enterPitStop(for1);
		assertTrue(for1.getIsinpit());
		assertFalse(for1.getDamaged());
		
	}

}
