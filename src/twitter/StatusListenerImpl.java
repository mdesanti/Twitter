package twitter;

import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

public class StatusListenerImpl implements StatusListener{

	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub
	}

	public void onException(Exception e) {
//		e.printStackTrace();
	}

	public void onStatus(Status status) {
		System.out.println("-----------------");
		System.out.println(status.getText());
	}

	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}
	
	

}
