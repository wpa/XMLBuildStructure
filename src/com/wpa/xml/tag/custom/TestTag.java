package com.wpa.xml.tag.custom;

import java.util.Map;

import com.wpa.xml.tag.AbstractTag;

public class TestTag extends AbstractTag {

	public TestTag() {
		super("module");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wpa.xml.tag.AbstractTag#processTag(org.xml.sax.Attributes,
	 * java.lang.String)
	 */
	@Override
	public void processTag(Map<String, String> attributes, String value) {
		System.out.println(attributes);
		System.out.println(value);
	}

}
