package com.ming.ebook.ebook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ming.ebook.R;
import com.ming.ebook.bean.BookChapters;

import java.util.List;

/**
 * 创建人: sunming
 * 创建时间：2017/10/5
 * version：1.0
 * Email:sunming@radacat.com
 */

public class CategoriesListAdapter extends RecyclerView.Adapter<CategoriesListAdapter.ItemCategoriesViewHolder> {
    private List<BookChapters.DataBean.ChaptersBean> mDataList;
    private Context mContext;

    public CategoriesListAdapter(List<BookChapters.DataBean.ChaptersBean> dataBeanList, Context context) {
        this.mDataList = dataBeanList;
        this.mContext = context;
    }

    @Override
    public ItemCategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book_catalogue_list, parent, false);

        return new ItemCategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemCategoriesViewHolder holder, int position) {
        if (mDataList != null && mDataList.size() > 0)
            holder.itemName.setText(mDataList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        if (mDataList == null) {
            return 0;
        }
        return mDataList.size();
    }

    class ItemCategoriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemName;

        ItemCategoriesViewHolder(View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.item_list_name);
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

    private CategoriesListAdapter.OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(CategoriesListAdapter.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
