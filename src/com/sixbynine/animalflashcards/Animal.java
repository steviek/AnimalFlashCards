package com.sixbynine.animalflashcards;

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
    private static String[][] animalNames;
    
    
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
	
	public static String getAnimalName(Context context, int language, int animal){
		if(animalNames == null){
			animalNames = new String[Language.NUMBER_OF_LANGUAGES][Animal.NUMBER_OF_ANIMALS];
			for(int i = 0; i < Language.NUMBER_OF_LANGUAGES; i ++){
				animalNames[i] = Language.getResources(context, i).getStringArray(R.array.animal_names);
			}
			
		}
		return animalNames[language][animal];
	}
}
