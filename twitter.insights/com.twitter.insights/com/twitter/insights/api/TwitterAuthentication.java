package com.twitter.insights.api;

import com.twitter.insights.main.TwitterConstants;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAuthentication {
	
	public static Twitter authenticate() throws TwitterException {
		System.err.println("=== [TWITTER] CONNECTING...");
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(TwitterConstants.CONSUMER_KEY)
							    .setOAuthConsumerSecret(TwitterConstants.CONSUMER_SECRET)
							    .setOAuthAccessToken(TwitterConstants.ACCESS_TOKEN)
							    .setOAuthAccessTokenSecret(TwitterConstants.ACCESS_TOKEN_SECRET);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		
		System.err.println("=== [TWITTER] CONNECTED\n");
		
		return twitter;
	}

}
