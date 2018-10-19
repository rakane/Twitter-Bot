package com.github.rakane;

import java.io.IOException;
import twitter4j.FilterQuery;
import twitter4j.IDs;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;


public class App {

	public static void main(String[] args) throws TwitterException, IOException {
		Twitter twitter = getTwitterInstance();

			//defines status listener
	    StatusListener feed = new StatusListener(){
	        public void onStatus(Status status) {
	        	long tweetid = status.getId();
	        	if(status.getUser().getId() == 624413 || status.getUser().getId() == 28140646 || status.getUser().getId() == 40533912 ||
	        	status.getUser().getId() == 15568127) {
	        		try {
						twitter.retweetStatus(tweetid);
					} catch (TwitterException e) {
						System.out.print("Unable to retweet: ");
						e.printStackTrace();
					}
					System.out.println(status.getUser().getName() + " : " + status.getText());
	        	}

	        }
	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
	        public void onException(Exception ex) {
	           ex.printStackTrace();
	        }
			    public void onScrubGeo(long userId, long upToStatusId) {}
			    public void onStallWarning(StallWarning warning) {}
	    };

			//creates query to get tweets only from the four accounts
	    FilterQuery query = new FilterQuery();
	    query.follow(new long [] {624413, 28140646, 40533912, 15568127});
	    query.language("en");

			//adds listener for TwitterStream and filters based on query
	    TwitterStream twitterFeed = getTwitterStreamInstance();
	    twitterFeed.addListener(feed);
	    twitterFeed.filter(query);
	}

	/**
	*  creates twitter instance using ConfigurationBuilder and user OAuth token and key
	*  @return Twitter instance for user account
	**/
	public static Twitter getTwitterInstance() {
    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("***")
    	  .setOAuthConsumerSecret("***")
		    .setOAuthAccessToken("***")
	      .setOAuthAccessTokenSecret("***");

    TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		return twitter;
  }

	/**
	*  creates TwitterStream instance using ConfigurationBuilder and user OAuth token and key
	*  @return TwitterStream instance for user account
	**/
  public static TwitterStream getTwitterStreamInstance() {
    ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("***")
				.setOAuthConsumerSecret("***")
				.setOAuthAccessToken("***")
				.setOAuthAccessTokenSecret("***");

    TwitterStreamFactory tf = new TwitterStreamFactory(cb.build());
    TwitterStream twitter = tf.getInstance();
    return twitter;
  }
}
