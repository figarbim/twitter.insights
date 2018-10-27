package com.twitter.insights.cloudant;

import java.util.List;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.twitter.insights.main.TwitterConstants;
import com.twitter.insights.objects.TwitterObject;

public class InsertTweets {
	
	public static void insert(List<TwitterObject> twitterObjList, CloudantClient client) {

		try {
			Database db = client.database(TwitterConstants.CLOUDANT_DB, false);
			
			db.bulk(twitterObjList);
			
			System.out.println("\nTweets inseridos na base com sucesso!");
		} catch (Exception e) {
			System.err.println(e);
		}
		
		//TwitterObject tob = db.find(TwitterObject.class, "93e302399e854936ae31522810fdff26");
		//System.out.println(tob);

	}

}
