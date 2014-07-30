package com.kince.progressrectangle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RecActivity extends Activity {

	boolean running;
	int progress = 0;
	ProgressRectangle progressRectangle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rec);
		
		progressRectangle=(ProgressRectangle) findViewById(R.id.progressBar);
		 final Runnable r = new Runnable() {
				public void run() {
					running = true;
					while(progress<100) {
						progressRectangle.incrementProgress();
						progress++;
						try {
							Thread.sleep(15);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					while(progress>0) {
						progressRectangle.unIncrementProgress();
						progress--;
						try {
							Thread.sleep(15);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
		
					running = false;
				}
	        };
	        
		Button increment = (Button) findViewById(R.id.btn_increment);
        increment.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(!running) {
					progress = 0;
					Thread s = new Thread(r);
					s.start();
				}
			}
        });
	}
}
