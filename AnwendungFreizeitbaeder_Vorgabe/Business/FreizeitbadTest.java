import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Freizeitbad;
import ownUtil.PlausiException;

class FreizeitbadTest {
	
	private Freizeitbad freizeitbad;
	
	@BeforeEach
	void setUp() throws PlausiException {
		this.freizeitbad = new Freizeitbad("Stadtbad", "7.00", "17.00", "27", "24");
	}
	
	@AfterEach
	void throwDown() {
		this.freizeitbad = null;
	}

	@Test
	void test() {
		assertTrue(() -> this.freizeitbad.getBeckenlaenge() == 25);
	}

}
