package view.xly.com.percentimageview;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by xuleyuan on 2017/10/20
 */

public abstract class BaseActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        initData();
    }

    protected abstract void initData();

    protected abstract int setLayoutId();

}
