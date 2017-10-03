package com.ming.ebook.system;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/**
 * 创建人: sunming
 * 创建时间：2017/5/19
 * version：1.0
 * Email:sunming@radacat.com
 */
public class ScreenUtils {

    /**
     * 获取屏幕的宽度px
     *
     * @param context
     * @return
     */
    public static float getRealScreenWidth(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(dm);
        // 屏幕宽（px，如：px）
        return dm.widthPixels;
    }

    /**
     * 获取屏幕的高度px
     *
     * @param context
     * @return
     */
    public static float getRealScreenHeight(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(dm);
        // 屏幕高（px，如：px）
        return dm.heightPixels;
    }

    /**
     * 根据手机的分辨率 从dp 转成px
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(float dpValue, Context context) {
        // PX跟DP之间的换算关系很简单：px = dp * (dpi / 160)
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(dm);
        int dpi = dm.densityDpi;  // 屏幕密度DPI（120 / 160 / 240）
        return (int) (dpValue * (dpi / 160));
    }

    /**
     * 根据手机的分辨率从px 转 dp
     *
     * @param context
     * @param pxValue
     * @return
     */
    public static int px2dip(float pxValue, Context context) {
        // PX跟DP之间的换算关系很简单：dp= px /(dpi / 160)
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(dm);
        // float density = dm.density;      // 屏幕密度（0.75 / 1.0 / 1.5）
        int dpi = dm.densityDpi;  // 屏幕密度DPI（120 / 160 / 240）
        return (int) (pxValue / (dpi / 160));
    }


    /**
     * 获取手机状态栏高度
     *
     * @param contex
     * @return
     */
    public static int getStatusBarHeight(Context contex) {
        int result = 0;
        int resourceId = contex.getResources().getIdentifier(
                "status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = contex.getResources().getDimensionPixelSize(resourceId);
        }
        Log.d("cj", "status_bar_height=" + result);
        return result;
    }

    /**
     * 动态设置Margin
     *
     * @param v
     * @param l
     * @param t
     * @param r
     * @param b
     */
    public static void setMargins(View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }
}
