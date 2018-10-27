package com.twitter.insights.api;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAuthentication {
	
	private static final String CONSUMER_KEY = "jzaTMozGzTiZc2EpddJzNdjxS";
	private static final String CONSUMER_SECRET = "Zagl6r9hSDIunk9S0BaZ5JKwWGJw1R8VjVdwtjY9jZLqLnhkTl";
	private static final String ACCESS_TOKEN = "1055199910277070850-JNYAP47jrT7tSl9GfF6eXpqrdUsLwQ";
	private static final String ACCESS_TOKEN_SECRET = "8Hszz7YjKDciYUavdlILuozmdSykexpSK265a2ner1gbw";
	
	public static Twitter authenticate() throws TwitterException {
		System.err.println("=== [TWITTER] CONNECTING...");
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(CONSUMER_KEY)
							    .setOAuthConsumerSecret(CONSUMER_SECRET)
							    .setOAuthAccessToken(ACCESS_TOKEN)
							    .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		
		System.err.println("=== [TWITTER] CONNECTED\n");
		
		return twitter;
	}

}
