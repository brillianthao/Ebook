package com.ming.ebook.launch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.ming.ebook.MainActivity;
import com.ming.ebook.R;
import com.ming.ebook.base.BaseActivity;
import com.ming.ebook.view.AccordionTransformer;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends BaseActivity {

    ViewPager viewPager;
    Button enterBt;
    private List<View> listImg;
    private GuideViewAdapter adapter;
    @Override
    protected int getContentViewId() {
        immersiveStatusBar(R.color.transparent);
        return R.layout.activity_guide;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        enterBt= (Button) findViewById(R.id.enter_bt);
        listImg = new ArrayList<>();
        listImg.add(findViewById(R.id.y1));
        listImg.add(findViewById(R.id.y2));
        listImg.add(findViewById(R.id.y3));
        adapter=new GuideViewAdapter();
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true,new AccordionTransformer());
        viewPager.addOnPageChangeListener(showPageChange);
        enterBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                GuideActivity.this.finish();
            }
        });
    }

    ViewPager.OnPageChangeListener showPageChange = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            for (int i = 0; i < listImg.size(); i++) {
                if (i == position) {
                    listImg.get(position).setBackgroundResource(R.drawable.y_focused);
                } else {
                    listImg.get(i).setBackgroundResource(R.drawable.y_normal);
                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    class GuideViewAdapter extends PagerAdapter {
        //每一个ViewPager就是一个页面
        List<View> mList = new ArrayList<>();
        int[] imgId = new int[]{R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3};

        public GuideViewAdapter() {
            for (int i = 0; i < imgId.length; i++) {
                ImageView img = new ImageView(GuideActivity.this);
                img.setImageResource(imgId[i]);
                img.setScaleType(ImageView.ScaleType.CENTER_CROP);
                mList.add(img);
            }
        }

        @Override
        public int getCount() {
            return imgId.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //添加视图到ViewGroup中
            container.addView(mList.get(position));
            return mList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mList.get(position));
        }
    }

    @Override
    public void finish() {
        super.finish();
        if (listImg!=null){
            listImg.clear();
            listImg=null;
        }
        if (viewPager!=null&&showPageChange!=null){
            viewPager.removeOnPageChangeListener(showPageChange);
            showPageChange=null;
            viewPager=null;
        }
        if (adapter!=null){
            adapter=null;
        }
    }
}
