package learning.opencv.chapter1;

import java.util.Random;

import learning.opencv.utils.Graphical;
import learning.opencv.utils.Tools;

import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import static com.googlecode.javacv.cpp.opencv_highgui.*;


public class PixelManipulation {

	public static void main(String[] args) {
		CvMat image = cvLoadImageM("example.jpg");
		addSalt(image, 1000);
		IplImage converted = Tools.matToIpImage(image);
		Graphical.showSimpleImage(converted);
	}
	
	private static void addSalt(CvMat image, int n){
		int size = image.rows() * image.cols();
		int numberOfChannels = image.channels();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			int index = random.nextInt(size);
			int offset = index * numberOfChannels;
			for (int j = 0; j < numberOfChannels; j++) {
				image.put(offset + i, 255);
			}
			
		}
	}
}
