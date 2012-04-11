package learning.opencv.chapter3;

import static com.googlecode.javacv.cpp.opencv_highgui.CV_LOAD_IMAGE_COLOR;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import learning.opencv.utils.Graphical;

import com.googlecode.javacv.cpp.opencv_core.IplImage;

public class ColorDetector {

	public static void main(String[] args) {
		
		IplImage image = cvLoadImage("example.jpg", CV_LOAD_IMAGE_COLOR);
//		Graphical.showSimpleImage( detectColor(image) );

	}
	
	
	
}
