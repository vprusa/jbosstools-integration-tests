/*******************************************************************************
 * Copyright (c) 2017 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributor:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.central.test.ui.reddeer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.eclipse.reddeer.common.logging.Logger;
import org.eclipse.reddeer.common.matcher.RegexMatcher;
import org.eclipse.reddeer.common.wait.WaitUntil;
import org.eclipse.reddeer.core.matcher.WithTextMatcher;
import org.eclipse.reddeer.eclipse.condition.BrowserContainsText;
import org.eclipse.reddeer.swt.condition.ShellIsAvailable;
import org.eclipse.reddeer.swt.impl.browser.InternalBrowser;
import org.eclipse.reddeer.swt.impl.ctab.DefaultCTabItem;
import org.eclipse.reddeer.swt.impl.shell.DefaultShell;
import org.eclipse.reddeer.swt.impl.toolbar.DefaultToolItem;
import org.eclipse.reddeer.workbench.impl.editor.DefaultEditor;
import org.eclipse.reddeer.workbench.impl.shell.WorkbenchShell;
import org.jboss.tools.central.reddeer.api.JavaScriptHelper;
import org.jboss.tools.central.reddeer.wait.CentralIsLoaded;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author rhopp
 *
 */

public class BasicTests {

	private static final String CONTACTS_MOBILE_BASIC = "contacts-mobile-basic";
	private static final String KITCHENSINK_JSP = "kitchensink-jsp";
	private static final String CENTRAL_LABEL = "Red Hat Central";
	private static Logger log = new Logger(HTML5Parameterized.class);
	private static InternalBrowser centralBrowser;
	private static JavaScriptHelper jsHelper = JavaScriptHelper.getInstance();

	@Before
	public void setup() {
		try {
			new DefaultEditor(CENTRAL_LABEL).close();
		} catch (Exception e) {
		}
		new DefaultToolItem(new WorkbenchShell(), CENTRAL_LABEL).click();
		// activate central editor
		new DefaultEditor(CENTRAL_LABEL);
		new WaitUntil(new CentralIsLoaded());
		centralBrowser = new InternalBrowser();
		
		jsHelper.setBrowser(centralBrowser);
	}

	@Test
	public void addToolsButton() {
		log.step("Clicking AddToolsButton");
		centralBrowser.execute("$(\"#addtools\").click()");
		assertTrue(new DefaultCTabItem("Software/Update").isShowing());
		new DefaultCTabItem("Getting Started").activate();
	}

	@Test
	public void learnAboutRedHatButton() {
		centralBrowser.execute("$(\'a[href=\"http://developers.redhat.com/\"]\').get( 0 ).click()");
		new WaitUntil(new ShellIsAvailable(new WithTextMatcher(new RegexMatcher(".*Red.*Hat.*Developer.*"))));
	}

	@Test
	public void catButton() {
		centralBrowser.execute("$(\'a[href=\"http://tools.jboss.org/cat/\"]\').get( 0 ).click()");
		new WaitUntil(new BrowserContainsText("JBoss Tools"));
		new WaitUntil(new BrowserContainsText("Community Acceptance Testing (CAT)"));
	}

	@Test
	public void archetypesArePresent() {
		List<String> wizards = Arrays.asList(jsHelper.getWizards());
		assertTrue(wizards.contains("HTML5 Project"));
		assertTrue(wizards.contains("OpenShift Application"));
		assertTrue(wizards.contains("AngularJS Forge"));
		assertTrue(wizards.contains("Java EE Web Project"));
		assertTrue(wizards.contains("Maven Project"));
		// removed from central
		//assertTrue(wizards.contains("Hybrid Mobile Project"));
	}

	@Test
	public void searchIsWorking() {
		jsHelper.searchFor(KITCHENSINK_JSP);
		String[] examples = jsHelper.getExamples();
		assertTrue("At least one example should be found", examples.length > 0);
		for (String example : examples) {
			String description = jsHelper.getDescriptionForExample(example);
			assertNotNull("Description should not be null.", description);
			assertFalse("Description should not be empty", description.isEmpty());
			String[] labels = jsHelper.getLabelsForExample(example);
			assertTrue("There should be at least one label", labels.length > 0);
		}
		jsHelper.clearSearch();
	}

	@Test
	public void HTML5ProjectWizardCanBeEnvoked() {
		jsHelper.clickWizard("HTML5 Project");
		new DefaultShell("New Project Example").close();
	}

	@Test
	public void newExampleWizardCanBeEnvoked() {
		jsHelper.searchFor(CONTACTS_MOBILE_BASIC);
		jsHelper.clickExample(CONTACTS_MOBILE_BASIC);
		new DefaultShell("New Project Example").close();
		jsHelper.clearSearch();
	}
	
}
