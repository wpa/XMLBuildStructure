/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 15, 2011
 */

package com.wpa.xml.tag;

import java.util.Map;
import java.util.Observable;

public class TagProcessor extends Observable {

	private volatile String tagName;

	public void processTag(String tagName, Object object) {

		this.tagName = tagName;
		setChanged();
		notifyObservers(object);
	}

	String getTagName() {
		return tagName;
	}

	String getValue(Object object) {
		Object[] contents = (Object[]) object;
		return (String) contents[1];
	}

	@SuppressWarnings("unchecked")
	Map<String, String> getAttributes(Object object) {
		Object[] contents = (Object[]) object;
		return (Map<String, String>) contents[0];
	}
}
