/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 15, 2011
 */

package com.wpa.xml;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.wpa.xml.tag.TagProcessor;

/**
 * 
 *
 */
public class ProjectConfigHandler extends DefaultHandler {

	private final TagProcessor processor;
	private final Map<String, Object> tagMap = new HashMap<String, Object>();
	private Object[] tagContent;

	public ProjectConfigHandler(TagProcessor processor) {
		this.processor = processor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
	 * java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		tagContent = new Object[2];
		tagMap.put(qName, tagContent);
		tagContent[0] = attributes;

	}

	@Override
	public void characters(char ch[], int start, int length) {
		StringBuffer content = new StringBuffer(length);
		for (int i = start; i < start + length; i++) {
			content.append(ch[i]);
		}
		tagContent[1] = content.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		processor.processTag(qName, tagMap.get(qName));
	}

}
