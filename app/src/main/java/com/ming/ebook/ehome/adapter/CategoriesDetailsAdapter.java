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
import com.ming.ebook.bean.CategoriesDetails;
import com.ming.ebook.utils.RegularUtils;

import java.util.List;

/**
 * 创建人: sunming
 * 创建时间：2017/10/6
 * version：1.0
 * Email:sunming@radacat.com
 */
public class CategoriesDetailsAdapter extends RecyclerView.Adapter<CategoriesDetailsAdapter.ItemDetailsViewHolder> {
    private List<CategoriesDetails.DataBean.BooksBean> mDataList;
    private Context mContext;

    public CategoriesDetailsAdapter(List<CategoriesDetails.DataBean.BooksBean> dataBeanList, Context context) {
        this.mDataList = dataBeanList;
        this.mContext = context;
    }

    @Override
    public ItemDetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_categories_details, parent, false);

        return new ItemDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemDetailsViewHolder holder, int position) {
        if (mDataList != null && mDataList.size() > 0) {
            CategoriesDetails.DataBean.BooksBean booksBean = mDataList.get(position);
            //加载图片
            Glide.with(mContext)
                    .load(RegularUtils.regularImageUrl(booksBean.getCover()))
                    .placeholder(R.drawable.day)
                    .crossFade()
                    .into(holder.book_cover);
            holder.book_cover.setTag(R.id.image_detail_tag, position);
            holder.book_title.setText(booksBean.getTitle());
            holder.book_author.setText(booksBean.getAuthor());
            holder.book_shortIntro.setText(booksBean.getShortIntro());
            holder.book_follower.setText(mContext.getString(R.string.item_followers, booksBean.getLatelyFollower()));

        }

    }

    @Override
    public int getItemCount() {
        if (mDataList == null) {
            return 0;
        }
        return mDataList.size();
    }

    class ItemDetailsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView book_cover;
        TextView book_title;
        TextView book_author;
        TextView book_shortIntro;
        TextView book_follower;

        ItemDetailsViewHolder(View itemView) {
            super(itemView);
            book_cover = (ImageView) itemView.findViewById(R.id.book_cover);
            book_title = (TextView) itemView.findViewById(R.id.book_title);
            book_author = (TextView) itemView.findViewById(R.id.book_author);
            book_shortIntro = (TextView) itemView.findViewById(R.id.book_shortIntro);
            book_follower = (TextView) itemView.findViewById(R.id.book_follower);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener!=null){
                mOnItemClickListener.onItemClick(v,getAdapterPosition());
            }
        }
    }
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
