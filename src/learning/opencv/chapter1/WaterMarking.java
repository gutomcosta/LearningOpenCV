package learning.opencv.chapter1;


import learning.opencv.utils.Graphical;

import com.googlecode.javacv.cpp.opencv_core.CvMat;
import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;

public class WaterMarking {

	public static void main(String[] args) {
		IplImage logo = cvLoadImage("logo.png", CV_LOAD_IMAGE_COLOR);
		IplImage mask = cvLoadImage("logo.png", CV_LOAD_IMAGE_GRAYSCALE);
		IplImage image = cvLoadImage("example.jpg", CV_LOAD_IMAGE_COLOR);

//		IplROI roi = new IplROI();
//		roi.xOffset(385);
//		roi.yOffset(270);
//		roi.width(logo.width());
//		roi.height(logo.height());
		
		cvSetImageROI(image, cvRect(385, 270, logo.width(), logo.height())); 
		cvCopy(logo,image,mask);
		// i don't know why the entire image is not displayed :(
		Graphical.showSimpleImage(image);
		
		
	}
}
