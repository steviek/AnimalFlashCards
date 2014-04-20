package com.example.animalflashcards;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalFragment extends Fragment{
	private ImageView mImageView;
	private TextView title;
	private TextView subTitle;
	private ImageView titleFlag;
	private ImageView subTitleFlag;
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
		title = (TextView) view.findViewById(R.id.title);
		subTitle = (TextView) view.findViewById(R.id.subTitle);
		titleFlag = (ImageView) view.findViewById(R.id.titleFlag);
		subTitleFlag = (ImageView) view.findViewById(R.id.subTitleFlag);
		
		int imgRes = Animal.getImgResources(animal);
		if(imgRes == 0){
			mImageView.setVisibility(View.INVISIBLE);
		}else{
			mImageView.setVisibility(View.VISIBLE);
			mImageView.setImageResource(imgRes);
		}
		
		title.setText(Animal.getAnimalName(getActivity(), animal, Utilities.getTopLanguage(getActivity())));
		subTitle.setText(Animal.getAnimalName(getActivity(), animal, Utilities.getBottomLanguage(getActivity())));
		titleFlag.setImageResource(Utilities.getFlagResource(getActivity(), Utilities.getTopLanguage(getActivity())));
		subTitleFlag.setImageResource(Utilities.getFlagResource(getActivity(), Utilities.getBottomLanguage(getActivity())));
		
		return view;
		
	}
	
	
	
	
	
	
}
