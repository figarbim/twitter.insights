package com.twitter.insights.api;

import java.util.ArrayList;
import java.util.List;

import com.twitter.insights.objects.TwitterObject;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class SearchTweets {
	
	public static List<TwitterObject> search(String hashtag, Twitter twitter) {
		
		List<TwitterObject> twitterObjList = new ArrayList<TwitterObject>();

		try {
			Query query = new Query(hashtag);
		    QueryResult result = twitter.search(query);
		    List<Status> tweets = result.getTweets();
		    
		    int index = 0;
	        for (Status tweet : tweets) {
	        	TwitterObject twitterObj = new TwitterObject();
	        	twitterObj.setHashtag(hashtag);
	        	twitterObj.setUser("@" + tweet.getUser().getScreenName());
	            twitterObj.setTweet(tweet.getText());
	            twitterObj.setLanguage(tweet.getUser().getLang());
	            twitterObj.setLocation(tweet.getUser().getLocation());
	            twitterObj.setCreationDate(tweet.getCreatedAt());
	            twitterObj.setFollowersCount(tweet.getUser().getFollowersCount());
	            twitterObjList.add(index, twitterObj);
	            index++;
	            
//	            System.out.println("+ Hashtag: " + hashtag);
//		        System.out.println("+ Usuário: " + twitterObj.getUser());
//		        System.out.println("+ Tweet: " + twitterObj.getTweet());
//		        System.out.println("+ Idioma: " + twitterObj.getLanguage());
//		        System.out.println("+ País: " + twitterObj.getLocation());
//		        System.out.println("+ Data de Postagem: " + twitterObj.getCreationDate());
//		        System.out.println("+ Número de Seguidores: " + twitterObj.getFollowersCount());
//		        System.out.println("\n");
	            
	        }
	        
		} catch (TwitterException te) {
			te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
		}
		
		return twitterObjList;
	}
}
