package learning.opencv.chapter1;

import learning.opencv.utils.Graphical;

import com.googlecode.javacv.cpp.opencv_core.CvMat;
import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;

public class LinearFilter {

	public static void main(String[] args) {
		IplImage image = cvLoadImage("example.jpg", CV_LOAD_IMAGE_COLOR);
		Graphical.showSimpleImage( applyFilter(image) );
		
	}
	
	private static IplImage applyFilter(IplImage image){
		IplImage imageWithFilter = cvCreateImage(cvGetSize(image), image.depth(), 3);
		//we need to define a construct to sharpening, all unassigned values are 0
		CvMat kernel = CvMat.create(3,3, CV_32F);
		kernel.put(1,1,5);
		kernel.put(0,1,-1);
		kernel.put(2,1,-1);
		kernel.put(1,0,-1);
		kernel.put(1,2,-1);
		
		filter2D(image,imageWithFilter, -1, kernel,new CvPoint(-1,1),0, BORDER_DEFAULT);
		
		return imageWithFilter;
	}
}
