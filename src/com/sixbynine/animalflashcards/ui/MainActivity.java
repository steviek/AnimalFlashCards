package com.sixbynine.animalflashcards.ui;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.sixbynine.animalflashcards.R;
import com.sixbynine.animalflashcards.adapter.RandomPagerAdapter;
import com.sixbynine.animalflashcards.adapter.RotationPageTransformer;
import com.sixbynine.animalflashcards.util.Animal;

public class MainActivity extends FragmentActivity implements AnimalFragment.Callback{
	private static final int DEGREES_BETWEEN_CARDS = 165;
	
	private ViewPager mPager;
	private RandomPagerAdapter mPagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mPager = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new RandomPagerAdapter(this.getSupportFragmentManager(), Animal.NUMBER_OF_ANIMALS);
		mPager.setAdapter(mPagerAdapter);
		mPager.setPageTransformer(true, new RotationPageTransformer(DEGREES_BETWEEN_CARDS));
		mPager.setOffscreenPageLimit(4);
		mPager.setPageMargin(- getResources().getDimensionPixelOffset(R.dimen.side_padding) * 2);
		mPager.setClipChildren(false);
	}

	@Override
	public void onLanguageChanged() {
		for(Fragment frag : getSupportFragmentManager().getFragments()){
			if(frag instanceof AnimalFragment){
				((AnimalFragment) frag).onLanguageChanged();
			}
		}	
	}

	@Override
	public void onTopPickerOpened() {
		for(Fragment frag : getSupportFragmentManager().getFragments()){
			if(frag instanceof AnimalFragment){
				((AnimalFragment) frag).onTopPickerOpened();
			}
		}
	}

	@Override
	public void onTopPickerClosed() {
		for(Fragment frag : getSupportFragmentManager().getFragments()){
			if(frag instanceof AnimalFragment){
				((AnimalFragment) frag).onTopPickerClosed();
			}
		}
	}

	@Override
	public void onBottomPickerOpened() {
		for(Fragment frag : getSupportFragmentManager().getFragments()){
			if(frag instanceof AnimalFragment){
				((AnimalFragment) frag).onBottomPickerOpened();
			}
		}
	}

	@Override
	public void onBottomPickerClosed() {
		for(Fragment frag : getSupportFragmentManager().getFragments()){
			if(frag instanceof AnimalFragment){
				((AnimalFragment) frag).onBottomPickerClosed();
			}
		}
	}
	
	@Override
	public void onBackPressed() {
		for(Fragment frag : getSupportFragmentManager().getFragments()){
			if(frag instanceof AnimalFragment){
				if(((AnimalFragment) frag).onBackPressed()){
					return;
				}else{
					break;
				}
			}
		}
		super.onBackPressed();
	}
	
	
    

}
