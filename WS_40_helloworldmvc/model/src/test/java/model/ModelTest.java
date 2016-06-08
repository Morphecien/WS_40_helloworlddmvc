package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModelTest {

	private Model model;

	@Before
	public void setUp() throws Exception {
	this.model = new Model();
	}

	@Test
	public void testGetHelloWorld() {
	assertEquals("Hello World", this.model.getHelloWorld());
	}
}
