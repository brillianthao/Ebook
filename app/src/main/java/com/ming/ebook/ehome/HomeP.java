package com.ming.ebook.ehome;

import com.ming.ebook.bean.BannerBean;
import com.ming.ebook.constant.EBookUri;
import com.ming.ebook.utils.PrintLog;

import java.util.List;

/**
 * 创建人: sunming
 * 创建时间：2017/10/4
 * version：1.0
 * Email:sunming@radacat.com
 */

public class HomeP implements IeHomeP {
    private IeHomeM mHomeM;
    private IeHomeV mHomeV;

    public HomeP(IeHomeV homeV) {
        mHomeV = homeV;
        mHomeM = new HomeM(this);
    }

    @Override
    public void getBannerData() {
        PrintLog.d("banner getBannerDataFromNet()");
        mHomeM.getBannerDataByUrl(EBookUri.BANNER);
    }

    @Override
    public void bannerDataBackP(List<BannerBean.DataBean.RankingBean.BooksBean> books) {
        PrintLog.d("banner getBannerData:" + books.toString());
        if (books != null && books.size() > 0) {
            mHomeV.showBannerDataToView(books);
        } else {
            mHomeV.showBannerDataToViewError();
        }
    }
}
