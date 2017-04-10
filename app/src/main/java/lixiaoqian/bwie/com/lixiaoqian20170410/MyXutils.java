package lixiaoqian.bwie.com.lixiaoqian20170410;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import xlistview.bawei.com.xlistviewlibrary.XListView;

/**
 * @类的用途：
 * @author: 李晓倩
 * @date: 2017/4/10
 */

public class MyXutils {

    private Context mContext;
    private XListView mXListView;

    public MyXutils(Context context, XListView XListView) {
        mContext = context;
        mXListView = XListView;
    }

    public  void  getXutil(String uri){
        RequestParams params = new RequestParams(uri);
        params.addQueryStringParameter("num","10");
        System.out.println(params);
        Log.d("zzz",params.toString());
        x.http().get(params, new Callback.CommonCallback<String>() {
            public void onSuccess(String result) {
                System.out.println(result);
                Gson gson=new Gson();
                GasonBean gasonBean = gson.fromJson(result, GasonBean.class);
                List<GasonBean.NewslistBean> newslist = gasonBean.getNewslist();
                System.out.println(newslist.size()+"zzz");
                mXListView.setAdapter(new MyBaseAdapter(mContext,newslist));
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

        });
    }
}
