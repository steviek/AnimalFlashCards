package com.sixbynine.animalflashcards;

import java.util.Locale;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public final class Language {
	public static final int ENGLISH = 0;
	public static final int FRENCH = 1;
	public static final int SPANISH = 2;
	public static final int NUMBER_OF_LANGUAGES = 3;
	
	public static Resources getResources(Context context, int language){
		Resources standardResources = context.getResources();
		AssetManager assets = standardResources.getAssets();
		DisplayMetrics metrics = standardResources.getDisplayMetrics();
		
		Configuration config = new Configuration(standardResources.getConfiguration());
		switch(language){
		case FRENCH:
			config.locale = Locale.FRENCH;
			break;
		case SPANISH:
			config.locale = new Locale("es", "ES");
			break;
		default:
			config.locale = Locale.ENGLISH;
		}
		
		return new Resources(assets, metrics, config);
	}
	
}
