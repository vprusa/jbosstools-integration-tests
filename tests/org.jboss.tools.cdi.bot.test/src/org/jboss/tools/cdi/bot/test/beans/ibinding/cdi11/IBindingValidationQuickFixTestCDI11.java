package org.jboss.tools.cdi.bot.test.beans.ibinding.cdi11;

import org.eclipse.reddeer.eclipse.ui.perspectives.JavaEEPerspective;
import org.eclipse.reddeer.junit.annotation.RequirementRestriction;
import org.eclipse.reddeer.junit.requirement.matcher.RequirementMatcher;
import org.eclipse.reddeer.requirements.openperspective.OpenPerspectiveRequirement.OpenPerspective;
import org.eclipse.reddeer.requirements.server.ServerRequirementState;
import org.jboss.ide.eclipse.as.reddeer.server.family.ServerMatcher;
import org.jboss.ide.eclipse.as.reddeer.server.requirement.ServerRequirement.JBossServer;
import org.jboss.tools.cdi.bot.test.beans.ibinding.template.IBindingValidationQuickFixTemplate;
import org.jboss.tools.cdi.reddeer.validators.InterceptorBindingValidationProviderCDI11;
import org.junit.Before;

@JBossServer(state=ServerRequirementState.PRESENT, cleanup=false)
@OpenPerspective(JavaEEPerspective.class)
public class IBindingValidationQuickFixTestCDI11 extends IBindingValidationQuickFixTemplate{

	@RequirementRestriction
	public static RequirementMatcher getRestrictionMatcher() {
	  return new RequirementMatcher(JBossServer.class, "family", ServerMatcher.WildFly());
	}
		
	@Before
	public void changeDiscoveryMode(){
		validationProvider = new InterceptorBindingValidationProviderCDI11();
		prepareBeanXml("all", true);
	}

}
