package RunnerPack;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/cucumber.json", "html:target/index.html"},
features={"C:\\Users\\k.a.ravindra.wakhare\\eclipse-workspace\\RestAssurredCaseStudy\\Features\\PostUser.feature",
		  "C:\\Users\\k.a.ravindra.wakhare\\eclipse-workspace\\RestAssurredCaseStudy\\Features\\GetUser.feature",
		  "C:\\Users\\k.a.ravindra.wakhare\\eclipse-workspace\\RestAssurredCaseStudy\\Features\\PutUser.feature",
		  "C:\\Users\\k.a.ravindra.wakhare\\eclipse-workspace\\RestAssurredCaseStudy\\Features\\DeleteUser.feature"},		  
glue="CaseStudyPack"
)
public class TestRunner {

}
