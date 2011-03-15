/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 15, 2011
 */

package com.wpa.xml;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
	private final Queue<String> tagQueue = new LinkedList<String>();

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
		Object[] tagContent = new Object[2];
		tagContent[0] = processAttributes(attributes);
		tagMap.put(qName, tagContent);
		tagQueue.offer(qName);

	}

	@Override
	public void characters(char ch[], int start, int length) {
		StringBuffer content = new StringBuffer(length);
		for (int i = start; i < start + length; i++) {
			content.append(ch[i]);
		}
		((Object[]) tagMap.get(tagQueue.peek()))[1] = content.toString();
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
		processor.processTag(qName, tagMap.get(tagQueue.poll()));
	}

	private Map<String, String> processAttributes(Attributes attributes) {

		Map<String, String> attributesMap = new HashMap<String, String>();
		for (int i = 0; i < attributes.getLength(); i++) {
			attributesMap.put(attributes.getQName(i), attributes.getValue(i));

		}
		return attributesMap;
	}

}
