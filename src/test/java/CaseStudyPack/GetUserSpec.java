package CaseStudyPack;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetUserSpec {
	
	RequestSpecification req;
	Response res;
	
	@Given("The get method of swagger petstore {string}")
	public void the_get_method_of_swagger_petstore(String string) {
		req=RestAssured.given();
		req.header("Content-Type","application/json");	    
	}

	@When("The petstore info get in Json format")
	public void the_petstore_info_get_in_Json_format() {
	    res=req.when().get("https://petstore.swagger.io/v2/user/Meena123");
	}

	@Then("User gets response as {int}")
	public void user_gets_response_as(Integer int1) {
	    res.then().log().all().statusCode(200);
	    ValidatableResponse vr=res.then();
	    vr.statusCode(200);
        vr.contentType("application/json");
        
        ExtentHtmlReporter Reporter= new ExtentHtmlReporter("C:\\Users\\k.a.ravindra.wakhare\\eclipse-workspace\\RestAssurredCaseStudy\\Extent Report\\CaseStudy_GetUser.html");
	    ExtentReports extent= new ExtentReports();
	    extent.attachReporter(Reporter);
	    ExtentTest test= extent.createTest("CaseStudy_Get_Method");
	    test.log(Status.INFO, "Swagger Petstore Web Service Testing");
	    test.log(Status.PASS, "the test has been passed");
	    test.log(Status.WARNING, MarkupHelper.createLabel("This is Warning statement",ExtentColor.RED));
	    extent.flush();
	}

}
