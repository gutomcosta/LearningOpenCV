package learning.opencv.chapter1;

import static com.googlecode.javacv.cpp.opencv_highgui.cvLoadImageM;
import learning.opencv.utils.Graphical;
import learning.opencv.utils.Tools;

import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.IplImage;


public class ColorReduction {
	
	public static void main(String[] args) {
		CvMat image = cvLoadImageM("example.jpg");
		CvMat reduced = reduceColor(image,40);
		IplImage imageWithColorReduced = Tools.matToIpImage(reduced);
		Graphical.showSimpleImage(imageWithColorReduced);
	}

	private static CvMat reduceColor(CvMat image, int colorReductionValue){
		int numberOfElements = image.rows() * image.cols() * image.channels();
		for (int i = 0; i < numberOfElements; i++) {
			//get a value of a pixel - this value is the color range 0 to 255
			int colorCode 	 = (int) image.get(i);
			int newColorCode = reduce(colorCode, colorReductionValue);
			image.put(i,newColorCode);
		}
		return image;
		
	}
	
	private static int reduce(int colorCode, int colorReductionValue){
		return ((colorCode / colorReductionValue) * colorReductionValue) + (colorReductionValue / 2);
	}
}
