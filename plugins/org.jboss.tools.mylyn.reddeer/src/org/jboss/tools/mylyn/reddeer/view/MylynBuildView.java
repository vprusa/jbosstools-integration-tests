package org.jboss.tools.mylyn.reddeer.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.reddeer.common.logging.Logger;
import org.eclipse.reddeer.common.wait.TimePeriod;
import org.eclipse.reddeer.common.wait.WaitUntil;
import org.eclipse.reddeer.eclipse.exception.EclipseLayerException;
import org.eclipse.reddeer.swt.api.Tree;
import org.eclipse.reddeer.swt.api.TreeItem;
import org.eclipse.reddeer.swt.condition.ControlIsEnabled;
import org.eclipse.reddeer.swt.exception.SWTLayerException;
import org.eclipse.reddeer.swt.impl.button.CheckBox;
import org.eclipse.reddeer.swt.impl.button.PushButton;
import org.eclipse.reddeer.swt.impl.shell.DefaultShell;
import org.eclipse.reddeer.swt.impl.text.LabeledText;
import org.eclipse.reddeer.swt.impl.toolbar.DefaultToolItem;
import org.eclipse.reddeer.swt.impl.tree.DefaultTree;
import org.eclipse.reddeer.swt.impl.tree.DefaultTreeItem;
import org.eclipse.reddeer.workbench.impl.view.WorkbenchView;
import org.jboss.tools.mylyn.reddeer.TestSupport;
import org.jboss.tools.mylyn.reddeer.mylynBuild.MylynBuild;

/**
 * Represents the Build List view - to support Mylyn automated tests. 
 *  
 * @author ldimaggi
 *
 */
public class MylynBuildView extends WorkbenchView {
	
	protected final static Logger log = Logger.getLogger(MylynBuildView.class);

	public static final String TITLE = "Builds";
	
	public MylynBuildView() {
		super(TITLE);
	}

	public List<MylynBuild> getMylynBuilds(){
		List<MylynBuild> theMylynBuilds = new ArrayList<MylynBuild>();

		Tree tree;
		try {
			tree = new DefaultTree();
		} catch (SWTLayerException e){
			return new ArrayList<MylynBuild>();
		}
		for (TreeItem item : tree.getItems()){
			theMylynBuilds.add(new MylynBuild(item));
		}
		return theMylynBuilds;
	}

	public MylynBuild getMylynBuild(String name){
		for (MylynBuild repository : getMylynBuilds()){
			if (repository.getName().equals(name)){
				return repository;
			}
		}
		throw new EclipseLayerException("There is no build with name " + name);
	}

	protected Tree getBuildsTree(){
		open();
		return new DefaultTree();
	}
	
	/* Method to locate and select a build in the build list view  */
	public TreeItem getBuild (String buildName) {
		new DefaultTree();
		DefaultTreeItem theBuild = new DefaultTreeItem (buildName);
		theBuild.select();
		return theBuild;
	}
	
	/* Method to locate and select a job under a build in the build list view  */
	public TreeItem getJenkinsJob (String buildName, String jobName) {
		new DefaultTree();
		DefaultTreeItem theBuild = new DefaultTreeItem (buildName);
		theBuild.select();

		List<TreeItem> theJobs = theBuild.getItems();
		for (TreeItem theItem : theJobs) {
			if (theItem.getText().equals(jobName)){
				return theItem;
			}
		}
		throw new EclipseLayerException("There is no job with name " + jobName);
	}
	
	/* For use in the Build List View */
	public void createAuthBuildServer (String serverURL, String userName, String passWord) {
		log.info("Creating New Build Server - " + serverURL);
		new DefaultToolItem("New Build Server Location").click();
		
		new DefaultShell ("New Repository");
		new DefaultTreeItem ("Hudson (supports Jenkins)").select();
		new PushButton("Next >").click();
		
		TestSupport.closeSecureStorageIfOpened ();
		
		new DefaultShell ("New Build Server");
		new LabeledText ("Server:").setText(serverURL);
		new LabeledText ("Label:").setText(serverURL);
		
		new CheckBox ("Anonymous").click();
		new CheckBox ("Save Password").click();
		new LabeledText ("User:").setText(userName);
		new LabeledText ("Password:").setText(passWord);
		
		/* Workaround for https://github.com/jboss-reddeer/reddeer/issues/817 */
		new PushButton("Validate").click();
		new PushButton("Select All").click();
		
		new PushButton("Finish").click();
	}
	
	/* For use in the Build List View */
	public void createBuildServer (String serverURL) {
		log.info("Creating New Build Server - " + serverURL);
		new DefaultToolItem("New Build Server Location").click();
		
		new DefaultShell ("New Repository");
		new DefaultTreeItem ("Hudson (supports Jenkins)").select();
		new PushButton("Next >").click();

		TestSupport.closeSecureStorageIfOpened();
		
		new DefaultShell ("New Build Server");
		new LabeledText ("Server:").setText(serverURL);
		new LabeledText ("Label:").setText(serverURL);
		validateSettings();
		new PushButton("Select All").click();
		new PushButton("Finish").click();
	}

	/* Check for the Validate button before and after it is clicked
	 * as validation can be slow 
	 */
	public void validateSettings() {
		new WaitUntil(new ControlIsEnabled(new PushButton("Validate")), TimePeriod.VERY_LONG);
		new PushButton("Validate").click();
		new WaitUntil(new ControlIsEnabled(new PushButton("Validate")), TimePeriod.VERY_LONG);
	}

}
