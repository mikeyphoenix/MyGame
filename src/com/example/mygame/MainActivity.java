package com.example.mygame;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.mygame.activity.AddTransactionActivity;
import com.example.mygame.constants.Constants;

public class MainActivity extends Activity {

	private Button btnSyncSmsInbox;
	private Button btnAddTransaction;
	private Button btnViewTransactions;
	private Button btnBudget;
	private Cursor cursor;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnSyncSmsInbox = (Button)findViewById(R.id.btnSyncSmsInbox);
		btnAddTransaction = (Button) findViewById(R.id.btnAddTransaction);
		btnViewTransactions = (Button) findViewById(R.id.btnViewTransactions);
		btnBudget = (Button) findViewById(R.id.btnBudget);
		
		
		btnSyncSmsInbox.setOnClickListener(syncSmsOnClickListener());
		btnAddTransaction.setOnClickListener(addTransactionOnClicklistener());
		btnViewTransactions.setOnClickListener(viewTransactionsOnClicklistener());
		btnBudget.setOnClickListener(budgetOnClicklistener());
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
	
	private OnClickListener syncSmsOnClickListener() {
		return new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Uri inboxUri = Uri.parse(Constants.SMS_INBOX_CONTENT_PROVIDER_URI);
				ContentResolver cr = getContentResolver();
				String [] projection = new String[] {"_id", "address", "date", "body"};
				cursor = cr.query(inboxUri, projection, null, null, null);
				while (cursor.moveToNext()) {
					String body = cursor.getString(3);
					Toast.makeText(getApplicationContext(), body, Toast.LENGTH_LONG).show();;
				}
			}
		};
	}
	
	private OnClickListener addTransactionOnClicklistener() {
		return new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AddTransactionActivity.class);
				startActivity(intent);
			}
		};
	}
	
	private OnClickListener viewTransactionsOnClicklistener() {
		return new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AddTransactionActivity.class);
				startActivity(intent);
			}
		};
	}
	
	private OnClickListener budgetOnClicklistener() {
		return new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AddTransactionActivity.class);
				startActivity(intent);
			}
		};
	}
}
