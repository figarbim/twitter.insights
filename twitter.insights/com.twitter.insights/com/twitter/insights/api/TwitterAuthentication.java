package com.twitter.insights.api;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAuthentication {
	
	private static final String CONSUMER_KEY = "jzaTMozGzTiZc2EpddJzNdjxS";
	private static final String CONSUMER_SECRET = "Zagl6r9hSDIunk9S0BaZ5JKwWGJw1R8VjVdwtjY9jZLqLnhkTl";
	private static final String ACCESS_TOKEN = "1055199910277070850-JNYAP47jrT7tSl9GfF6eXpqrdUsLwQ";
	private static final String ACCESS_TOKEN_SECRET = "8Hszz7YjKDciYUavdlILuozmdSykexpSK265a2ner1gbw";
	
	public static void authenticate() throws TwitterException {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(CONSUMER_KEY)
							    .setOAuthConsumerSecret(CONSUMER_SECRET)
							    .setOAuthAccessToken(ACCESS_TOKEN)
							    .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		
		System.out.println("oi");
		
		try {
			Query query = new Query("#api");
		    QueryResult result = twitter.search(query);
		    List<Status> tweets = result.getTweets();
	        for (Status tweet : tweets) {
	            System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
	        }
	        
	        System.exit(0);
		} catch (TwitterException te) {
			te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
		}
		
	}

}
