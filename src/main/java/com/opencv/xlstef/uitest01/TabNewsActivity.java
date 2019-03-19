package com.opencv.xlstef.uitest01;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.opencv.xlstef.uitest01.fragment.FragNewsAllInfo;
import com.opencv.xlstef.uitest01.fragment.FragNewsCommissionInfo;
import com.opencv.xlstef.uitest01.fragment.FragNewsMallInfo;
import com.opencv.xlstef.uitest01.fragment.FragNewsPayInfo;
import com.opencv.xlstef.uitest01.fragment.FragNewsSummaryInfo;
import com.opencv.xlstef.uitest01.fragment.TabFragmentPagerAdapter;
import com.opencv.xlstef.uitest01.utils.MoveBg;

import java.util.ArrayList;
import java.util.List;

public class TabNewsActivity extends AppCompatActivity {
	RelativeLayout layout;
	TextView tv_front;//��Ҫ�ƶ���View

	TextView tv_bar_news;
	TextView tv_bar_sport;
	TextView tv_bar_play;
	TextView tv_bar_finance;
	TextView tv_bar_science;
	ViewPager layout_body;
	//TextView tv_bar_more;
	List<Fragment> list;
	TabFragmentPagerAdapter tabFragAdapter;

	int avg_width = 0;// ���ڼ�¼ƽ��ÿ����ǩ�Ŀ�ȣ��ƶ���ʱ����Ҫ

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_news);

		initViews();
	}

	private void initViews() {
		layout = (RelativeLayout) findViewById(R.id.layout_title_bar);
		layout_body=(ViewPager) findViewById(R.id.layout_body);
		tv_bar_news = (TextView) findViewById(R.id.tv_title_bar_news);
		tv_bar_sport = (TextView) findViewById(R.id.tv_title_bar_sport);
		tv_bar_play = (TextView) findViewById(R.id.tv_title_bar_play);
		tv_bar_finance = (TextView) findViewById(R.id.tv_title_bar_finance);
		tv_bar_science = (TextView) findViewById(R.id.tv_title_bar_science);
		//tv_bar_more = (TextView) findViewById(R.id.tv_title_bar_more);

		tv_bar_news.setOnClickListener(onClickListener);
		tv_bar_sport.setOnClickListener(onClickListener);
		tv_bar_play.setOnClickListener(onClickListener);
		tv_bar_finance.setOnClickListener(onClickListener);
		tv_bar_science.setOnClickListener(onClickListener);
		layout_body.addOnPageChangeListener(new MyPagerChangeListener());
		//tv_bar_more.setOnClickListener(onClickListener);
		//把Fragment添加到List集合里面
		list = new ArrayList<>();
		list.add(new FragNewsAllInfo());
		list.add(new FragNewsMallInfo());
		list.add(new FragNewsPayInfo());
		list.add(new FragNewsCommissionInfo());
		list.add(new FragNewsSummaryInfo());
		tabFragAdapter=new TabFragmentPagerAdapter(getSupportFragmentManager(),list);
		layout_body.setAdapter(tabFragAdapter);
		layout_body.setCurrentItem(0);
		//设置显示栏背景
		tv_front = new TextView(this);
		tv_front.setBackgroundResource(R.drawable.slidebar);
		tv_front.setTextColor(Color.WHITE);
		tv_front.setText(getResources().getText(R.string.news_top_left_text));
		tv_front.setGravity(Gravity.CENTER);
		LayoutParams param = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		param.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
		layout.addView(tv_front, param);


	}

	private OnClickListener onClickListener = new OnClickListener() {
		int startX;//�ƶ�����ʼλ��

		@Override
		public void onClick(View v) {
			avg_width = findViewById(R.id.layout).getWidth();
			switch (v.getId()) {
			case R.id.tv_title_bar_news:
				layout_body.setCurrentItem(0);
				MoveBg.moveFrontBg(tv_front, startX, 0, 0, 0);
				startX = 0;
				tv_front.setText(R.string.title_news_category_tops);
				break;
			case R.id.tv_title_bar_sport:
				layout_body.setCurrentItem(1);
				MoveBg.moveFrontBg(tv_front, startX, avg_width, 0, 0);
				startX = avg_width;
				tv_front.setText(R.string.title_news_category_sport);
				break;
			case R.id.tv_title_bar_play:
				layout_body.setCurrentItem(2);
				MoveBg.moveFrontBg(tv_front, startX, avg_width * 2, 0, 0);
				startX = avg_width * 2;
				tv_front.setText(R.string.title_news_category_play);
				break;
			case R.id.tv_title_bar_finance:
				layout_body.setCurrentItem(3);
				MoveBg.moveFrontBg(tv_front, startX, avg_width * 3, 0, 0);
				startX = avg_width * 3;
				tv_front.setText(R.string.title_news_category_finance);
				break;
			case R.id.tv_title_bar_science:
				layout_body.setCurrentItem(4);
				MoveBg.moveFrontBg(tv_front, startX, avg_width * 4, 0, 0);
				startX = avg_width * 4;
				tv_front.setText(R.string.title_news_category_science);
				break;
			default:
				break;
			}
		}
	};
	/**
	 * 设置一个ViewPager的侦听事件，当左右滑动ViewPager时菜单栏被选中状态跟着改变
	 *
	 */
	class MyPagerChangeListener implements ViewPager.OnPageChangeListener {
		int startX;

		@Override
		public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

		}

		@Override
		public void onPageSelected(int position) {
			avg_width = findViewById(R.id.layout).getWidth();
			switch (position){
				case 0:
					//layout_body.setCurrentItem(0);
					MoveBg.moveFrontBg(tv_front, startX, 0, 0, 0);
					startX = 0;
					tv_front.setText(R.string.title_news_category_tops);

					break;
				case 1:
					//layout_body.setCurrentItem(1);
					MoveBg.moveFrontBg(tv_front, startX, avg_width, 0, 0);
					startX = avg_width;
					tv_front.setText(R.string.title_news_category_sport);
					break;
				case 2:
					//layout_body.setCurrentItem(2);
					MoveBg.moveFrontBg(tv_front, startX, avg_width * 2, 0, 0);
					startX = avg_width * 2;
					tv_front.setText(R.string.title_news_category_play);
					break;
				case 3:
					//layout_body.setCurrentItem(3);
					MoveBg.moveFrontBg(tv_front, startX, avg_width * 3, 0, 0);
					startX = avg_width * 3;
					tv_front.setText(R.string.title_news_category_finance);
					break;
				case 4:
					MoveBg.moveFrontBg(tv_front, startX, avg_width * 4, 0, 0);
					startX = avg_width * 4;
					tv_front.setText(R.string.title_news_category_science);
					break;
				default:
					break;
			}
		}

		@Override
		public void onPageScrollStateChanged(int state) {

		}
	}

}
