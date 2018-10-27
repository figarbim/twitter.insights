package com.twitter.insights.cloudant;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.twitter.insights.main.TwitterConstants;

public class CloudantConnection {

	public static CloudantClient connect() {

		System.err.println("=== [CLOUDANT] CONNECTING...");
		CloudantClient client = ClientBuilder.account(TwitterConstants.CLOUDANT_ACCOUNT).
				username(TwitterConstants.CLOUDANT_USERNAME).
				password(TwitterConstants.CLOUDANT_PASSWORD).build();
		System.err.println("=== [CLOUDANT] CONNECTED\n");

		return client;
		
	}

}
