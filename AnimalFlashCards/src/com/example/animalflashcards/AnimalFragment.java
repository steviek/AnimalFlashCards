package com.example.animalflashcards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AnimalFragment extends Fragment{
	private static final int GIRAFFE = 0;
	private static final int KANGAROO = 1;
	private static final int OWL = 2;
	private static final int PENGUIN = 3;
	private static final int SQUIRREL = 4;
	private static final int ZEBRA = 5;
	
	private ImageView mImageView;
	private int animal;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle args = getArguments();
		if(args != null){
			this.animal = args.getInt("animal", -1);
		}
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_animal, null);
		mImageView = (ImageView) view.findViewById(R.id.imageView);
		
		switch(animal){
		case GIRAFFE:
			mImageView.setImageResource(R.drawable.giraffe);
			break;
		case KANGAROO:
			mImageView.setImageResource(R.drawable.kangaroo);
			break;
		case OWL:
			mImageView.setImageResource(R.drawable.owl);
			break;
		case PENGUIN:
			mImageView.setImageResource(R.drawable.penguin);
			break;
		case SQUIRREL:
			mImageView.setImageResource(R.drawable.squirrel);
			break;
		case ZEBRA:
			mImageView.setImageResource(R.drawable.zebra);
			break;
		default:
			mImageView.setVisibility(View.INVISIBLE);
		}
		
		return view;
		
	}
	
	
	
	
	
	
}
