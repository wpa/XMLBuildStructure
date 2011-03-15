package com.wpa.xml;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		ProjectConfig config = new ProjectConfig();

		InputStream projectInput = new FileInputStream("test.xml");

		config.getConfig(projectInput);

	}

}
