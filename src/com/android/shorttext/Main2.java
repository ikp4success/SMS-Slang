package com.android.shorttext;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class Main2 extends Fragment {
	String[] slangs = { "<3", "?", "?4U", ";S", "ZZZZ" };
	AutoCompleteTextView myAutoComplete;

	/** Called when the activity is first created. */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.gc();
		View v = inflater.inflate(R.layout.main2, container, false);
		myAutoComplete = (AutoCompleteTextView) v
				.findViewById(R.id.autoCompleteTextView1);

		myAutoComplete.setAdapter(new ArrayAdapter<String>(this.getActivity(),
				android.R.layout.simple_dropdown_item_1line, slangs));
		return v;
		// TODO Auto-generated method stub
	}

}
