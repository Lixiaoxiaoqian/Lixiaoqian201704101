package lixiaoqian.bwie.com.lixiaoqian20170410;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @类的用途：主界面
 * @author: 李晓倩
 * @date: 2017/4/10
 */
public class MainActivity extends AppCompatActivity {

    private TabLayout tablay;
    private ViewPager vp;
    private List<String> tablist=new ArrayList<>();
    private List<MyFragment> mlist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initControl();
    }

    private void initControl() {
        initData();
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), mlist, tablist);
        vp.setAdapter(pagerAdapter);
        tablay.setupWithViewPager(vp);
    }

    private void initData() {
        if(tablist.size()==0){
            tablist.add("社会");
            tablist.add("国内");
            tablist.add("国际");
            tablist.add("娱乐");
            tablist.add("体育");
            tablist.add("NBA");
            tablist.add("足球");
            tablist.add("科技");
            tablist.add("创业");
            tablist.add("苹果");
        }

        tablay.setTabMode(TabLayout.MODE_SCROLLABLE);
        tablay.setTabTextColors(Color.GRAY,Color.RED);
        tablay.setSelectedTabIndicatorColor(Color.TRANSPARENT);
        if(mlist.size()==0){
           mlist.add(MyFragment.getFragment(UrL.url1));
           mlist.add(MyFragment.getFragment(UrL.url2));
           mlist.add(MyFragment.getFragment(UrL.url3));
           mlist.add(MyFragment.getFragment(UrL.url4));
           mlist.add(MyFragment.getFragment(UrL.url5));
           mlist.add(MyFragment.getFragment(UrL.url6));
           mlist.add(MyFragment.getFragment(UrL.url7));
           mlist.add(MyFragment.getFragment(UrL.url8));
           mlist.add(MyFragment.getFragment(UrL.url9));
           mlist.add(MyFragment.getFragment(UrL.url10));
        }
    }


    private void initView() {
        tablay = (TabLayout) findViewById(R.id.tablay);
        vp = (ViewPager) findViewById(R.id.vp);
    }
}
