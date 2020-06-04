package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;
import de.hfu.Util;

public class HalbjahrTest {

	@Test
	public void isErstesHalbjahr() {		
		assertTrue("jop", Util.istErstesHalbjahr(4));
	}
	
	@Test
	public void isNotErstesHalbjahr() {		
		assertFalse("jop", Util.istErstesHalbjahr(8));
	}
	
	@Test(expected=IllegalArgumentException.class, timeout=1000)
	public void isInvalidMonth() {
		Util.istErstesHalbjahr(-1);
	}

}
