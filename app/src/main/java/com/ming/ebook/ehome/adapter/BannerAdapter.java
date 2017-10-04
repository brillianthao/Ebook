package com.ming.ebook.ehome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ming.ebook.R;
import com.ming.ebook.bean.BannerBean;
import com.ming.ebook.utils.RegularUtils;

import java.util.List;

/**
 * 创建人: sunming
 * 创建时间：2017/10/3
 * version：1.0
 * Email:sunming@radacat.com
 */

public class BannerAdapter extends BaseAdapter {
    private List<BannerBean.DataBean.RankingBean.BooksBean> datas;
    private Context mContext;

    public BannerAdapter(List<BannerBean.DataBean.RankingBean.BooksBean> datas, Context context) {
        this.datas = datas;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_banner, null);
            holder.iv_banner = (ImageView) convertView.findViewById(R.id.item_iv_banner);
            holder.tv_banner = (TextView) convertView.findViewById(R.id.item_tv_banner);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //加载图片
        Glide.with(mContext)
                .load(RegularUtils.regularImageUrl(datas.get(position).getCover()))
                .placeholder(R.drawable.day)
                .crossFade()
                .into(holder.iv_banner);
        holder.iv_banner.setTag(R.id.image_tag, position);
        holder.tv_banner.setText(datas.get(position).getShortIntro());

        return convertView;
    }

    private class ViewHolder {
        ImageView iv_banner;
        TextView tv_banner;
    }
}
