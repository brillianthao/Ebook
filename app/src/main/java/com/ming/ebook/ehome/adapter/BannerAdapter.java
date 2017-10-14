package com.ming.ebook.ehome.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ItemViewHolder> {
    private List<BannerBean.DataBean.RankingBean.BooksBean> datas;
    private Context mContext;

    public BannerAdapter(List<BannerBean.DataBean.RankingBean.BooksBean> datas, Context context) {
        this.datas = datas;
        this.mContext = context;
    }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_banner, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        //加载图片
        Glide.with(mContext)
                .load(RegularUtils.regularImageUrl(datas.get(position).getCover()))
                .placeholder(R.drawable.day)
                .crossFade()
                .into(holder.iv_banner);
        holder.iv_banner.setTag(R.id.image_tag, position);
        holder.tv_banner.setText(datas.get(position).getShortIntro());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv_banner;
        TextView tv_banner;

        ItemViewHolder(View itemView) {
            super(itemView);
            iv_banner = (ImageView) itemView.findViewById(R.id.item_iv_banner);
            tv_banner = (TextView) itemView.findViewById(R.id.item_tv_banner);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private BannerAdapter.OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(BannerAdapter.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
