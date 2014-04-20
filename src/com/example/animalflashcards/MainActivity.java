package com.example.animalflashcards;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

	private ViewPager mPager;
	private RandomPagerAdapter mPagerAdapter;
	private static final int DEGREES_BETWEEN_CARDS = 170;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mPager = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new RandomPagerAdapter(this.getSupportFragmentManager(), Animal.NUMBER_OF_ANIMALS);
		mPager.setAdapter(mPagerAdapter);
		mPager.setPageTransformer(true, new RotationPageTransformer(DEGREES_BETWEEN_CARDS));
		mPager.setOffscreenPageLimit(2);
		mPager.setPageMargin(- getResources().getDimensionPixelOffset(R.dimen.side_padding) * 2);
		mPager.setClipChildren(false);
	}
	
    

}
