package bwf.demo_scroll_message_textview;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//屏幕适配class
public class MakeXml {
	private final static String rootPath = "E:\\Tencent\\767623796\\FileRecv\\Demo-Scroll-Message-TextView\\app\\src\\main\\res\\values-{0}x{1}\\";
    private final static float dw = 320f;
    private final static float dh = 480f;
	public static void main(String[] args) {
		makeString(320, 480);
        makeString(480,800);
        makeString(480, 854);
        makeString(540, 960);
        makeString(600, 1024);
        makeString(720, 1184);
        makeString(720, 1196);
        makeString(720, 1280);
        makeString(768, 1024);
        makeString(800, 1280);
        makeString(1080, 1812);
        makeString(1080, 1920);
        makeString(1440, 2560);
		
	}

	private static void makeString(int w, int h) {
		File parentFile = new File(handlString(rootPath, h,w));
		parentFile.mkdirs();
		File layxFile = new File(parentFile, "lay_x.xml");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(layxFile));
			float cellW = w/dw;
			bw.write("<resources>");
			bw.newLine();
			for (int i = 1; i <= 320; i++) {
				bw.write("<dimen name=\"x"+i+"\">"+handleFloatNum(i*cellW)+"px</dimen>");
				bw.newLine();
			}
			bw.write("</resources>");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File layyFile = new File(parentFile, "lay_y.xml");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(layyFile));
			float cellH = h/dh;
			bw.write("<resources>");
			bw.newLine();
			for (int i = 1; i <= 480; i++) {
				bw.write("<dimen name=\"y"+i+"\">"+handleFloatNum(i*cellH)+"px</dimen>");
				bw.newLine();
			}
			bw.write("</resources>");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static float handleFloatNum(float x){
		return ((int)(x*10))/10f;
	}
	public  static final String handlString(String source,Object... params){
		for (int i = 0; i < params.length; i++) {
			source = source.replace("{"+i+"}", params[i]+"");
		}
		return source;
	}
	
}
