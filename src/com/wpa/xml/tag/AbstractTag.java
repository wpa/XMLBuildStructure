/**
 * Copyright by  2011
 *  
 * @author Wojciech Padula
 * @since Mar 15, 2011
 */

package com.wpa.xml.tag;

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

	final void doProcessTag(Object tagObject) {

	}

	public final void update(Observable o, Object arg) {
		System.out.println(o.getClass().getCanonicalName());

	}

	abstract public void processTag(Object tagObject);
}
