package com.twitter.insights.cloudant;

import java.util.List;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.twitter.insights.objects.TwitterObject;

public class InsertTweets {
	
	private static String CLOUDANT_DB = "db_twitter";
	
	public static void insert(List<TwitterObject> twitterObjList, CloudantClient client) {
		
//		List<String> databases = client.getAllDbs();
//		System.out.println("\nAll my databases : ");
//		for ( String db : databases ) {
//			System.out.println(db);
//		}
		try {
			Database db = client.database(CLOUDANT_DB, false);
			
			db.bulk(twitterObjList);
			
			System.out.println("\nTweets inseridos na base com sucesso!");
		} catch (Exception e) {
			System.err.println(e);
		}
		
		//TwitterObject tob = db.find(TwitterObject.class, "93e302399e854936ae31522810fdff26");
		//System.out.println(tob);

	}

}
