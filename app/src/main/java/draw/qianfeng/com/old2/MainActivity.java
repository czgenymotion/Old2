package draw.qianfeng.com.old2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.qianfeng.helper.DBAccess;
import com.qianfeng.helper.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener, View.OnClickListener{

    private EditText name;
    private EditText age;
    private RadioGroup rg;
    private String names;
    private String ages;
    private String sexs;
    private User user;
    private DBAccess db = new DBAccess(this);
    private Button btn1;
    private Button btn2;
    private List<User> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(this);
        //
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        //
        initView();
    }

    private void initView(){

        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        rg = (RadioGroup) findViewById(R.id.sex);
        btn1 = (Button) findViewById(R.id.addd);
        btn2 = (Button) findViewById(R.id.neverr);
        ListView listView = (ListView) findViewById(R.id.listView);
        MyCursorAdapter adapter = new MyCursorAdapter(this,db.query());
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if(id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item){
        switch(item.getItemId()){
            case R.id.add:
                Log.e("tag", "add");
                showCustomer();
                break;
            case R.id.query:
                Log.e("tag", "qeury");
                break;
        }
        return true;
    }

    private void showCustomer(){
        user = new User();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(R.layout.customer_list);
        builder.setTitle("添加学员");
        final AlertDialog dialog = builder.show();
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        Toast.makeText(this,"aa",Toast.LENGTH_SHORT).show();
    }
}
