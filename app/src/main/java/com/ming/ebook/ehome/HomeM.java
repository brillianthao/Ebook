package com.ming.ebook.ehome;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.ming.ebook.bean.BannerBean;
import com.ming.ebook.utils.Model;
import com.ming.ebook.utils.PrintLog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;

/**
 * 创建人: sunming
 * 创建时间：2017/10/4
 * version：1.0
 * Email:sunming@radacat.com
 */

public class HomeM implements IeHomeM {
    IeHomeP mIeHomeP;

    public HomeM(IeHomeP ieHomeP) {
        mIeHomeP = ieHomeP;
    }

    @Override
    public void getBannerDataByUrl(final String url) {
        PrintLog.d("banner getBannerDataByUrl");
        //网络访问
        Model.getInstance().getGloablThreadPool().execute(new Runnable() {

            @Override
            public void run() {
                OkHttpClient okHttpClient = new OkHttpClient();
                okhttp3.Request request = new okhttp3.Request.Builder()
                        .url(url)
                        .build();
                Call call = okHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        PrintLog.d("banner getBannerDataByUrl网络访问失败");
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull okhttp3.Response response) throws IOException {
                        int resCode = response.code();
                        if (resCode == 200) {
                            //解析json
                            String json = response.body().string();
                            PrintLog.d("banner json:" + json);
                            Gson gson = new Gson();
                            BannerBean bean = gson.fromJson(json, BannerBean.class);
                            List<BannerBean.DataBean.RankingBean.BooksBean> books = bean.getData().getRanking().getBooks();
                            if (books.size()>=4){
                                ArrayList<BannerBean.DataBean.RankingBean.BooksBean> fourList=new ArrayList<BannerBean.DataBean.RankingBean.BooksBean>();
                                for (int i = 0; i < 4; i++) {
                                    fourList.add(books.get(i));
                                }
                                mIeHomeP.bannerDataBackP(fourList);
                            }else {
                                mIeHomeP.bannerDataBackP(books);
                            }
                        }
                    }
                });
            }
        });
    }

    @Override
    public void getBannerDataByCache(String bannerKey) {

    }
}
