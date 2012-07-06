package twitter;

import java.io.IOException;

import twitter4j.FilterQuery;
import twitter4j.StatusListener;
import twitter4j.StatusStream;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;

public class Test {

	public static void main(String[] args) throws TwitterException, IOException {

		ConnectionManager cm = new ConnectionManager("settings.properties");
//		Twitter twitter = cm.getTwitterConnection();
//		Query q = new Query("#OdioCuando");
//		QueryResult qr = twitter.search(q);
//		List<Tweet> tweets = qr.getTweets();
//
//		for (Tweet tweet : tweets) {
//			System.out.println(tweet.getText());
//		}
		
		StatusListener sl = new StatusListenerImpl();
		TwitterStream ts = cm.getTwitterStreamConnection(sl);
		String[] track = {"#OdioCuando"};
		FilterQuery fq = new FilterQuery();
		fq.track(track);
		StatusStream ss = ts.getFilterStream(fq);
		while(true) {
			try {
			ss.next(sl);
			} catch (TwitterException e) {
				
			}
		}
	}
}
