package com.sixbynine.animalflashcards;


import com.sixbynine.animalflashcards.ui.LanguagePicker;
import com.sixbynine.animalflashcards.ui.LanguagePicker.OnLanguagePickedListener;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalFragment extends Fragment implements OnLanguagePickedListener{
	private ImageView mImageView;
	private TextView title;
	private TextView subTitle;
	private ImageView titleFlag;
	private ImageView subTitleFlag;
	
	private LanguagePicker topChooser;
	private LanguagePicker bottomChooser;
	private int animal;
	private Callback callback;
	
	public interface Callback{
		public void onLanguageChanged();
		public void onTopPickerOpened();
		public void onTopPickerClosed();
		public void onBottomPickerOpened();
		public void onBottomPickerClosed();
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if(activity instanceof Callback){
			callback = (Callback) activity;
		}else{
			throw new IllegalStateException(activity.getClass().toString() + " must implement interface Callback");
		}
	}
	
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
		
		topChooser = (LanguagePicker) view.findViewById(R.id.flags_chooser_top);
		topChooser.setOnLanguagePickedListener(this);
		bottomChooser = (LanguagePicker) view.findViewById(R.id.flags_chooser_bottom);
		bottomChooser.setOnLanguagePickedListener(this);
		
		titleFlag.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				callback.onTopPickerOpened();
			}
		});
		subTitleFlag.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				callback.onBottomPickerOpened();
			}
		});
		
		int imgRes = Animal.getImgResources(animal);
		if(imgRes == 0){
			mImageView.setVisibility(View.INVISIBLE);
		}else{
			mImageView.setVisibility(View.VISIBLE);
			mImageView.setImageResource(imgRes);
		}
		
		title.setText(Animal.getAnimalName(getActivity(), Utilities.getTopLanguage(getActivity()), animal));
		subTitle.setText(Animal.getAnimalName(getActivity(), Utilities.getBottomLanguage(getActivity()), animal));
		titleFlag.setImageResource(Utilities.getFlagResource(getActivity(), Utilities.getTopLanguage(getActivity())));
		subTitleFlag.setImageResource(Utilities.getFlagResource(getActivity(), Utilities.getBottomLanguage(getActivity())));
		return view;
		
	}
	
	private void fadeStuff(){
		float fade = 0.3f;
		mImageView.setAlpha(fade);
		title.setAlpha(fade);
		subTitle.setAlpha(fade);
		titleFlag.setAlpha(fade);
		subTitleFlag.setAlpha(fade);
	}
	
	private void unFadeStuff(){
		float fade = 1.0f;
		mImageView.setAlpha(fade);
		title.setAlpha(fade);
		subTitle.setAlpha(fade);
		titleFlag.setAlpha(fade);
		subTitleFlag.setAlpha(fade);
	}
	@Override
	public void onLanguagePicked(View v, int language) {
		if(v == topChooser){
			Utilities.saveTopLanguage(getActivity(), language);
			callback.onTopPickerClosed();
		}else if(v == bottomChooser){
			Utilities.saveBottomLanguage(getActivity(), language);
			callback.onBottomPickerClosed();
		}
		callback.onLanguageChanged();
	}
	
	public void onLanguageChanged(){
		title.setText(Animal.getAnimalName(getActivity(), Utilities.getTopLanguage(getActivity()), animal));
		subTitle.setText(Animal.getAnimalName(getActivity(), Utilities.getBottomLanguage(getActivity()), animal));
		titleFlag.setImageResource(Utilities.getFlagResource(getActivity(), Utilities.getTopLanguage(getActivity())));
		subTitleFlag.setImageResource(Utilities.getFlagResource(getActivity(), Utilities.getBottomLanguage(getActivity())));
	}
	
	public void onTopPickerOpened(){
		topChooser.setVisibility(View.VISIBLE);
		fadeStuff();
	}
	
	public void onTopPickerClosed() {
		topChooser.setVisibility(View.GONE);
		unFadeStuff();
	}

	public void onBottomPickerOpened() {
		bottomChooser.setVisibility(View.VISIBLE);
		fadeStuff();
	}

	public void onBottomPickerClosed() {
		bottomChooser.setVisibility(View.GONE);
		unFadeStuff();
	}
	
	public boolean onBackPressed(){
		if(bottomChooser.getVisibility() == View.VISIBLE){
			callback.onBottomPickerClosed();
			return true;
		}else if(topChooser.getVisibility() == View.VISIBLE){
			callback.onTopPickerClosed();
			return true;
		}
		return false;
	}
	
	
	
	
	
	
}
