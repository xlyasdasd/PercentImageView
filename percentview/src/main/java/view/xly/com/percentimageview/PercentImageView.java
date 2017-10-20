package view.xly.com.percentimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import view.xly.com.percentimageview.util.ScreenUtils;

/**
 * Created by xuleyuan on 2017/10/20
 */

public class PercentImageView extends BaseImageView {

    private double rate = 1;
    private int uiWidth;
    private int uiHeight;
    private int uiScreenWidth;
    private int mode;
    private final int RESIZE_HEIGHT = 0;
    private final int RESIZE_WIDTH = 1;
    private final int RESIZE_BY_SCREEN = 2;

    public PercentImageView(Context context) {
        super(context);
    }

    public PercentImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RateImageView);
        init(typedArray, context);
    }

    public PercentImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RateImageView);
        init(typedArray, context);
    }

    private void init(TypedArray typedArray, Context context) {
        ScreenUtils.initScreen(context);
        uiHeight = typedArray.getInteger(R.styleable.RateImageView_uiHeight, 1);
        uiWidth = typedArray.getInteger(R.styleable.RateImageView_uiWidth, 1);
        mode = typedArray.getInt(R.styleable.RateImageView_resize, RESIZE_HEIGHT);
        uiScreenWidth = typedArray.getInt(R.styleable.RateImageView_uiScreenWidth, 1000);
        typedArray.recycle();
        switch (mode) {
            case RESIZE_HEIGHT:
                rate = div(uiHeight, uiWidth, 50);
                break;
            case RESIZE_WIDTH:
                rate = div(uiWidth, uiHeight, 50);
                break;
            case RESIZE_BY_SCREEN:
                break;
            default:
                rate = 1;
                break;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int height = View.MeasureSpec.getSize(heightMeasureSpec);
        int measureWidth = 0, measureHeight = 0;
        switch (mode) {
            case RESIZE_HEIGHT:
                measureWidth = width;
                measureHeight = (int) (width * rate);//match_parent
                break;
            case RESIZE_WIDTH:
                measureHeight = height;
                measureWidth = ((int) (height * rate));//match_parent
                break;
            case RESIZE_BY_SCREEN:
                measureWidth = (int) div(mul(uiWidth, ScreenUtils.getInstance().getWidthPixels()), uiScreenWidth, 1);
                measureHeight = (int) div(mul(measureWidth, uiHeight), uiWidth, 1);
                break;
            default:
                break;
        }

        setMeasuredDimension(measureWidth, measureHeight);

    }

}
