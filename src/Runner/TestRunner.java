package Runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options
		(	
				
		features = "C:\\Users\\PallabDocuments16\\Workspace\\CucumberProject\\MyScenarios\\MyFeatures.feature", 
		glue= {"StepDefinition"},
		dryRun = false
		
		)

public class TestRunner {

}
