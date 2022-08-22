package mulan.tools.datagenerators;

import mulan.data.MultiLabelInstances;

public interface MulanDataGenerator {
	/**
	 * An interface for classes that creates Mulan-compatible datasets
	 */
	
	MultiLabelInstances generateData()throws Exception;

}
