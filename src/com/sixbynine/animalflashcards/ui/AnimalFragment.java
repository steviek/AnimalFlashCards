package com.sixbynine.animalflashcards.ui;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sixbynine.animalflashcards.R;
import com.sixbynine.animalflashcards.ui.LanguagePicker.OnLanguagePickedListener;
import com.sixbynine.animalflashcards.util.Animal;
import com.sixbynine.animalflashcards.util.Utilities;

public class AnimalFragment extends Fragment implements OnLanguagePickedListener{
	private ImageView mAnimalImageView;
	private LanguagePicker mLanguagePickerBottom;
	private LanguagePicker mLanguagePickerTop;
	private ImageView mTitleFlag;
	private TextView mSubTitleTextView;
	private ImageView mSubTitleFlag;
	private TextView mTitleTextView;
	
	private Callback mCallback;
	
	private int mAnimalId;
	
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
			mCallback = (Callback) activity;
		}else{
			throw new IllegalStateException(activity.getClass().toString() + " must implement interface Callback");
		}
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Bundle args = getArguments();
		if(args != null){
			this.mAnimalId = args.getInt("animal", -1);
		}
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_animal, null);
		mAnimalImageView = (ImageView) view.findViewById(R.id.imageView);
		mTitleTextView = (TextView) view.findViewById(R.id.title);
		mSubTitleTextView = (TextView) view.findViewById(R.id.subTitle);
		mTitleFlag = (ImageView) view.findViewById(R.id.titleFlag);
		mSubTitleFlag = (ImageView) view.findViewById(R.id.subTitleFlag);
		
		mLanguagePickerTop = (LanguagePicker) view.findViewById(R.id.flags_chooser_top);
		mLanguagePickerTop.setOnLanguagePickedListener(this);
		mLanguagePickerBottom = (LanguagePicker) view.findViewById(R.id.flags_chooser_bottom);
		mLanguagePickerBottom.setOnLanguagePickedListener(this);
		
		mTitleFlag.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCallback.onTopPickerOpened();
			}
		});
		mSubTitleFlag.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCallback.onBottomPickerOpened();
			}
		});
		
		int imgRes = Animal.getImgResources(mAnimalId);
		if(imgRes == 0){
			mAnimalImageView.setVisibility(View.INVISIBLE);
		}else{
			mAnimalImageView.setVisibility(View.VISIBLE);
			mAnimalImageView.setImageResource(imgRes);
		}
		
		mTitleTextView.setText(Animal.getAnimalName(getActivity(), Utilities.getTopLanguage(getActivity()), mAnimalId));
		mSubTitleTextView.setText(Animal.getAnimalName(getActivity(), Utilities.getBottomLanguage(getActivity()), mAnimalId));
		mTitleFlag.setImageResource(Utilities.getFlagResource(getActivity(), Utilities.getTopLanguage(getActivity())));
		mSubTitleFlag.setImageResource(Utilities.getFlagResource(getActivity(), Utilities.getBottomLanguage(getActivity())));
		return view;
		
	}
	
	private void fadeStuff(){
		float fade = 0.3f;
		mAnimalImageView.setAlpha(fade);
		mTitleTextView.setAlpha(fade);
		mSubTitleTextView.setAlpha(fade);
		mTitleFlag.setAlpha(fade);
		mSubTitleFlag.setAlpha(fade);
	}
	
	private void unFadeStuff(){
		float fade = 1.0f;
		mAnimalImageView.setAlpha(fade);
		mTitleTextView.setAlpha(fade);
		mSubTitleTextView.setAlpha(fade);
		mTitleFlag.setAlpha(fade);
		mSubTitleFlag.setAlpha(fade);
	}
	@Override
	public void onLanguagePicked(View v, int language) {
		if(v == mLanguagePickerTop){
			Utilities.saveTopLanguage(getActivity(), language);
			mCallback.onTopPickerClosed();
		}else if(v == mLanguagePickerBottom){
			Utilities.saveBottomLanguage(getActivity(), language);
			mCallback.onBottomPickerClosed();
		}
		mCallback.onLanguageChanged();
	}
	
	public void onLanguageChanged(){
		mTitleTextView.setText(Animal.getAnimalName(getActivity(), Utilities.getTopLanguage(getActivity()), mAnimalId));
		mSubTitleTextView.setText(Animal.getAnimalName(getActivity(), Utilities.getBottomLanguage(getActivity()), mAnimalId));
		mTitleFlag.setImageResource(Utilities.getFlagResource(getActivity(), Utilities.getTopLanguage(getActivity())));
		mSubTitleFlag.setImageResource(Utilities.getFlagResource(getActivity(), Utilities.getBottomLanguage(getActivity())));
	}
	
	public void onTopPickerOpened(){
		mLanguagePickerTop.setVisibility(View.VISIBLE);
		fadeStuff();
	}
	
	public void onTopPickerClosed() {
		mLanguagePickerTop.setVisibility(View.GONE);
		unFadeStuff();
	}

	public void onBottomPickerOpened() {
		mLanguagePickerBottom.setVisibility(View.VISIBLE);
		fadeStuff();
	}

	public void onBottomPickerClosed() {
		mLanguagePickerBottom.setVisibility(View.GONE);
		unFadeStuff();
	}
	
	public boolean onBackPressed(){
		if(mLanguagePickerBottom.getVisibility() == View.VISIBLE){
			mCallback.onBottomPickerClosed();
			return true;
		}else if(mLanguagePickerTop.getVisibility() == View.VISIBLE){
			mCallback.onTopPickerClosed();
			return true;
		}
		return false;
	}

}
