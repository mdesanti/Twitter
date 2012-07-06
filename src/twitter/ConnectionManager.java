package twitter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.ConfigurationBuilder;

public class ConnectionManager {

	private String consumerKey;
	private String consumerSecretKey;
	private String accessToken;
	private String secretAccessToken;
	private String propertiesFile;

	public ConnectionManager(String propertiesFile) {
		this.propertiesFile = propertiesFile;
	}

	public Twitter getTwitterConnection() throws TwitterException {
		loadSettings();
		Twitter twitter = new TwitterFactory().getInstance(getOAuthAuthorization());
		return twitter;
	}
	
	public TwitterStream getTwitterStreamConnection(StatusListener listener) {
		TwitterStream ts = getTwitterStreamConnection();
		ts.addListener(listener);
		return ts;
	}
	
	public TwitterStream getTwitterStreamConnection() {
		loadSettings();
		TwitterStream twitterStream = new TwitterStreamFactory().getInstance(getOAuthAuthorization());
		return twitterStream;
	}
	
	private OAuthAuthorization getOAuthAuthorization() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthAccessTokenSecret(secretAccessToken);
		cb.setOAuthAccessToken(accessToken);
		cb.setOAuthConsumerKey(consumerKey);
		cb.setOAuthConsumerSecret(consumerSecretKey);
		OAuthAuthorization oauth = new OAuthAuthorization(cb.build());
		return oauth;
	}

	private void loadSettings() {
		try {
			Properties twitterSettings = new Properties();
			System.out.println("Reading proxy.properties file...");
			FileInputStream in = new FileInputStream(propertiesFile);
			twitterSettings.load(in);
			in.close();
			accessToken = twitterSettings.getProperty("AccessToken");
			secretAccessToken = twitterSettings
					.getProperty("SecretAccessToken");
			consumerKey = twitterSettings.getProperty("ConsumerKey");
			consumerSecretKey = twitterSettings
					.getProperty("ConsumerSecretKey");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
