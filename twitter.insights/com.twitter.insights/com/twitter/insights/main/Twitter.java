package com.twitter.insights.main;

import com.twitter.insights.api.TwitterAuthentication;

import twitter4j.TwitterException;

public class Twitter {

	public static void main(String[] args) throws TwitterException {

		TwitterAuthentication.authenticate();
	}

}
