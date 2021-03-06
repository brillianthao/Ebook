package com.ming.ebook.ehome.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ming.ebook.R;
import com.ming.ebook.bean.Categories;
import com.ming.ebook.ehome.activity.CategoriesDetailsActivity;

import java.util.List;

/**
 * 创建人: sunming
 * 创建时间：2017/10/5
 * version：1.0
 * Email:sunming@radacat.com
 */

public class CategoriesFemaleAdapter extends RecyclerView.Adapter<CategoriesFemaleAdapter.ItemCategoriesViewHolder> {
    private List<Categories.DataBean.FemaleBean> mDataList;
    private Context mContext;

    public CategoriesFemaleAdapter(List<Categories.DataBean.FemaleBean> dataBeanList, Context context) {
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

    class ItemCategoriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView itemName;
        TextView itemCount;

        ItemCategoriesViewHolder(View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.item_name);
            itemCount = (TextView) itemView.findViewById(R.id.item_count);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //跳转
            Intent intent = new Intent(mContext, CategoriesDetailsActivity.class);
            Categories.DataBean.FemaleBean bean = mDataList.get(getAdapterPosition());
            intent.putExtra("details_key", "FemaleBean");
            intent.putExtra("details_data", bean);
            mContext.startActivity(intent);
        }
    }
}
