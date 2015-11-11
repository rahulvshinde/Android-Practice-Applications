package com.example.rahul.simpledb;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener
{


    My_Database my_database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my_database = new My_Database(this);
        Button insert_Button = (Button)findViewById(R.id.addbutton);
        insert_Button.setOnClickListener((android.view.View.OnClickListener) this);
        Log.d("text", "testing onCreate!");
        Button read_Button = (Button)findViewById(R.id.getbutton);
        read_Button.setOnClickListener((android.view.View.OnClickListener) this);

    }

    public void onClick(View view)
    {
         int myId= view.getId();
         if(myId == R.id.addbutton) {
             EditText editText = (EditText) findViewById(R.id.addtext);
             my_database.addText(editText.getText().toString());
         }
         else
         if(myId == R.id.getbutton)
         {
                 TextView textView = (TextView)findViewById(R.id.displaytext);
                 textView.setText(my_database.getText());
         }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
class My_Database extends SQLiteOpenHelper
{

    public static final String db_name = "my_db1";
    public static final int db_version = 1;
    private static final String tb_name = "my_table";
    Context myContext;

    public My_Database(Context context)
    {
        super(context, db_name, null, db_version);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try
        {
            db.execSQL("CREATE TABLE IF NOT EXISTS " + tb_name + " (text1 VARCHAR UNIQUE);");
        }
        catch(Exception e)
        {
            Log.d("On create ERROR : ", e.toString());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        try
        {
            db.execSQL("DROP TABLE IF EXISTS " + tb_name);
            onCreate(db);
        }
        catch(Exception e)
        {
            Log.d("On Upgrade error:  ", e.toString());
        }
    }

    public boolean addText (String text)
    {
        try
        {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            Log.d("Databse Insert data: ", "INSERT OR REPLACE into "+tb_name+ " (text1) Values ("+text+");");
            sqLiteDatabase.execSQL("INSERT OR REPLACE INTO "+tb_name+" (text1) Values (\"" +text+ "\");");
            Log.d("Current Databse", "reached here");
            sqLiteDatabase.close();
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }

    public String getText()
    {
        String return_str = " ";
        try
        {
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " +tb_name+ "(text1 VARCHAR UNIQUE);");
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " +tb_name, null);
            Log.d("Cursor is here: ", cursor.toString());
            if(cursor != null)
            {
                if(cursor.moveToFirst())
                {
                    do
                    {
                        String txt = cursor.getString(0);
                        return_str= return_str + txt+"\n";
                        Log.d("Output of return_str", return_str);
                    } while(cursor.moveToNext());
                }
            }
            Log.d("Cursor is here: ", cursor.toString());
            sqLiteDatabase.close();
        }
        catch (Exception e)
        {
            return "";
        }
        return return_str;
    }
}