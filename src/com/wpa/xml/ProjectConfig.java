/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 15, 2011
 */

package com.wpa.xml;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.wpa.xml.tag.AbstractTag;
import com.wpa.xml.tag.TagProcessor;
import com.wpa.xml.tag.custom.TestTag;

/**
 * 
 *
 */
public class ProjectConfig {

	public ProjectConfig() {

	}

	public String getConfig(InputStream projectConfigInput) {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			TagProcessor processor = new TagProcessor();
			AbstractTag tag = new TestTag();
			processor.addObserver(tag);
			saxParser.parse(projectConfigInput, new ProjectConfigHandler(
					processor));
		} catch (Exception e) {

			throw new RuntimeException(e);
		}
		return null;
	}
}
