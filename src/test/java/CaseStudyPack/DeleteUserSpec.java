package CaseStudyPack;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class DeleteUserSpec {
	RequestSpecification req;
	Response res;
		
	@Given("The petstore API URI for delete Method {string}")
	public void the_petstore_API_URI_for_delete_Method(String string) {
		
		req=RestAssured.given();
		req.header("Content-Type","application/json");	 
	}

	@When("The petstore info Get deleted")
	public void the_petstore_info_Get_deleted() {
		res=req.when().delete("https://petstore.swagger.io/v2/user/Rina123");
	}
	
	@Then("User gets response code as {int}")
	public void user_gets_response_code_as(Integer int1)
	{
		res.then().log().all().statusCode(200);
	    Assert.assertEquals(res.getStatusCode(),200); 
	    ExtentHtmlReporter Reporter= new ExtentHtmlReporter("C:\\Users\\k.a.ravindra.wakhare\\eclipse-workspace\\RestAssurredCaseStudy\\Extent Report\\CaseStudy_DeleteUser.html");
	    ExtentReports extent= new ExtentReports();
	    extent.attachReporter(Reporter);
	    ExtentTest test= extent.createTest("CaseStudy_Delete_Method");
	    test.log(Status.INFO, "Swagger Petstore Web Service Testing");
	    test.log(Status.PASS, "the test has been passed");
	    test.log(Status.WARNING, MarkupHelper.createLabel("This is Warning statement",ExtentColor.RED));
	    extent.flush();
	}

}
