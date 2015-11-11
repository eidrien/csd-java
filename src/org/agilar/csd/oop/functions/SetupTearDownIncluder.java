package org.agilar.csd.oop.functions;

import org.agilar.csd.oop.functions.util.*;

// Functions should be no longer than about 6 or so lines

// Functions should only do one thing

// One level of abstraction per function

// Switch statements only tolerated to create polymorphic objects

// Have no side effects

// Function arguments
// - niladic functions are preferred
// - monadic functions if you can't have niladic
// - diadic functions are ok
// - triadic functions are to be avoided
// - polyadic fucntions should never exist
// Output arguments should be avoided

// Command-query separation

// Prefer exceptions to error codes
// Only capture exceptions when needed, you must be doing something with them

// Multiple returns are ok


public class SetupTearDownIncluder {
	private PageData pageData;
	private boolean isSuite;
	private WikiPage testPage;
	private StringBuffer newPageContent;
	private PageCrawler pageCrawler;

	public static String render(PageData pageData) throws Exception {
		return render(pageData, false);
	}

	public static String render(PageData pageData, boolean isSuite) throws Exception {
		return new SetupTearDownIncluder(pageData).render(isSuite);
	}

	private SetupTearDownIncluder(PageData pageData) {
		this.pageData = pageData;
		testPage = pageData.getWikiPage();
		pageCrawler = testPage.getPageCrawler();
		newPageContent = new StringBuffer();
	}

	private String render(boolean isSuite) throws Exception {
		this.isSuite = isSuite;
		if (isTestPage())
			includeSetupAndTeardownPages();
		return pageData.getHtml();
	}

	private boolean isTestPage() throws Exception {
		return pageData.hasAttribute("Test");
	}

	private void includeSetupAndTeardownPages() throws Exception {
		includeSetupPages();
		includePageContent();
		includeTeardownPages();
		updatePageContent();
	}

	private void includeSetupPages() throws Exception {
		if (isSuite)
			includeSuiteSetupPage();
		includeSetupPage();
	}

	private void includeSuiteSetupPage() throws Exception {
		include(SuiteResponder.SUITE_SETUP_NAME, "-setup");
	}

	private void includeSetupPage() throws Exception {
		include("SetUp", "-setup");
	}

	private void includePageContent() throws Exception {
		newPageContent.append(pageData.getContent());
	}

	private void includeTeardownPages() throws Exception {
		includeTeardownPage();
		if (isSuite)
			includeSuiteTeardownPage();
	}

	private void includeTeardownPage() throws Exception {
		include("TearDown", "-teardown");
	}

	private void includeSuiteTeardownPage() throws Exception {
		include(SuiteResponder.SUITE_TEARDOWN_NAME, "-teardown");
	}

	private void updatePageContent() throws Exception {
		pageData.setContent(newPageContent.toString());
	}

	private void include(String pageName, String arg) throws Exception {
		WikiPage inheritedPage = findInheritedPage(pageName);
		if (inheritedPage != null) {
			String pagePathName = getPathNameForPage(inheritedPage);
			buildIncludeDirective(pagePathName, arg);
		}
	}

	private WikiPage findInheritedPage(String pageName) throws Exception {
		return PageCrawlerImpl.getInheritedPage(pageName, testPage);
	}

	private String getPathNameForPage(WikiPage page) throws Exception {
		WikiPagePath pagePath = pageCrawler.getFullPath(page);
		return PathParser.render(pagePath);
	}

	private void buildIncludeDirective(String pagePathName, String arg) {
		newPageContent.append("\n!include ").append(arg).append(" .").append(pagePathName).append("\n");
	}
}