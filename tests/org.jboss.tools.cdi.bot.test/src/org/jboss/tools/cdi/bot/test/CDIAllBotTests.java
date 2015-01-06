/*******************************************************************************
 * Copyright (c) 2010-2011 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.cdi.bot.test;

import org.jboss.reddeer.junit.runner.RedDeerSuite;
import org.jboss.tools.cdi.bot.test.beansxml.BeansXMLCompletionTest;
import org.jboss.tools.cdi.bot.test.beansxml.BeansXMLValidationTest;
import org.jboss.tools.cdi.bot.test.cd11.CDI11BeansXmlTest;
import org.jboss.tools.cdi.bot.test.cd11.CDI11DiscoveryModes;
import org.jboss.tools.cdi.bot.test.cd11.CDI11Wizard;
import org.jboss.tools.cdi.bot.test.cd11.VetoedAnnotation;
import org.jboss.tools.cdi.bot.test.decorator.DecoratorFromWebBeanTest;
import org.jboss.tools.cdi.bot.test.editor.BeansEditorTest;
import org.jboss.tools.cdi.bot.test.editor.WeldExtensionTest;
import org.jboss.tools.cdi.bot.test.extensions.BuiltInContexts;
import org.jboss.tools.cdi.bot.test.extensions.ParametersAnnotation;
import org.jboss.tools.cdi.bot.test.extensions.WeldExclude;
import org.jboss.tools.cdi.bot.test.named.NamedComponentsSearchingTest;
import org.jboss.tools.cdi.bot.test.named.NamedRefactoringTest;
import org.jboss.tools.cdi.bot.test.openon.FindObserverForEventTest;
import org.jboss.tools.cdi.bot.test.openon.OpenOnTest;
import org.jboss.tools.cdi.bot.test.quickfix.dialog.AllAssignableDialogTest;
import org.jboss.tools.cdi.bot.test.quickfix.dialog.AssignableDialogFilterTest;
import org.jboss.tools.cdi.bot.test.quickfix.injection.ProblemEligibleInjectionTest;
import org.jboss.tools.cdi.bot.test.quickfix.test.BeanValidationQuickFixTest;
import org.jboss.tools.cdi.bot.test.quickfix.test.BeansXMLValidationQuickFixTest;
import org.jboss.tools.cdi.bot.test.quickfix.test.DecoratorValidationQuickFixTest;
import org.jboss.tools.cdi.bot.test.quickfix.test.IBindingValidationQuickFixTest;
import org.jboss.tools.cdi.bot.test.quickfix.test.InterceptorValidationQuickFixTest;
import org.jboss.tools.cdi.bot.test.quickfix.test.QualifierValidationQuickFixTest;
import org.jboss.tools.cdi.bot.test.quickfix.test.QuickFixProposalsDescriptionTest;
import org.jboss.tools.cdi.bot.test.quickfix.test.ScopeValidationQuickFixTest;
import org.jboss.tools.cdi.bot.test.quickfix.test.StereotypeValidationQuickFixTest;
import org.jboss.tools.cdi.bot.test.validation.AsYouTypeValidationTest;
import org.jboss.tools.cdi.bot.test.validation.CDIValidatorTest;
import org.jboss.tools.cdi.bot.test.wizard.CDIWebProjectWizardTest;
import org.jboss.tools.cdi.bot.test.wizard.ConfigurationPresetTest;
import org.jboss.tools.cdi.bot.test.wizard.DynamicWebProjectWithCDITest;
import org.jboss.tools.cdi.bot.test.wizard.FacetTest;
import org.jboss.tools.cdi.bot.test.wizard.WizardTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

/**
 *
 * @author Lukas Jungmann
 * @author Jaroslav Jankovic
 */
@RunWith(RedDeerSuite.class)
@SuiteClasses({	
	
//	PerspectiveTest.class,  // not included in JBDS anymore
	ConfigurationPresetTest.class,
	
	FacetTest.class, 
	CDIWebProjectWizardTest.class,
	DynamicWebProjectWithCDITest.class,
	CDIValidatorTest.class,
	WizardTest.class,
	BeansEditorTest.class,
	WeldExtensionTest.class,
	//NamedRefactoringTest.class,
	NamedComponentsSearchingTest.class,
	BeansXMLValidationTest.class,
	BeansXMLCompletionTest.class,
	
	BeansXMLValidationQuickFixTest.class,
	
	
	AsYouTypeValidationTest.class,
	
	
	DecoratorFromWebBeanTest.class,
	ProblemEligibleInjectionTest.class,
	
	
	AllAssignableDialogTest.class,
	
	
	AssignableDialogFilterTest.class,
	QuickFixProposalsDescriptionTest.class,
	
	StereotypeValidationQuickFixTest.class,
	QualifierValidationQuickFixTest.class,
	ScopeValidationQuickFixTest.class,
	BeanValidationQuickFixTest.class,
	InterceptorValidationQuickFixTest.class,
	DecoratorValidationQuickFixTest.class,
	IBindingValidationQuickFixTest.class,
	
	OpenOnTest.class,
	FindObserverForEventTest.class,
	CDI11BeansXmlTest.class,
	CDI11Wizard.class,
	CDI11DiscoveryModes.class,
	ParametersAnnotation.class,
	BuiltInContexts.class,
	WeldExclude.class,
	VetoedAnnotation.class
	
})
public class CDIAllBotTests {
		
}
