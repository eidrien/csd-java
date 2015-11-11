package org.agilar.csd.oop.functions.util;

public interface PageData {

	WikiPage getWikiPage();

	boolean hasAttribute(String string);

	Object getContent();

	String getHtml();

	void setContent(String string);

}
