package learning.opencv.misc;

import static com.googlecode.javacv.cpp.opencv_core.cvCreateImage;
import static com.googlecode.javacv.cpp.opencv_core.cvGetSize;
import static com.googlecode.javacv.cpp.opencv_core.cvInRangeS;
import static com.googlecode.javacv.cpp.opencv_core.cvReleaseImage;
import static com.googlecode.javacv.cpp.opencv_core.cvScalar;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_BGR2HSV;
import static com.googlecode.javacv.cpp.opencv_imgproc.CV_MEDIAN;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvCvtColor;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvSmooth;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvGetSpatialMoment;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvGetCentralMoment;
import static com.googlecode.javacv.cpp.opencv_imgproc.cvMoments;

import java.awt.Dimension;

import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_imgproc.CvMoments;;


public class DetectElement {

	private static int hueLowerR = 160;
	private static int hueUpperR = 180;

	
	public IplImage hsvThreshold(IplImage orgImg) {
		// 8-bit, 3- color =(RGB)
        IplImage imgHSV = cvCreateImage(cvGetSize(orgImg), 8, 3);
        cvCvtColor(orgImg, imgHSV, CV_BGR2HSV);
        // 8-bit 1- color = monochrome
        IplImage imgThreshold = cvCreateImage(cvGetSize(orgImg), 8, 1);
        // cvScalar : ( H , S , V, A)
        cvInRangeS(imgHSV, cvScalar(hueLowerR, 100, 100, 0), cvScalar(hueUpperR, 255, 255, 0), imgThreshold);
        cvReleaseImage(imgHSV);
        cvSmooth(imgThreshold, imgThreshold, CV_MEDIAN, 13);
        // save
        return imgThreshold;
	}
	
	public Dimension getCoordinates(IplImage image){
		int x = 0;
		int y = 0;
		CvMoments moments = new CvMoments();
		cvMoments(image,moments,1);
		double momentX = cvGetSpatialMoment(moments, 1, 0);
		double momentY = cvGetSpatialMoment(moments, 0, 1);
		double area    = cvGetCentralMoment(moments, 0, 0);
		x = (int) (momentX / area);
		y = (int) (momentY / area);
		
		return new Dimension(x,y);
		
	}


}
