package com.example.rahul.filemanipulator1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;


public class MainActivity extends Activity {

    EditText editview1;
    TextView textview1;
    Button read1;
    Button write1;
    Button append1;
    File myfile = new File(Environment.getExternalStorageDirectory()+"/myfile.txt");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editview1 = (EditText) findViewById(R.id.editview1);
        textview1 = (TextView) findViewById(R.id.textview1);
        read1 = (Button) findViewById(R.id.read);
        write1 = (Button) findViewById(R.id.write);
        append1 = (Button) findViewById(R.id.append);

        write1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                try
                {
                    if(!myfile.exists())
                        myfile.createNewFile();

                    FileWriter fw = new FileWriter(myfile);
                    BufferedWriter bw = new BufferedWriter(fw);
                    //bw.append((CharSequence) editview1);
                    Toast.makeText(getApplicationContext(),"Successfully replaced text from file",Toast.LENGTH_SHORT).show();
                    bw.write(editview1.getText().toString());

                    bw.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    textview1.setText("");
                    editview1.setText("");
                }
            }
        });

        read1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                try
                    {
                        if(!myfile.exists())
                            Toast.makeText(getApplicationContext(),"File Not Found",Toast.LENGTH_SHORT).show();
                            //myfile.createNewFile();

                        StringBuilder sb = new StringBuilder();
                        FileReader fr = new FileReader(myfile);
                        BufferedReader br = new BufferedReader(fr);
                        //StringBuffer sb = new StringBuffer();

                        String line;
                        while((line = br.readLine())!=null)
                        {
                           sb.append(line);
                            sb.append('\n');
                        }

                        br.close();

                        textview1.setText(sb);
                     //   Toast.makeText(getApplicationContext(),"Successfully fetched data from file",Toast.LENGTH_SHORT).show();
                    }

                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    finally
                    {
                      //  textview1.setText("");
                        editview1.setText("");
                    }

            }
        });

        append1.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                try
                {
                    if(!myfile.exists())
                        myfile.createNewFile();

                    FileWriter fw = new FileWriter(myfile,true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    if(!editview1.getText().toString().isEmpty())
                    {
                        bw.write("\n" + editview1.getText().toString());
                        Toast.makeText(getApplicationContext(), "Successfully added text to the end of file", Toast.LENGTH_LONG).show();
                    }
                    //bw.write(editview1.getText().toString());

                    bw.close();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    textview1.setText("");
                    editview1.setText("");
                }
            }

        });



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
