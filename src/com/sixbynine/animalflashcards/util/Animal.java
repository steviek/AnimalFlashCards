package com.sixbynine.animalflashcards.util;

import android.content.Context;

import com.sixbynine.animalflashcards.R;

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
    private static final String[][] animalNames = {
    	{"Bear","Bee","Elk","Frog","Giraffe","Goat","Hippo","Kangaroo","Leopard","Lion","Llama","Monkey","Moose","Ostrich","Owl","Panda","Peacock","Penguin","Rhino","Squirrel","Walrus","Weasel","Yak","Zebra"},
    	{"L'ours","L'abeille","L'élan","La grenouille","La girafe","La chèvre","L'hippopotame","Le kangourou","Le léopard","Le lion","Le lama","Le singe","L'orignal","L'autruche","Le hibou","Le panda","Le paon","Le manchot","Le rhinocéros","L'écureil","Le morse","La belette","Le yak","Le zèbre"},
    	{"El oso","La abeja","El wapití","La rana","La jirafa","La cabra","El hipopótamo","El canguro","El leopardo","El león","La llama","El mono","El alce","El avestruz","El búho","El panda","El pavo real","El pingüino","El rinoceronte","La ardilla","La morsa","La comadreja","El yak","La cebra"},
    };
    
    
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
		return animalNames[language][animal];
	}
}
