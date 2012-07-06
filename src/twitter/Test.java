package twitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import twitter.connectionManager.api.ConnectionManager;
import twitter.connectionManager.impl.ConnectionManagerImpl;
import twitter4j.FilterQuery;
import twitter4j.StatusListener;
import twitter4j.StatusStream;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;

public class Test {

	private static int ArgentinaWEOID = 23424747;
	
	public static void main(String[] args) throws TwitterException, IOException {

		ConnectionManager cm = new ConnectionManagerImpl("twitter4j.properties");
		StatusListener sl = new StatusListenerImpl();
		Twitter twitter = cm.getTwitterConnection();
		Trends trends = twitter.getLocationTrends(ArgentinaWEOID);
		List<String> track = new ArrayList<String>();
		for(Trend trend: trends.getTrends()) {
			track.add(trend.getName());
		}
		TwitterStream ts = cm.getTwitterStreamConnection();
		FilterQuery fq = new FilterQuery();
		fq.track((String[])track.toArray());
		StatusStream ss = ts.getFilterStream(fq);
		while(true) {
			try {
			ss.next(sl);
			} catch (TwitterException e) {
				
			}
		}
	}
}
