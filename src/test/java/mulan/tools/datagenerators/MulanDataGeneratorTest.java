package mulan.tools.datagenerators;

import org.junit.Test;

import junit.framework.TestCase;
import mulan.data.MultiLabelInstances;

public abstract class MulanDataGeneratorTest extends TestCase {

	public abstract MulanDataGenerator getGenerator();
	
	@Test
	public void testGenerator() {
		MulanDataGenerator gen = this.getGenerator();
		try {
			MultiLabelInstances mlInstances = gen.generateData();
			assertTrue("Multilabel instances not null", mlInstances != null);
		} catch (Exception e) {
			fail("An exception has been caught: " + e);
		}
	}

}
