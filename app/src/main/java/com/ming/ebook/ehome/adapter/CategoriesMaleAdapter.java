package com.ming.ebook.ehome.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ming.ebook.R;
import com.ming.ebook.bean.Categories;

import java.util.List;

/**
 * 创建人: sunming
 * 创建时间：2017/10/5
 * version：1.0
 * Email:sunming@radacat.com
 */

public class CategoriesMaleAdapter extends RecyclerView.Adapter<CategoriesMaleAdapter.ItemCategoriesViewHolder> {
    private List<Categories.DataBean.MaleBean> mDataList;
    private Context mContext;

    public CategoriesMaleAdapter(List<Categories.DataBean.MaleBean> dataBeanList, Context context) {
        this.mDataList = dataBeanList;
        this.mContext = context;
    }

    @Override
    public ItemCategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_categories_text, parent, false);

        return new ItemCategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemCategoriesViewHolder holder, int position) {
        if (mDataList != null && mDataList.size() > 0)
            holder.itemName.setText(mDataList.get(position).getName());
        holder.itemCount.setText(mContext.getString(R.string.item_counts, mDataList.get(position).getBookCount()));
    }

    @Override
    public int getItemCount() {
        if (mDataList == null) {
            return 0;
        }
        return mDataList.size();
    }

    static class ItemCategoriesViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        TextView itemCount;

        ItemCategoriesViewHolder(View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemCount = (TextView) itemView.findViewById(R.id.item_count);
        }
    }
}
