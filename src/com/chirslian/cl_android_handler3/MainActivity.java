package com.chirslian.cl_android_handler3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

	private Handler handler;
	private Button  button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
			
        	int i = 0;
			@Override
			public void onClick(View v) {
				Message msg = handler.obtainMessage();
				msg.what = i++;
				handler.sendMessage(msg);
			}
		});
        
        WorkThread wt = new WorkThread();
        wt.start();
        
    }
    
    class WorkThread extends Thread{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			
			Looper.prepare();
			handler = new Handler(){

				@Override
				public void handleMessage(Message msg) {
					System.out.println("get message what = "+msg.what);
				}
			};
			Looper.loop();
			
		}
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
