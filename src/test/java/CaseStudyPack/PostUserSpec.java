package CaseStudyPack;

import java.io.File;

import org.junit.Assert;

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
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class PostUserSpec {
	RequestSpecification request;
	Response response;
	String URI;
	
	@Given("The petstore API for Post method {string}")
	public void the_petstore_API_for_Post_method(String string) {
		URI="https://petstore.swagger.io/v2/user/createWithList";
		request=RestAssured.given();
		request.header("Content-Type","application/json");
	}

	@When("The petstore information post in json format")
	public void the_petstore_information_post_in_json_format() {
		response=request.body(new File("src/test/resources/postPayload.json")).when().post(URI);
	}

	@Then("The Response is returned as {int}")
	public void the_Response_is_returned_as(Integer int1) {
		response.then().log().all().statusCode(200);
		Assert.assertEquals(response.getStatusCode(),200);
		ExtentHtmlReporter Reporter= new ExtentHtmlReporter("C:\\Users\\k.a.ravindra.wakhare\\eclipse-workspace\\RestAssurredCaseStudy\\Extent Report\\CaseStudy_PostUser.html");
	    ExtentReports extent= new ExtentReports();
	    extent.attachReporter(Reporter);
	    ExtentTest test= extent.createTest("CaseStudy_Post_Method");
	    test.log(Status.INFO, "Swagger Petstore Web Service Testing");
	    test.log(Status.PASS, "the test has been passed");
	    test.log(Status.WARNING, MarkupHelper.createLabel("This is Warning statement",ExtentColor.RED));
	    extent.flush();
	    
	}

}
