package com.bluetag.api.register.service;

import java.io.IOException;

import javax.xml.bind.DatatypeConverter;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class QueryService {
	private String failJson = "{\"result\": \"something has gone horribly wrong. Please try again\"}";
	private String authHeaderKey = "Authorization";
	private String toConvert = "ce70b172-450a-4bb0-a7b0-1c57c500f8f7-bluemix:c2858c25dda5de8d0679be0fa50e7801046ac74de2fa80dda1cb5cb585150328";
	private String authHeaderValue = "Basic "
			+ DatatypeConverter.printBase64Binary(toConvert.getBytes());
	private String acceptHeaderKey = "Accept";
	private String acceptHeaderValue = "application/json";
	private String contentHeaderKey = "Content-Type";
	private String contentHeaderValue = "application/json";
	private String cloudantURI = "https://ce70b172-450a-4bb0-a7b0-1c57c500f8f7-bluemix:c2858c25dda5de8d0679be0fa50e7801046ac74de2fa80dda1cb5cb585150328@ce70b172-450a-4bb0-a7b0-1c57c500f8f7-bluemix.cloudant.com";
	
	public String getUserInfo(String username){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet queryInfoGet = new HttpGet(cloudantURI + "/info/" + username);
		queryInfoGet.addHeader(authHeaderKey, authHeaderValue);
		queryInfoGet.addHeader(acceptHeaderKey, acceptHeaderValue);
		queryInfoGet.addHeader(contentHeaderKey, contentHeaderValue);
		
		try {
			HttpResponse queryInfoResp = httpclient.execute(queryInfoGet); 
			String info = EntityUtils.toString(queryInfoResp.getEntity());
			httpclient.close();
			return info;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				httpclient.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return failJson;
		} 
	}
	
	public String getTagged(String username){
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet getTaggedGet = new HttpGet(cloudantURI + "/tag/" + username);
		getTaggedGet.addHeader(authHeaderKey, authHeaderValue);
		getTaggedGet.addHeader(acceptHeaderKey, acceptHeaderValue);
		getTaggedGet.addHeader(contentHeaderKey, contentHeaderValue);
		
		try {
			HttpResponse getTaggedResp = httpclient.execute(getTaggedGet); 
			String tagged = EntityUtils.toString(getTaggedResp.getEntity());
			httpclient.close();
			return tagged;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				httpclient.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return failJson;
		} 
	}
}
