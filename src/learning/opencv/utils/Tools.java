package learning.opencv.utils;

import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage;
import static com.googlecode.javacv.cpp.opencv_core.cvGetImage;

import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

public class Tools {

	public static IplImage matToIpImage(CvMat image){
		IplImage new_image = cvCreateImage(image.cvSize(), image.elemSize(), 1);
		cvGetImage(image, new_image);
		return new_image;
	}
	
}
