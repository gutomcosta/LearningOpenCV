package learning.opencv.misc;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.omg.CORBA.INTERNAL;

import static com.googlecode.javacv.cpp.opencv_core.CV_AA;
import static com.googlecode.javacv.cpp.opencv_core.cvFlip;
import static com.googlecode.javacv.cpp.opencv_core.cvPoint;
import static com.googlecode.javacv.cpp.opencv_core.cvRectangle;
import static com.googlecode.javacv.cpp.opencv_highgui.CV_LOAD_IMAGE_COLOR;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import static com.googlecode.javacv.cpp.opencv_highgui.cvSaveImage;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.VideoInputFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

public class GrabberShow implements Runnable{

	//private final int INTERVAL = 1000; 
	private IplImage image;
	private CanvasFrame canvas = new CanvasFrame("Web Cam");
	//private CanvasFrame detect = new CanvasFrame("Detectings");
	
	public GrabberShow(){
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void run() {
		FrameGrabber grabber = new OpenCVFrameGrabber(0); 
		DetectElement detector = new DetectElement();
		int i = 0;
		try {
			grabber.start();
			IplImage img;
			while(true){
				img = grabber.grab();
				if (img != null){
					cvFlip(img, img, 1); // 1-r = 90 degrees steps anti clockwise
					IplImage detectedImg = detector.hsvThreshold(img);
					Dimension coordinates = detector.getCoordinates(detectedImg);
					System.out.println("Coordinates: "+coordinates.width+" - "+coordinates.height);
					if (coordinates.width > 0 ){
						cvRectangle(img, 
					    		cvPoint(coordinates.width, coordinates.height),
					    		cvPoint(coordinates.width+30, coordinates.height+30), 
					    	          opencv_core.CvScalar.YELLOW, 1, CV_AA, 0);
					}

					canvas.showImage(img);
					//detect.showImage(detectedImg);
					
					
				}
				//Thread.sleep(INTERVAL);
			}
			
		} catch (Exception e) {
		}
		
	}

}
