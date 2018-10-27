package com.twitter.insights.objects;

import java.util.Date;

public class TwitterObject {
	private String user;
	private String tweet;
	private String language;
	private String location;
	private String hashtag;
	private Date creationDate;
	private int followersCount;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date date) {
		this.creationDate = date;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int i) {
		this.followersCount = i;
	}



}
