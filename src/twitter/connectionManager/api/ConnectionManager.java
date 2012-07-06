package twitter.connectionManager.api;

import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterStream;

public interface ConnectionManager {

	public Twitter getTwitterConnection();
	
	public TwitterStream getTwitterStreamConnection(StatusListener listener);
	
	public TwitterStream getTwitterStreamConnection();
}
