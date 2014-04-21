package com.sixbynine.animalflashcards;


import android.content.Context;
import android.content.SharedPreferences;

public class Utilities {

	public static int getTopLanguage(Context context){
		SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_MULTI_PROCESS);
		String lng = prefs.getString("topLang", "en");
		if(lng.equals("fr")){
			return Language.FRENCH;
		}else if(lng.equals("es")){
			return Language.SPANISH;
		}else{
			return Language.ENGLISH;
		}
	}
	
	public static int getBottomLanguage(Context context){
		SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_MULTI_PROCESS);
		String lng = prefs.getString("botLang", "fr");
		if(lng.equals("fr")){
			return Language.FRENCH;
		}else if(lng.equals("es")){
			return Language.SPANISH;
		}else{
			return Language.ENGLISH;
		}
	}
	
	public static void saveTopLanguage(Context context, int lang){
		SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_MULTI_PROCESS);
		if(lang == Language.FRENCH){
			prefs.edit().putString("topLang", "fr").commit();
		}else if(lang == Language.SPANISH){
			prefs.edit().putString("topLang", "es").commit();
		}else{
			prefs.edit().putString("topLang", "en").commit();
		}
	}
	
	public static void saveBottomLanguage(Context context, int lang){
		SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_MULTI_PROCESS);
		if(lang == Language.FRENCH){
			prefs.edit().putString("botLang", "fr").commit();
		}else if(lang == Language.SPANISH){
			prefs.edit().putString("botLang", "es").commit();
		}else{
			prefs.edit().putString("botLang", "en").commit();
		}
	}
	
	public static int getFlagResource(Context context, int lang){
		if(lang == Language.FRENCH){
			return R.drawable.flag_fr;
		}else if(lang == Language.SPANISH){
			return R.drawable.flag_es;
		}else{
			return R.drawable.flag_en;
		}
	}
}
