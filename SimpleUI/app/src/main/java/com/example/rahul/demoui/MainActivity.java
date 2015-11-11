package com.example.rahul.demoui;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
           final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            final RelativeLayout r1= (RelativeLayout) rootView.findViewById(R.id.relativelayout1);
            final Button b1 = (Button) rootView.findViewById(R.id.button1);
            final Button b2 =  (Button) rootView.findViewById(R.id.button2);
            final Button b3 =  (Button) rootView.findViewById(R.id.button3);


            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView text1=(TextView) rootView.findViewById(R.id.textview1);
                    TextView text2=(TextView) rootView.findViewById(R.id.textview2);

                    r1.setBackgroundColor(Color.CYAN);
                    text2.setTextColor(Color.MAGENTA);
                    text1.setTextColor(Color.MAGENTA);

                    b1.setTextColor(Color.MAGENTA);
                    b1.setBackgroundColor(Color.CYAN);
                    text1.setText("Background Color is CYAN.");
                    text2.setText("Text Color is MAGENTA.");

                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView text1=(TextView) rootView.findViewById(R.id.textview1);
                    TextView text2=(TextView) rootView.findViewById(R.id.textview2);
                    r1.setBackgroundColor(Color.RED);
                    text2.setTextColor(Color.YELLOW);
                    text1.setTextColor(Color.YELLOW);
                    b2.setTextColor(Color.YELLOW);
                    b2.setBackgroundColor(Color.RED);
                    text1.setText("Background Color is RED.");
                    text2.setText("Text Color is YELLOW.");

                }
            });

            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView text1=(TextView) rootView.findViewById(R.id.textview1);
                    TextView text2=(TextView) rootView.findViewById(R.id.textview2);

                    r1.setBackgroundColor(Color.GREEN);
                    text2.setTextColor(Color.RED);
                    text1.setTextColor(Color.RED);
                    b3.setTextColor(Color.RED);
                    b3.setBackgroundColor(Color.GREEN);
                    text1.setText("Background color is GREEN.");
                    text2.setText("Text Color is RED.");

                }
            });
            return rootView;
        }
    }
}
