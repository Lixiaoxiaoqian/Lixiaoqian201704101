package lixiaoqian.bwie.com.lixiaoqian20170410;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.common.Callback;
import org.xutils.x;

import java.util.List;

import static lixiaoqian.bwie.com.lixiaoqian20170410.R.id.imageView;

/**
 * @类的用途：xlv的适配器类
 * @author: 李晓倩
 * @date: 2017/4/10
 */

public class MyBaseAdapter extends BaseAdapter{
    private Context mContext;
    private List<GasonBean.NewslistBean> mList;

    public MyBaseAdapter(Context context, List<GasonBean.NewslistBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(convertView==null){
            convertView=View.inflate(mContext,R.layout.xlv_item,null);
            holder=new ViewHolder();
            holder.tv1= (TextView) convertView.findViewById(R.id.textView);
            holder.tv2= (TextView) convertView.findViewById(R.id.textView2);
            holder.img= (ImageView) convertView.findViewById(imageView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
            holder.tv1.setText(mList.get(position).getTitle());
            holder.tv2.setText(mList.get(position).getDescription());
            x.image().loadDrawable(mList.get(position).getPicUrl(), ImageOptionsUtils.imageUtils(), new Callback.CommonCallback<Drawable>() {
            @Override
            public void onSuccess(Drawable result) {
                holder.img.setImageDrawable(result);
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
        return convertView;
    }

     class ViewHolder{
         TextView tv1;
         TextView tv2;
         ImageView img;
     }
}
