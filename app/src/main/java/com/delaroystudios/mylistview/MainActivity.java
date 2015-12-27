package com.delaroystudios.mylistview;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements OnItemClickListener {

	String[] member_names;
	TypedArray profile_pics;
	String[] statues;
	String[] contactType;

	List<RowItem> rowItems;
	ListView mylistview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		rowItems = new ArrayList<RowItem>();

		member_names = getResources().getStringArray(R.array.Member_names);

		profile_pics = getResources().obtainTypedArray(R.array.profile_pics);

		statues = getResources().getStringArray(R.array.statues);

		contactType = getResources().getStringArray(R.array.contactType);

		for (int i = 0; i < member_names.length; i++) {
			RowItem item = new RowItem(member_names[i],
					profile_pics.getResourceId(i, -1), statues[i],
					contactType[i]);
			rowItems.add(item);
		}

		mylistview = (ListView) findViewById(R.id.list);
		CustomAdapter adapter = new CustomAdapter(this, rowItems);
		mylistview.setAdapter(adapter);

		mylistview.setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		String member_name = rowItems.get(position).getMember_name();
		Toast.makeText(getApplicationContext(), "" + member_name,
				Toast.LENGTH_SHORT).show();
	}

}
