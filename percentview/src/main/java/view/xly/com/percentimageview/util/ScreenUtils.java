package view.xly.com.percentimageview.util;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * @author Derrick
 * @date 2014-5-26 下午5:14:16
 */
public class ScreenUtils {

	static final ScreenUtils SCREEN = new ScreenUtils();

	private int widthPixels; // 屏幕宽
	private int heightPixels; // 屏幕高
	private float density;
	private float scaledDensity;
	private int densityDpi;
	private float xdpi;
	private float ydpi;

	public int getWidthPixels() {
		return widthPixels;
	}

	public int getHeightPixels() {
		return heightPixels;
	}

	public float getDensity() {
		return density;
	}

	public float getScaledDensity() {
		return scaledDensity;
	}

	public int getDensityDpi() {
		return densityDpi;
	}

	public float getXdpi() {
		return xdpi;
	}

	public float getYdpi() {
		return ydpi;
	}

	private ScreenUtils() {

	}

	public static void initScreen(Context context) {
		DisplayMetrics display = context.getResources().getDisplayMetrics();
		SCREEN.widthPixels = display.widthPixels;
		SCREEN.heightPixels = display.heightPixels;
		SCREEN.density = display.density; // 屏幕密度（0.75 / 1.0 / 1.5）
		SCREEN.scaledDensity = display.scaledDensity;// 同display.density
		SCREEN.densityDpi = display.densityDpi; // 屏幕密度DPI（120 / 160 /240）
		SCREEN.xdpi = display.xdpi;
		SCREEN.ydpi = display.ydpi;
	}


	public static ScreenUtils getInstance() {
		return SCREEN;
	}
}
