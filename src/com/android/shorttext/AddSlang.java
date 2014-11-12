package com.android.shorttext;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddSlang extends Fragment {
	Button addSlang;
	String To;
	EditText slang;
	EditText Mslang;
	String subject = "New Slang from SMS Slang App User";
	View v;

	/** Called when the activity is first created. */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

		final int height = dm.heightPixels;
		final int width = dm.widthPixels;
		if ((height == 1280) && (width == 800)) {
			v = inflater.inflate(R.layout.addslang_7inch, container, false);
		}else if ((height == 1024) && (width == 600)) {
			v = inflater.inflate(R.layout.addslang_7inch, container, false);
		}
		else if ((height > 960) && (width > 730)) {
			v = inflater.inflate(R.layout.addslang_tablet, container, false);
		} else if ((height < 480) && (width < 320)) {
			v = inflater.inflate(R.layout.addslang_small, container, false);
		} else {
			v = inflater.inflate(R.layout.addslang, container, false);
		}

		addSlang = (Button) v.findViewById(R.id.adslng);
		To = "smsslang@gmail.com";
		slang = (EditText) v.findViewById(R.id.slng);
		Mslang = (EditText) v.findViewById(R.id.Mslang);
		
		InputMethodManager imm = (InputMethodManager) getActivity()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(slang.getWindowToken(), 0);

		addSlang.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String slang2 = slang.getText().toString();
				String Mslang2 = Mslang.getText().toString();
				if ((slang2.equals("") || slang2.equals(" "))) {
					Toast display = Toast.makeText(AddSlang.this.getActivity(),
							"Add Slang TextBox is Empty", Toast.LENGTH_SHORT);// toast
					display.show();
				} else if ((Mslang2.equals("") || Mslang2.equals(" "))) {
					Toast display = Toast.makeText(AddSlang.this.getActivity(),
							"Slang Meaning TextBox is Empty",
							Toast.LENGTH_SHORT);// toast
					display.show();
				} else {

					String Ms = "Slang:" + slang2 + "\n" + "\n"
							+ "Slang Meaning:" + Mslang2;

					Intent email = new Intent(Intent.ACTION_SEND);
					email.putExtra(Intent.EXTRA_EMAIL, new String[] { To });
					// email.putExtra(Intent.EXTRA_CC, new String[]{ to});
					// email.putExtra(Intent.EXTRA_BCC, new String[]{to});
					email.putExtra(Intent.EXTRA_SUBJECT, subject);

					email.putExtra(Intent.EXTRA_TEXT, Ms);

					// need this to prompts email client only
					email.setType("message/rfc822");

					startActivity(Intent.createChooser(email,
							"Choose an Email client :"));
					getActivity().finish();
				}

			}
		});

		return v;
		// TODO Auto-generated method stub
	}

}
