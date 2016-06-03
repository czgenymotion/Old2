package com.qianfeng.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/2 0002.
 */
public class MyHelper extends SQLiteOpenHelper{
    private static MyHelper helper=null;


    private MyHelper(Context context){
        super(context, "user.db", null, 1);
    }
    public static MyHelper getInstance(Context context){
        Log.e("aa", "cc" );
        if(helper==null){
            synchronized(MyHelper.class){
                if(helper==null){
                    helper=new MyHelper(context);
                    Log.e("aa", "ddd" );
                    return  helper;
                }

            }
        }
        return helper;
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        Log.e("aa", "bb" );
        String sql="create table user(_id integer primary key autoincrement,name text," +
                "age text,sex text)";
        Log.e("aa", "aa" );
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
    }
}
