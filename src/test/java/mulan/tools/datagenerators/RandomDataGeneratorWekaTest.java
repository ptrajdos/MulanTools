package mulan.tools.datagenerators;

import mulan.data.MultiLabelInstances;
import weka.tools.data.RandomDataGenerator;

public class RandomDataGeneratorWekaTest extends MulanDataGeneratorTest {

	@Override
	public MulanDataGenerator getGenerator() {
		return new RandomDataGeneratorWeka();
	}
	
	public void testOtherConstructor() {
		RandomDataGenerator gen = new RandomDataGenerator();
		
		RandomDataGeneratorWeka mlGen = new RandomDataGeneratorWeka(gen);
		
		assertTrue("The same object inside", mlGen.getGenerator() == gen);
		
		mlGen.setGenerator(new RandomDataGenerator());
		
		assertTrue("Other object inside", mlGen.getGenerator() != gen);

	}
	
	public void testNoClass() {
		RandomDataGenerator gen = new RandomDataGenerator();
		gen.setAddClassAttrib(false);
		
		RandomDataGeneratorWeka mlGen = (RandomDataGeneratorWeka) this.getGenerator();
		
		mlGen.setGenerator(gen);
		
		try {
			MultiLabelInstances instances = mlGen.generateData();
			fail("An exception should have been thrown");
		} catch (Exception e) {
			//OK
		}
		
	}



}
