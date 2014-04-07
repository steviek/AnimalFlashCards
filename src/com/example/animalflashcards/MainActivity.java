package com.example.animalflashcards;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {

	private ViewPager mPager;
	private SimplePagerAdapter mPagerAdapter;
	private static final int DEGREES_BETWEEN_CARDS = 170;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mPager = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new SimplePagerAdapter(this.getSupportFragmentManager());
		mPager.setAdapter(mPagerAdapter);
		mPager.setPageTransformer(true, new RotationPageTransformer(DEGREES_BETWEEN_CARDS));
		mPager.setOffscreenPageLimit(mPagerAdapter.getCount());
		mPager.setPageMargin(- getResources().getDimensionPixelOffset(R.dimen.side_padding) * 2);
		mPager.setClipChildren(false);
	}
	
    private class SimplePagerAdapter extends FragmentStatePagerAdapter {
        public SimplePagerAdapter(FragmentManager fm) {
            super(fm);
        }

		@Override
        public Fragment getItem(int position) {
			Fragment frag = new AnimalFragment();
			Bundle args = new Bundle();
			args.putInt("animal", position);
			frag.setArguments(args);
			return frag;
        }

        @Override
        public int getCount() {
				return 6;
        }  
        
    }

}
