package com.example.animalflashcards;

import java.util.Locale;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class Animal {
	public static final int BEAR = 0;
    public static final int BEE = 1;
    public static final int ELK = 2;
    public static final int FROG = 3;
    public static final int GIRAFFE = 4;
    public static final int GOAT = 5;
    public static final int HIPPO = 6;
    public static final int KANGAROO = 7;
    public static final int LEOPARD = 8;
    public static final int LION = 9;
    public static final int LLAMA = 10;
    public static final int MONKEY = 11;
    public static final int MOOSE = 12;
    public static final int OSTRICH = 13;
    public static final int OWL = 14;
    public static final int PANDA = 15;
    public static final int PEACOCK = 16;
    public static final int PENGUIN = 17;
    public static final int RHINO = 18;
    public static final int SQUIRREL = 19;
    public static final int WALRUS = 20;
    public static final int WEASEL = 21;
    public static final int YAK = 22;
    public static final int ZEBRA = 23;
	public static final int NUMBER_OF_ANIMALS = 24;
    private static String[] animalNamesEnglish;
    private static String[] animalNamesFrench;
    private static String[] animalNamesSpanish;
    public enum Language{
    	ENGLISH, FRENCH, SPANISH
    }
    
    /**
     * 
     * @param animal
     * @return the res id for the animal
     */
	public static int getImgResources(int animal){
		switch(animal){
		case BEAR:
			return R.drawable.bear;
        case BEE:
        	return R.drawable.bee;
        case ELK:
        	return R.drawable.elk;
        case FROG:
        	return R.drawable.frog;
        case GIRAFFE:
        	return R.drawable.girafe;
        case GOAT:
        	return R.drawable.goat;
        case HIPPO:
        	return R.drawable.hippo;
        case KANGAROO:
        	return R.drawable.kangaroo;
        case LEOPARD:
        	return R.drawable.leopard;
        case LION:
        	return R.drawable.lion;
        case LLAMA:
        	return R.drawable.llama;
        case MONKEY:
        	return R.drawable.monkey;
        case MOOSE:
        	return R.drawable.moose;
        case OSTRICH:
        	return R.drawable.ostrich;
        case OWL:
        	return R.drawable.owl;
        case PANDA:
        	return R.drawable.panda;
        case PEACOCK:
        	return R.drawable.peacock;
        case PENGUIN:
        	return R.drawable.penguin;
        case RHINO:
        	return R.drawable.rhino;
        case SQUIRREL:
        	return R.drawable.squirrel;
        case WALRUS:
        	return R.drawable.walrus;
        case WEASEL:
        	return R.drawable.weasel;
        case YAK:
        	return R.drawable.yak;
        case ZEBRA:
        	return R.drawable.zebra;
		}
		return 0;
	}
	
	public static String getAnimalName(Context context, int animal, Language language){
		if(animalNamesEnglish == null || animalNamesFrench == null || animalNamesSpanish == null){
			Resources standardResources = context.getResources();
			AssetManager assets = standardResources.getAssets();
			DisplayMetrics metrics = standardResources.getDisplayMetrics();
			
			Configuration englishConfig = new Configuration(standardResources.getConfiguration());
			englishConfig.locale = Locale.ENGLISH;
			Resources englishResources = new Resources(assets, metrics, englishConfig);
			animalNamesEnglish = englishResources.getStringArray(R.array.animal_names);
			
			Configuration frenchConfig = new Configuration(standardResources.getConfiguration());
			frenchConfig.locale = Locale.FRENCH;
			Resources frenchResources = new Resources(assets, metrics, frenchConfig);
			animalNamesFrench = frenchResources.getStringArray(R.array.animal_names);
			
			Configuration spanishConfig = new Configuration(standardResources.getConfiguration());
			spanishConfig.locale = new Locale("es", "ES");
			Resources spanishResources = new Resources(assets, metrics, spanishConfig);
			animalNamesSpanish = spanishResources.getStringArray(R.array.animal_names);
			
		}
		switch(language){
		case FRENCH:
			return animalNamesFrench[animal];
		case SPANISH:
			return animalNamesSpanish[animal];
		default:
			return animalNamesEnglish[animal];
		}
	}
}
