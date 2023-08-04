package selenium.in.gov.abdm.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import selenium.in.gov.abdm.baseclassfile.SeleniumBaseClass;

import java.io.IOException;

public class FetchOTP extends SeleniumBaseClass {

    public String getOtp() throws IOException {
        RestAssured.baseURI=readXpath("config","ABHA_Base_URI","abha");
        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("apikey", readXpath("config", "Api_Key", "abha"));
        httpRequest.header("Content-Type", "application/json");

        Response response = httpRequest.get(readXpath("config","ABHA_EndPoint1","abha"));
        //    response.prettyPrint();

        String jsonResponse = response.getBody().asString();
        String[] otps = jsonResponse.split("otp\":\"(.*?)");

        ObjectMapper objectMapper = new ObjectMapper();
        OTPRes[] root = objectMapper.readValue(jsonResponse, OTPRes[].class);
        // String otp = JsonPath.from(jsonResponse)..get();
        // System.out.println("OTP is ------------------------------> " +otp);
        String otp1 = root[0].otp;
        System.out.println("OTP is ------------------------------> " +otp1);

        return otp1;

    }
}
class OTPRes{
    public int id;
    public String origin;
    public String notificationType;
    public String contentType;
    public String sender;
    public String receiver;
    public String notification;
    public String createdAt;
    public String otp;
}
