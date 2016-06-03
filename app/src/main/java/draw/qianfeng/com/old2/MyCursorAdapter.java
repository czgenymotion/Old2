package draw.qianfeng.com.old2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/2 0002.
 */
public class MyCursorAdapter extends CursorAdapter{

    public MyCursorAdapter(Context context, Cursor cursor){
        super(context, cursor, FLAG_REGISTER_CONTENT_OBSERVER);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        View v=LayoutInflater.from(context).inflate(R.layout.adapter_list,parent,false);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor){
        if(view!=null){
            TextView name= (TextView) view.findViewById(R.id.showname);
            TextView age= (TextView) view.findViewById(R.id.showage);
            TextView sex= (TextView) view.findViewById(R.id.showsex);

            name.setText(cursor.getString(cursor.getColumnIndex("name")));
            age.setText(cursor.getString(cursor.getColumnIndex("age")));
            sex.setText(cursor.getString(cursor.getColumnIndex("sex")));
        }
    }
}
