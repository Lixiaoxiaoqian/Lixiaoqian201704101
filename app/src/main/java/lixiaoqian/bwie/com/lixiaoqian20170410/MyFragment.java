package lixiaoqian.bwie.com.lixiaoqian20170410;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.x;

import java.text.SimpleDateFormat;
import java.util.Date;

import xlistview.bawei.com.xlistviewlibrary.XListView;

/**
 * @类的用途：主界面的片段fragment
 * @author: 李晓倩
 * @date: 2017/4/10
 */

public class MyFragment extends Fragment{

    private View mView;
    private XListView mXlv;

    public static MyFragment getFragment(String uri){
        MyFragment mf=new MyFragment();
        Bundle b=new Bundle();
        b.putString("uri",uri);
        mf.setArguments(b);
        return mf;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment,null);
        x.view().inject(this, mView);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initControl();
    }


    private void initControl() {
        Bundle bundle = getArguments();
        String uri = bundle.getString("uri");
        MyXutils myXutils=new MyXutils(getActivity(),mXlv);
        myXutils.getXutil(uri);
        mXlv.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                onLoad();
            }

            @Override
            public void onLoadMore() {

            }
        });


    }

    private void onLoad() {
//        mXlv.stopRefresh();//停止刷新
//        mXlv.stopLoadMore();//停止加载更多
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd EEEE");
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");//设置日期显示格式
        Date curDate = new Date();//获取当前时间
        String str = formatter.format(curDate);// 将时间装换为设置好的格式
        mXlv.setRefreshTime(str);//设置时间
       // mXlv.setRefreshTime("放开即可推荐...");
    }

    private void initView() {
        mXlv = (XListView) mView.findViewById(R.id.xlv);
    }

}
