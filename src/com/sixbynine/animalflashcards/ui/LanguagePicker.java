package com.sixbynine.animalflashcards.ui;

import com.sixbynine.animalflashcards.R;
import com.sixbynine.animalflashcards.util.Language;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class LanguagePicker extends LinearLayout{

	private OnLanguagePickedListener mListener;
	
	public interface OnLanguagePickedListener{
		public void onLanguagePicked(View v, int language);
	}
	
	public LanguagePicker(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.setOrientation(VERTICAL);
		this.setBackgroundColor(0xFFFFFFFF);
		this.setGravity(Gravity.CENTER);
		
		LayoutInflater.from(context).inflate(R.layout.flags_chooser, this, true);
		
		findViewById(R.id.btn_flag_en).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mListener != null){
					mListener.onLanguagePicked(LanguagePicker.this, Language.ENGLISH);
				}
				
			}
		});
		
		findViewById(R.id.btn_flag_fr).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mListener != null){
					mListener.onLanguagePicked(LanguagePicker.this, Language.FRENCH);
				}
				
			}
		});
		
		findViewById(R.id.btn_flag_es).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mListener != null){
					mListener.onLanguagePicked(LanguagePicker.this, Language.SPANISH);
				}
				
			}
		});
		
	}

	public void setOnLanguagePickedListener(OnLanguagePickedListener listener) {
		this.mListener = listener;
	}
	
	

	
	
}
