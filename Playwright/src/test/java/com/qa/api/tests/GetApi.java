package com.qa.api.tests;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

public class GetApi {

	@Test
	public void getUserApiTest() throws IOException {
		
		Playwright playwright = Playwright.create();
		APIRequest request = playwright.request();// https request established
		APIRequestContext requestContext = request.newContext();//similar to browser context
		
		
		List<String> seenImages = new ArrayList<>();
		for(int i =0; i<4; i++) {
		
		APIResponse apiResponse = requestContext.get("https://dog.ceo/api/breed/hound/images/random");
		int StatusCode = apiResponse.status();
		System.out.println("response Status code : " + StatusCode);
		 Assert.assertEquals(StatusCode, 200);
		
		ObjectMapper objMapper = new ObjectMapper();
        JsonNode jsonResponse = objMapper.readTree(apiResponse.body());
       String imageurl =  jsonResponse.toPrettyString();
       System.out.println("Json response is"+ imageurl); 
       
       
       //Do not check for duplicates in the first three requests
       if(i==3) {
       if(seenImages.contains(imageurl)) {
    	   fail("Duplicate image found" + imageurl);
    	   }
       else {
    	   
       seenImages.add(imageurl);
       System.out.print("Duplicate Images not Found  " );
       
    	   
       }
	}
	
	
	
	}
	}
}


