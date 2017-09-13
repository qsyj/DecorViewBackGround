package com.wqlin.demo;

import android.app.Activity;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * Created by wqlin on 2017/9/13.
 */

public class Utils {
    public static void setWindowBackGround(Activity activity,WindowBackGroundInfo info,boolean isShow) {
        FrameLayout decorView = (FrameLayout) activity.getWindow().getDecorView();
        View backGroundView = null;
        int count=decorView.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = decorView.getChildAt(i);
            String tag= (String) child.getTag();
            if (tag != null && tag.equals("wqlin_back_ground_View")) {
                backGroundView = child;
                break;
            }
        }
        if (isShow) {
            if (backGroundView == null) {
                backGroundView = new View(activity);
                backGroundView.setTag("wqlin_back_ground_View");
            }
            backGroundView.setBackgroundColor(Color.parseColor("#000000"));
            backGroundView.setAlpha(info.getAlpha());

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(getWindowWidth(activity), info.getyEnd() - info.getyStart());
            params.topMargin = info.getyStart();
            backGroundView.setLayoutParams(params);
            decorView.addView(backGroundView);
        } else {
            if (backGroundView != null) {
                decorView.removeView(backGroundView);
            }
        }

    }

    public static int getWindowWidth(Activity activity) {
        WindowManager manager = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        return width;

    }
    public static int getWindowHeight(Activity activity) {
        WindowManager manager = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int height = outMetrics.heightPixels;
        return height;
    }

    public static int[] getWindowHeightSize(Activity activity) {
        int[] size = new int[2];
        WindowManager manager = activity.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;
        size[0]=width;
        size[1]=height;
        return size;
    }
    public static class WindowBackGroundInfo{
        private float alpha;
        private int yStart;
        private int yEnd;

        public WindowBackGroundInfo(float alpha, int yStart, int yEnd) {
            this.alpha = alpha;
            this.yStart = yStart;
            this.yEnd = yEnd;
        }

        public float getAlpha() {
            return alpha;
        }

        public void setAlpha(float alpha) {
            this.alpha = alpha;
        }

        public int getyStart() {
            return yStart;
        }

        public void setyStart(int yStart) {
            this.yStart = yStart;
        }

        public int getyEnd() {
            return yEnd;
        }

        public void setyEnd(int yEnd) {
            this.yEnd = yEnd;
        }
    }

}
