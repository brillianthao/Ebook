package com.ming.ebook.ebook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ming.ebook.R;
import com.ming.ebook.constant.AppConstants;
import com.ming.ebook.dao.entity.BookBean;
import com.ming.ebook.system.ScreenUtils;
import com.ming.ebook.utils.RegularUtils;

import java.util.List;

/**
 * 创建人: sunming
 * 创建时间：2017/10/7
 * version：1.0
 * Email:sunming@radacat.com
 */

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.ItemViewHolder> {
    private List<BookBean> dataBookList;
    private Context mContext;

    public StaggeredGridAdapter(List<BookBean> bookList, Context context) {
        this.dataBookList = bookList;
        this.mContext = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_book_bean, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        if (dataBookList != null && dataBookList.size() > 0) {
            BookBean book = dataBookList.get(position);
            //加载图片
            Glide.with(mContext)
                    .load(RegularUtils.regularImageUrl(book.getBook_cover()))
                    .placeholder(R.drawable.day)
                    .crossFade()
                    .into(holder.itemBookCover);
            holder.itemBookCover.setTag(R.id.book_cover_tag, position);
            if (book.getReaded_chapter().equals(AppConstants.NO_READED_CHAPTER)){
                holder.itemBookReadedChapter.setText(AppConstants.NO_READED_CHAPTER);
            }else {
                holder.itemBookReadedChapter.setText(mContext.getString(R.string.readed_chapter,book.getReaded_chapter()));
            }
        }
    }

    @Override
    public int getItemCount() {
        return dataBookList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        FrameLayout item_Fl;
        ImageView itemBookCover;
        TextView itemBookReadedChapter;

        public ItemViewHolder(View itemView) {
            super(itemView);
            item_Fl = (FrameLayout) itemView.findViewById(R.id.item_book_fl);
            ViewGroup.LayoutParams params = item_Fl.getLayoutParams();
            params.height = (int) (ScreenUtils.getRealScreenHeight(mContext) / 4);
            item_Fl.setLayoutParams(params);
            itemBookCover = (ImageView) itemView.findViewById(R.id.item_book_cover);
            itemBookReadedChapter = (TextView) itemView.findViewById(R.id.item_book_readed_chapter);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemBookClickListener != null) {
                mOnItemBookClickListener.itemBookClick(v, getAdapterPosition());
            }
        }
    }

    public interface OnItemBookClickListener {
        void itemBookClick(View v, int position);
    }

    private OnItemBookClickListener mOnItemBookClickListener;

    public void setOnItemBookClickListener(OnItemBookClickListener itemBookClickListener) {
        this.mOnItemBookClickListener = itemBookClickListener;
    }
}
