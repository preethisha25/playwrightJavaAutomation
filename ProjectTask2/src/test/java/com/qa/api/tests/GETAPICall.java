
package com.qa.api.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

public class GETAPICall {
	Playwright playwright;
	APIRequest request;
	APIRequestContext requestcontext;
	ArrayList <String> al= new ArrayList <>();
	@BeforeTest
	public void setup() {
		playwright=Playwright.create();
		request=playwright.request();
		requestcontext=request.newContext();
	}
	/*
	@Test
	public void getSpecificUser() throws IOException{
		APIResponse apiResponse=requestcontext.get("https://gorest.co.in/public/v2/users",
				RequestOptions.create()
				.setQueryParam("id", 5632441)
				.setQueryParam("status", "active")
				);
		int statusCode=apiResponse.status();
		String statusResText=apiResponse.statusText();
		ObjectMapper objMapper=new ObjectMapper();
		JsonNode jsonResponse = objMapper.readTree(apiResponse.body());
		String jsonPreetyResponse = jsonResponse.toPrettyString();
		Map <String,String> headersMap=apiResponse.headers();
		//https://animechan.xyz/api/random
		System.out.println("--------------------API Response code--------------------");
		System.out.println("API Response code: "+statusCode);
		System.out.println("API Response code.OK: "+apiResponse.ok());
		System.out.println("--------------------API Response Text--------------------");
		System.out.println("API Response Text: "+statusResText);
		System.out.println("--------------------API Response Body--------------------");
		System.out.println("API Response Body: "+jsonPreetyResponse);
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(apiResponse.ok(), true);
		Assert.assertEquals(statusResText, "OK");
	}*/
	@Test
	public void getUsersAPITest() throws IOException {
		for(int i=0;i<5;i++) {
	APIResponse apiResponse=requestcontext.get("https://dog.ceo/api/breeds/image/random");
	int statusCode=apiResponse.status();
	String statusResText=apiResponse.statusText();
	ObjectMapper objMapper=new ObjectMapper();
	JsonNode jsonResponse = objMapper.readTree(apiResponse.body());
	String jsonPreetyResponse = jsonResponse.toPrettyString();
	Map <String,String> headersMap=apiResponse.headers();
	System.out.println("--------------------API Response code--------------------");
	System.out.println("API Response code: "+statusCode);
	System.out.println("API Response code.OK: "+apiResponse.ok());
	System.out.println("--------------------API Response Text--------------------");
	System.out.println("API Response Text: "+statusResText);
	System.out.println("--------------------API Response Body--------------------");
	System.out.println("API Response Body: "+jsonPreetyResponse);
	/*System.out.println("--------------------API Response URL--------------------");
	System.out.println("API Response URL: "+apiResponse.url());
	System.out.println("--------------------API Response Header--------------------");
	System.out.println("API Response Header Map: "+headersMap);
	System.out.println("--------------------API Response Text--------------------");
	System.out.println("API Response Text Method: "+apiResponse.text());*/
	Assert.assertEquals(statusCode, 200);
	Assert.assertEquals(apiResponse.ok(), true);
	Assert.assertEquals(statusResText, "OK");
	//Assert.assertEquals(apiResponse.text(), "close");
	//Assert.assertEquals(headersMap.get("x-powered-by"), "PHP/8.1.0");
	al.add(apiResponse.text());
		}
	for(int i=0;i<al.size();i++) {
		for(int j=i+1;j<al.size();j++) {
	        if(!al.get(i).equals(al.get(j)))
			{
		    	 
		     }
	        else {
	        	System.out.println("NOT UNIQUE IMAGE");
	        	break;
	        }
		}
		System.out.println("# "+i+" is UNIQUE Image link: "+al.get(i));
	}
	}
	@AfterTest
	public void teardown() {
		playwright.close();
	}

}

