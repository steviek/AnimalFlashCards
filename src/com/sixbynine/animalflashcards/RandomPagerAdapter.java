package com.sixbynine.animalflashcards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class RandomPagerAdapter extends FragmentStatePagerAdapter {
	private int count;
	private int[] shuffledPositions;
    public RandomPagerAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = count;
    }

	@Override
    public Fragment getItem(int position) {
		if(shuffledPositions == null){
			initializeShuffledPositions();
		}
		Fragment frag = new AnimalFragment();
		Bundle args = new Bundle();
		args.putInt("animal", shuffledPositions[position]);
		frag.setArguments(args);
		return frag;
    }

    @Override
    public int getCount() {
			return count;
    }  
    
    private void initializeShuffledPositions(){
    	shuffledPositions = new int[count];
        for(int i = 0; i < count; i ++){
        	shuffledPositions[i] = i;
        }
        for(int j = 0; j < count * 3; j ++){
        	int x = (int) (Math.random() * count);
        	int y = (int) (Math.random() * count);
        	int temp = shuffledPositions[x];
        	shuffledPositions[x] = shuffledPositions[y];
        	shuffledPositions[y] = temp;
        }
    }
    
}
