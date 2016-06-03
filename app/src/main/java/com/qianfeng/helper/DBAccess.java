package com.qianfeng.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2016/6/2 0002.
 */
public class DBAccess {
    private MyHelper helper;
    public DBAccess(Context context){
        helper=MyHelper.getInstance(context);
    }
    public void insert(User user){
        SQLiteDatabase db=helper.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",user.getName());
        values.put("age",user.getAge());
        values.put("sex",user.getSex());
        db.insert("user",null,values);
        db.close();
    }
    public Cursor query(){
        SQLiteDatabase db=helper.getReadableDatabase();
        Cursor cursor=db.query(true,"user",null,null,null, null, null, null, null);
        return cursor;
    }

}
