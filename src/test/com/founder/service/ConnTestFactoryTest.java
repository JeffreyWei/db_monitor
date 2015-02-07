package com.founder.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConnTestFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDbStatus() {
		ConnTestFactory fac=new ConnTestFactory();
		fac.dbStatus();
	}

}
