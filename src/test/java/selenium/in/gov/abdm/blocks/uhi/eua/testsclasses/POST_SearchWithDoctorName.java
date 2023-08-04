package selenium.in.gov.abdm.blocks.uhi.eua.testsclasses;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.val;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;
import io.restassured.RestAssured;

public class POST_SearchWithDoctorName extends SeleniumBaseClass
{
		 SoftAssert softAssert1 = new SoftAssert();
		 SoftAssert softAssert2 = new SoftAssert();
		 SoftAssert softAssert3 = new SoftAssert();
		 SoftAssert softAssert4 = new SoftAssert();
		
		@Test(priority = 1)
		@Severity(SeverityLevel.CRITICAL)
		@Description("Search with Doctor Name API") 
		@Story("Search_with_Doctor_Name_API")
		public void Search_doctor_Api() throws EncryptedDocumentException, IOException
		{
			test = extent.createTest("Search_with_Doctor_Name_API");
			RestAssured.baseURI = readXpath("eua-hspa","EUA_Base_URI","uhi");
			RequestSpecification httpRequest = RestAssured.given();
			
			//------------------------------------------------------------------------------------//
			
			Map<String, Object> mainObj = new HashMap<>();

			Map<String, Object> context = new LinkedHashMap<>();
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
			val item = new LinkedHashMap<String, Object>();
			val descriptor = new LinkedHashMap<String, Object>();
			
			descriptor.put("code", "Consultation");
			descriptor.put("name", "Consultation");
			
			item.put("descriptor", descriptor);
			intent.put("item", item);
			//message.put("message", intent);

			val fulfillment = new LinkedHashMap<String, Object>();

			val agent = new LinkedHashMap<String, Object>();
			agent.put("name", "amod");
			fulfillment.put("agent", agent);

			val start = new LinkedHashMap<String, Object>();
			val starttime = new LinkedHashMap<String, Object>();
			starttime.put("timestamp", "2022-07-15T00:00:00");
			start.put("time", starttime);
			fulfillment.put("start", start);

			val end = new LinkedHashMap<String, Object>();
			val endtime = new LinkedHashMap<String, Object>();
			endtime.put("timestamp", "2022-07-15T00:00:00");
			end.put("time", endtime);
			fulfillment.put("end", end);
			
			
			fulfillment.put("type", "Online");
			
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
		@Description("Fields missing in context of Doctor Name API") 
		@Story("Missing_Search_with_Doctor_Name_API")
		public void Missing_Context_Search_Doc() throws EncryptedDocumentException, IOException
		{
			test = extent.createTest("Missing_Search_with_Doctor_Name_API");
			RestAssured.baseURI = readXpath("eua-hspa","EUA_Base_URI","uhi");
			RequestSpecification httpRequest = RestAssured.given();
			
			//------------------------------------------------------------------------------------//
			
			Map<String, Object> mainObj = new HashMap<>();

			val context = new LinkedHashMap<String, Object>();
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
			val item = new LinkedHashMap<String, Object>();
			val descriptor = new LinkedHashMap<String, Object>();
			
			descriptor.put("code", "Consultation");
			descriptor.put("name", "Consultation");
			
			item.put("descriptor", descriptor);
			intent.put("item", item);
			//message.put("message", intent);

			val fulfillment = new LinkedHashMap<String, Object>();

			val agent = new LinkedHashMap<String, Object>();
			agent.put("name", "amod");
			fulfillment.put("agent", agent);

			val start = new LinkedHashMap<String, Object>();
			val starttime = new LinkedHashMap<String, Object>();
			starttime.put("timestamp", "2022-07-15T00:00:00");
			start.put("time", starttime);
			fulfillment.put("start", start);

			val end = new LinkedHashMap<String, Object>();
			val endtime = new LinkedHashMap<String, Object>();
			endtime.put("timestamp", "2022-07-15T00:00:00");
			end.put("time", endtime);
			fulfillment.put("end", end);
			
			
			fulfillment.put("type", "Online");
			
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
		
		
		@Test(priority = 3, enabled = true)
		@Severity(SeverityLevel.CRITICAL)
		@Description("Agent section missing in message of Doctor Name API")
		@Story("Missing_Agent_in_Doctor_Name_API")
		public void Missing_Agent_Search_Doc() throws EncryptedDocumentException, IOException
		{
			test = extent.createTest("Missing_Agent_in_Doctor_Name_API");
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
			val item = new LinkedHashMap<String, Object>();
			val descriptor = new LinkedHashMap<String, Object>();
			
			descriptor.put("code", "Consultation");
			descriptor.put("name", "Consultation");
			
			item.put("descriptor", descriptor);
			intent.put("item", item);
			//message.put("message", intent);

			val fulfillment = new LinkedHashMap<String, Object>();

			val start = new LinkedHashMap<String, Object>();
			val starttime = new LinkedHashMap<String, Object>();
			starttime.put("timestamp", "2022-07-15T00:00:00");
			start.put("time", starttime);
			fulfillment.put("start", start);

			val end = new LinkedHashMap<String, Object>();
			val endtime = new LinkedHashMap<String, Object>();
			endtime.put("timestamp", "2022-07-15T00:00:00");
			end.put("time", endtime);
			fulfillment.put("end", end);
			
			
			fulfillment.put("type", "Online");
			
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
			
	        softAssert3.assertEquals(status, "NACK");
	        softAssert3.assertEquals(error, "Mandatory fields on context are Null");
	        softAssert3.assertEquals(response.statusCode(), 500);
	        softAssert3.assertEquals(response.statusLine(), "HTTP/1.1 500 Internal Server Error");
			softAssert3.assertAll();
			
		}
		
		@Test(priority = 4, enabled = true)
		@Severity(SeverityLevel.CRITICAL)
		@Description("Type section mssing in message of Doctor Name API") 
		@Story("Missing_Type_in_Doctor_Name_API")
		public void Missing_Type_Search_Doc() throws EncryptedDocumentException, IOException
		{
			test = extent.createTest("Missing_Type_in_Doctor_Name_API");
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
			val item = new LinkedHashMap<String, Object>();
			val descriptor = new LinkedHashMap<String, Object>();
			
			descriptor.put("code", "Consultation");
			descriptor.put("name", "Consultation");
			
			item.put("descriptor", descriptor);
			intent.put("item", item);
			//message.put("message", intent);

			val fulfillment = new LinkedHashMap<String, Object>();

			val agent = new LinkedHashMap<String, Object>();
			agent.put("name", "amod");
			fulfillment.put("agent", agent);

			val start = new LinkedHashMap<String, Object>();
			val starttime = new LinkedHashMap<String, Object>();
			starttime.put("timestamp", "2022-07-15T00:00:00");
			start.put("time", starttime);
			fulfillment.put("start", start);

			val end = new LinkedHashMap<String, Object>();
			val endtime = new LinkedHashMap<String, Object>();
			endtime.put("timestamp", "2022-07-15T00:00:00");
			end.put("time", endtime);
			fulfillment.put("end", end);
			
			
		
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
			
	        softAssert4.assertEquals(status, "ACK");
	        softAssert4.assertEquals(error, "Mandatory fields on context are Null");
	        softAssert4.assertEquals(response.statusCode(), 500);
	        softAssert4.assertEquals(response.statusLine(), "HTTP/1.1 500 Internal Server Error");
			softAssert4.assertAll();
			
		}

}
