package learning.opencv.chapter1;


import static com.googlecode.javacv.cpp.opencv_core.cvAddWeighted;
import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSize;
import static com.googlecode.javacv.cpp.opencv_highgui.CV_LOAD_IMAGE_COLOR;
import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImage;
import learning.opencv.utils.Graphical;

import com.googlecode.javacv.cpp.opencv_core.IplImage;

public class BlendingImages {

	public static void main(String[] args) {
		IplImage scenery = cvLoadImage("example.jpg", CV_LOAD_IMAGE_COLOR);
		IplImage rain	 = cvLoadImage("rain.jpg", CV_LOAD_IMAGE_COLOR);
		
		IplImage combinedImage = cvCreateImage(cvGetSize(scenery), scenery.depth(),3);
		cvAddWeighted(scenery,0.7, rain, 0.9,0.0, combinedImage);
		
		Graphical.showSimpleImage(combinedImage);
		
	}
	
}
