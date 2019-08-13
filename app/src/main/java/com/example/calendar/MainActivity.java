package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "CalendarActivity";
    private LinearLayout ll_calendar_main; // for calendar
    private LinearLayout ll_month_select; // for choosing month
    private MonthPicker mp_month; // for picking month
    private ViewPager vp_calendar; // view page
    private TextView tv_calendar; // for the view of chosen object
    private boolean isShowSelect = false; // if showing the selection
    private int mSelectedYear = 2000; // the number of the year
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_calendar_main = findViewById(R.id.ll_calendar_main);
        ll_month_select = findViewById(R.id.ll_month_select);
        mp_month = findViewById(R.id.mp_month);
        findViewById(R.id.btn_ok).setOnClickListener(this);
        PagerTabStrip pts_calendar = findViewById(R.id.pts_calendar);
        pts_calendar.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
        pts_calendar.setTextColor(Color.BLACK);
        vp_calendar = findViewById(R.id.vp_calendar);
        tv_calendar = findViewById(R.id.tv_calendar);
        tv_calendar.setOnClickListener(this);
        showCalendar(DateUtil.getNowYear(), DateUtil.getNowMonth());
    }

    private void showCalendar(int year, int month) {
        // rebuild the new calendar if it is not the calendar last built
        if (year != mSelectedYear) {
            tv_calendar.setText(year + "year");
            // 构建一个指定年份的年历翻页适配器
            CalendarPagerAdapter adapter = new CalendarPagerAdapter(getSupportFragmentManager(), year);
            // 给vp_calendar设置年历翻页适配器
            vp_calendar.setAdapter(adapter);
            mSelectedYear = year;
        }
        // 设置vp_calendar默认显示指定月份的月历页
        vp_calendar.setCurrentItem(month - 1);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_calendar) { // 点击了年份文本
            // 重新选择万年历的年月
            resetPage();
        } else if (v.getId() == R.id.btn_ok) { // 点击了确定按钮
            // 根据月份选择器上设定的年月，刷新万年历的显示界面
            showCalendar(mp_month.getYear(), mp_month.getMonth() + 1);
            resetPage();
        }
    }

    // 重置页面。在显示万年历主页面和显示月份选择器之间切换
    private void resetPage() {
        isShowSelect = !isShowSelect;
        ll_calendar_main.setVisibility(isShowSelect ? View.GONE : View.VISIBLE);
        ll_month_select.setVisibility(isShowSelect ? View.VISIBLE : View.GONE);
    }
}
