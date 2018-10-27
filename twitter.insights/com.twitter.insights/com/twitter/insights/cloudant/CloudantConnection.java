package com.twitter.insights.cloudant;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;

public class CloudantConnection {

	private static final String CLOUDANT_ACCOUNT = "e5b19eb3-3191-4b62-bdac-1e369b673d07-bluemix";
	private static final String CLOUDANT_USERNAME = "e5b19eb3-3191-4b62-bdac-1e369b673d07-bluemix";
	private static final String CLOUDANT_PASSWORD = "394e2b5b04863b5adee5198d21a10eefb9c6d6a4c35e8ae79d0a90f29e1a3c7d";

	public static CloudantClient connect() {

		System.err.println("=== [CLOUDANT] CONNECTING...");
		CloudantClient client = ClientBuilder.account(CLOUDANT_ACCOUNT).username(CLOUDANT_USERNAME).password(CLOUDANT_PASSWORD).build();
		System.err.println("=== [CLOUDANT] CONNECTED\n");

		return client;
		
	}

}
