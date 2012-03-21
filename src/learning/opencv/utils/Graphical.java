package learning.opencv.utils;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

public class Graphical {

	public static void showSimpleImage(IplImage image){
		CanvasFrame frame = new CanvasFrame("imagem");
		frame.showImage(image);
	}
}
