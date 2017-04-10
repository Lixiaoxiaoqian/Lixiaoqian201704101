package lixiaoqian.bwie.com.lixiaoqian20170410;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @类的用途：vp的适配器类
 * @author: 李晓倩
 * @date: 2017/4/10
 */

public class MyPagerAdapter extends FragmentPagerAdapter{

    private List<MyFragment> mList;
    private List<String> tablist;

    public MyPagerAdapter(FragmentManager fm, List<MyFragment> list, List<String> tablist) {
        super(fm);
        mList = list;
        this.tablist = tablist;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tablist.get(position);
    }
}
