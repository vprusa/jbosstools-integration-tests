package org.jboss.tools.hibernate.reddeer.editor;

import org.jboss.reddeer.common.logging.Logger;
import org.jboss.reddeer.core.condition.JobIsRunning;
import org.jboss.reddeer.common.exception.RedDeerException;
import org.jboss.reddeer.swt.impl.button.YesButton;
import org.jboss.reddeer.swt.impl.shell.DefaultShell;
import org.jboss.reddeer.swt.impl.toolbar.DefaultToolItem;
import org.jboss.reddeer.common.wait.WaitWhile;
import org.jboss.reddeer.workbench.impl.editor.TextEditor;

/**
 * Hibernate Criteria Editor RedDeer implementation
 * @author Jiri Peterka
 *
 */
public class CriteriaEditor extends TextEditor {

	private Logger log = Logger.getLogger(CriteriaEditor.class);
	
	/**
	 * Sets focus to Criteria Editor with given title 
	 * @param hibernateConsoleName hibernateConsoleName
	 */
	public CriteriaEditor(String hibernateConsoleName) {
		super("Criteria:" + hibernateConsoleName);
	}

	/**
	 * Executes criteria 
	 */
	public void runCriteria() {
		new DefaultToolItem("Run criteria").click();
		
		try {
			new DefaultShell("Open Session factory");
			new YesButton().click();
		}
		catch (RedDeerException e) {
			log.warn("Open Session factory question dialog was expected");
		} finally {
			new WaitWhile(new JobIsRunning());
		}
	}
	
}
