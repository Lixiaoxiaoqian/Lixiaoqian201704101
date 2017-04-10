package lixiaoqian.bwie.com.lixiaoqian20170410;

import org.xutils.image.ImageOptions;

/**
 * @类的用途：
 * @author: 李晓倩
 * @date: 2017/4/10
 */

public class ImageOptionsUtils {

    public static ImageOptions imageUtils(){
        //通过ImageOptions.Builder().set方法设置图片的属性
        ImageOptions imageOptions= new ImageOptions.Builder().setFadeIn(true)
        //.setCircular(true) //设置图片显示为圆形
                //.setSquare(true) //设置图片显示为正方形
                //.setSize(260,200)
                .setCrop(true).setSize(240,190) //设置大小
        .setUseMemCache(true).build(); //设置使用MemCache，默认true
        return imageOptions;

    }

}
