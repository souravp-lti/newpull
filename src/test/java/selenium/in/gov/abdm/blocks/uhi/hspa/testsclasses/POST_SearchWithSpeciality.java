package selenium.in.gov.abdm.blocks.uhi.hspa.testsclasses;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.val;
import org.apache.poi.EncryptedDocumentException;
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

public class POST_SearchWithSpeciality extends SeleniumBaseClass
	{
	  SoftAssert softAssert = new SoftAssert();
		
		@Test(priority = 1, enabled = true)
		@Severity(SeverityLevel.NORMAL)
		@Description("Search with Specility API") 
		@Story("Search_with_Specility_API")
		public void Search_Specility_Api() throws EncryptedDocumentException, IOException
		{
			test = extent.createTest("Search_with_Specility_API");
			RestAssured.baseURI = readXpath("eua-hspa","HSPA_Base_URI","uhi");
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
			context.put("consumer_uri", "http://uhieuasandbox.abdm.gov.in/api/v1/euaService");
			context.put("message_id", "e9");
			context.put("timestamp", "2022-07-05T15:24:35");
			context.put("provider_id", "hspa-nha");
			context.put("provider_uri", "http://hspasbx.abdm.gov.in/api/v1");
			context.put("transaction_id", "e9a19230-f951-11ec-b135-53aea776f66b");
			
			mainObj.put("context", context);
			// create message object
			val message = new LinkedHashMap<String, Object>();
			
			// create intent object
			val intent = new LinkedHashMap<String, Object>();
			
			// create category object
			val category = new LinkedHashMap<String, Object>();
			//create descriptor object inside category object
			val descriptor = new LinkedHashMap<String, Object>();
			descriptor.put("code", "Cardiology");
			descriptor.put("name", "CARDIOLOGY");
			
			//Put object in category
			category.put("descriptor", descriptor);
			
			//put category in intent object
			intent.put("category", category);
			
			// create fulfillment object
			val fulfillment = new LinkedHashMap<String, Object>();
			
			// insert type in fulfillment object
			fulfillment.put("type", "Physical");
			
			// create start and end objects
			val start = new LinkedHashMap<String, Object>();
			val startTime = new LinkedHashMap<String, Object>();
			
			startTime.put("timestamp", "2022-07-15T00:00:00");
			start.put("time", startTime);

			fulfillment.put("start", start);

			val end = new LinkedHashMap<String, Object>();
			val endTime = new LinkedHashMap<String, Object>();
			endTime.put("timestamp", "2022-07-16T00:00:00");
			end.put("time", endTime);
			
			fulfillment.put("end", end);
			
			// create item object
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
			httpRequest.header("X-Gateway-Authorization", "dummy");
			Response response = httpRequest.body(mainObj).post(readXpath("eua-hspa","HSPA_End_Point","uhi"));
			
			response.prettyPrint();
			
			String jsonResponse = response.getBody().asString();
	        String status = JsonPath.from(jsonResponse).get("message.ack.status");
	        System.out.println("Status is : " + status);
			
	        softAssert.assertEquals(status, "ACK");
	        softAssert.assertEquals(response.statusCode(), 200);
	        System.out.println(response.statusLine());
	        //softAssert.assertEquals(response.statusLine(), "HTTP/1.1 200");
			softAssert.assertAll();
			
		}
		// remove gateway header from request header
		@Test(priority = 2, enabled = true)
		@Severity(SeverityLevel.NORMAL)
		@Description("Search with Specility API removing gateway header") 
		@Story("Search_with_Specility_API")
		public void Search_Specility_Api_remove_gateway_header() throws EncryptedDocumentException, IOException
		{
			test = extent.createTest("Search_with_Specility_API");
			RestAssured.baseURI = readXpath("eua-hspa","HSPA_Base_URI","uhi");
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
			context.put("consumer_uri", "http://uhieuasandbox.abdm.gov.in/api/v1/euaService");
			context.put("message_id", "e9");
			context.put("timestamp", "2022-07-05T15:24:35");
			context.put("provider_id", "hspa-nha");
			context.put("provider_uri", "http://hspasbx.abdm.gov.in/api/v1");
			context.put("transaction_id", "e9a19230-f951-11ec-b135-53aea776f66b");
			
			mainObj.put("context", context);
			
			// create message object
			val message = new LinkedHashMap<String, Object>();
			
			// create intent object
			val intent = new LinkedHashMap<String, Object>();
			
			// create category object
			val category = new LinkedHashMap<String, Object>();
			//create descriptor object inside category object
			val descriptor = new LinkedHashMap<String, Object>();
			descriptor.put("code", "Cardiology");
			descriptor.put("name", "CARDIOLOGY");
			
			//Put object in category
			category.put("descriptor", descriptor);
			
			//put category in intent object
			intent.put("category", category);
			
			// create fulfillment object
			val fulfillment = new LinkedHashMap<String, Object>();
			
			// insert type in fulfillment object
			fulfillment.put("type", "Physical");
			
			// create start and end objects
			val start = new LinkedHashMap<String, Object>();
			val startTime = new LinkedHashMap<String, Object>();
			
			startTime.put("timestamp", "2022-07-15T00:00:00");
			start.put("time", startTime);

			fulfillment.put("start", start);

			val end = new LinkedHashMap<String, Object>();
			val endTime = new LinkedHashMap<String, Object>();
			endTime.put("timestamp", "2022-07-16T00:00:00");
			end.put("time", endTime);
			
			fulfillment.put("end", end);
			
			// create item object
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
			//httpRequest.header("X-Gateway-Authorization", "dummy");
			Response response = httpRequest.body(mainObj).post(readXpath("eua-hspa","HSPA_End_Point","uhi"));
			
			response.prettyPrint();
			
			String jsonResponse = response.getBody().asString();
	        String status = JsonPath.from(jsonResponse).get("message.ack.status");
	        System.out.println("Status is : " + status);
			
	        softAssert.assertEquals(status, "NACK");
	        softAssert.assertEquals(response.statusCode(), 400);
	        System.out.println(response.statusLine());
	        //softAssert.assertEquals(response.statusLine(), "HTTP/1.1 200");
			softAssert.assertAll();
			
		}
		// remove context object parameters which are required
				@Test(priority = 3, enabled = true)
				@Severity(SeverityLevel.NORMAL)
				@Description("Search with Specility API removed context object required parameters") 
				@Story("Search_with_Specility_API")
				public void Search_Specility_Api_context_object_required_parameters() throws EncryptedDocumentException, IOException
				{
					test = extent.createTest("Search_with_Specility_API");
					RestAssured.baseURI = readXpath("eua-hspa","HSPA_Base_URI","uhi");
					RequestSpecification httpRequest = RestAssured.given();
					
					//------------------------------------------------------------------------------------//
					
					Map<String, Object> mainObj = new HashMap<>();
					// remove country and city from context object
					val context = new LinkedHashMap<String, Object>();
					context.put("domain", "nic2004:85111");
					context.put("action", "search");
					context.put("core_version", "0.7.1");
					context.put("consumer_id", "eua-nha");
					context.put("consumer_uri", "http://uhieuasandbox.abdm.gov.in/api/v1/euaService");
					context.put("message_id", "e9");
					context.put("timestamp", "2022-07-05T15:24:35");
					context.put("provider_id", "hspa-nha");
					context.put("provider_uri", "http://hspasbx.abdm.gov.in/api/v1");
					context.put("transaction_id", "e9a19230-f951-11ec-b135-53aea776f66b");
					
					mainObj.put("context", context);
					
					// create message object
					val message = new LinkedHashMap<String, Object>();
					
					// create intent object
					val intent = new LinkedHashMap<String, Object>();
					
					// create category object
					val category = new LinkedHashMap<String, Object>();
					//create descriptor object inside category object
					val descriptor = new LinkedHashMap<String, Object>();
					descriptor.put("code", "Cardiology");
					descriptor.put("name", "CARDIOLOGY");
					
					//Put object in category
					category.put("descriptor", descriptor);
					
					//put category in intent object
					intent.put("category", category);
					
					// create fulfillment object
					val fulfillment = new LinkedHashMap<String, Object>();
					
					// insert type in fulfillment object
					fulfillment.put("type", "Physical");
					
					// create start and end objects
					val start = new LinkedHashMap<String, Object>();
					val startTime = new LinkedHashMap<String, Object>();
					
					startTime.put("timestamp", "2022-07-15T00:00:00");
					start.put("time", startTime);

					fulfillment.put("start", start);

					val end = new LinkedHashMap<String, Object>();
					val endTime = new LinkedHashMap<String, Object>();
					endTime.put("timestamp", "2022-07-16T00:00:00");
					end.put("time", endTime);
					
					fulfillment.put("end", end);
					
					// create item object
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
					httpRequest.header("X-Gateway-Authorization", "dummy");
					Response response = httpRequest.body(mainObj).post(readXpath("eua-hspa","HSPA_End_Point","uhi"));
					
					response.prettyPrint();
					
					String jsonResponse = response.getBody().asString();
			        String status = JsonPath.from(jsonResponse).get("message.ack.status");
			        System.out.println("Status is : " + status);
					
			        softAssert.assertEquals(status, "NACK");
			        softAssert.assertEquals(response.statusCode(), 400);
			        System.out.println(response.statusLine());
			        //softAssert.assertEquals(response.statusLine(), "HTTP/1.1 200");
					softAssert.assertAll();
					
				}
				// add invalid information for context object for country and city parameters
				@Test(priority = 4, enabled = true)
				@Severity(SeverityLevel.NORMAL)
				@Description("Search with Specility API sending invalid information for Country and city parameters") 
				@Story("Search_with_Specility_API")
				public void Search_Specility_Api_invcalid_information_context_object() throws EncryptedDocumentException, IOException
				{
					test = extent.createTest("Search_with_Specility_API");
					RestAssured.baseURI = readXpath("eua-hspa","HSPA_Base_URI","uhi");
					RequestSpecification httpRequest = RestAssured.given();
					
					//------------------------------------------------------------------------------------//
					
					Map<String, Object> mainObj = new HashMap<>();
					// invalid information for country and city
					val context = new LinkedHashMap<String, Object>();
					context.put("domain", "nic2004:85111");
					context.put("country", "123");
					context.put("city", "stderd:080");
					context.put("action", "search");
					context.put("core_version", "0.7.1");
					context.put("consumer_id", "eua-nha");
					context.put("consumer_uri", "http://uhieuasandbox.abdm.gov.in/api/v1/euaService");
					context.put("message_id", "e9");
					context.put("timestamp", "2022-07-05T15:24:35");
					context.put("provider_id", "hspa-nha");
					context.put("provider_uri", "http://hspasbx.abdm.gov.in/api/v1");
					context.put("transaction_id", "e9a19230-f951-11ec-b135-53aea776f66b");
					
					mainObj.put("context", context);
					
					// create message object
					val message = new LinkedHashMap<String, Object>();
					
					// create intent object
					val intent = new LinkedHashMap<String, Object>();
					
					// create category object
					val category = new LinkedHashMap<String, Object>();
					//create descriptor object inside category object
					val descriptor = new LinkedHashMap<String, Object>();
					descriptor.put("code", "Cardiology");
					descriptor.put("name", "CARDIOLOGY");
					
					//Put object in category
					category.put("descriptor", descriptor);
					
					//put category in intent object
					intent.put("category", category);
					
					// create fulfillment object
					val fulfillment = new LinkedHashMap<String, Object>();
					
					// insert type in fulfillment object
					fulfillment.put("type", "Physical");
					
					// create start and end objects
					val start = new LinkedHashMap<String, Object>();
					val startTime = new LinkedHashMap<String, Object>();
					
					startTime.put("timestamp", "2022-07-15T00:00:00");
					start.put("time", startTime);

					fulfillment.put("start", start);

					val end = new LinkedHashMap<String, Object>();
					val endTime = new LinkedHashMap<String, Object>();
					endTime.put("timestamp", "2022-07-16T00:00:00");
					end.put("time", endTime);
					
					fulfillment.put("end", end);
					
					// create item object
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
					httpRequest.header("X-Gateway-Authorization", "dummy");
					Response response = httpRequest.body(mainObj).post(readXpath("eua-hspa","HSPA_End_Point","uhi"));
					
					response.prettyPrint();
					
					String jsonResponse = response.getBody().asString();
			        String status = JsonPath.from(jsonResponse).get("message.ack.status");
			        System.out.println("Status is : " + status);
					
			        softAssert.assertEquals(status, "ACK");
			        softAssert.assertEquals(response.statusCode(), 200);
			        System.out.println(response.statusLine());
			        //softAssert.assertEquals(response.statusLine(), "HTTP/1.1 200");
					softAssert.assertAll();
					
				}
				// remove item object
				@Test(priority = 5, enabled = true)
				@Severity(SeverityLevel.NORMAL)
				@Description("Search with Specility API remove item from category object") 
				@Story("Search_with_Specility_API")
				public void Search_Specility_Api_remove_item_from_category_object() throws EncryptedDocumentException, IOException
				{
					test = extent.createTest("Search_with_Specility_API");
					RestAssured.baseURI = readXpath("eua-hspa","HSPA_Base_URI","uhi");
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
					context.put("consumer_uri", "http://uhieuasandbox.abdm.gov.in/api/v1/euaService");
					context.put("message_id", "e9");
					context.put("timestamp", "2022-07-05T15:24:35");
					context.put("provider_id", "hspa-nha");
					context.put("provider_uri", "http://hspasbx.abdm.gov.in/api/v1");
					context.put("transaction_id", "e9a19230-f951-11ec-b135-53aea776f66b");
					
					mainObj.put("context", context);
					
					// create message object
					val message = new LinkedHashMap<String, Object>();
					
					// create intent object
					val intent = new LinkedHashMap<String, Object>();
					
					// create category object
					val category = new LinkedHashMap<String, Object>();
					//create descriptor object inside category object
					val descriptor = new LinkedHashMap<String, Object>();
					descriptor.put("code", "Cardiology");
					descriptor.put("name", "CARDIOLOGY");
					
					//Put object in category
					category.put("descriptor", descriptor);
					
					//put category in intent object
					intent.put("category", category);
					
					// create fulfillment object
					val fulfillment = new LinkedHashMap<String, Object>();
					
					// insert type in fulfillment object
					fulfillment.put("type", "Physical");
					
					// create start and end objects
					val start = new LinkedHashMap<String, Object>();
					val startTime = new LinkedHashMap<String, Object>();
					
					startTime.put("timestamp", "2022-07-15T00:00:00");
					start.put("time", startTime);

					fulfillment.put("start", start);

					val end = new LinkedHashMap<String, Object>();
					val endTime = new LinkedHashMap<String, Object>();
					endTime.put("timestamp", "2022-07-16T00:00:00");
					end.put("time", endTime);
					
					fulfillment.put("end", end);
					
					// create item object
					//Map<String, Object> item = new LinkedHashMap<String, Object>();
					//Map<String, Object> descriptor1 = new LinkedHashMap<String, Object>();
					//descriptor1.put("code", "Consultation");
					//descriptor1.put("name", "Consultation");
					//item.put("descriptor", descriptor1);
					
					//fulfillment.put("item", item);
					
					intent.put("fulfillment", fulfillment);
					
					message.put("intent", intent);
					
					mainObj.put("message", message);
					System.out.println(mainObj);
					
					//------------------------------------------------------------------------------------//
					
					httpRequest.header("Content-Type", "application/json");
					httpRequest.header("X-Gateway-Authorization", "dummy");
					Response response = httpRequest.body(mainObj).post(readXpath("eua-hspa","HSPA_End_Point","uhi"));
					
					response.prettyPrint();
					
					String jsonResponse = response.getBody().asString();
			        String status = JsonPath.from(jsonResponse).get("message.ack.status");
			        System.out.println("Status is : " + status);
					
			        softAssert.assertEquals(status, "ACK");
			        softAssert.assertEquals(response.statusCode(), 200);
			        System.out.println(response.statusLine());
			        //softAssert.assertEquals(response.statusLine(), "HTTP/1.1 200");
					softAssert.assertAll();
					
				}
				// remove category object
				@Test(priority = 6, enabled = true)
				@Severity(SeverityLevel.NORMAL)
				@Description("Search with Specility API remove category object from message") 
				@Story("Search_with_Specility_API")
				public void Search_Specility_Api_remove_category_message_object() throws EncryptedDocumentException, IOException
				{
					test = extent.createTest("Search_with_Specility_API");
					RestAssured.baseURI = readXpath("eua-hspa","HSPA_Base_URI","uhi");
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
					context.put("consumer_uri", "http://uhieuasandbox.abdm.gov.in/api/v1/euaService");
					context.put("message_id", "e9");
					context.put("timestamp", "2022-07-05T15:24:35");
					context.put("provider_id", "hspa-nha");
					context.put("provider_uri", "http://hspasbx.abdm.gov.in/api/v1");
					context.put("transaction_id", "e9a19230-f951-11ec-b135-53aea776f66b");
					
					mainObj.put("context", context);
					
					// create message object
					val message = new LinkedHashMap<String, Object>();
					
					// create intent object
					val intent = new LinkedHashMap<String, Object>();
					
					// create category object
					
					// create fulfillment object
					val fulfillment = new LinkedHashMap<String, Object>();
					
					// insert type in fulfillment object
					fulfillment.put("type", "Physical");
					
					// create start and end objects
					val start = new LinkedHashMap<String, Object>();
					val startTime = new LinkedHashMap<String, Object>();
					
					startTime.put("timestamp", "2022-07-15T00:00:00");
					start.put("time", startTime);

					fulfillment.put("start", start);

					val end = new LinkedHashMap<String, Object>();
					val endTime = new LinkedHashMap<String, Object>();
					endTime.put("timestamp", "2022-07-16T00:00:00");
					end.put("time", endTime);
					
					fulfillment.put("end", end);
					
					// create item object
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
					httpRequest.header("X-Gateway-Authorization", "dummy");
					Response response = httpRequest.body(mainObj).post(readXpath("eua-hspa","HSPA_End_Point","uhi"));
					
					response.prettyPrint();
					
					String jsonResponse = response.getBody().asString();
			        String status = JsonPath.from(jsonResponse).get("message.ack.status");
			        System.out.println("Status is : " + status);
					
			        softAssert.assertEquals(status, "ACK");
			        softAssert.assertEquals(response.statusCode(), 200);
			        System.out.println(response.statusLine());
			        //softAssert.assertEquals(response.statusLine(), "HTTP/1.1 200");
					softAssert.assertAll();
					
				}
				// remove fulfillment object
				@Test(priority = 7, enabled = true)
				@Severity(SeverityLevel.NORMAL)
				@Description("Search with Specility API r" ) 
				@Story("Search_with_Specility_API")
				public void Search_Specility_Api_remove_fulfillment_object() throws EncryptedDocumentException, IOException
				{
					test = extent.createTest("Search_with_Specility_API");
					RestAssured.baseURI = readXpath("eua-hspa","HSPA_Base_URI","uhi");
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
					context.put("consumer_uri", "http://uhieuasandbox.abdm.gov.in/api/v1/euaService");
					context.put("message_id", "e9");
					context.put("timestamp", "2022-07-05T15:24:35");
					context.put("provider_id", "hspa-nha");
					context.put("provider_uri", "http://hspasbx.abdm.gov.in/api/v1");
					context.put("transaction_id", "e9a19230-f951-11ec-b135-53aea776f66b");
					
					mainObj.put("context", context);
					
					// create message object
					val message = new LinkedHashMap<String, Object>();
					
					// create intent object
					val intent = new LinkedHashMap<String, Object>();
					
					// create category object
					val category = new LinkedHashMap<String, Object>();
					//create descriptor object inside category object
					val descriptor = new LinkedHashMap<String, Object>();
					descriptor.put("code", "Cardiology");
					descriptor.put("name", "CARDIOLOGY");
					
					//Put object in category
					category.put("descriptor", descriptor);
					
					//put category in intent object
					intent.put("category", category);
					
					// create fulfillment object
					/*Map<String, Object> fulfillment = new LinkedHashMap<String, Object>();
					
					// insert type in fulfillment object
					fulfillment.put("type", "Physical");
					
					// create start and end objects
					Map<String, Object> start = new LinkedHashMap<String, Object>();
					Map<String, Object> startTime = new LinkedHashMap<String, Object>();
					
					startTime.put("timestamp", "2022-07-15T00:00:00");
					start.put("time", startTime);

					fulfillment.put("start", start);
					
					Map<String, Object> end = new LinkedHashMap<String, Object>();
					Map<String, Object> endTime = new LinkedHashMap<String, Object>();
					endTime.put("timestamp", "2022-07-16T00:00:00");
					end.put("time", endTime);
					
					fulfillment.put("end", end);
					
					// create item object
					Map<String, Object> item = new LinkedHashMap<String, Object>();
					Map<String, Object> descriptor1 = new LinkedHashMap<String, Object>();
					descriptor1.put("code", "Consultation");
					descriptor1.put("name", "Consultation");
					item.put("descriptor", descriptor1);
					
					fulfillment.put("item", item);
					
					intent.put("fulfillment", fulfillment);*/
					
					message.put("intent", intent);
					
					mainObj.put("message", message);
					System.out.println(mainObj);
					
					//------------------------------------------------------------------------------------//
					
					httpRequest.header("Content-Type", "application/json");
					httpRequest.header("X-Gateway-Authorization", "dummy");
					Response response = httpRequest.body(mainObj).post(readXpath("eua-hspa","HSPA_End_Point","uhi"));
					
					response.prettyPrint();
					
					String jsonResponse = response.getBody().asString();
			        String status = JsonPath.from(jsonResponse).get("message.ack.status");
			        System.out.println("Status is : " + status);
					
			        softAssert.assertEquals(status, "NACK");
			        softAssert.assertEquals(response.statusCode(), 400);
			        System.out.println(response.statusLine());
			        //softAssert.assertEquals(response.statusLine(), "HTTP/1.1 200");
					softAssert.assertAll();
					
				}
				// remove message object
				@Test(priority = 8, enabled = true)
				@Severity(SeverityLevel.NORMAL)
				@Description("Search with Specility API removing Message object") 
				@Story("Search_with_Specility_API")
				public void Search_Specility_Api_remove_message_object() throws EncryptedDocumentException, IOException
				{
					test = extent.createTest("Search_with_Specility_API");
					RestAssured.baseURI = readXpath("eua-hspa","HSPA_Base_URI","uhi");
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
					context.put("consumer_uri", "http://uhieuasandbox.abdm.gov.in/api/v1/euaService");
					context.put("message_id", "e9");
					context.put("timestamp", "2022-07-05T15:24:35");
					context.put("provider_id", "hspa-nha");
					context.put("provider_uri", "http://hspasbx.abdm.gov.in/api/v1");
					context.put("transaction_id", "e9a19230-f951-11ec-b135-53aea776f66b");
					
					mainObj.put("context", context);
					
					System.out.println(mainObj);
					
					//------------------------------------------------------------------------------------//
					
					httpRequest.header("Content-Type", "application/json");
					httpRequest.header("X-Gateway-Authorization", "dummy");
					Response response = httpRequest.body(mainObj).post(readXpath("eua-hspa","HSPA_End_Point","uhi"));
					
					response.prettyPrint();
					
					String jsonResponse = response.getBody().asString();
			        String status = JsonPath.from(jsonResponse).get("message.ack.status");
			        System.out.println("Status is : " + status);
					
			        softAssert.assertEquals(status, "ACK");
			        softAssert.assertEquals(response.statusCode(), 200);
			        System.out.println(response.statusLine());
			        //softAssert.assertEquals(response.statusLine(), "HTTP/1.1 200");
					softAssert.assertAll();
					
				}
				
}

