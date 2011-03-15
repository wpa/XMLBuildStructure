/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 15, 2011
 */

package com.wpa.xml.tag;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * 
 *
 */
public abstract class AbstractTag implements Observer {

	private final String supportedTag;

	public AbstractTag(String supportedTag) {
		this.supportedTag = supportedTag;

	}

	final boolean isTagSupported(String tag) {

		return supportedTag.equals(tag);
	}

	public final void update(Observable tagProcessor, Object object) {
		TagProcessor processor = (TagProcessor) tagProcessor;

		if (processor.getTagName().equals(supportedTag)) {
			processTag(processor.getAttributes(object), processor
					.getValue(object));
		}
	}

	public abstract void processTag(Map<String, String> attributes, String value);

}
