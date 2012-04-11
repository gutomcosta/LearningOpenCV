package learning.opencv.misc;

public class TestGrabber {

	public static void main(String[] args) {
		GrabberShow gs = new GrabberShow();
		Thread t = new Thread(gs);
		t.start();
	}
	
}
