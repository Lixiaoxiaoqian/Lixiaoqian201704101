package lixiaoqian.bwie.com.lixiaoqian20170410;

import android.app.Application;

import org.xutils.x;

/**
 * @类的用途：imageloader初始化类
 * @author: 李晓倩
 * @date: 2017/4/10
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }

}
