package com.example.mygame.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlLiteDBOpenHelper extends SQLiteOpenHelper{

	private SQLiteDatabase database; 

	final private static String NAME = "artist_db";
	final private static Integer VERSION = 1;
	final private Context mContext;
	
	public SqlLiteDBOpenHelper(Context context) {
		super(context, NAME, null, VERSION);
		this.mContext = context;
		
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}		
	
	
}
