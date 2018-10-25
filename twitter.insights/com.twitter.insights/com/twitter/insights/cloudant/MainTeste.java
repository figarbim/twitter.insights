package com.twitter.insights.cloudant;

import java.util.List;

import com.cloudant.client.api.CloudantClient;

public class MainTeste {

	public static void main(String[] args) {
		
		CloudantClient client = CloudantConnection.connect();

		List<String> databases = client.getAllDbs();
		System.out.println("All my databases : ");
		for ( String db : databases ) {
			System.out.println(db);
		}

	}

}
