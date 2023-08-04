package selenium.in.gov.abdm.blocks.uhi.eua.testsclasses;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.val;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;

public class POST_SearchWithDoctorNameFacility extends SeleniumBaseClass
{
	    SoftAssert softAssert1 = new SoftAssert();
	    SoftAssert softAssert2 = new SoftAssert();
		
		@Test(priority = 1, enabled = true)
		@Severity(SeverityLevel.CRITICAL)
		@Description("Search with Doctor Name API") 
		@Story("Search_with_Doctor_Name_API")
		public void Search_doctor_facility_Api() throws EncryptedDocumentException, IOException
		{
			test = extent.createTest("Search_with_Doctor_Name_API");
			RestAssured.baseURI = readXpath("eua-hspa","EUA_Base_URI","uhi");
			RequestSpecification httpRequest = RestAssured.given();
			
			//------------------------------------------------------------------------------------//
			
			Map<String, Object> mainObj = new HashMap<>();

			val context = new LinkedHashMap<String, Object>();
			context.put("domain", "nic2004:85111");
			context.put("country", "IND");
			context.put("city", "std:080");
			context.put("action", "search");
			context.put("core_version", "0.7.1");
			context.put("consumer_id", "eua-nha");
			context.put("consumer_uri", "http://100.65.158.41:8901/api/v1/euaService");
			context.put("message_id", "e9");
			context.put("timestamp", "2022-07-05T15:24:35");
			context.put("transaction_id", "e9a19230-f951-11ec-b135-53aea776f66b");
			
			mainObj.put("context", context);

			val message = new LinkedHashMap<String, Object>();
			val intent = new LinkedHashMap<String, Object>();
			val category = new LinkedHashMap<String, Object>();
			val descriptor = new LinkedHashMap<String, Object>();
			
			descriptor.put("code", "Consultation");
			descriptor.put("name", "Consultation");
			
			category.put("descriptor", descriptor);
			intent.put("category", category);
			//message.put("message", intent);

			val provider = new LinkedHashMap<String, Object>();
			val descriptor2 = new LinkedHashMap<String, Object>();
			descriptor2.put("name" ,"Test Hospital");
			provider.put("descriptor", descriptor2);
			intent.put("provider", provider);

			val fulfillment = new LinkedHashMap<String, Object>();

			val agent = new LinkedHashMap<String, Object>();
			agent.put("name", "amod");
			fulfillment.put("agent", agent);	
			
			fulfillment.put("type", "Online");

			val item = new LinkedHashMap<String, Object>();
			val descriptor1 = new LinkedHashMap<String, Object>();
			descriptor1.put("code", "Consultation");
			descriptor1.put("name", "Consultation");
			
			item.put("descriptor", descriptor1);
			fulfillment.put("item", item);
			
			intent.put("fulfillment", fulfillment);
			message.put("intent", intent);
			
			mainObj.put("message", message);
			
			
			System.out.println(mainObj);
			
			//------------------------------------------------------------------------------------//
			
			httpRequest.header("Content-Type", "application/json");
			Response response = httpRequest.body(mainObj).post(readXpath("eua-hspa","EUA_End_Point","uhi"));
			
			response.prettyPrint();
			
			String jsonResponse = response.getBody().asString();
	        String status = JsonPath.from(jsonResponse).get("message.ack.status");
	        System.out.println("Status is : " + status);
	        String error = JsonPath.from(jsonResponse).get("error.message");
	        System.out.println("Error is : " + error);
				        
			
			if(status == "ACK" && error != null) {
				
				Assert.fail("\u001B[31m"+"THE STATUS IS ACKNOWLEDGED BUT STILL SEEING THE ERROR MESSAGE. MESSAGE IS : "+"\u001B[0m"+error);
				
			}
			
			softAssert1.assertEquals(status, "ACK");
	        softAssert1.assertEquals(error, null);
	        softAssert1.assertEquals(response.statusCode(), 200);
	        softAssert1.assertEquals(response.statusLine(), "HTTP/1.1 200 OK");
			softAssert1.assertAll();
			
		}
		
		@Test(priority = 2, enabled = true)
		@Severity(SeverityLevel.CRITICAL)
		@Description("Search with Doctor Name API") 
		@Story("Search_with_Doctor_Name_API")
		public void Missing_Search_doctor_facility_Api() throws EncryptedDocumentException, IOException
		{
			test = extent.createTest("Search_with_Doctor_Name_API");
			RestAssured.baseURI = readXpath("eua-hspa","EUA_Base_URI","uhi");
			RequestSpecification httpRequest = RestAssured.given();
			
			//------------------------------------------------------------------------------------//
			
			Map<String, Object> mainObj = new HashMap<>();

			val context = new LinkedHashMap<String, Object>();
			context.put("domain", "nic2004:85111");
			context.put("country", "IND");
			context.put("city", "std:080");
			context.put("action", "search");
			context.put("core_version", "0.7.1");
			context.put("timestamp", "2022-07-05T15:24:35");
			context.put("transaction_id", "e9a19230-f951-11ec-b135-53aea776f66b");
			
			mainObj.put("context", context);

			val message = new LinkedHashMap<String, Object>();
			val intent = new LinkedHashMap<String, Object>();
			val category = new LinkedHashMap<String, Object>();
			val descriptor = new LinkedHashMap<String, Object>();
			
			descriptor.put("code", "Consultation");
			descriptor.put("name", "Consultation");
			
			category.put("descriptor", descriptor);
			intent.put("category", category);
			//message.put("message", intent);

			val provider = new LinkedHashMap<String, Object>();
			val descriptor2 = new LinkedHashMap<String, Object>();
			descriptor2.put("name" ,"Test Hospital");
			provider.put("descriptor", descriptor2);
			intent.put("provider", provider);

			val fulfillment = new LinkedHashMap<String, Object>();

			val agent = new LinkedHashMap<String, Object>();
			agent.put("name", "amod");
			fulfillment.put("agent", agent);	
			
			fulfillment.put("type", "Online");

			val item = new LinkedHashMap<String, Object>();
			val descriptor1 = new LinkedHashMap<String, Object>();
			descriptor1.put("code", "Consultation");
			descriptor1.put("name", "Consultation");
			
			item.put("descriptor", descriptor1);
			fulfillment.put("item", item);
			
			intent.put("fulfillment", fulfillment);
			message.put("intent", intent);
			
			mainObj.put("message", message);
			
			
			System.out.println(mainObj);
			
			//------------------------------------------------------------------------------------//
			
			httpRequest.header("Content-Type", "application/json");
			Response response = httpRequest.body(mainObj).post(readXpath("eua-hspa","EUA_End_Point","uhi"));
			
			response.prettyPrint();
			
			String jsonResponse = response.getBody().asString();
	        String status = JsonPath.from(jsonResponse).get("message.ack.status");
	        System.out.println("Status is : " + status);
	        String error = JsonPath.from(jsonResponse).get("error.message");
	        System.out.println("Error is : " + error);
	        

			if(status == "NACK" && error == null) {
				
				Assert.fail("\u001B[31m"+"THE STATUS IS NOT ACKNOWLEDGED BUT STILL NOT SEEING THE ERROR MESSAGE. MESSAGE IS NULL "+"\u001B[0m");
				
			}
			
	        softAssert2.assertEquals(status, "NACK");
	        softAssert2.assertEquals(error, "Mandatory fields on context are Null");
	        softAssert2.assertEquals(response.statusCode(), 500);
	        softAssert2.assertEquals(response.statusLine(), "HTTP/1.1 500 Internal Server Error");
			softAssert2.assertAll();
			
		}

}
