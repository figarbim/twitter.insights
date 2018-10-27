package com.twitter.insights.main;

import java.util.List;

import com.cloudant.client.api.CloudantClient;
import com.twitter.insights.api.SearchTweets;
import com.twitter.insights.api.TwitterAuthentication;
import com.twitter.insights.cloudant.CloudantConnection;
import com.twitter.insights.cloudant.InsertTweets;
import com.twitter.insights.objects.TwitterObject;
import com.twitter.util.Util;

import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterMain {

	public static void main(String[] args) throws TwitterException {

		try {
			
			CloudantClient client = CloudantConnection.connect();
			Twitter twitter = TwitterAuthentication.authenticate();
			
			List<String> hashtagsList = Util.getServicesFromFile(TwitterConstants.HASHTAGS_FILE);
			
			//iterate over all hashtags 
			for (int i = 0; i < hashtagsList.size(); i++) {
				List<TwitterObject> twitterObjList = SearchTweets.search(hashtagsList.get(i), twitter);
				InsertTweets.insert(twitterObjList, client);
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}

}
