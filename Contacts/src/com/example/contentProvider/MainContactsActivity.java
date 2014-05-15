package com.example.contentProvider;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainContactsActivity extends Activity {
	
	private ArrayList<String> list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activitycontacts_main);
		String[] contacts=new String[]{
			ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
			ContactsContract.CommonDataKinds.Phone.NUMBER
		};
		
		Uri uri=ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
		
		ContentResolver cr=getContentResolver();
		Cursor managedCursor=cr.query(uri, contacts, null, null, null);
		
		managedCursor.moveToFirst();
		list=new ArrayList<String>();
		do{
			int nameIndex=managedCursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
			String name=managedCursor.getString(nameIndex);
			
			int numberIndex=managedCursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER);
			String number=managedCursor.getString(numberIndex);
			
			list.add(name+":"+number);
		}while(managedCursor.moveToNext());
		
		ListView listView=(ListView) findViewById(R.id.listContacts);
		ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		listView.setAdapter(arrayAdapter);
	}
}