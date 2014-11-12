package com.android.shorttext;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Fragment {
	String input;
	Intent nextActivity;
	ImageView IMV;
	EditText ET;
	Toast display;
	AutoCompleteTextView myAutoComplete;
	View v;
	// TextView text;
	String[] slangs = { "<3", "?", "?4U", ";S", "^^", "<3", "@TEOTD", "121",
			"14AA41", "10X", "1CE", "1DR", "2", "2EZ", "2G2BT", "2M2H", "2MI",
			"2MOR", "2NTE", "4", "404", "411", "4COL", "4EAE", "4NR", "^5",
			"511", "555", "6Y", "7K", "73", "86", "88", "*s*", "*w*", "A3",
			"AA", "AAF", "AAK", "AAMOF", "AAMOI", "AAP", "AAR", "AATK", "ABT",
			"ABT2", "ABTA", "ACD", "ACDNT", "ACK", "ACPT", "ACQSTN", "ADAD",
			"ADBB", "ADD", "ADR", "ADIP", "ADMIN", "ADMINR", " AEAP", "AF",
			"AFC", "AFAIAA", "AFAIC", "AFAIK", "AFAP", "AFJ", "AFK", "AH",
			"AIGHT", "AIR", "AISB", "AISI", "AKA", "ALCON", "ALOL", "AMAP",
			"AMBW", "AML", "AMOF", "AOTA", "APAC", "AQAP", "ARE", "ASIG",
			"ASAP", "A/S/L", "ASL", "ASLA", "AT", "ATB", "ATEOTD", "ATM",
			"ATSITS", "ATSL", "AWESO", "AWOL", "AYDY", "AYEC", "AYOR", "AYSOS",
			"AYS", "AYT", "AYTMTB", "B", "B&", "B2W", "B8", "B9", "B/F", "B/G",
			"B4", "B4N", "BAK", "BAS", "BASOR", "BAU", "BAY", "BB", "BBC",
			"BBIAB", "BBIAF", "BBIAM", "BBIAS", "BBL", "BBN", "BBS", "BBT",
			"BC", "B/C", "BCNU", "BCOS", "BD", "BDAY", "B-DAY", "BDN", "BEG",
			"BF", "BFAW", "BFF", "BFFL", "BFFLNMW", "BFD", "BFG", "BFFN",
			"BFN", "BG", "BGWM", "BHL8", "BPLM", "BRB", "BRD", "BRH", "BRT",
			"BSF", "BSTS", "BT", "BTA", "BTDT", "BTW", "BWL", "BWTHDIK",
			"BYOB", "BYOC", "BYTM", "C4N", "C&G", "CAD", "CAM", "CB", "CFS",
			"CFY", "CIAO", "CICO", "CID", "CLAB", "CM", "CMB", "CMIIW", "CMON",
			"CNP", "CRB", "CRBT", "CRS", "CSG", "CSL", "CT", "CTC", "CTHU",
			"CU", "CUL", "CUL8ER", "CUMID", "CURLO", "CWOT", "CWYL", "CYA",
			"CYAL8R", "CYE", "CYO", "DA", "DBAU", "DC", "DD", "DE", "DF",
			"DFLA", "DGAF", "DIIK", "DIS", "DITYID", "DIY", "DIKU", "DKDC",
			"DL", "D/L", "DLTBBB", "DM", "DN", "DNC", "DNR", "DNT", "d00d",
			"DOM", "DOS", "DP", "DQMOT", "DR", "DTR", "DTRT", "DTS", "DTTD",
			"DUPE", "DUR", "DV8", "DWB", "DXNRY", "DYNWUTB", "DYFI", "DYOR",
			"E", "E1", "E123", "E2E", "E2EG", "EAK", "EBKAC", "EF4T", "EG",
			"EI", "EIP", "EMA", "EMFBI", "EMSG", "ENUF", "EOD", "EOL", "EOM",
			"EOS", "EOT", "ERS2", "ES", "ETA", "ETLA", "EVA", "EVO", "EYC",
			"EZ", "EZY", "F", "F2F", "FAAK", "FAF", "FAQ", "FBF", "FBM",
			"FBOW", "FC", "FFS", "FICCL", "FIIK", "FIIOOH", "FIL", "FISH",
			"FIMH", "FITB", "FLA", "FMTYEWTK", "FOMC", "FOMCL", "FOAD", "FOAF",
			"FRT", "FTBOMH", "FTW", "FU", "FUBAR", "FUBB", "FUD", "FW", "FWM",
			"FWIW", "FYEO", "FYA", "FYI", "G", "G/F", "G2CU", "G2G", "G4C",
			"G9", "GA", "GAL", "GAS", "GB", "GBTW", "GBU", "GDR", "GFI", "GF",
			"GFN", "GG", "GGMSOT", "GGOH", "GIGO", "GIAR", "GIRL", "GIWIST",
			"GJ", "GL", "GMBA", "GMTA", "GMAB", "GN", "GNE1", "GNIGHT",
			"GNITE", "GNSD", "GOL", "GOI", "GR8", "GRATZ", "GRL", "GRWG",
			"GR&D", "GS", "GTRM", "GTSY", "GT", "GTFO", "GTG", "GUD", "GWHTLC",
			"H", "H8", "H8TTU", "H&K", "H2CUS", "HAGN", "HAGO", "HAG1", "HAND",
			"HAK", "HAU", "HB", "H-BDAY", "HBU", "HF", "HFAC", "H-FDAY",
			"HHIS", "HIG", "HLA", "H-MDAY", "HNL", "HOAS", "HP", "HRU", "HTH",
			"HT", "HUB", "HUYA", "HV", "HW", "I2", "IA8", "IAAA", "IAAD",
			"IAAL", "IANAC", "IAC", "IAE", "IAO", "IAW", "IB", "IC", "ICAM",
			"ICBW", "ICEDI", "ICFILWU", "IDC", "IDK", "IDTS", "IDUNNO", "IFYP",
			"IG2R", "IGHT", "IGN", "IHNI", "IHA", "IHU", "IIRC", "IIIO", "IK",
			"IKR", "ILBL8", "ILU", "ILY", "IM", "IMAO", "IMCO", "IMHO",
			"IMing", "IMNSHO", "IMO", "IMS", "IMSB", "IMTM", "IMU", "IOMH",
			"IOW", "IRL", "ITA", "ITIGBS", "IRMC", "ISLY", "ITYK", "IWAWO",
			"IWIAM", "IWALU", "IYO", "IYSS", "IYSWIM", "j00", "j00r", "J4G",
			"JAC", "JAM", "JBOD", "JFF", "JFGI", "JIC", "JK", "j/k", "JLMK",
			"JP", "JMO", "JTLYK", "JW", "k", "KK", "k/b", "KB", "KDFU", "KEWL",
			"KEYA", "KEYME", "KFY", "KIA", "KISS", "KIT", "KOC", "KOTC",
			"KOTL", "KPC", "KUTGW", "KWIM?", "L2G", "L2K", "l33t", "L8R",
			"L8R G8R", "LBAY", "LEMENO", "LGH", "LHM", "LHO", "LIC", "LIK",
			"LIMT", "LLGB", "LERK", "LD", "LDR", "LLTA", "LMAO", "LMSO",
			"LMFAO", "LMIRL", "LMK", "LMNK", "LNT", "LOA", "LOL", "LOLO",
			"LOTI", "LRF", "LQTM", "LSHMBH", "LSV", "LTD", "LTNS", "LTR",
			"LULAB", "LULAS", "LUWAMH", "LY", "LY4E", "LTS", "LULT", "LULZ",
			"LVM", "LWOS", "LYLAS", "LYLC", "LYSM", "M8", "MB", "MC", "MEGO",
			"MEH", "MEHH", "MFI", "MGB", "MIRL", "MKAY", "MLM", "MNC", "MNSG",
			"MorF", "MOOS", "MOSS", "MOTOS", "MSG", "MTF", "MTFBWU", "MUSM",
			"MUAH", "MWAH", "MYO", "MYOB", "n00b", "N1", "N2M", "NADT",
			"NALOPKT", "NANA", "NBD", "NE", "NE1", "NFM", "NFS", "NFW", "NFWS",
			"NIGI", "NIMBY", "NIROK", "NLT", "NM", "NMH", "NMU", "NO1", "NOYB",
			"NP", "NQT", "NFG", "N/P", "NRN", "NSA", "NSFW", "NSISR", "NT",
			"NTHING", "NVM", "NVR", "NW", "NWO", "O4U", "O", "OA", "OATUS",
			"OB", "OI", " ", "OIC", "OLL", "OIB", "OJ", "OL", "OM", "OMG",
			"OMGYG2BK", "OMW", "ONL", "OTF", "OTOH", "OTTOMH", "OO", "OOC",
			"OOH", "OOTD", "OOTO", "OP", "ORLY", "OT", "OTB", "", "OTFL",
			"OTL", "OTP", "OTT", "OTW", "OVA", "OYO", "P2P", "PANS", "PAW",
			"PCMCIA", "PCM", "PDA", "PDH", "PDS", "PDQ", "PEBCAK", "PEEPS",
			"PFT", "PIC", "PIR", "PISS", "PIBKAC", "PITA", "PL8", "PLD",
			"PLMK", "PLS", "PLU", "PLZ", "PM", "PMFI", "PMFJI", "POAHF",
			"::POOF::", "POTS", "POS", "POV", "PPL", "PPU", "PROLLY", "PROGGY",
			"PRON", "PRT", "PRW", "PSOS", "PSP", "PTL", "PTMM", "PU", "PWN",
			"PXT", "PZ", "PZA", "Q", "QFE", "QFI", "QIK", "QL", "QQ", "QSL",
			"QSO", "QT", "QTPI", "R8", "RBAY", "RIP", "RL", "RLY", "RME",
			"RMLB", "RMMM", "ROR", "ROTFL", "ROFL", "ROTFLMAO", "ROFLMAO",
			"ROFLCOPTER", "ROTFLUTS", "RPG", "RSN", "RT", "RTBS", "RTFM",
			"RTFQ", "RTNTN", "RTRMT", "RTSM", "RU", "RUMOF", "RUT", "RUOK",
			"RX", "RW", "RYB", "RYS", "RYO", "S^", "SH^", "S2R", "S2S", "S4L",
			"SAL", "SBT", "SC", "SDMB", "SETE", "SF", "SFAIK", "SH", "SHCOON",
			"SHID", "SICNR", "SIG2R", "SIHTH", "SIMYC", "SIR", "SIS", "SIT",
			"SK8", "SK8NG", "SK8R", "SLAP", "SMHID", "SNAFU", "SNERT", "SN",
			"SO", "S'OK", "SOL", "SOMY", "SorG", "SOS", "SOT", "SOTMG", "SOWM",
			"SPK", "SRSLY", "SPST", "SPTO", "SQ", "SRY", "SS", "SSDD", "SSIF",
			"SSINF", "STW", "ST&D", "STFU", "STR8", "SUITM", "SUL", "SUP",
			"SUX", "SU", "SUAKM", "SWAK", "SWALK", "SWAT", "SWL", "SWMBO",
			"SWAG", "SYL", "SYS", "T+", "T4BU", "T:)T", "TA", "TAFN", "TAM",
			"TANK", "TANKED", "TANKING", "TARFU", "TAU", "TAUMUALU",
			"TANSTAAFL", "TBC", "TBD", "TBH", "TB4U", "TBL", "TC", "TCB",
			"TCOY", "TFS", "TGIF", "THX", "THNX", "THNQ", "THT", "TILII",
			"TIA", "TIAD", "TIC", "TILIS", "TLK2UL8R", "TL", "TLA", "TTYAFN",
			"TMI", "TMB", "TMOT", "TMTH", "TMWFI", "TNSTAAFL", "TNT", "TOPCA",
			"TOY", "TOJ", "TOS", "TOU", "TPM", "TPTB", "TQ", "TSH", "TSNF",
			"TSTB", "TTLY", "TTTT", "TTUL", "TTG", "TTFN", "TTT", "TTYL",
			"TTYS", "TU", "TWSS", "TY", "TYFYC", "TYS", "TYT", "TYSO", "TYVM",
			"^URS", "UAPITA", "UAF", "UCMU", "UDI", "UDM", "UDS", "UFN",
			"UGTBK", "UKTR", "UL", "U-L", "UNA", "UN4TUN8", "UNBLEFBLE",
			"UNCRTN", "UNPC", "UOK", "UR", "UR2YS4ME", "URA*", "URH", "URL",
			"URSKTM", "URTM", "URW", "USBCA", "USU", "UT2L", "UV", "UW", "VBS",
			"VEG", "VFF", "VFM", "VGC", "VIP", "VM", "VN", "VRY", "VSC", "VSF",
			"VBG", "W@", "W/", "W/B", "W3", "WWW", "W8", "WAG", "WAYD", "WAH",
			"WAJ", "WAM", "WAN2", "WAN2TLK", "WAREZ", "WAS", "WAWA", "WAYF",
			"WB", "WBS", "WBU", "WC", "WCA", "WDALYIC", "WDYK", "WDYT", "WE",
			"W/E", "W/END", "WFM", "WIBNI", "WH5", "WIIFM", "WISP", "WITP",
			"WITW", "WIU", "WK", "WKD", "WL", "W/O", "WOMBAT", "WRT", "WRK",
			"WRU@", "WRUD", "WTF", "WTFE", "WTG", "WTGP", "WTH", "WTM", "WT?",
			"WTGP?", "WU?", "WU", "WUW", "WUU2", "WUF?", "WWNC", "WWYC",
			"WYCM", "WYD", "WYGAM", "WYHAM", "WYLEI", "WYWH", "WYSITWIRL",
			"WYSIWYG", "X-1-10", "X", "X!", "XD", "XME", "XOXOXO", "XLNT",
			"XLR8", "XYL", "XYZ", "Y?", "Y", "Y2K", "YA", "YAA", "YABA",
			"YARLY", "YBIC", "YBS", "YCDBWYCID", "YCHT", "YCLIU", "YCMU", "YF",
			"YG", "YGTBKM", "YHBW", "YHL", "YIU", "YKW", "YKWYCD", "YL",
			"YMMV", "YNK", "YR", "YRYOCC", "YSIC", "YSYD", "YT", "YTTL", "YTG",
			"YWHOL", "YWSYLS", "YYSSW", "YW", "Z", "Z%", "ZH", "ZOT", "ZUP",
			"ZZZZ" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.gc();
		// DisplayMetrics metrics = new DisplayMetrics();
		// double screenHeight = metrics.heightPixels *
		// getResources().getDisplayMetrics().density;
		// double screenWidth = metrics.widthPixels *
		// getResources().getDisplayMetrics().density;
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

		final int height = dm.heightPixels;
		final int width = dm.widthPixels;
		if ((height == 1280) && (width == 800)) {
			v = inflater.inflate(R.layout.main_7inch, container, false);
		}else if ((height == 1024) && (width == 600)) {
			v = inflater.inflate(R.layout.main_7inch, container, false);
		}
		else if ((height > 960) && (width > 730)) {
			v = inflater.inflate(R.layout.main_tablet, container, false);
		} else if ((height < 480) && (width < 320)) {
			v = inflater.inflate(R.layout.main_small, container, false);
		} else {
			v = inflater.inflate(R.layout.main, container, false);
		}

		// TextView txt = (TextView) v.findViewById(R.id.custom_font);
		Typeface font = Typeface.createFromAsset(getActivity().getAssets(),
				"fonts/the beautiful ones.ttf");
//		TextView text = (TextView) v.findViewById(R.id.tv1);
//		text.setText("Resolution" + "\n" + height + "\n" + "\n" + width);
		// txt.setTypeface(font);
		// txt.setTextSize(25);

		myAutoComplete = (AutoCompleteTextView) v
				.findViewById(R.id.autoCompleteTextView3);

		myAutoComplete.setAdapter(new ArrayAdapter<String>(this.getActivity(),
				android.R.layout.simple_dropdown_item_1line, slangs));

		myAutoComplete.setTextSize(20);

		InputMethodManager imm = (InputMethodManager) getActivity()
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(myAutoComplete.getWindowToken(), 0);

		IMV = (ImageView) v.findViewById(R.id.imv);
		// BT.setTypeface(font);
		// BT.setTextSize(20);

		// // Setup the Intent that will start the next Activity
		// nextActivity = new Intent(Main.this.getActivity(), Display.class);
		// // Assumes this references this instance of Activity A
		// nextActivity.putExtra("KEY", input);

		IMV.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// display = Toast.makeText(Main.this.getActivity(),
				// "There are no videos to play", Toast.LENGTH_SHORT);// toast

				// Bundle b = new Bundle();
				// b.putString("Key", input);

				// display.show();
				// Main.this.getActivity().startActivity(nextActivity);
				input = myAutoComplete.getText().toString().replaceAll(" ", "");
				if (input.toString().equals("") || input.toString().equals(" ")) {
					display = Toast.makeText(Main.this.getActivity(),
							"TextBox Empty", Toast.LENGTH_SHORT);// toast
					display.show();
				}// big if
				else {
					// Toast display2 = Toast.makeText(Main.this.getActivity(),
					// "Translating", Toast.LENGTH_SHORT);// toast
					// display2.show();
					if ("wtf".equalsIgnoreCase(input.toString())) {
						showPopup("	WHAT THE FUCK	");
					} else if ("!".equalsIgnoreCase(input.toString())) {
						showPopup("	I have a comment	");
					} else if ("*$".equalsIgnoreCase(input.toString())) {
						showPopup("	Starbucks	");
					} else if ("**//".equalsIgnoreCase(input.toString())) {
						showPopup("	it means wink wink, nudge nudge	");
					} else if (",!!!!".equalsIgnoreCase(input.toString())) {
						showPopup("	talk to the hand	");
					} else if ("02".equalsIgnoreCase(input.toString())) {
						showPopup("	Your (or my) two cents worth");
					} else if ("10Q".equalsIgnoreCase(input.toString())) {
						showPopup("	thank you	");
					} else if ("1174".equalsIgnoreCase(input.toString())) {
						showPopup("	Nude club	");
					} else if ("121".equalsIgnoreCase(input.toString())) {
						showPopup("	One to one	");
					} else if ("1337".equalsIgnoreCase(input.toString())) {
						showPopup("	Elite -or- leet -or- L337	");
					} else if ("143".equalsIgnoreCase(input.toString())) {
						showPopup("	I love you	");
					} else if ("1432".equalsIgnoreCase(input.toString())) {
						showPopup("	I Love You Too	");
					} else if ("14AA41".equalsIgnoreCase(input.toString())) {
						showPopup("	One for All and All for One	");
					} else if ("182I".equalsIgnoreCase(input.toString())) {
						showPopup("	hate you");
					} else if ("187".equalsIgnoreCase(input.toString())) {
						showPopup("	it means murder/ homicide");
					} else if ("190".equalsIgnoreCase(input.toString())) {
						showPopup("	hand");
					} else if ("20".equalsIgnoreCase(input.toString())) {
						showPopup("	Location");
					} else if ("2b@".equalsIgnoreCase(input.toString())) {
						showPopup("	To Be At");
					} else if ("2BZ4UQT".equalsIgnoreCase(input.toString())) {
						showPopup("Too	Busy For You Cutey");
					} else if ("2G2B4G".equalsIgnoreCase(input.toString())) {
						showPopup("Too	Good To Be Forgotten");
					} else if ("2G2BT".equalsIgnoreCase(input.toString())) {
						showPopup("Too	Good To Be True");
					} else if ("2moro".equalsIgnoreCase(input.toString())) {
						showPopup("	Tomorrow");
					} else if ("2nite".equalsIgnoreCase(input.toString())) {
						showPopup("	Tonight");
					} else if ("2U2".equalsIgnoreCase(input.toString())) {
						showPopup("	To You Too");
					} else if ("303".equalsIgnoreCase(input.toString())) {
						showPopup("	Mom");
					} else if ("404".equalsIgnoreCase(input.toString())) {
						showPopup("	I haven't a clue");
					} else if ("411".equalsIgnoreCase(input.toString())) {
						showPopup("	Information");
					} else if ("420".equalsIgnoreCase(input.toString())) {
						showPopup("	Marijuana");
					} else if ("459".equalsIgnoreCase(input.toString())) {
						showPopup("	I love you");
					} else if ("4COL".equalsIgnoreCase(input.toString())) {
						showPopup("	For Crying Out Loud");
					} else if ("4EAE".equalsIgnoreCase(input.toString())) {
						showPopup("	ForEver And Ever");
					} else if ("4eva".equalsIgnoreCase(input.toString())) {
						showPopup("	forever");
					} else if ("4ever".equalsIgnoreCase(input.toString())) {
						showPopup("	Forever");
					} else if ("4NR".equalsIgnoreCase(input.toString())) {
						showPopup("	Foreigner");
					} else if ("4Q".equalsIgnoreCase(input.toString())) {
						showPopup("	Fuck You");
					} else if ("511".equalsIgnoreCase(input.toString())) {
						showPopup("	Too much information");
					} else if ("53X".equalsIgnoreCase(input.toString())) {
						showPopup("	Sex");
					} else if ("5FS5".equalsIgnoreCase(input.toString())) {
						showPopup("	 Finger Salute");
					} else if ("8".equalsIgnoreCase(input.toString())) {
						showPopup("	 Oral sex");
					} else if ("831".equalsIgnoreCase(input.toString())) {
						showPopup("	 I Love You");
					} else if ("86".equalsIgnoreCase(input.toString())) {
						showPopup("	 Out of, over");
					} else if ("9".equalsIgnoreCase(input.toString())) {
						showPopup("	 Parent is watching");
					} else if ("99".equalsIgnoreCase(input.toString())) {
						showPopup("	 Parent is no longer watching");
					} else if ("::poof::".equalsIgnoreCase(input.toString())) {
						showPopup("	 i'm gone");
					} else if ("<3".equalsIgnoreCase(input.toString())) {
						showPopup("	 heart");
					} else if ("?".equalsIgnoreCase(input.toString())) {
						showPopup("	 I have a question");
					} else if ("?^".equalsIgnoreCase(input.toString())) {
						showPopup("	 hook up?");
					} else if ("@".equalsIgnoreCase(input.toString())) {
						showPopup("	 French equivalent of CUL8R");
					} else if ("@TEOT".equalsIgnoreCase(input.toString())) {
						showPopup("	 DAt The End Of The Day");
					} else if ("A/N".equalsIgnoreCase(input.toString())) {
						showPopup("	 Author's Note");
					} else if ("AAAAA".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	 American Association Against Acronym Abuse");
					} else if ("AAFAs".equalsIgnoreCase(input.toString())) {
						showPopup("	 A Friend -or- Always And Forever");
					} else if ("AAK".equalsIgnoreCase(input.toString())) {
						showPopup("	 Asleep At Keyboard");
					} else if ("AAMOF".equalsIgnoreCase(input.toString())) {
						showPopup("	 As A Matter Of Fact");
					} else if ("AAMOI".equalsIgnoreCase(input.toString())) {
						showPopup("	 As A Matter Of Interest");
					} else if ("AAR".equalsIgnoreCase(input.toString())) {
						showPopup("	 At Any Rate");
					} else if ("AAR8".equalsIgnoreCase(input.toString())) {
						showPopup("	 At Any Rate");
					} else if ("AAS".equalsIgnoreCase(input.toString())) {
						showPopup("	 Alive And Smiling");
					} else if ("AATK".equalsIgnoreCase(input.toString())) {
						showPopup("	 Always At The Keyboard");
					} else if ("AB".equalsIgnoreCase(input.toString())) {
						showPopup("	 Ass Backwards");
					} else if ("abt".equalsIgnoreCase(input.toString())) {
						showPopup("	 about");
					} else if ("ABITHIWTITB".equalsIgnoreCase(input.toString())) {
						showPopup("	 A Bird In The Hand " + "\n" + "\n"
								+ "Is Worth Two In The Bush");
					} else if ("ABT2".equalsIgnoreCase(input.toString())) {
						showPopup("	 About To");
					} else if ("ACD".equalsIgnoreCase(input.toString())) {
						showPopup("	 Alt Control Delete");
					} else if ("ACE".equalsIgnoreCase(input.toString())) {
						showPopup("	 Access Control Entry");
					} else if ("ACK".equalsIgnoreCase(input.toString())) {
						showPopup("	 Acknowledgement");
					} else if ("ACORNA".equalsIgnoreCase(input.toString())) {
						showPopup("	 Completely Obsessive Really Nutty person");
					} else if ("ADAD".equalsIgnoreCase(input.toString())) {
						showPopup("	 Another Day Another Dollar");
					} else if ("ADBB".equalsIgnoreCase(input.toString())) {
						showPopup("	 All Done Bye Bye");
					} else if ("addy".equalsIgnoreCase(input.toString())) {
						showPopup("	 address");
					} else if ("ADIH".equalsIgnoreCase(input.toString())) {
						showPopup("	 Another Day In Hell");
					} else if ("ADIP".equalsIgnoreCase(input.toString())) {
						showPopup("	 Another Day In Paradise");
					} else if ("ADN".equalsIgnoreCase(input.toString())) {
						showPopup("	 Any Day Now");
					} else if ("ADR".equalsIgnoreCase(input.toString())) {
						showPopup("	 Address");
					} else if ("ADVD".equalsIgnoreCase(input.toString())) {
						showPopup("	 Advised");
					} else if ("AEAP".equalsIgnoreCase(input.toString())) {
						showPopup("	 As Early As Possible");
					} else if ("AFAGAY".equalsIgnoreCase(input.toString())) {
						showPopup("	 A Friend As Good As You");
					} else if ("AFAHMASP".equalsIgnoreCase(input.toString())) {
						showPopup("	 A Fool And His Money Are Soon Parted");
					} else if ("AFAIC".equalsIgnoreCase(input.toString())) {
						showPopup("	 As Far As I'm Concerned");
					} else if ("AFAICS".equalsIgnoreCase(input.toString())) {
						showPopup("	 As Far As I Can See");
					} else if ("AFAICT".equalsIgnoreCase(input.toString())) {
						showPopup("	 As Far As I Can Tell");
					} else if ("AFAIK".equalsIgnoreCase(input.toString())) {
						showPopup("	 As Far As I Know");
					} else if ("AFAIR".equalsIgnoreCase(input.toString())) {
						showPopup("	 As Far As I Remember");
					} else if ("AFAIU".equalsIgnoreCase(input.toString())) {
						showPopup("	 As Far As I Understand");
					} else if ("AFAIUI".equalsIgnoreCase(input.toString())) {
						showPopup("	 As Far As I Understand It");
					} else if ("AFAP".equalsIgnoreCase(input.toString())) {
						showPopup("	 As Far As Possible");
					} else if ("AFAYC".equalsIgnoreCase(input.toString())) {
						showPopup("	 As Far As You're Concerned");
					} else if ("AFC".equalsIgnoreCase(input.toString())) {
						showPopup("	 Away From Computer");
					} else if ("AFDN".equalsIgnoreCase(input.toString())) {
						showPopup("	 Any Fucking Day Now");
					} else if ("AFGO".equalsIgnoreCase(input.toString())) {
						showPopup("	 Another F***ing Growth Opportunity");
					} else if ("AFIAA".equalsIgnoreCase(input.toString())) {
						showPopup("	 As Far As I Am Aware");
					} else if ("AFINIAFI".equalsIgnoreCase(input.toString())) {
						showPopup("	 A Friend In Need Is A Friend Indeed");
					} else if ("AFJ".equalsIgnoreCase(input.toString())) {
						showPopup("	April Fools Joke");
					} else if ("AFK".equalsIgnoreCase(input.toString())) {
						showPopup("	Away From Keyboard");
					} else if ("AFPOE".equalsIgnoreCase(input.toString())) {
						showPopup("	A Fresh Pair Of Eyes");
					} else if ("AFT".equalsIgnoreCase(input.toString())) {
						showPopup("	About Fucking Time");
					} else if ("AFU".equalsIgnoreCase(input.toString())) {
						showPopup("	All Fucked Up");
					} else if ("AFZ".equalsIgnoreCase(input.toString())) {
						showPopup("	Acronym Free Zone");
					} else if ("AGB".equalsIgnoreCase(input.toString())) {
						showPopup("	Almost Good Bridge");
					} else if ("AGKWE".equalsIgnoreCase(input.toString())) {
						showPopup("	And God Knows What Else");
					} else if ("AIAMU".equalsIgnoreCase(input.toString())) {
						showPopup("	And I'm A Monkey's Uncle");
					} else if ("aight".equalsIgnoreCase(input.toString())) {
						showPopup("	all right");
					} else if ("AIH".equalsIgnoreCase(input.toString())) {
						showPopup("	As It Happens");
					} else if ("AIMB".equalsIgnoreCase(input.toString())) {
						showPopup("	As It Happens");
					} else if ("AIMP".equalsIgnoreCase(input.toString())) {
						showPopup("	Always In My Prayers");
					} else if ("AISB".equalsIgnoreCase(input.toString())) {
						showPopup("	As I Said Before");
					} else if ("AISE".equalsIgnoreCase(input.toString())) {
						showPopup("	As I Said Earlier");
					} else if ("AISI".equalsIgnoreCase(input.toString())) {
						showPopup("	As I See It");
					} else if ("AITR".equalsIgnoreCase(input.toString())) {
						showPopup("	Adult In The Room");
					} else if ("AKA".equalsIgnoreCase(input.toString())) {
						showPopup("	Adult In The Room");
					} else if ("a.k.a".equalsIgnoreCase(input.toString())) {
						showPopup("	Also Known As");
					} else if ("ALAP".equalsIgnoreCase(input.toString())) {
						showPopup("	Also Known As");
					} else if ("ALAP".equalsIgnoreCase(input.toString())) {
						showPopup("	As Late As Possible");
					} else if ("alcon".equalsIgnoreCase(input.toString())) {
						showPopup("	All Concerned");
					} else if ("ALOL".equalsIgnoreCase(input.toString())) {
						showPopup("	Actually Laughing Out Loud");
					} else if ("ALOTBSOL".equalsIgnoreCase(input.toString())) {
						showPopup("	Always Look On The Bright Side Of Life");
					} else if ("ALTGAct".equalsIgnoreCase(input.toString())) {
						showPopup("	Locally, Think Globally");
					} else if ("AMAP".equalsIgnoreCase(input.toString())) {
						showPopup("	As Many As Possible" + "\n" + "\n"
								+ "	As Much As Possible");
					} else if ("AMBW".equalsIgnoreCase(input.toString())) {
						showPopup("	All My Best Wishes");
					} else if ("AMF".equalsIgnoreCase(input.toString())) {
						showPopup("	Adios Mother Fucker");
					} else if ("AML".equalsIgnoreCase(input.toString())) {
						showPopup("	All My Love");
					} else if ("AMRMTYFTS".equalsIgnoreCase(input.toString())) {
						showPopup("	All My Roommates Thank You For The Show");
					} else if ("ANFAWFOS".equalsIgnoreCase(input.toString())) {
						showPopup("	And Now For A Word From Our Sponsor");
					} else if ("ANFSCD".equalsIgnoreCase(input.toString())) {
						showPopup("	And Now For Something Completely Different");
					} else if ("ANGB".equalsIgnoreCase(input.toString())) {
						showPopup("	Almost Nearly Good Bridge");
					} else if ("AOAS".equalsIgnoreCase(input.toString())) {
						showPopup("	All Of A Sudden");
					} else if ("AOB".equalsIgnoreCase(input.toString())) {
						showPopup("	Abuse Of Bandwidth");
					} else if ("AON".equalsIgnoreCase(input.toString())) {
						showPopup("	Apropos Of Nothing");
					} else if ("AOR".equalsIgnoreCase(input.toString())) {
						showPopup("	Agency On Record");
					} else if ("AP".equalsIgnoreCase(input.toString())) {
						showPopup("	Apple Pie");
					} else if ("AR".equalsIgnoreCase(input.toString())) {
						showPopup("	Action Required");
					} else if ("AS".equalsIgnoreCase(input.toString())) {
						showPopup("	Another Subject");
					} else if ("ASAFP".equalsIgnoreCase(input.toString())) {
						showPopup("	As Soon As Fucking Possible");
					} else if ("ASAMOF".equalsIgnoreCase(input.toString())) {
						showPopup("	As A Matter Of Fact");
					} else if ("ASAP".equalsIgnoreCase(input.toString())) {
						showPopup("	As Soon As Possible");
					} else if ("ASAYGT".equalsIgnoreCase(input.toString())) {
						showPopup("	As Soon As You Get This");
					} else if ("ATAB".equalsIgnoreCase(input.toString())) {
						showPopup("	Ain't That A Bitch");
					} else if ("ATC".equalsIgnoreCase(input.toString())) {
						showPopup("	Any Two Cards");
					} else if ("ATM".equalsIgnoreCase(input.toString())) {
						showPopup("	At The Moment" + "\n" + "\n"
								+ "Automated Teller Machine" + "\n" + "\n"
								+ "Asynchronous Transfer Mode");
					} else if ("ATSL".equalsIgnoreCase(input.toString())) {
						showPopup("	Along The Same Line" + "\n" + "\n"
								+ "Automated Teller Machine" + "\n" + "\n"
								+ "Asynchronous Transfer Mode");
					} else if ("ATST".equalsIgnoreCase(input.toString())) {
						showPopup("	At The Same Time" + "\n" + "\n"
								+ "Automated Teller Machine" + "\n" + "\n"
								+ "Asynchronous Transfer Mode");
					} else if ("ATW".equalsIgnoreCase(input.toString())) {
						showPopup("	All The Web" + "\n" + "\n"
								+ "Around The Web" + "\n" + "\n"
								+ "All The Way");
					} else if ("AUNT".equalsIgnoreCase(input.toString())) {
						showPopup("	And U Know This");
					} else if ("AUNTM".equalsIgnoreCase(input.toString())) {
						showPopup("	And U Know This Man");
					} else if ("AWC".equalsIgnoreCase(input.toString())) {
						showPopup("	After While, Crocodile");
					} else if ("AWGTHTGTTA".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	Are We Going To Have To Go Through This Again");
					} else if ("AWHFY".equalsIgnoreCase(input.toString())) {
						showPopup("	Are We Having Fun Yet?");
					} else if ("AWLTP".equalsIgnoreCase(input.toString())) {
						showPopup("	Avoiding Work Like The Plague");
					} else if ("AWNIAC".equalsIgnoreCase(input.toString())) {
						showPopup("	All We Need Is Another Chair");
					} else if ("AWOL".equalsIgnoreCase(input.toString())) {
						showPopup("	Absent Without Leave");
					} else if ("AWTTW".equalsIgnoreCase(input.toString())) {
						showPopup("	A Word To The Wise");
					} else if ("AYC".equalsIgnoreCase(input.toString())) {
						showPopup("	Aren't You Clever" + "\n" + "\n"
								+ "Aren't You Cheeky");
					} else if ("AYCE".equalsIgnoreCase(input.toString())) {
						showPopup("	All You Can Eat");
					} else if ("AYK".equalsIgnoreCase(input.toString())) {
						showPopup("	As You Know");
					} else if ("AYOR".equalsIgnoreCase(input.toString())) {
						showPopup("	At Your Own Risk");
					} else if ("AYSOS".equalsIgnoreCase(input.toString())) {
						showPopup("	Are You Stupid Or Something");
					} else if ("AYTMTB".equalsIgnoreCase(input.toString())) {
						showPopup("	And You're Telling Me This Because");
					} else if ("AYV".equalsIgnoreCase(input.toString())) {
						showPopup("	Are You Vertical?");
					} else if ("B&F".equalsIgnoreCase(input.toString())) {
						showPopup("	Back and Forth");
					} else if ("B/C".equalsIgnoreCase(input.toString())) {
						showPopup("	Because");
					} else if ("B4".equalsIgnoreCase(input.toString())) {
						showPopup("	Before");
					} else if ("B4N".equalsIgnoreCase(input.toString())) {
						showPopup("	Bye For Now");
					} else if ("B4U".equalsIgnoreCase(input.toString())) {
						showPopup("	Before You");
					} else if ("B4YKI".equalsIgnoreCase(input.toString())) {
						showPopup("	Before You Know It");
					} else if ("B@U".equalsIgnoreCase(input.toString())) {
						showPopup("	Back at You");
					} else if ("BAK@U".equalsIgnoreCase(input.toString())) {
						showPopup("	Back at You");
					} else if ("BABY".equalsIgnoreCase(input.toString())) {
						showPopup("	Being Annoyed By You");
					} else if ("BAC".equalsIgnoreCase(input.toString())) {
						showPopup("	Bad Ass Chick");
					} else if ("BAG".equalsIgnoreCase(input.toString())) {
						showPopup("	Busting A Gut" + "\n" + "\n"
								+ "Big Ass Grin");
					} else if ("BAK".equalsIgnoreCase(input.toString())) {
						showPopup("	Back At Keyboard");
					} else if ("BAMF".equalsIgnoreCase(input.toString())) {
						showPopup("	Bad Ass Mother Fucker");
					} else if ("banana".equalsIgnoreCase(input.toString())) {
						showPopup("	code word for penis");
					} else if ("banana".equalsIgnoreCase(input.toString())) {
						showPopup("	code word for penis");
					} else if ("BARB".equalsIgnoreCase(input.toString())) {
						showPopup("	Buy Abroad but Rent in Britain");
					} else if ("BAU".equalsIgnoreCase(input.toString())) {
						showPopup("	Business As Usualn");
					} else if ("BB".equalsIgnoreCase(input.toString())) {
						showPopup("	Busting A Gut" + "\n" + "\n"
								+ "	Buzzard Breath");
					} else if ("BB4N".equalsIgnoreCase(input.toString())) {
						showPopup("	Bye Bye for Now");
					} else if ("BBAMFIC".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Bad Ass Mother Fucker In Charge");
					} else if ("BBB".equalsIgnoreCase(input.toString())) {
						showPopup("	Bye Bye Babe" + "\n" + "\n"
								+ "	Boring Beyond Belief");
					} else if ("BBBG".equalsIgnoreCase(input.toString())) {
						showPopup("	Bye Bye Be Good");
					} else if ("BBFBBM".equalsIgnoreCase(input.toString())) {
						showPopup("	Body By Fisher" + "\n" + "\n"
								+ "	Brains By Mattel");
					} else if ("BBFN".equalsIgnoreCase(input.toString())) {
						showPopup("	Bye Bye for Now");
					} else if ("BBIAB".equalsIgnoreCase(input.toString())) {
						showPopup("	Be Back In A Bit");
					} else if ("BBIAF".equalsIgnoreCase(input.toString())) {
						showPopup("	Be Back In A Few");
					} else if ("BBIAS".equalsIgnoreCase(input.toString())) {
						showPopup("	Be Back In A Sec");
					} else if ("BBIAW".equalsIgnoreCase(input.toString())) {
						showPopup("	Be Back In A While");
					} else if ("BBL".equalsIgnoreCase(input.toString())) {
						showPopup("	Be Back Later");
					} else if ("BBMFIC".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Bad Mother Fucker In Charge");
					} else if ("BBR".equalsIgnoreCase(input.toString())) {
						showPopup("	Burnt Beyond Repair");
					} else if ("BBS".equalsIgnoreCase(input.toString())) {
						showPopup("	Be Back Soon" + "\n" + "\n"
								+ "	Bulletin Board Service");
					} else if ("BBSD".equalsIgnoreCase(input.toString())) {
						showPopup("	Be Back Soon Darling");
					} else if ("BBSL".equalsIgnoreCase(input.toString())) {
						showPopup("	Be Back Sooner or Later");
					} else if ("BBT".equalsIgnoreCase(input.toString())) {
						showPopup("	Be Back Tomorrow");
					} else if ("BBW".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Beautiful Woman" + "\n" + "\n"
								+ "	Big Black Woman");
					} else if ("BC".equalsIgnoreCase(input.toString())) {
						showPopup("	Because");
					} else if ("BCBG".equalsIgnoreCase(input.toString())) {
						showPopup("	Bon Chic Bon Genre" + "\n" + "\n"
								+ "	Belle Cu Belle Geulle");
					} else if ("BCBS".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Company, Big School");
					} else if ("BCNU".equalsIgnoreCase(input.toString())) {
						showPopup("	Be Seeing You");
					} else if ("bcoz".equalsIgnoreCase(input.toString())) {
						showPopup("	because");
					} else if ("BD".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Deal" + "\n" + "\n" + "	Baby Dance"
								+ "\n" + "\n" + "Brain Drain");
					} else if ("BDBI5M".equalsIgnoreCase(input.toString())) {
						showPopup("	Busy Daydreaming Back In 5 Minutes");
					} else if ("BDC".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Dumb Company " + "\n" + "\n"
								+ "	Big Dot Com");
					} else if ("BDN".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Damn Number");
					} else if ("BDSM".equalsIgnoreCase(input.toString())) {
						showPopup("	Bondage" + "\n" + "\n" + "	Dominance"
								+ "\n" + "\n" + "Sadism" + "\n" + "\n"
								+ "Masochism");
					} else if ("BEG".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Evil Grin");
					} else if ("beos".equalsIgnoreCase(input.toString())) {
						showPopup("	Nudge");
					} else if ("BF".equalsIgnoreCase(input.toString())) {
						showPopup("	Boyfriend");
					} else if ("BFD".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Fucking Deal");
					} else if ("BFD".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Fucking Disaster");
					} else if ("BFF".equalsIgnoreCase(input.toString())) {
						showPopup("	Best Friends Forever");
					} else if ("BFFN".equalsIgnoreCase(input.toString())) {
						showPopup("	Best Friends For Now");
					} else if ("BFN".equalsIgnoreCase(input.toString())) {
						showPopup("	Bye For Now");
					} else if ("BFR".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Fucking Rock");
					} else if ("BG".equalsIgnoreCase(input.toString())) {
						showPopup("	Be Good");
					} else if ("BHAG".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Hairy Audacious Goal");
					} else if ("BHG".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Hearted Guy or Girl");
					} else if ("BHIMBGO".equalsIgnoreCase(input.toString())) {
						showPopup("	Bloody Hell, I Must Be Getting Old");
					} else if ("BHOF".equalsIgnoreCase(input.toString())) {
						showPopup("	Bald Headed Old Fart");
					} else if ("BI".equalsIgnoreCase(input.toString())) {
						showPopup("	Business Intelligence");
					} else if ("BI5".equalsIgnoreCase(input.toString())) {
						showPopup("	Back In Five");
					} else if ("BIBI".equalsIgnoreCase(input.toString())) {
						showPopup("	Bye Bye");
					} else if ("BIBO".equalsIgnoreCase(input.toString())) {
						showPopup("	Beer In, Beer Out");
					} else if ("BIF".equalsIgnoreCase(input.toString())) {
						showPopup("	Basis In Fact " + "\n" + "\n"
								+ "	Before I Forget");
					} else if ("BIL".equalsIgnoreCase(input.toString())) {
						showPopup("	Brother-In-Law " + "\n" + "\n"
								+ "	Boss Is Listening");
					} else if ("BIO".equalsIgnoreCase(input.toString())) {
						showPopup("	Bring It On");
					} else if ("BIOIYA".equalsIgnoreCase(input.toString())) {
						showPopup("	Break It Off In Your Ass");
					} else if ("BION".equalsIgnoreCase(input.toString())) {
						showPopup("	Believe It Or Not");
					} else if ("BIOYE".equalsIgnoreCase(input.toString())) {
						showPopup("	Blow It Out Your Ear");
					} else if ("BIOYIOP".equalsIgnoreCase(input.toString())) {
						showPopup("	Blow It Out Your I/O Port");
					} else if ("BIOYN".equalsIgnoreCase(input.toString())) {
						showPopup("	Blow it Out Your Nose");
					} else if ("BITCH".equalsIgnoreCase(input.toString())) {
						showPopup("	Basically In The Clear Homey");
					} else if ("BITD".equalsIgnoreCase(input.toString())) {
						showPopup("	Back In The Day");
					} else if ("BITFOB".equalsIgnoreCase(input.toString())) {
						showPopup("	Bring It The F*** On, Bitch");
					} else if ("BJ".equalsIgnoreCase(input.toString())) {
						showPopup("	Blow Job");
					} else if ("BKA".equalsIgnoreCase(input.toString())) {
						showPopup("	Better Known As");
					} else if ("BL".equalsIgnoreCase(input.toString())) {
						showPopup("	Belly Laughing");
					} else if ("BLBBLB".equalsIgnoreCase(input.toString())) {
						showPopup("	Back Like Bull, Brain Like Bird");
					} else if ("Blkbry".equalsIgnoreCase(input.toString())) {
						showPopup("	Blackberry");
					} else if ("BM".equalsIgnoreCase(input.toString())) {
						showPopup("	Byte Me");
					} else if ("BMF".equalsIgnoreCase(input.toString())) {
						showPopup("	Bad Mother Fucker");
					} else if ("BMGWL".equalsIgnoreCase(input.toString())) {
						showPopup("	Busting My Gut With Laughter");
					} else if ("BMOC".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Man On Campus");
					} else if ("BMOF".equalsIgnoreCase(input.toString())) {
						showPopup("	Bite Me Old Fart");
					} else if ("BMOTA".equalsIgnoreCase(input.toString())) {
						showPopup("	Byte Me On The Ass");
					} else if ("BMS".equalsIgnoreCase(input.toString())) {
						showPopup("	Baby Making Sex");
					} else if ("BNDN".equalsIgnoreCase(input.toString())) {
						showPopup("	Been Nowhere Done Nothing");
					} else if ("BNF".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Name Fan");
					} else if ("BO".equalsIgnoreCase(input.toString())) {
						showPopup("	Bug Off " + "\n" + "\n" + "	Body Odor");
					} else if ("BOB".equalsIgnoreCase(input.toString())) {
						showPopup("	Battery Operated Boyfriend");
					} else if ("BOBFOC".equalsIgnoreCase(input.toString())) {
						showPopup("	Body Off Baywatch, Face Off Crimewatch");
					} else if ("BOCTAAE".equalsIgnoreCase(input.toString())) {
						showPopup("	But Of Course There Are Always Exceptions");
					} else if ("BOFH".equalsIgnoreCase(input.toString())) {
						showPopup("	Bastard Operator From Hell");
					} else if ("BOHICA".equalsIgnoreCase(input.toString())) {
						showPopup("	Bend Over Here It Comes Again");
					} else if ("BON".equalsIgnoreCase(input.toString())) {
						showPopup("	Believe it Or Not");
					} else if ("bookit".equalsIgnoreCase(input.toString())) {
						showPopup("	means cool");
					} else if ("BOTEC".equalsIgnoreCase(input.toString())) {
						showPopup("	Back Of The Envelope Calculation");
					} else if ("BOTOH".equalsIgnoreCase(input.toString())) {
						showPopup("	But On The Other Hand");
					} else if ("BPLM".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Person Little Mind");
					} else if ("BR".equalsIgnoreCase(input.toString())) {
						showPopup("	Bathroom");
					} else if ("BRB".equalsIgnoreCase(input.toString())) {
						showPopup("	Be Right Back");
					} else if ("BRIC".equalsIgnoreCase(input.toString())) {
						showPopup("	Brazil, Russia, India, China");
					} else if ("BRL".equalsIgnoreCase(input.toString())) {
						showPopup("	Belly Roll Laughs");
					} else if ("BRT".equalsIgnoreCase(input.toString())) {
						showPopup("	Be Right There");
					} else if ("BS".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Smile " + "\n" + "\n" + "	Bull Shit"
								+ "\n" + "\n" + " Brain Strai");
					} else if ("BSBD&NE".equalsIgnoreCase(input.toString())) {
						showPopup("	Book Smart, Brain Dead & No Experience");
					} else if ("BSAAW".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Smile And A Wink");
					} else if ("BSEG".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Shit Eating Grin");
					} else if ("BSF".equalsIgnoreCase(input.toString())) {
						showPopup("	But Seriously, Folks");
					} else if ("BSOD".equalsIgnoreCase(input.toString())) {
						showPopup("	Blue Screen of Death");
					} else if ("BT".equalsIgnoreCase(input.toString())) {
						showPopup("	Byte This");
					} else if ("BTA".equalsIgnoreCase(input.toString())) {
						showPopup("	But Then Again " + "\n" + "\n"
								+ "	Before The Attacks");
					} else if ("BTD".equalsIgnoreCase(input.toString())) {
						showPopup("	Bored To Death");
					} else if ("BTDT".equalsIgnoreCase(input.toString())) {
						showPopup("	Been There Done That");
					} else if ("BTDTGTS".equalsIgnoreCase(input.toString())) {
						showPopup("	Been There, Done That, Got The T-shirt");
					} else if ("BTFO".equalsIgnoreCase(input.toString())) {
						showPopup("	Back The Fuck Off " + "\n" + "\n"
								+ "	Bend The Fuck Over");
					} else if ("BTHOOM".equalsIgnoreCase(input.toString())) {
						showPopup("	Beats The Heck Out Of Me");
					} else if ("BTN".equalsIgnoreCase(input.toString())) {
						showPopup("	Better Than Nothing");
					} else if ("BTOIYA".equalsIgnoreCase(input.toString())) {
						showPopup("	Be There Or It's Your Ass");
					} else if ("BTSOOM".equalsIgnoreCase(input.toString())) {
						showPopup("	Beats The Shit Out Of Me");
					} else if ("BTTT".equalsIgnoreCase(input.toString())) {
						showPopup("	Back To The Top");
					} else if ("BTW".equalsIgnoreCase(input.toString())) {
						showPopup("	By The Way");
					} else if ("BTWBO".equalsIgnoreCase(input.toString())) {
						showPopup("	Be There With Bells On");
					} else if ("BTWITIAILWU".equalsIgnoreCase(input.toString())) {
						showPopup("	By The Way I Think I Am In Love With You");
					} else if ("BUFF".equalsIgnoreCase(input.toString())) {
						showPopup("	Big Ugly Fat FUCK");
					} else if ("buh".equalsIgnoreCase(input.toString())) {
						showPopup("	byebye");
					} else if ("BW".equalsIgnoreCase(input.toString())) {
						showPopup("	Best Wishes");
					} else if ("BWDIK".equalsIgnoreCase(input.toString())) {
						showPopup("	But What Do I Know");
					} else if ("BWL".equalsIgnoreCase(input.toString())) {
						showPopup("	Bursting With Laughter");
					} else if ("BWO".equalsIgnoreCase(input.toString())) {
						showPopup("	Black, White or Other");
					} else if ("BWTM".equalsIgnoreCase(input.toString())) {
						showPopup("	But Wait, There's More");
					} else if ("BYKI".equalsIgnoreCase(input.toString())) {
						showPopup("	Before You Know It");
					} else if ("BYKT".equalsIgnoreCase(input.toString())) {
						showPopup("	But You Knew That");
					} else if ("BYOA".equalsIgnoreCase(input.toString())) {
						showPopup("	Bring Your Own Advil");
					} else if ("BYOB".equalsIgnoreCase(input.toString())) {
						showPopup("	Bring Your Own Bottle");
					} else if ("BYOW".equalsIgnoreCase(input.toString())) {
						showPopup("	Build Your Own Website " + "\n" + "\n"
								+ "	Bring Your Own Wine");
					} else if ("BZ".equalsIgnoreCase(input.toString())) {
						showPopup("	Busy");
					} else if ("c ya".equalsIgnoreCase(input.toString())) {
						showPopup("	see ya");
					} else if ("C&G".equalsIgnoreCase(input.toString())) {
						showPopup("	Chuckly and Grin");
					} else if ("C-P".equalsIgnoreCase(input.toString())) {
						showPopup("	Sleepy");
					} else if ("C-T".equalsIgnoreCase(input.toString())) {
						showPopup("	City");
					} else if ("C/P".equalsIgnoreCase(input.toString())) {
						showPopup("	Cross Post");
					} else if ("C/S".equalsIgnoreCase(input.toString())) {
						showPopup("	Change of Subject");
					} else if ("C4N".equalsIgnoreCase(input.toString())) {
						showPopup("	Ciao For Now");
					} else if ("CAAC".equalsIgnoreCase(input.toString())) {
						showPopup("	Cool As A Cucumber");
					} else if ("CAS".equalsIgnoreCase(input.toString())) {
						showPopup("	Crack A Smile");
					} else if ("CB".equalsIgnoreCase(input.toString())) {
						showPopup("	Chat Brat " + "\n" + "\n" + "	Coffee"
								+ "\n" + "\n" + " Break" + "\n" + "\n"
								+ "Call Back");
					} else if ("CBB".equalsIgnoreCase(input.toString())) {
						showPopup("	Can't Be Bothered");
					} else if ("CBF".equalsIgnoreCase(input.toString())) {
						showPopup("	Can't Be Fucked");
					} else if ("CBJ".equalsIgnoreCase(input.toString())) {
						showPopup("	Covered Blow Job");
					} else if ("CD9".equalsIgnoreCase(input.toString())) {
						showPopup("	Code 9 - it means parents are around");
					} else if ("CF".equalsIgnoreCase(input.toString())) {
						showPopup("	Coffee Freak");
					} else if ("CFV".equalsIgnoreCase(input.toString())) {
						showPopup("	Call For Vote");
					} else if ("CHA".equalsIgnoreCase(input.toString())) {
						showPopup("	Click Here Asshole");
					} else if ("CIAO".equalsIgnoreCase(input.toString())) {
						showPopup("	Goodbye (in Italian)");
					} else if ("CICO".equalsIgnoreCase(input.toString())) {
						showPopup("	Coffee In, Coffee Out");
					} else if ("CICYHW".equalsIgnoreCase(input.toString())) {
						showPopup("	Can I Copy Your Home Work");
					} else if ("CID".equalsIgnoreCase(input.toString())) {
						showPopup("	Consider It Done");
					} else if ("CID".equalsIgnoreCase(input.toString())) {
						showPopup("	Crying In Disgrace");
					} else if ("CIL".equalsIgnoreCase(input.toString())) {
						showPopup("	Check In Later");
					} else if ("CINBA".equalsIgnoreCase(input.toString())) {
						showPopup("	Clad In Naught But Air");
					} else if ("CLM".equalsIgnoreCase(input.toString())) {
						showPopup("	Career Limiting Move");
					} else if ("CM".equalsIgnoreCase(input.toString())) {
						showPopup("	Call Me");
					} else if ("CMAP".equalsIgnoreCase(input.toString())) {
						showPopup("	Cover My Ass Partner");
					} else if ("CMF".equalsIgnoreCase(input.toString())) {
						showPopup("	Count My Fingers");
					} else if ("CMIW".equalsIgnoreCase(input.toString())) {
						showPopup("	Correct Me if I'm Wrong");
					} else if ("CMU".equalsIgnoreCase(input.toString())) {
						showPopup("	Crack Me Up");
					} else if ("CNP".equalsIgnoreCase(input.toString())) {
						showPopup("	Continued in Next Post");
					} else if ("COB".equalsIgnoreCase(input.toString())) {
						showPopup("	Close Of Business");
					} else if ("COBRAS".equalsIgnoreCase(input.toString())) {
						showPopup("	Come On By Right After School");
					} else if ("COD".equalsIgnoreCase(input.toString())) {
						showPopup("	Change Of Dressing");
					} else if ("Cof$".equalsIgnoreCase(input.toString())) {
						showPopup("	Church of Scientology");
					} else if ("CofS".equalsIgnoreCase(input.toString())) {
						showPopup("	Church of Scientology");
					} else if ("coo".equalsIgnoreCase(input.toString())) {
						showPopup("	short for cool");
					} else if ("COS".equalsIgnoreCase(input.toString())) {
						showPopup("	Change Of Subject");
					} else if ("CPG".equalsIgnoreCase(input.toString())) {
						showPopup("	Consumer Packaged Goods");
					} else if ("CQRT".equalsIgnoreCase(input.toString())) {
						showPopup("	Security");
					} else if ("CRAFT".equalsIgnoreCase(input.toString())) {
						showPopup("	Can't Remember A Fucking Thing");
					} else if ("CRAP".equalsIgnoreCase(input.toString())) {
						showPopup("	Cheap Redundant Assorted Products");
					} else if ("CRAT".equalsIgnoreCase(input.toString())) {
						showPopup("	Can't Remember A Thing");
					} else if ("CRAWS".equalsIgnoreCase(input.toString())) {
						showPopup("	Can't Remember Anything Worth A Shit");
					} else if ("CRB".equalsIgnoreCase(input.toString())) {
						showPopup("	Come Right Back");
					} else if ("CRBT".equalsIgnoreCase(input.toString())) {
						showPopup("	Crying Real Big Tears");
					} else if ("CRD".equalsIgnoreCase(input.toString())) {
						showPopup("	Caucasian Rhythm Disorder -or- Deficiency");
					} else if ("CRDTCHCK".equalsIgnoreCase(input.toString())) {
						showPopup("	Credit Check");
					} else if ("CRDTCHCK".equalsIgnoreCase(input.toString())) {
						showPopup("	Credit Check");
					} else if ("CRS".equalsIgnoreCase(input.toString())) {
						showPopup("	Can't Remember Shit");
					} else if ("CRTLA".equalsIgnoreCase(input.toString())) {
						showPopup("	Can't Remember the Three-Letter Acronym");
					} else if ("CS".equalsIgnoreCase(input.toString())) {
						showPopup("	Career Suicide");
					} else if ("CSA".equalsIgnoreCase(input.toString())) {
						showPopup("	Career Suicide");
					} else if ("CSABR".equalsIgnoreCase(input.toString())) {
						showPopup("	Continued Success And Best Regards");
					} else if ("CSL".equalsIgnoreCase(input.toString())) {
						showPopup("	Can't Stop Laughing");
					} else if ("CSN".equalsIgnoreCase(input.toString())) {
						showPopup("	Chuckle, Snicker, Grin");
					} else if ("CT".equalsIgnoreCase(input.toString())) {
						showPopup("	Can't Talk");
					} else if ("CTA".equalsIgnoreCase(input.toString())) {
						showPopup("	Call To Action");
					} else if ("CTC".equalsIgnoreCase(input.toString())) {
						showPopup("	Care To Chat " + "\n" + "\n" + "	Contact"
								+ "\n" + "\n" + " Choking The Chicken");
					} else if ("CTC".equalsIgnoreCase(input.toString())) {
						showPopup("	Care To Chat " + "\n" + "\n" + "	Contact"
								+ "\n" + "\n" + " Choking The Chicken");
					} else if ("CTFO".equalsIgnoreCase(input.toString())) {
						showPopup("	Come The Fuck On");
					} else if ("CTMQ".equalsIgnoreCase(input.toString())) {
						showPopup("	Chuckle To Myself Quietly");
					} else if ("CTO".equalsIgnoreCase(input.toString())) {
						showPopup("	Check This Out");
					} else if ("CU".equalsIgnoreCase(input.toString())) {
						showPopup("	See You");
					} else if ("CU".equalsIgnoreCase(input.toString())) {
						showPopup("	Cracking Up");
					} else if ("CU46".equalsIgnoreCase(input.toString())) {
						showPopup("	See You For Sex");
					} else if ("CUATU".equalsIgnoreCase(input.toString())) {
						showPopup("	See You Around The Universe");
					} else if ("CUL8R".equalsIgnoreCase(input.toString())) {
						showPopup("	See You Later");
					} else if ("CULA".equalsIgnoreCase(input.toString())) {
						showPopup("	See You Later Alligator");
					} else if ("CUNS".equalsIgnoreCase(input.toString())) {
						showPopup("	See You In School");
					} else if ("CUOL".equalsIgnoreCase(input.toString())) {
						showPopup("	See You OnLine");
					} else if ("CUOL".equalsIgnoreCase(input.toString())) {
						showPopup("	See You OnLine");
					} else if ("CUWTA".equalsIgnoreCase(input.toString())) {
						showPopup("	Catch Up With The Acronyms");
					} else if ("CUZ".equalsIgnoreCase(input.toString())) {
						showPopup("	Because");
					} else if ("CWOT".equalsIgnoreCase(input.toString())) {
						showPopup("	Complete Waste Of Time");
					} else if ("CWYL".equalsIgnoreCase(input.toString())) {
						showPopup("	Chat With You Later");
					} else if ("CX".equalsIgnoreCase(input.toString())) {
						showPopup("	Cancelled");
					} else if ("CY".equalsIgnoreCase(input.toString())) {
						showPopup("	Calm Yourself");
					} else if ("CYA".equalsIgnoreCase(input.toString())) {
						showPopup("	Cover Your Ass -or- See Ya");
					} else if ("CYE".equalsIgnoreCase(input.toString())) {
						showPopup("	Check your Email");
					} else if ("CYL".equalsIgnoreCase(input.toString())) {
						showPopup("	See You Later");
					} else if ("CYM".equalsIgnoreCase(input.toString())) {
						showPopup("	Check Your Mail");
					} else if ("CYO".equalsIgnoreCase(input.toString())) {
						showPopup("	See You Online");
					} else if ("CYOH".equalsIgnoreCase(input.toString())) {
						showPopup("	Create Your Own Happening");
					} else if ("CYT".equalsIgnoreCase(input.toString())) {
						showPopup("	See You Tomorrow");
					} else if ("D&M".equalsIgnoreCase(input.toString())) {
						showPopup("	Deep & Meaningful");
					} else if ("d/c".equalsIgnoreCase(input.toString())) {
						showPopup("	disconnected");
					} else if ("d00d".equalsIgnoreCase(input.toString())) {
						showPopup("	dude, also seen as dood");
					} else if ("da".equalsIgnoreCase(input.toString())) {
						showPopup("	there");
					} else if ("DAMHIKT".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Ask Me How I Know That");
					} else if ("DARFC".equalsIgnoreCase(input.toString())) {
						showPopup("	Ducking And Running For Cover");
					} else if ("DBA".equalsIgnoreCase(input.toString())) {
						showPopup("	Doing Business As");
					} else if ("DBABAI".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Be A Bitch About It");
					} else if ("DBD".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Be Dumb");
					} else if ("DBEYR".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Believe Everything You Read");
					} else if ("DD".equalsIgnoreCase(input.toString())) {
						showPopup("	Due Diligence");
					} else if ("DDSOS".equalsIgnoreCase(input.toString())) {
						showPopup("	Different Day, Same Old Shit");
					} else if ("def".equalsIgnoreCase(input.toString())) {
						showPopup("	Definitely");
					} else if ("DEGT".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Even Go There");
					} else if ("dem".equalsIgnoreCase(input.toString())) {
						showPopup("	them");
					} else if ("DENIAL".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Even Notice I Am Lying");
					} else if ("dese".equalsIgnoreCase(input.toString())) {
						showPopup("	these");
					} else if ("DETI".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Even Think It");
					} else if ("dewd".equalsIgnoreCase(input.toString())) {
						showPopup("	dude");
					} else if ("dey".equalsIgnoreCase(input.toString())) {
						showPopup("	they");
					} else if ("DF".equalsIgnoreCase(input.toString())) {
						showPopup("	Dear Friend");
					} else if ("DFIK".equalsIgnoreCase(input.toString())) {
						showPopup("	Darn If I Know");
					} else if ("DFLA".equalsIgnoreCase(input.toString())) {
						showPopup("	Disenhanced Four-Letter Acronym");
					} else if ("DFU".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Fuck Up");
					} else if ("DGA".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Go Anywhere");
					} else if ("DGT".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Go There");
					} else if ("DGTG".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Go There GirlFriend");
					} else if ("DGYF".equalsIgnoreCase(input.toString())) {
						showPopup("	Damn Girl You're Fine");
					} else if ("DH".equalsIgnoreCase(input.toString())) {
						showPopup("	Dear Husband");
					} else if ("DHYB".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Hold Your Breath");
					} else if ("DIAF".equalsIgnoreCase(input.toString())) {
						showPopup("	Die In A Fire");
					} else if ("DIC".equalsIgnoreCase(input.toString())) {
						showPopup("	Drunk In Charge");
					} else if ("DIKU".equalsIgnoreCase(input.toString())) {
						showPopup("	Do I Know You?");
					} else if ("DILLIGAD".equalsIgnoreCase(input.toString())) {
						showPopup("	Do I Look Like I Give A Damn");
					} else if ("DILLIGAS".equalsIgnoreCase(input.toString())) {
						showPopup("	Do I Look Like I Give A Shit");
					} else if ("DINK".equalsIgnoreCase(input.toString())) {
						showPopup("	Double Incomes, No Kids");
					} else if ("DIRFT".equalsIgnoreCase(input.toString())) {
						showPopup("	Do It Right the First Time");
					} else if ("DISTO".equalsIgnoreCase(input.toString())) {
						showPopup("	Did I Say That Outloud?");
					} else if ("DITR".equalsIgnoreCase(input.toString())) {
						showPopup("	Dancing In The Rain");
					} else if ("ditto".equalsIgnoreCase(input.toString())) {
						showPopup("	same here");
					} else if ("DITYID".equalsIgnoreCase(input.toString())) {
						showPopup("	Did I Tell You I'm Distressed");
					} else if ("DIY".equalsIgnoreCase(input.toString())) {
						showPopup("	Do It Yourself");
					} else if ("DL".equalsIgnoreCase(input.toString())) {
						showPopup("	Down Low" + "\n" + "\n" + "Download" + "\n"
								+ "\n" + "Dead Link");
					} else if ("DL".equalsIgnoreCase(input.toString())) {
						showPopup("	Down Low" + "\n" + "\n" + "Download" + "\n"
								+ "\n" + "Dead Link");
					} else if ("DLTBBB".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Let The Bed Bugs Bite");
					} else if ("DLTM".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Lie To Me");
					} else if ("DMI".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Mention It");
					} else if ("DNBL8".equalsIgnoreCase(input.toString())) {
						showPopup("	Do Not Be Late");
					} else if ("DNC".equalsIgnoreCase(input.toString())) {
						showPopup("	Does Not Compute");
					} else if ("DND".equalsIgnoreCase(input.toString())) {
						showPopup("	Do Not Disturb");
					} else if ("DNPMPL".equalsIgnoreCase(input.toString())) {
						showPopup("	Damn Near Pissed My Pants Laughing");
					} else if ("DOC".equalsIgnoreCase(input.toString())) {
						showPopup("	Drug Of Choice");
					} else if ("DOE".equalsIgnoreCase(input.toString())) {
						showPopup("	Depends On Experience");
					} else if ("DOEI".equalsIgnoreCase(input.toString())) {
						showPopup("	Goodbye (in Dutch)");
					} else if ("DORD".equalsIgnoreCase(input.toString())) {
						showPopup("	Department Of Redundancy Department");
					} else if ("DP".equalsIgnoreCase(input.toString())) {
						showPopup("	Domestic Partner");
					} else if ("dps".equalsIgnoreCase(input.toString())) {
						showPopup("	Damage Per Second");
					} else if ("DPUP".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Poop Your Pants");
					} else if ("DQMOT".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Quote Me On This");
					} else if ("DQYDJ".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Quit Your Day Job");
					} else if ("DRB".equalsIgnoreCase(input.toString())) {
						showPopup("	Dirty Rat Bastard");
					} else if ("DRIB".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Read If Busy");
					} else if ("DSTR8".equalsIgnoreCase(input.toString())) {
						showPopup("	Damn Straight");
					} else if ("DTC".equalsIgnoreCase(input.toString())) {
						showPopup("	Deep Throaty Chuckle");
					} else if ("DTRT".equalsIgnoreCase(input.toString())) {
						showPopup("	Do The Right Thing");
					} else if ("DUI".equalsIgnoreCase(input.toString())) {
						showPopup("	Driving Under the Influence");
					} else if ("DUM".equalsIgnoreCase(input.toString())) {
						showPopup("	Do You Masturbate?");
					} else if ("DUNA".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Use No Acronyms");
					} else if ("dunno".equalsIgnoreCase(input.toString())) {
						showPopup("	i don't know");
					} else if ("DURS".equalsIgnoreCase(input.toString())) {
						showPopup("	Damn You Are Sexy");
					} else if ("DUSL".equalsIgnoreCase(input.toString())) {
						showPopup("	Do You Scream Loud?");
					} else if ("DWB".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Write Back");
					} else if ("DWBH".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't Worry Be Happy");
					} else if ("DWI".equalsIgnoreCase(input.toString())) {
						showPopup("	Driving While Intoxicated");
					} else if ("DWPKOTL".equalsIgnoreCase(input.toString())) {
						showPopup("	Deep Wet Passionate Kiss On The Lips");
					} else if ("DWS".equalsIgnoreCase(input.toString())) {
						showPopup("	Driving While Stupid");
					} else if ("DWWWI".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	Surfing the World Wide Web while intoxicated");
					} else if ("DWYM".equalsIgnoreCase(input.toString())) {
						showPopup("	Does What You Mean");
					} else if ("DYFM".equalsIgnoreCase(input.toString())) {
						showPopup("	Dude You Fascinate Me");
					} else if ("DYHAB".equalsIgnoreCase(input.toString())) {
						showPopup("	Do You Have A Boyfriend?");
					} else if ("DYHAGD".equalsIgnoreCase(input.toString())) {
						showPopup("	Do You Have A Girlfriend");
					} else if ("DYJHIW".equalsIgnoreCase(input.toString())) {
						showPopup("	Don't You Just Hate It When...");
					} else if ("DYLI".equalsIgnoreCase(input.toString())) {
						showPopup("	Do You Love It?");
					} else if ("DYOFDW".equalsIgnoreCase(input.toString())) {
						showPopup("	Do Your Own Fucking Dirty Work");
					} else if ("DYSTSOTT".equalsIgnoreCase(input.toString())) {
						showPopup("	Did You See The Size Of That Thing");
					} else if ("E123".equalsIgnoreCase(input.toString())) {
						showPopup("	Easy as One, Two, Three");
					} else if ("E2HO".equalsIgnoreCase(input.toString())) {
						showPopup("	Each to His/Her Own");
					} else if ("EAK".equalsIgnoreCase(input.toString())) {
						showPopup("	Eating at Keyboard");
					} else if ("EBKAC".equalsIgnoreCase(input.toString())) {
						showPopup("	Error between keyboard and chair");
					} else if ("EF4T".equalsIgnoreCase(input.toString())) {
						showPopup("	 Effort");
					} else if ("EG".equalsIgnoreCase(input.toString())) {
						showPopup("	 Evil grin");
					} else if ("EI".equalsIgnoreCase(input.toString())) {
						showPopup("	 Eat it");
					} else if ("EIP".equalsIgnoreCase(input.toString())) {
						showPopup("	 Editing in progress");
					} else if ("EMA".equalsIgnoreCase(input.toString())) {
						showPopup("	 E-mail address");
					} else if ("EMFBI".equalsIgnoreCase(input.toString())) {
						showPopup("	 Excuse me for butting in");
					} else if ("EMFJI".equalsIgnoreCase(input.toString())) {
						showPopup("	 Excuse me for jumping in");
					} else if ("EMFJI".equalsIgnoreCase(input.toString())) {
						showPopup("	 Excuse me for jumping in");
					} else if ("EMSG".equalsIgnoreCase(input.toString())) {
						showPopup("	 E-mail message");
					} else if ("ENUF".equalsIgnoreCase(input.toString())) {
						showPopup("	 Enough");
					} else if ("EOD".equalsIgnoreCase(input.toString())) {
						showPopup("	 End of day");
					} else if ("EOD".equalsIgnoreCase(input.toString())) {
						showPopup("	 End of discussion");
					} else if ("EOL".equalsIgnoreCase(input.toString())) {
						showPopup("	 End of lecture");
					} else if ("EOM".equalsIgnoreCase(input.toString())) {
						showPopup("	 End of message");
					} else if ("EOS".equalsIgnoreCase(input.toString())) {
						showPopup("	 End of show");
					} else if ("EOT".equalsIgnoreCase(input.toString())) {
						showPopup("	 End of transmission");
					} else if ("EOT".equalsIgnoreCase(input.toString())) {
						showPopup("	 End of thread (end of discussion)");
					} else if ("ERS2".equalsIgnoreCase(input.toString())) {
						showPopup("	 Eres tz / are you (Spanish SMS)");
					} else if ("ES".equalsIgnoreCase(input.toString())) {
						showPopup("	 Erase screen");
					} else if ("ETA".equalsIgnoreCase(input.toString())) {
						showPopup("	 Estimated time (of) arrival");
					} else if ("ETLA".equalsIgnoreCase(input.toString())) {
						showPopup("	 Extended three-letter acronym (an FLA)");
					} else if ("EVA".equalsIgnoreCase(input.toString())) {
						showPopup("	 Ever");
					} else if ("EVO".equalsIgnoreCase(input.toString())) {
						showPopup("	 Evolution");
					} else if ("EYC".equalsIgnoreCase(input.toString())) {
						showPopup("	 Excitable, yet calm");
					} else if ("EZ".equalsIgnoreCase(input.toString())) {
						showPopup("	 Easy");
					} else if ("EZY".equalsIgnoreCase(input.toString())) {
						showPopup("	 Easy");
					} else if ("F".equalsIgnoreCase(input.toString())) {
						showPopup("	 Meaning female");
					} else if ("F2F".equalsIgnoreCase(input.toString())) {
						showPopup("	 Face to face");
					} else if ("FAAK".equalsIgnoreCase(input.toString())) {
						showPopup("	 Falling asleep at keyboard");
					} else if ("FAF".equalsIgnoreCase(input.toString())) {
						showPopup("	 Funny as *freak*");
					} else if ("FAQ".equalsIgnoreCase(input.toString())) {
						showPopup("	 Frequently-asked questions");
					} else if ("FBF".equalsIgnoreCase(input.toString())) {
						showPopup("	 Fat boy food (e.g. pizza, burgers, fries)");
					} else if ("FBF".equalsIgnoreCase(input.toString())) {
						showPopup("	 Fine by me");
					} else if ("FBOW".equalsIgnoreCase(input.toString())) {
						showPopup("	 For better or worse");
					} else if ("FC".equalsIgnoreCase(input.toString())) {
						showPopup("	 Fingers crossed");
					} else if ("FFS".equalsIgnoreCase(input.toString())) {
						showPopup("	 For *freak'*sakes");
					} else if ("FICCL".equalsIgnoreCase(input.toString())) {
						showPopup("	 Frankly I couldn't care a less");
					} else if ("FIIK".equalsIgnoreCase(input.toString())) {
						showPopup("	 *Freaked* if I know");
					} else if ("FIIOOH".equalsIgnoreCase(input.toString())) {
						showPopup("	 Forget it, I'm out of here");
					} else if ("FIL".equalsIgnoreCase(input.toString())) {
						showPopup("	 Father in law");
					} else if ("FISH".equalsIgnoreCase(input.toString())) {
						showPopup("	 First in, still here ");
					} else if ("FIMH".equalsIgnoreCase(input.toString())) {
						showPopup("	 Forever in my heart");
					} else if ("FIMH".equalsIgnoreCase(input.toString())) {
						showPopup("	 Fill in the blank");
					} else if ("FLA".equalsIgnoreCase(input.toString())) {
						showPopup("	 Four-letter acronym");
					} else if ("FMTYEWTK".equalsIgnoreCase(input.toString())) {
						showPopup("	 Far more than you ever wanted to know");
					} else if ("FOMC".equalsIgnoreCase(input.toString())) {
						showPopup("	 Falling off my chair");
					} else if ("FOMC".equalsIgnoreCase(input.toString())) {
						showPopup("	 Falling off my chair laughing ");
					} else if ("FOMCL".equalsIgnoreCase(input.toString())) {
						showPopup("	 Falling off my chair laughing ");
					} else if ("FOAD".equalsIgnoreCase(input.toString())) {
						showPopup("	 Freak off and die");
					} else if ("FOF".equalsIgnoreCase(input.toString())) {
						showPopup("	 Friend of a friend");
					} else if ("FRT".equalsIgnoreCase(input.toString())) {
						showPopup("	  For real though");
					} else if ("FTBOMH".equalsIgnoreCase(input.toString())) {
						showPopup("	   From the bottom of my heart");
					} else if ("FTW".equalsIgnoreCase(input.toString())) {
						showPopup("	   For the win");
					} else if ("FU".equalsIgnoreCase(input.toString())) {
						showPopup("	   *Freak* you");
					} else if ("FUBAR".equalsIgnoreCase(input.toString())) {
						showPopup("	   Fouled up beyond all recognition");
					} else if ("FUBB".equalsIgnoreCase(input.toString())) {
						showPopup("	   Fouled up beyond belief");
					} else if ("FUD".equalsIgnoreCase(input.toString())) {
						showPopup("	   Fear, Uncertainty, and Doubt");
					} else if ("FW".equalsIgnoreCase(input.toString())) {
						showPopup("	   Forward");
					} else if ("FWM".equalsIgnoreCase(input.toString())) {
						showPopup("	   Fine with me");
					} else if ("FWIM".equalsIgnoreCase(input.toString())) {
						showPopup("	   For what it's worth");
					} else if ("FYEO".equalsIgnoreCase(input.toString())) {
						showPopup("	   For your eyes only");
					} else if ("FYA".equalsIgnoreCase(input.toString())) {
						showPopup("	   For your amusement");
					} else if ("FYI".equalsIgnoreCase(input.toString())) {
						showPopup("	   For your information");
					} else if ("G".equalsIgnoreCase(input.toString())) {
						showPopup("	   Grin");
					} else if ("G".equalsIgnoreCase(input.toString())) {
						showPopup("	    Giggle");
					} else if ("G".equalsIgnoreCase(input.toString())) {
						showPopup("	    Giggle");
					} else if ("GF".equalsIgnoreCase(input.toString())) {
						showPopup("	    Giggle");
					} else if ("G2CU".equalsIgnoreCase(input.toString())) {
						showPopup("	    Good to see you");
					} else if ("G2G".equalsIgnoreCase(input.toString())) {
						showPopup("	    Got to go");
					} else if ("G4C".equalsIgnoreCase(input.toString())) {
						showPopup("	    Going for coffee");
					} else if ("G9".equalsIgnoreCase(input.toString())) {
						showPopup("	    Genius");
					} else if ("GA".equalsIgnoreCase(input.toString())) {
						showPopup("	    Go ahead");
					} else if ("GAL".equalsIgnoreCase(input.toString())) {
						showPopup("	    Get a life");
					} else if ("GAS".equalsIgnoreCase(input.toString())) {
						showPopup("	    Got a second?");
					} else if ("GB".equalsIgnoreCase(input.toString())) {
						showPopup("	    Goodbye");
					} else if ("GBTW".equalsIgnoreCase(input.toString())) {
						showPopup("	    Get back to work");
					} else if ("GBU".equalsIgnoreCase(input.toString())) {
						showPopup("	    God bless you");
					} else if ("GDR".equalsIgnoreCase(input.toString())) {
						showPopup("	    Grinning, ducking, and running");
					} else if ("GFI".equalsIgnoreCase(input.toString())) {
						showPopup("	    Go for it");
					} else if ("GF".equalsIgnoreCase(input.toString())) {
						showPopup("	    Girlfriend");
					} else if ("GFN".equalsIgnoreCase(input.toString())) {
						showPopup("	    Gone for now");
					} else if ("GG".equalsIgnoreCase(input.toString())) {
						showPopup("	    Gotta Go");
					} else if ("GGMSOT".equalsIgnoreCase(input.toString())) {
						showPopup("	    Gotta get me some of that");
					} else if ("GGOH".equalsIgnoreCase(input.toString())) {
						showPopup("	    Gotta get outa Here");
					} else if ("GIGO".equalsIgnoreCase(input.toString())) {
						showPopup("	    Garbage in, garbage out");
					} else if ("GIAR".equalsIgnoreCase(input.toString())) {
						showPopup("	    Give it a rest");
					} else if ("GIRL".equalsIgnoreCase(input.toString())) {
						showPopup("	    Guy in real life");
					} else if ("GIWIST".equalsIgnoreCase(input.toString())) {
						showPopup("	     Gee, I wish I'd said that");
					} else if ("GJ".equalsIgnoreCase(input.toString())) {
						showPopup("	     Good job");
					} else if ("GL".equalsIgnoreCase(input.toString())) {
						showPopup("	     Good luck");
					} else if ("GMBA".equalsIgnoreCase(input.toString())) {
						showPopup("	     Giggling my butt off");
					} else if ("GMTA".equalsIgnoreCase(input.toString())) {
						showPopup("	     Great minds think alike");
					} else if ("GMAB".equalsIgnoreCase(input.toString())) {
						showPopup("	     Give me a break");
					} else if ("GN".equalsIgnoreCase(input.toString())) {
						showPopup("	     Good night");
					} else if ("GNE1".equalsIgnoreCase(input.toString())) {
						showPopup("	     Good night everyone");
					} else if ("GNIGHT".equalsIgnoreCase(input.toString())) {
						showPopup("	     Good night");
					} else if ("GNITE".equalsIgnoreCase(input.toString())) {
						showPopup("	     Good night");
					} else if ("GNSD".equalsIgnoreCase(input.toString())) {
						showPopup("	     Good night, sweet dreams");
					} else if ("GOL".equalsIgnoreCase(input.toString())) {
						showPopup("	     Giggling out loud");
					} else if ("GOI".equalsIgnoreCase(input.toString())) {
						showPopup("	     Get over it");
					} else if ("GR8".equalsIgnoreCase(input.toString())) {
						showPopup("	     Great");
					} else if ("GRATZ".equalsIgnoreCase(input.toString())) {
						showPopup("	     Congratulations");
					} else if ("GRL".equalsIgnoreCase(input.toString())) {
						showPopup("	     Girl");
					} else if ("GRWG".equalsIgnoreCase(input.toString())) {
						showPopup("	     Get right with God");
					} else if ("GR&D".equalsIgnoreCase(input.toString())) {
						showPopup("	     Grinning, running and ducking");
					} else if ("GS".equalsIgnoreCase(input.toString())) {
						showPopup("	     Good Shot");
					} else if ("GTRM".equalsIgnoreCase(input.toString())) {
						showPopup("	     Going to read mail");
					} else if ("GTSY".equalsIgnoreCase(input.toString())) {
						showPopup("	     Glad to see you");
					} else if ("GT".equalsIgnoreCase(input.toString())) {
						showPopup("	     Good try");
					} else if ("GT".equalsIgnoreCase(input.toString())) {
						showPopup("	     Glad to see you");
					} else if ("GTFO".equalsIgnoreCase(input.toString())) {
						showPopup("	     Get the *freak* out");
					} else if ("GTG".equalsIgnoreCase(input.toString())) {
						showPopup("	     Got to go");
					} else if ("GTRM".equalsIgnoreCase(input.toString())) {
						showPopup("	      Going to read mail");
					} else if ("GTRM".equalsIgnoreCase(input.toString())) {
						showPopup("	      Great (or good) to see you");
					} else if ("GUD".equalsIgnoreCase(input.toString())) {
						showPopup("	      Good");
					} else if ("GWHTLC".equalsIgnoreCase(input.toString())) {
						showPopup("	      Glad we had this little chat");
					} else if ("H".equalsIgnoreCase(input.toString())) {
						showPopup("	      Hug");
					} else if ("H8".equalsIgnoreCase(input.toString())) {
						showPopup("	      Hate");
					} else if ("H8TBU".equalsIgnoreCase(input.toString())) {
						showPopup("	      Hate to be you");
					} else if ("H&K".equalsIgnoreCase(input.toString())) {
						showPopup("	      Hug and kiss");
					} else if ("H2CUS".equalsIgnoreCase(input.toString())) {
						showPopup("	      Hope to see you soon");
					} else if ("HAGN".equalsIgnoreCase(input.toString())) {
						showPopup("	      Have a good night");
					} else if ("HB".equalsIgnoreCase(input.toString())) {
						showPopup("	      Hurry Back");
					} else if ("HAK".equalsIgnoreCase(input.toString())) {
						showPopup("	      Hug and kiss");
					} else if ("HAG1".equalsIgnoreCase(input.toString())
							|| "HAGO".equalsIgnoreCase(input.toString())) {
						showPopup("	      Have a good one");
					} else if ("HAND".equalsIgnoreCase(input.toString())) {
						showPopup("	      Have a nice day");
					} else if ("HB".equalsIgnoreCase(input.toString())) {
						showPopup("	      hug back");
					} else if ("H-BDAY".equalsIgnoreCase(input.toString())) {
						showPopup("	      Happy Birthday");
					} else if ("HBU".equalsIgnoreCase(input.toString())) {
						showPopup("	      How about you?");
					} else if ("HF".equalsIgnoreCase(input.toString())) {
						showPopup("	     Have fun");
					} else if ("HFAC".equalsIgnoreCase(input.toString())) {
						showPopup("	     Holy flipping animal crackers");
					} else if ("H-FDAY".equalsIgnoreCase(input.toString())) {
						showPopup("	     Happy Father's Day");
					} else if ("HHIS".equalsIgnoreCase(input.toString())) {
						showPopup("	     Head hanging in shame");
					} else if ("HHIS".equalsIgnoreCase(input.toString())) {
						showPopup("	     Hanging head in shame");
					} else if ("HIG".equalsIgnoreCase(input.toString())) {
						showPopup("	     How's it going");
					} else if ("HLA".equalsIgnoreCase(input.toString())) {
						showPopup("	     Hola / hello (Spanish SMS)");
					} else if ("H-MDAY".equalsIgnoreCase(input.toString())) {
						showPopup("	     Happy Mother's Day");
					} else if ("HNL".equalsIgnoreCase(input.toString())) {
						showPopup("	     Whole 'H' another level");
					} else if ("HOAS".equalsIgnoreCase(input.toString())) {
						showPopup("	     Hold on a second");
					} else if ("HP".equalsIgnoreCase(input.toString())) {
						showPopup("	     Hit points / " + "\n" + "\n"
								+ "Health points (online gaming)");
					} else if ("HRU".equalsIgnoreCase(input.toString())) {
						showPopup("	     How are you?");
					} else if ("HTH".equalsIgnoreCase(input.toString())) {
						showPopup("	     Hope this helps");
					} else if ("HT".equalsIgnoreCase(input.toString())) {
						showPopup("	     Hi there");
					} else if ("HUB".equalsIgnoreCase(input.toString())) {
						showPopup("	     Head up butt");
					} else if ("HUYA".equalsIgnoreCase(input.toString())) {
						showPopup("	     Head up your *butt*");
					} else if ("HV".equalsIgnoreCase(input.toString())) {
						showPopup("	     Have");
					} else if ("HV".equalsIgnoreCase(input.toString())) {
						showPopup("	     Homework");
					} else if ("I2".equalsIgnoreCase(input.toString())) {
						showPopup("	     I too (me too)");
					} else if ("IA8".equalsIgnoreCase(input.toString())) {
						showPopup("	     I already ate");
					} else if ("IAAA".equalsIgnoreCase(input.toString())) {
						showPopup("	    I am an accountant");
					} else if ("IAAD".equalsIgnoreCase(input.toString())) {
						showPopup("	    I am a doctor");
					} else if ("IAAL".equalsIgnoreCase(input.toString())) {
						showPopup("	    I am a lawyer");
					} else if ("IANAC".equalsIgnoreCase(input.toString())) {
						showPopup("	    I am not a crook");
					} else if ("IAC".equalsIgnoreCase(input.toString())) {
						showPopup("	    In any case");
					} else if ("IAE".equalsIgnoreCase(input.toString())) {
						showPopup("	    In any event");
					} else if ("IAO".equalsIgnoreCase(input.toString())) {
						showPopup("	    I am out (of here)");
					} else if ("IAW".equalsIgnoreCase(input.toString())) {
						showPopup("	    I agree with / In accordance with ");
					} else if ("IS".equalsIgnoreCase(input.toString())) {
						showPopup("	    I see ");
					} else if ("IB".equalsIgnoreCase(input.toString())) {
						showPopup("	    I'm back ");
					} else if ("ICAM".equalsIgnoreCase(input.toString())) {
						showPopup("	    I couldn't agree more ");
					} else if ("ICBW".equalsIgnoreCase(input.toString())) {
						showPopup("	    It could be worse ");
					} else if ("ICEDI".equalsIgnoreCase(input.toString())) {
						showPopup("	    I can't even discuss it ");
					} else if ("ICFILWU".equalsIgnoreCase(input.toString())) {
						showPopup("	    I could fall in love with you");
					} else if ("IDC".equalsIgnoreCase(input.toString())) {
						showPopup("	    I don't care");
					} else if ("IDK".equalsIgnoreCase(input.toString())) {
						showPopup("	    I don't know");
					} else if ("IDTS".equalsIgnoreCase(input.toString())) {
						showPopup("	    I don't think so");
					} else if ("IDUNNO".equalsIgnoreCase(input.toString())) {
						showPopup("	    I don't know");
					} else if ("IFYP".equalsIgnoreCase(input.toString())) {
						showPopup("	    I feel your pain");
					} else if ("IG2R".equalsIgnoreCase(input.toString())) {
						showPopup("	     I got to run");
					} else if ("IGHT".equalsIgnoreCase(input.toString())) {
						showPopup("	     I got high tonight");
					} else if ("IGN".equalsIgnoreCase(input.toString())) {
						showPopup("	     I (I've) got nothing");
					} else if ("IGN".equalsIgnoreCase(input.toString())) {
						showPopup("	     I hate acronyms");
					} else if ("IHU".equalsIgnoreCase(input.toString())) {
						showPopup("	     I hear you");
					} else if ("IIRC".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	     If I recall / remember / recollect correctly");
					} else if ("IIIO".equalsIgnoreCase(input.toString())) {
						showPopup("	     Intel inside, idiot outside");
					} else if ("IK".equalsIgnoreCase(input.toString())) {
						showPopup("	     I know");
					} else if ("IKR".equalsIgnoreCase(input.toString())) {
						showPopup("	     I know, right?");
					} else if ("ILBL8".equalsIgnoreCase(input.toString())) {
						showPopup("	     I'll be late");
					} else if ("ILU".equalsIgnoreCase(input.toString())) {
						showPopup("	     I love you");
					} else if ("ILY".equalsIgnoreCase(input.toString())) {
						showPopup("	     I love you");
					} else if ("IM".equalsIgnoreCase(input.toString())) {
						showPopup("	     Immediate message" + "\n" + "\n"
								+ "Instant message");
					} else if ("IMAO".equalsIgnoreCase(input.toString())) {
						showPopup("	     In my arrogant opinion");
					} else if ("IMCO".equalsIgnoreCase(input.toString())) {
						showPopup("	     In my considered opinion");
					} else if ("IMing".equalsIgnoreCase(input.toString())) {
						showPopup("	     Chatting with someone online");
					} else if ("IMHO".equalsIgnoreCase(input.toString())) {
						showPopup("	     In my humble opinion");
					} else if ("IMNSHO".equalsIgnoreCase(input.toString())) {
						showPopup("	     In my not so humble opinion");
					} else if ("IMO".equalsIgnoreCase(input.toString())) {
						showPopup("	     In my opinion");
					} else if ("IMS".equalsIgnoreCase(input.toString())) {
						showPopup("	     I am sorry");
					} else if ("IMSB".equalsIgnoreCase(input.toString())) {
						showPopup("	     I am so bored");
					} else if ("IMTM".equalsIgnoreCase(input.toString())) {
						showPopup("	     I am the man");
					} else if ("IMU".equalsIgnoreCase(input.toString())) {
						showPopup("	     I miss u (you)");
					} else if ("IOMH".equalsIgnoreCase(input.toString())) {
						showPopup("	     In over my head");
					} else if ("IOW".equalsIgnoreCase(input.toString())) {
						showPopup("	     In other words");
					} else if ("IRL".equalsIgnoreCase(input.toString())) {
						showPopup("	     In real life");
					} else if ("ITA".equalsIgnoreCase(input.toString())) {
						showPopup("	     I totally agree");
					} else if ("ITIGBS".equalsIgnoreCase(input.toString())) {
						showPopup("	     I think I'm going to be sick");
					} else if ("IRMC".equalsIgnoreCase(input.toString())) {
						showPopup("	      I rest my case");
					} else if ("ISLY".equalsIgnoreCase(input.toString())) {
						showPopup("	      I still love you");
					} else if ("ITYK".equalsIgnoreCase(input.toString())) {
						showPopup("	      I thought you knew");
					} else if ("IWAWO".equalsIgnoreCase(input.toString())) {
						showPopup("	      I want a way out");
					} else if ("IWIAM".equalsIgnoreCase(input.toString())) {
						showPopup("	      Idiot wrapped in a moron");
					} else if ("IWALU".equalsIgnoreCase(input.toString())) {
						showPopup("	      I will always love you");
					} else if ("IYO".equalsIgnoreCase(input.toString())) {
						showPopup("	      In your opinion");
					} else if ("IYSS".equalsIgnoreCase(input.toString())) {
						showPopup("	      If you say so");
					} else if ("IYSWIM".equalsIgnoreCase(input.toString())) {
						showPopup("	     If you see what I mean");
					} else if ("j00".equalsIgnoreCase(input.toString())) {
						showPopup("	     You");
					} else if ("j00r".equalsIgnoreCase(input.toString())) {
						showPopup("	     Your");
					} else if ("JAC".equalsIgnoreCase(input.toString())) {
						showPopup("	     Just a sec");
					} else if ("JAM".equalsIgnoreCase(input.toString())) {
						showPopup("	     Just a minutes");
					} else if ("JBOD".equalsIgnoreCase(input.toString())) {
						showPopup("	     Just a bunch of disks");
					} else if ("JFF".equalsIgnoreCase(input.toString())) {
						showPopup("	     Just for fun");
					} else if ("JFGI".equalsIgnoreCase(input.toString())) {
						showPopup("	     Just *freaking* Google it");
					} else if ("JIC".equalsIgnoreCase(input.toString())) {
						showPopup("	     Just in case");
					} else if ("JK".equalsIgnoreCase(input.toString())) {
						showPopup("	     Just kidding");
					} else if ("J/K".equalsIgnoreCase(input.toString())) {
						showPopup("	     Just kidding");
					} else if ("JLMK".equalsIgnoreCase(input.toString())) {
						showPopup("	     Just let me know");
					} else if ("JP".equalsIgnoreCase(input.toString())) {
						showPopup("	     Just playing");
					} else if ("JMO".equalsIgnoreCase(input.toString())) {
						showPopup("	     Just my opinion");
					} else if ("JTLYK".equalsIgnoreCase(input.toString())) {
						showPopup("	     Just to let you know");
					} else if ("JW".equalsIgnoreCase(input.toString())) {
						showPopup("	     Just wondering");
					} else if ("K".equalsIgnoreCase(input.toString())) {
						showPopup("	     OK" + "\n" + "\n" + "Okay");
					} else if ("K/b".equalsIgnoreCase(input.toString())) {
						showPopup("	      Keyboard");
					} else if ("K".equalsIgnoreCase(input.toString())) {
						showPopup("	     KNock, KNock");
					} else if ("KDFU".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	      Means Cracking (K) the (D as in Da) *freak* up");
					} else if ("KEWL".equalsIgnoreCase(input.toString())) {
						showPopup("	       Cool");
					} else if ("KEYA".equalsIgnoreCase(input.toString())) {
						showPopup("	       I will key you later");
					} else if ("KEYME".equalsIgnoreCase(input.toString())) {
						showPopup("	      Key me when you get in");
					} else if ("KFY".equalsIgnoreCase(input.toString())) {
						showPopup("	      Kiss for you");
					} else if ("KIA".equalsIgnoreCase(input.toString())) {
						showPopup("	      Know it all");
					} else if ("KISS".equalsIgnoreCase(input.toString())) {
						showPopup("	      Keep it simple stupid");
					} else if ("KIT".equalsIgnoreCase(input.toString())) {
						showPopup("	      Keep in touch");
					} else if ("KOC".equalsIgnoreCase(input.toString())) {
						showPopup("	      Kiss on cheek ");
					} else if ("KOTC".equalsIgnoreCase(input.toString())) {
						showPopup("	      Kiss on the cheek");
					} else if ("KOTL".equalsIgnoreCase(input.toString())) {
						showPopup("	       Kiss on the lips");
					} else if ("KPC".equalsIgnoreCase(input.toString())) {
						showPopup("	       Keeping parents clueless");
					} else if ("KUTGW".equalsIgnoreCase(input.toString())) {
						showPopup("	       Keep up the good work");
					} else if ("KWIM?".equalsIgnoreCase(input.toString())) {
						showPopup("	       Know what I mean?");
					} else if ("KWIM".equalsIgnoreCase(input.toString())) {
						showPopup("	       Know what I mean?");
					} else if ("L2G".equalsIgnoreCase(input.toString())) {
						showPopup("	       Like to go?");
					} else if ("L2G".equalsIgnoreCase(input.toString())) {
						showPopup("	       Love to go?");
					} else if ("L2K".equalsIgnoreCase(input.toString())) {
						showPopup("	       Like to come");
					} else if ("l33t".equalsIgnoreCase(input.toString())) {
						showPopup("	       Elite");
					} else if ("L8R".equalsIgnoreCase(input.toString())) {
						showPopup("	       Later");
					} else if ("L8R G8R".equalsIgnoreCase(input.toString())) {
						showPopup("	       Later gator");
					} else if ("G8R".equalsIgnoreCase(input.toString())) {
						showPopup("	       gator");
					} else if ("G8T".equalsIgnoreCase(input.toString())) {
						showPopup("	       great");
					} else if ("LBAY".equalsIgnoreCase(input.toString())) {
						showPopup("	       Laughing back at you");
					} else if ("LEMENO".equalsIgnoreCase(input.toString())) {
						showPopup("	       Let me know");
					} else if ("LGH".equalsIgnoreCase(input.toString())) {
						showPopup("	       Lets get high");
					} else if ("LHM".equalsIgnoreCase(input.toString())) {
						showPopup("	       Lord help me");
					} else if ("LHO".equalsIgnoreCase(input.toString())) {
						showPopup("	       Laughing head off");
					} else if ("LIC".equalsIgnoreCase(input.toString())) {
						showPopup("	       Like I care");
					} else if ("LIK".equalsIgnoreCase(input.toString())) {
						showPopup("	       Liquor");
					} else if ("LIMT".equalsIgnoreCase(input.toString())) {
						showPopup("	       Laugh in my tummy");
					} else if ("LLGB".equalsIgnoreCase(input.toString())) {
						showPopup("	       Love, later, God bless");
					} else if ("LERK".equalsIgnoreCase(input.toString())) {
						showPopup("	       Leaving easy reach of keyboard ");
					} else if ("LD".equalsIgnoreCase(input.toString())) {
						showPopup("	       Later, dude / Long distance ");
					} else if ("LDR".equalsIgnoreCase(input.toString())) {
						showPopup("	       Long-distance relationship ");
					} else if ("LHO".equalsIgnoreCase(input.toString())) {
						showPopup("	       Laughing head off ");
					} else if ("LLTA".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	        Lots and lots of thunderous applause ");
					} else if ("Lmao".equalsIgnoreCase(input.toString())) {
						showPopup("	        Laughing my ass off ");
					} else if ("LMSO".equalsIgnoreCase(input.toString())) {
						showPopup("	        Laughing my socks off ");
					} else if ("LMFAO".equalsIgnoreCase(input.toString())) {
						showPopup("	         Laughing my freaking *a* off");
					} else if ("LMIRL".equalsIgnoreCase(input.toString())) {
						showPopup("	         Lets meet in real life");
					} else if ("LMK".equalsIgnoreCase(input.toString())) {
						showPopup("	         Let me know ");
					} else if ("LMNK".equalsIgnoreCase(input.toString())) {
						showPopup("	         Leave my name out");
					} else if ("LNT".equalsIgnoreCase(input.toString())) {
						showPopup("	         Meaning lost in translation");
					} else if ("LOA".equalsIgnoreCase(input.toString())) {
						showPopup("	         List of acronyms");
					} else if ("LOL".equalsIgnoreCase(input.toString())) {
						showPopup("	         Lots of love" + "\n" + "\n"
								+ "Laughing out loud");
					} else if ("LOTI".equalsIgnoreCase(input.toString())) {
						showPopup("	         Laughing on the inside");
					} else if ("LRF".equalsIgnoreCase(input.toString())) {
						showPopup("	         Little rubber feet ");
					} else if ("LQTM".equalsIgnoreCase(input.toString())) {
						showPopup("	         Laughing quietly to myself");
					} else if ("LSHMBH".equalsIgnoreCase(input.toString())) {
						showPopup("	         Laughing so hard my belly hurts");
					} else if ("LSV".equalsIgnoreCase(input.toString())) {
						showPopup("	          Language, sex and violence");
					} else if ("LTD".equalsIgnoreCase(input.toString())) {
						showPopup("	          Living the dream");
					} else if ("LTNS".equalsIgnoreCase(input.toString())) {
						showPopup("	          Long time no see");
					} else if ("LTR".equalsIgnoreCase(input.toString())) {
						showPopup("	          Long-term relationship");
					} else if ("LULAB".equalsIgnoreCase(input.toString())) {
						showPopup("	          Love you like a brother");
					} else if ("LULAS".equalsIgnoreCase(input.toString())) {
						showPopup("	           Love you like a sister");
					} else if ("LUWAMH".equalsIgnoreCase(input.toString())) {
						showPopup("	           Love you with all my heart");
					} else if ("LY".equalsIgnoreCase(input.toString())) {
						showPopup("	           Love ya");
					} else if ("LY4E".equalsIgnoreCase(input.toString())) {
						showPopup("	          Love ya forever");
					} else if ("LTS".equalsIgnoreCase(input.toString())) {
						showPopup("	          Laughing to self");
					} else if ("LULT".equalsIgnoreCase(input.toString())) {
						showPopup("	          Love you long time");
					} else if ("LULZ".equalsIgnoreCase(input.toString())) {
						showPopup("	          Slang for LOL");
					} else if ("LVM".equalsIgnoreCase(input.toString())) {
						showPopup("	          Left voice mail");
					} else if ("LWOS".equalsIgnoreCase(input.toString())) {
						showPopup("	           Laughing without smiling");
					} else if ("LY".equalsIgnoreCase(input.toString())) {
						showPopup("	           Love ya");
					} else if ("LYLAS".equalsIgnoreCase(input.toString())) {
						showPopup("	           Love you like crazy");
					} else if ("LYLC".equalsIgnoreCase(input.toString())) {
						showPopup("	           Love you like a sis");
					} else if ("M8".equalsIgnoreCase(input.toString())) {
						showPopup("	           Mate");
					} else if ("LYSM".equalsIgnoreCase(input.toString())) {
						showPopup("	           Love you so much");
					} else if ("MB".equalsIgnoreCase(input.toString())) {
						showPopup("	           Mamma's boy");
					} else if ("MC".equalsIgnoreCase(input.toString())) {
						showPopup("	           Merry Christmas");
					} else if ("MEGO".equalsIgnoreCase(input.toString())) {
						showPopup("	           My eyes glaze over");
					} else if ("MEH".equalsIgnoreCase(input.toString())) {
						showPopup("	           Shrug or shrugging shoulders");
					} else if ("MEH".equalsIgnoreCase(input.toString())) {
						showPopup("	           Shrug or shrugging shoulders");
					} else if ("MEH".equalsIgnoreCase(input.toString())) {
						showPopup("	           sighing");
					} else if ("MFI".equalsIgnoreCase(input.toString())) {
						showPopup("	           Mad for it");
					} else if ("MGB".equalsIgnoreCase(input.toString())) {
						showPopup("	           May God bless");
					} else if ("MIRL".equalsIgnoreCase(input.toString())) {
						showPopup("	           Meet in real life");
					} else if ("MKAY".equalsIgnoreCase(input.toString())) {
						showPopup("	           Mmm, okay");
					} else if ("MLM".equalsIgnoreCase(input.toString())) {
						showPopup("	           Give the middle finger");
					} else if ("MNC".equalsIgnoreCase(input.toString())) {
						showPopup("	           Mother nature calls");
					} else if ("MNSG".equalsIgnoreCase(input.toString())) {
						showPopup("	           Mensaje (message in Spanish)");
					} else if ("MorF".equalsIgnoreCase(input.toString())) {
						showPopup("	           Male or female?");
					} else if ("MOOS".equalsIgnoreCase(input.toString())) {
						showPopup("	           Member of the opposite sex");
					} else if ("MOSS".equalsIgnoreCase(input.toString())) {
						showPopup("	           Member of same sex");
					} else if ("MorF".equalsIgnoreCase(input.toString())) {
						showPopup("	           Male or female");
					} else if ("MOTOS".equalsIgnoreCase(input.toString())) {
						showPopup("	          Member of the opposite sex");
					} else if ("MSG".equalsIgnoreCase(input.toString())) {
						showPopup("	          Message");
					} else if ("MTF".equalsIgnoreCase(input.toString())) {
						showPopup("	          More to follow");
					} else if ("MTFBWU".equalsIgnoreCase(input.toString())) {
						showPopup("	          May the force be with you");
					} else if ("MUSM".equalsIgnoreCase(input.toString())) {
						showPopup("	          Miss you so much");
					} else if ("MUSM".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	          Multiple unsuccessful attempts (at / to) humor");
					} else if ("MUSM".equalsIgnoreCase(input.toString())) {
						showPopup("	          Meaning 'kiss' ");
					} else if ("MYO".equalsIgnoreCase(input.toString())) {
						showPopup("	          Mind your own (business)");
					} else if ("MYOB".equalsIgnoreCase(input.toString())) {
						showPopup("	          Mind your own business");
					} else if ("n00b".equalsIgnoreCase(input.toString())) {
						showPopup("	          Newbie");
					} else if ("N1".equalsIgnoreCase(input.toString())) {
						showPopup("	          Nice one");
					} else if ("N2M".equalsIgnoreCase(input.toString())) {
						showPopup("	          Nothing too much");
					} else if ("NADT".equalsIgnoreCase(input.toString())) {
						showPopup("	          Not a darn thing");
					} else if ("NALOPKT".equalsIgnoreCase(input.toString())) {
						showPopup("	          Not a lot of people know that");
					} else if ("NANA".equalsIgnoreCase(input.toString())) {
						showPopup("	          Not now, no need");
					} else if ("NBD".equalsIgnoreCase(input.toString())) {
						showPopup("	          No big deal");
					} else if ("NE".equalsIgnoreCase(input.toString())) {
						showPopup("	          Any");
					} else if ("NE1".equalsIgnoreCase(input.toString())) {
						showPopup("	          Anyone");
					} else if ("NFM".equalsIgnoreCase(input.toString())) {
						showPopup("	          None for me / Not for me");
					} else if ("NFS".equalsIgnoreCase(input.toString())) {
						showPopup("	          Not for sale");
					} else if ("NFW".equalsIgnoreCase(input.toString())) {
						showPopup("	          No *freaking* way" + "\n" + "\n"
								+ "Not for work");
					} else if ("NFWS".equalsIgnoreCase(input.toString())) {
						showPopup("	          Not for work safe");
					} else if ("NIGI".equalsIgnoreCase(input.toString())) {
						showPopup("	         Now I get it");
					} else if ("NIMBY".equalsIgnoreCase(input.toString())) {
						showPopup("	         Not in my back yard");
					} else if ("NIROK".equalsIgnoreCase(input.toString())) {
						showPopup("	         Not in reach of keyboard");
					} else if ("NLT".equalsIgnoreCase(input.toString())) {
						showPopup("	         No later than");
					} else if ("NM".equalsIgnoreCase(input.toString())) {
						showPopup("	         Nothing much" + "\n" + "\n"
								+ "Never mind");
					} else if ("NMH".equalsIgnoreCase(input.toString())) {
						showPopup("	         Not much here");
					} else if ("NMU".equalsIgnoreCase(input.toString())) {
						showPopup("	         Not much, you?");
					} else if ("NO1".equalsIgnoreCase(input.toString())) {
						showPopup("	         No one");
					} else if ("NOYB".equalsIgnoreCase(input.toString())) {
						showPopup("	         None of your business");
					} else if ("NP".equalsIgnoreCase(input.toString())) {
						showPopup("	         No problem");
					} else if ("NQT".equalsIgnoreCase(input.toString())) {
						showPopup("	         Newly qualified teacher");
					} else if ("NADT".equalsIgnoreCase(input.toString())) {
						showPopup("	         Not a darn thing");
					} else if ("NFG".equalsIgnoreCase(input.toString())) {
						showPopup("	         No fucking good");
					} else if ("NFW".equalsIgnoreCase(input.toString())) {
						showPopup("	         No feasible way");
					} else if ("NP".equalsIgnoreCase(input.toString())) {
						showPopup("	         No problem");
					} else if ("N/P".equalsIgnoreCase(input.toString())) {
						showPopup("	         No problem");
					} else if ("NRN".equalsIgnoreCase(input.toString())) {
						showPopup("	         No response necessary");
					} else if ("NSA".equalsIgnoreCase(input.toString())) {
						showPopup("	         No strings attached");
					} else if ("NSFW".equalsIgnoreCase(input.toString())) {
						showPopup("	         Not safe for work");
					} else if ("NSISR".equalsIgnoreCase(input.toString())) {
						showPopup("	         Not sure if spelled right");
					} else if ("NT".equalsIgnoreCase(input.toString())) {
						showPopup("	         Nice try");
					} else if ("NTHING".equalsIgnoreCase(input.toString())) {
						showPopup("	         Nothing (SMS)");
					} else if ("NVM".equalsIgnoreCase(input.toString())) {
						showPopup("	         Never mind");
					} else if ("NVR".equalsIgnoreCase(input.toString())) {
						showPopup("	        Never");
					} else if ("NW".equalsIgnoreCase(input.toString())) {
						showPopup("	        No way");
					} else if ("NWO".equalsIgnoreCase(input.toString())) {
						showPopup("	        No way out");
					} else if ("O4U".equalsIgnoreCase(input.toString())) {
						showPopup("	        Only for you");
					} else if ("O".equalsIgnoreCase(input.toString())) {
						showPopup("	        Hugs" + "\n" + "\n" + "Over");
					} else if ("OA".equalsIgnoreCase(input.toString())) {
						showPopup("	        Online auctions");
					} else if ("OATUS".equalsIgnoreCase(input.toString())) {
						showPopup("	        On a totally unrelated subject");
					} else if ("OB".equalsIgnoreCase(input.toString())) {
						showPopup("	        Oh baby" + "\n" + "\n"
								+ "Oh brother");
					} else if ("OI".equalsIgnoreCase(input.toString())) {
						showPopup("	         Operator indisposed");
					} else if ("OIC".equalsIgnoreCase(input.toString())) {
						showPopup("	         Oh, I see");
					} else if ("OLL".equalsIgnoreCase(input.toString())) {
						showPopup("	        Online love");
					} else if ("OIB".equalsIgnoreCase(input.toString())) {
						showPopup("	        Oh, I'm back");
					} else if ("OJ".equalsIgnoreCase(input.toString())) {
						showPopup("	        Only joking");
					} else if ("OL".equalsIgnoreCase(input.toString())) {
						showPopup("	        Old lady");
					} else if ("OM".equalsIgnoreCase(input.toString())) {
						showPopup("	        Old man" + "\n" + "\n" + "Oh, my");
					} else if ("OMG".equalsIgnoreCase(input.toString())) {
						showPopup("	        Oh my God");
					} else if ("OMGYG2BK".equalsIgnoreCase(input.toString())) {
						showPopup("	        Oh my God, you got to be kidding");
					} else if ("OMW".equalsIgnoreCase(input.toString())) {
						showPopup("	        On my way");
					} else if ("ONL".equalsIgnoreCase(input.toString())) {
						showPopup("	        Online");
					} else if ("OTF".equalsIgnoreCase(input.toString())) {
						showPopup("	        Off the floor");
					} else if ("OTOH".equalsIgnoreCase(input.toString())) {
						showPopup("	        On the other hand");
					} else if ("OTTOMH".equalsIgnoreCase(input.toString())) {
						showPopup("	        Off the top of my head");
					} else if ("OO".equalsIgnoreCase(input.toString())) {
						showPopup("	        Over and out");
					} else if ("OOC".equalsIgnoreCase(input.toString())) {
						showPopup("	        Out of character");
					} else if ("OOH".equalsIgnoreCase(input.toString())) {
						showPopup("	        Out of here");
					} else if ("OOTD".equalsIgnoreCase(input.toString())) {
						showPopup("	        One of these days");
					} else if ("OOTO".equalsIgnoreCase(input.toString())) {
						showPopup("	        Out of the office");
					} else if ("OP".equalsIgnoreCase(input.toString())) {
						showPopup("	        On phone");
					} else if ("ORLY".equalsIgnoreCase(input.toString())) {
						showPopup("	        Oh really?");
					} else if ("OT".equalsIgnoreCase(input.toString())) {
						showPopup("	       Off topic (discussion forums)");
					} else if ("OTB".equalsIgnoreCase(input.toString())) {
						showPopup("	       Off to bed");
					} else if ("OTFL".equalsIgnoreCase(input.toString())) {
						showPopup("	       On the floor laughing");
					} else if ("OTL".equalsIgnoreCase(input.toString())) {
						showPopup("	        Out to lunch");
					} else if ("OTOH".equalsIgnoreCase(input.toString())) {
						showPopup("	        On the other hand");
					} else if ("OTP".equalsIgnoreCase(input.toString())) {
						showPopup("	        On the phone");
					} else if ("OTT".equalsIgnoreCase(input.toString())) {
						showPopup("	         Over the top");
					} else if ("OTTOMH".equalsIgnoreCase(input.toString())) {
						showPopup("	         Off the top of my head");
					} else if ("OTW".equalsIgnoreCase(input.toString())) {
						showPopup("	         Off to work");
					} else if ("OVA".equalsIgnoreCase(input.toString())) {
						showPopup("	         Over");
					} else if ("OYO".equalsIgnoreCase(input.toString())) {
						showPopup("	         On your own");
					} else if ("p2p".equalsIgnoreCase(input.toString())) {
						showPopup("	         Parent to parent" + "\n" + "\n"
								+ "Peer to peer");
					} else if ("PANS".equalsIgnoreCase(input.toString())) {
						showPopup("	         Pretty awesome new stuff");
					} else if ("PAW".equalsIgnoreCase(input.toString())) {
						showPopup("	         Parents are watching");
					} else if ("PCMCIA".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	         People can't master computer industry acronyms");
					} else if ("PDA".equalsIgnoreCase(input.toString())) {
						showPopup("	         Public display of affection ");
					} else if ("PDH".equalsIgnoreCase(input.toString())) {
						showPopup("	         Pretty darn happy");
					} else if ("PDS".equalsIgnoreCase(input.toString())) {
						showPopup("	         Please don't shoot");
					} else if ("PDQ".equalsIgnoreCase(input.toString())) {
						showPopup("	         Pretty darn quick");
					} else if ("PEBCAK".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	         Problem exists between chair and keyboard");
					} else if ("PEEPS".equalsIgnoreCase(input.toString())) {
						showPopup("	        People");
					} else if ("PFT".equalsIgnoreCase(input.toString())) {
						showPopup("	        Pretty *freaking* tight");
					} else if ("PIC".equalsIgnoreCase(input.toString())) {
						showPopup("	        Picture");
					} else if ("PIR".equalsIgnoreCase(input.toString())) {
						showPopup("	        Parents in room");
					} else if ("PISS".equalsIgnoreCase(input.toString())) {
						showPopup("	        Put in some sugar");
					} else if ("PIBKAC".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	        Problem is between keyboard and chair");
					} else if ("PITA".equalsIgnoreCase(input.toString())) {
						showPopup("	        Pain in the ass");
					} else if ("PL8".equalsIgnoreCase(input.toString())) {
						showPopup("	        Played");
					} else if ("PLMK".equalsIgnoreCase(input.toString())) {
						showPopup("	        Please let me know");
					} else if ("PLS".equalsIgnoreCase(input.toString())) {
						showPopup("	        Please");
					} else if ("PLU".equalsIgnoreCase(input.toString())) {
						showPopup("	        People like us");
					} else if ("PLZ".equalsIgnoreCase(input.toString())) {
						showPopup("	        Please");
					} else if ("PM".equalsIgnoreCase(input.toString())) {
						showPopup("	        Private Message");
					} else if ("PMFI".equalsIgnoreCase(input.toString())) {
						showPopup("	        Pardon me for interrupting");
					} else if ("PMFJI".equalsIgnoreCase(input.toString())) {
						showPopup("	        Pardon me for jumping in");
					} else if ("POAHF".equalsIgnoreCase(input.toString())) {
						showPopup("	        Put on a happy face");
					} else if ("::POOF::".equalsIgnoreCase(input.toString())) {
						showPopup("	        Goodbye (leaving the room)");
					} else if ("POTS".equalsIgnoreCase(input.toString())) {
						showPopup("	       Plain old telephone service");
					} else if ("POAHF".equalsIgnoreCase(input.toString())) {
						showPopup("	       Put on a happy face");
					} else if ("POS".equalsIgnoreCase(input.toString())) {
						showPopup("	       Parent over shoulder");
					} else if ("POV".equalsIgnoreCase(input.toString())) {
						showPopup("	       Point of view" + "\n" + "\n"
								+ "Privately owned vehicle");
					} else if ("PPL".equalsIgnoreCase(input.toString())) {
						showPopup("	       People");
					} else if ("PPU".equalsIgnoreCase(input.toString())) {
						showPopup("	       Pending pick-up");
					} else if ("PROLLY".equalsIgnoreCase(input.toString())) {
						showPopup("	       Probably");
					} else if ("PROGGY".equalsIgnoreCase(input.toString())) {
						showPopup("	       Computer program");
					} else if ("PORN".equalsIgnoreCase(input.toString())) {
						showPopup("	       Pornography");
					} else if ("PRON".equalsIgnoreCase(input.toString())) {
						showPopup("	       Pornography");
					} else if ("PRT".equalsIgnoreCase(input.toString())) {
						showPopup("	       Party");
					} else if ("PRW".equalsIgnoreCase(input.toString())) {
						showPopup("	       People/parents are watching");
					} else if ("PSOS".equalsIgnoreCase(input.toString())) {
						showPopup("	       Parent standing over shoulder");
					} else if ("PSP".equalsIgnoreCase(input.toString())) {
						showPopup("	       Playstation Portable");
					} else if ("PTL".equalsIgnoreCase(input.toString())) {
						showPopup("	       Praise the Lord");
					} else if ("PTMM".equalsIgnoreCase(input.toString())) {
						showPopup("	       Please tell me more");
					} else if ("PU".equalsIgnoreCase(input.toString())) {
						showPopup("	       That stinks!");
					} else if ("PWN".equalsIgnoreCase(input.toString())) {
						showPopup("	       Own");
					} else if ("PXT".equalsIgnoreCase(input.toString())) {
						showPopup("	       Please explain that");
					} else if ("PZ".equalsIgnoreCase(input.toString())) {
						showPopup("	       Peace");
					} else if ("PZA".equalsIgnoreCase(input.toString())) {
						showPopup("	       Pizza ");
					} else if ("Q".equalsIgnoreCase(input.toString())) {
						showPopup("	       Queue");
					} else if ("QFE".equalsIgnoreCase(input.toString())) {
						showPopup("	       Question for everyone");
					} else if ("QFI".equalsIgnoreCase(input.toString())) {
						showPopup("	      Quoted for idiocy" + "\n" + "\n"
								+ "Quoted for irony");
					} else if ("QIK".equalsIgnoreCase(input.toString())) {
						showPopup("	      Quick");
					} else if ("QL".equalsIgnoreCase(input.toString())) {
						showPopup("	      Quit laughing");
					} else if ("QQ".equalsIgnoreCase(input.toString())) {
						showPopup("	      Crying eyes" + "\n" + "\n"
								+ "Quick question");
					} else if ("QSL".equalsIgnoreCase(input.toString())) {
						showPopup("	      Reply");
					} else if ("QSO".equalsIgnoreCase(input.toString())) {
						showPopup("	      Conversation");
					} else if ("QT".equalsIgnoreCase(input.toString())) {
						showPopup("	      Cutie");
					} else if ("QTPI".equalsIgnoreCase(input.toString())) {
						showPopup("	      Cutie pie");
					} else if ("R8".equalsIgnoreCase(input.toString())) {
						showPopup("	      Rate");
					} else if ("RIP".equalsIgnoreCase(input.toString())) {
						showPopup("	      Rest in peace");
					} else if ("RL".equalsIgnoreCase(input.toString())) {
						showPopup("	      Real life");
					} else if ("RLY".equalsIgnoreCase(input.toString())) {
						showPopup("	      Really");
					} else if ("RME".equalsIgnoreCase(input.toString())) {
						showPopup("	      Rolling my eyes");
					} else if ("RMLB".equalsIgnoreCase(input.toString())) {
						showPopup("	      Read my lips baby");
					} else if ("RMMM".equalsIgnoreCase(input.toString())) {
						showPopup("	      Read my mail man");
					} else if ("ROR".equalsIgnoreCase(input.toString())) {
						showPopup("	      Raffing out roud ");
					} else if ("ROTFL".equalsIgnoreCase(input.toString())) {
						showPopup("	      Rolling on the floor laughing");
					} else if ("ROFL".equalsIgnoreCase(input.toString())) {
						showPopup("	      Rolling on floor laughing");
					} else if ("ROTFLMAO".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	      Rolling on the floor laughing my ass off");
					} else if ("ROFLMAO".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	      Rolling on the floor, laughing my ass off");
					} else if ("ROFLCOPTER".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	      Rolling on floor laughing and spinning around");
					} else if ("ROFASA".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	      Rolling on floor laughing and spinning around");
					} else if ("ROTFLUTS".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	      Rolling on the floor laughing unable to speak");
					} else if ("RPG".equalsIgnoreCase(input.toString())) {
						showPopup("	      Role-playing games");
					} else if ("RSN".equalsIgnoreCase(input.toString())) {
						showPopup("	      Real soon now");
					} else if ("RT".equalsIgnoreCase(input.toString())) {
						showPopup("	     Real time");
					} else if ("RTBS".equalsIgnoreCase(input.toString())) {
						showPopup("	     Reason to be single");
					} else if ("RTFM".equalsIgnoreCase(input.toString())) {
						showPopup("	     Read the *freaking* manual");
					} else if ("RTFQ".equalsIgnoreCase(input.toString())) {
						showPopup("	     Read the *freaking* question");
					} else if ("RTNTN".equalsIgnoreCase(input.toString())) {
						showPopup("	     Retention (e-mail, Government)");
					} else if ("RTRMT".equalsIgnoreCase(input.toString())) {
						showPopup("	    Retirement (e-mail, Government)");
					} else if ("RTSM".equalsIgnoreCase(input.toString())) {
						showPopup("	    Read the stupid manual");
					} else if ("RU".equalsIgnoreCase(input.toString())) {
						showPopup("	    Are you?");
					} else if ("RUMOF".equalsIgnoreCase(input.toString())) {
						showPopup("	    Are you male or female?");
					} else if ("RUT".equalsIgnoreCase(input.toString())) {
						showPopup("	    Are you there?");
					} else if ("RUOK".equalsIgnoreCase(input.toString())) {
						showPopup("	    Are you okay?");
					} else if ("RX".equalsIgnoreCase(input.toString())) {
						showPopup("	    Regards" + "\n" + "\n"
								+ "Meaning drugs or prescriptions");
					} else if ("RW".equalsIgnoreCase(input.toString())) {
						showPopup("	    Real world");
					} else if ("HYD".equalsIgnoreCase(input.toString())) {
						showPopup("	    How you doing");
					} else if ("ikr".equalsIgnoreCase(input.toString())) {
						showPopup("	    i know right");
					} else if ("RYB".equalsIgnoreCase(input.toString())) {
						showPopup("	    Read your Bible ");
					} else if ("RYS".equalsIgnoreCase(input.toString())) {
						showPopup("	    Read your screen" + "\n" + "\n"
								+ "Are you single?");
					} else if ("RYS".equalsIgnoreCase(input.toString())) {
						showPopup("	    Roll your own");
					} else if ("S^".equalsIgnoreCase(input.toString())) {
						showPopup("	    S'up - what's up");
					} else if ("SH^".equalsIgnoreCase(input.toString())) {
						showPopup("	    Shut up");
					} else if ("S2R".equalsIgnoreCase(input.toString())) {
						showPopup("	    Send to receive");
					} else if ("S2S".equalsIgnoreCase(input.toString())) {
						showPopup("	    Sorry to say");
					} else if ("S4L".equalsIgnoreCase(input.toString())) {
						showPopup("	    Spam for life");
					} else if ("SAL".equalsIgnoreCase(input.toString())) {
						showPopup("	    Such a laugh");
					} else if ("SBT".equalsIgnoreCase(input.toString())) {
						showPopup("	    Sorry 'bout that");
					} else if ("SC".equalsIgnoreCase(input.toString())) {
						showPopup("	    Stay cool");
					} else if ("SETE".equalsIgnoreCase(input.toString())) {
						showPopup("	    Smiling ear to ear");
					} else if ("SDMB".equalsIgnoreCase(input.toString())) {
						showPopup("	    Sweet dreams, my baby");
					} else if ("SF".equalsIgnoreCase(input.toString())) {
						showPopup("	    Surfer-friendly");
					} else if ("SFAIK".equalsIgnoreCase(input.toString())) {
						showPopup("	    So far as I know");
					} else if ("SH".equalsIgnoreCase(input.toString())) {
						showPopup("	    Same here");
					} else if ("SHCOON".equalsIgnoreCase(input.toString())) {
						showPopup("	    Shoot hot coffee out of nose");
					} else if ("SHID".equalsIgnoreCase(input.toString())) {
						showPopup("	    Slap(ing)s head in disgust");
					} else if ("SICNR".equalsIgnoreCase(input.toString())) {
						showPopup("	    Sorry, I could not resist");
					} else if ("SIG2R".equalsIgnoreCase(input.toString())) {
						showPopup("	    Sorry, I got to run");
					} else if ("SIHTH".equalsIgnoreCase(input.toString())) {
						showPopup("	    Stupidity is hard to take");
					} else if ("SIMYC".equalsIgnoreCase(input.toString())) {
						showPopup("	    Sorry I missed your call");
					} else if ("SIR".equalsIgnoreCase(input.toString())) {
						showPopup("	    Strike it rich");
					} else if ("SIS".equalsIgnoreCase(input.toString())) {
						showPopup("	    Snickering in silence");
					} else if ("SIT".equalsIgnoreCase(input.toString())) {
						showPopup("	    Stay in touch");
					} else if ("SK8".equalsIgnoreCase(input.toString())) {
						showPopup("	    Skate");
					} else if ("SK8NG".equalsIgnoreCase(input.toString())) {
						showPopup("	    Skating");
					} else if ("SK8R".equalsIgnoreCase(input.toString())) {
						showPopup("	    Skater");
					} else if ("SLAP".equalsIgnoreCase(input.toString())) {
						showPopup("	    Sounds like a plan");
					} else if ("SMHID".equalsIgnoreCase(input.toString())) {
						showPopup("	    Scratching my head in disbelief");
					} else if ("SN".equalsIgnoreCase(input.toString())) {
						showPopup("	    Situation normal");
					} else if ("SNERT".equalsIgnoreCase(input.toString())) {
						showPopup("	    Snot nosed egotistical rude teenager");
					} else if ("SO".equalsIgnoreCase(input.toString())) {
						showPopup("	    Significant other");
					} else if ("S'OK".equalsIgnoreCase(input.toString())) {
						showPopup("	    It is okay");
					} else if ("SOL".equalsIgnoreCase(input.toString())) {
						showPopup("	    Sooner or later");
					} else if ("SOMY".equalsIgnoreCase(input.toString())) {
						showPopup("	    Sick of me yet?");
					} else if ("SOMY".equalsIgnoreCase(input.toString())) {
						showPopup("	    Straight or Gay?");
					} else if ("SOS".equalsIgnoreCase(input.toString())) {
						showPopup("	    Emergency / help");
					} else if ("SOT".equalsIgnoreCase(input.toString())) {
						showPopup("	    Short of time");
					} else if ("SOTMG".equalsIgnoreCase(input.toString())) {
						showPopup("	    Short of time, must go");
					} else if ("SPK".equalsIgnoreCase(input.toString())) {
						showPopup("	    Speak (SMS)");
					} else if ("SRSLY".equalsIgnoreCase(input.toString())) {
						showPopup("	    Seriously");
					} else if ("SPST".equalsIgnoreCase(input.toString())) {
						showPopup("	    Same place, same time");
					} else if ("SPTO".equalsIgnoreCase(input.toString())) {
						showPopup("	    Spoke to");
					} else if ("SQ".equalsIgnoreCase(input.toString())) {
						showPopup("	    Square");
					} else if ("SRY".equalsIgnoreCase(input.toString())) {
						showPopup("	    Sorry");
					} else if ("SS".equalsIgnoreCase(input.toString())) {
						showPopup("	    So sorry");
					} else if ("SSDD".equalsIgnoreCase(input.toString())) {
						showPopup("	    Same stuff, different day");
					} else if ("SSIF".equalsIgnoreCase(input.toString())) {
						showPopup("	    So stupid it's funny");
					} else if ("STW".equalsIgnoreCase(input.toString())) {
						showPopup("	    Search the Web");
					} else if ("ST&D".equalsIgnoreCase(input.toString())) {
						showPopup("	    Stop texting and drive");
					} else if ("STFU".equalsIgnoreCase(input.toString())) {
						showPopup("	     Shut the *freak* up");
					} else if ("STR8".equalsIgnoreCase(input.toString())) {
						showPopup("	     Straight");
					} else if ("STW".equalsIgnoreCase(input.toString())) {
						showPopup("	     Search the Web");
					} else if ("SUITM".equalsIgnoreCase(input.toString())) {
						showPopup("	     See you in the morning");
					} else if ("SUL".equalsIgnoreCase(input.toString())) {
						showPopup("	     See you later");
					} else if ("SUP".equalsIgnoreCase(input.toString())) {
						showPopup("	     What's up?");
					} else if ("SUX".equalsIgnoreCase(input.toString())) {
						showPopup("	     Sucks / it sucks");
					} else if ("SU".equalsIgnoreCase(input.toString())) {
						showPopup("	     Sucks / it sucks");
					} else if ("SUAKM".equalsIgnoreCase(input.toString())) {
						showPopup("	     Shut up and kiss me");
					} else if ("SWAK".equalsIgnoreCase(input.toString())) {
						showPopup("	     Sent (or sealed) with a kiss");
					} else if ("SWALK".equalsIgnoreCase(input.toString())) {
						showPopup("	     Sealed (or sealed) with a loving kiss");
					} else if ("SWAT".equalsIgnoreCase(input.toString())) {
						showPopup("	      Scientific wild *butt* guess");
					} else if ("SWL".equalsIgnoreCase(input.toString())) {
						showPopup("	      Screaming with laughter");
					} else if ("SWMBO".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	      She who must be obeyed. (wife or partner)");
					} else if ("SWAG".equalsIgnoreCase(input.toString())) {
						showPopup("	      Stupid wild ass guess");
					} else if ("SWAK".equalsIgnoreCase(input.toString())) {
						showPopup("	      Sealed with a kiss");
					} else if ("SWL".equalsIgnoreCase(input.toString())) {
						showPopup("	      Screaming with laughter");
					} else if ("SYS".equalsIgnoreCase(input.toString())) {
						showPopup("	      See you soon");
					} else if ("SYL".equalsIgnoreCase(input.toString())) {
						showPopup("	      See you later");
					} else if ("T".equalsIgnoreCase(input.toString())) {
						showPopup("	      Think positive");
					} else if ("T4BU".equalsIgnoreCase(input.toString())) {
						showPopup("	      Thanks for being you");
					} else if ("T:)T".equalsIgnoreCase(input.toString())) {
						showPopup("	      Think happy thoughts");
					} else if ("TA".equalsIgnoreCase(input.toString())) {
						showPopup("	      Thanks a lot");
					} else if ("TA".equalsIgnoreCase(input.toString())) {
						showPopup("	      Thanks again");
					} else if ("TAFN".equalsIgnoreCase(input.toString())) {
						showPopup("	      That's all for now");
					} else if ("TAM".equalsIgnoreCase(input.toString())) {
						showPopup("	      Tomorrow a.m.");
					} else if ("TANK".equalsIgnoreCase(input.toString())) {
						showPopup("	      Meaning really strong");
					} else if ("TANKED".equalsIgnoreCase(input.toString())) {
						showPopup("	      Owned");
					} else if ("TANKING".equalsIgnoreCase(input.toString())) {
						showPopup("	      Owning");
					} else if ("TARFU".equalsIgnoreCase(input.toString())) {
						showPopup("	      Things are really fouled up.");
					} else if ("TAU".equalsIgnoreCase(input.toString())) {
						showPopup("	     Thinking about you");
					} else if ("TAUMUALU".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	     Thinking about you miss you always love you");
					} else if ("TAFN".equalsIgnoreCase(input.toString())) {
						showPopup("	     That's all for now");
					} else if ("TANSTAAFL".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	     There ain't no such thing as a free lunch");
					} else if ("TBC".equalsIgnoreCase(input.toString())) {
						showPopup("	     To be continued");
					} else if ("TBD".equalsIgnoreCase(input.toString())) {
						showPopup("	     To be determined");
					} else if ("TBH".equalsIgnoreCase(input.toString())) {
						showPopup("	     To be honest");
					} else if ("TB4U".equalsIgnoreCase(input.toString())) {
						showPopup("	     Too bad for you");
					} else if ("TBL".equalsIgnoreCase(input.toString())) {
						showPopup("	     Text back later");
					} else if ("TC".equalsIgnoreCase(input.toString())) {
						showPopup("	     Take care");
					} else if ("TCB".equalsIgnoreCase(input.toString())) {
						showPopup("	     Take care of business");
					} else if ("TCOY".equalsIgnoreCase(input.toString())) {
						showPopup("	     Take care of yourself");
					} else if ("TFS".equalsIgnoreCase(input.toString())) {
						showPopup("	     Thanks for sharing");
					} else if ("TGIF".equalsIgnoreCase(input.toString())) {
						showPopup("	      Thank God it's Friday");
					} else if ("THX".equalsIgnoreCase(input.toString())) {
						showPopup("	      Thanks");
					} else if ("THNX".equalsIgnoreCase(input.toString())) {
						showPopup("	      Thanks");
					} else if ("THNQ".equalsIgnoreCase(input.toString())) {
						showPopup("	      Thank you (SMS)");
					} else if ("THT".equalsIgnoreCase(input.toString())) {
						showPopup("	      Think happy thoughts");
					} else if ("TILII".equalsIgnoreCase(input.toString())) {
						showPopup("	      Tell it like it is");
					} else if ("TIA".equalsIgnoreCase(input.toString())) {
						showPopup("	      Thanks in advance");
					} else if ("TIAD".equalsIgnoreCase(input.toString())) {
						showPopup("	      Tomorrow is another day");
					} else if ("TIC".equalsIgnoreCase(input.toString())) {
						showPopup("	      Tongue-in-cheek");
					} else if ("TILIS".equalsIgnoreCase(input.toString())) {
						showPopup("	      Tell it like it is");
					} else if ("TLK2UL8R".equalsIgnoreCase(input.toString())) {
						showPopup("	      Talk to you later");
					} else if ("TL".equalsIgnoreCase(input.toString())) {
						showPopup("	      Too long");
					} else if ("TLA".equalsIgnoreCase(input.toString())) {
						showPopup("	      Three-letter acronym");
					} else if ("TTYAFN".equalsIgnoreCase(input.toString())) {
						showPopup("	      Talk to you awhile from now");
					} else if ("TLK2UL8R".equalsIgnoreCase(input.toString())) {
						showPopup("	      Talk to you later");
					} else if ("TMI".equalsIgnoreCase(input.toString())) {
						showPopup("	      Too much information");
					} else if ("TMB".equalsIgnoreCase(input.toString())) {
						showPopup("	      Text me back");
					} else if ("TMOT".equalsIgnoreCase(input.toString())) {
						showPopup("	      Trust me on this");
					} else if ("TMTH".equalsIgnoreCase(input.toString())) {
						showPopup("	      Too much to handle");
					} else if ("TMWFI".equalsIgnoreCase(input.toString())) {
						showPopup("	      Take my word for it");
					} else if ("TMWFI".equalsIgnoreCase(input.toString())) {
						showPopup("	      Take my word for it");
					} else if ("TNSTAAFL".equalsIgnoreCase(input.toString())) {
						showPopup("	     There's no such thing as a free lunch");
					} else if ("TNT".equalsIgnoreCase(input.toString())) {
						showPopup("	     Till next time");
					} else if ("TOPCA".equalsIgnoreCase(input.toString())) {
						showPopup("	     Til our paths cross again");
					} else if ("TOY".equalsIgnoreCase(input.toString())) {
						showPopup("	     Thinking of you");
					} else if ("TOY".equalsIgnoreCase(input.toString())) {
						showPopup("	     Thinking of you");
					} else if ("TOJ".equalsIgnoreCase(input.toString())) {
						showPopup("	     Tears of joy");
					} else if ("TOS".equalsIgnoreCase(input.toString())) {
						showPopup("	     Terms of service");
					} else if ("TOU".equalsIgnoreCase(input.toString())) {
						showPopup("	     Thinking of you");
					} else if ("TOY".equalsIgnoreCase(input.toString())) {
						showPopup("	     Thinking of you");
					} else if ("TPM".equalsIgnoreCase(input.toString())) {
						showPopup("	     Tomorrow p.m.");
					} else if ("TPTB".equalsIgnoreCase(input.toString())) {
						showPopup("	     The powers that be");
					} else if ("TPTB".equalsIgnoreCase(input.toString())) {
						showPopup("	     The powers that be");
					} else if ("TQ".equalsIgnoreCase(input.toString())) {
						showPopup("	     Te quiero / I love you");
					} else if ("TQ".equalsIgnoreCase(input.toString())) {
						showPopup("	     Tripping so hard");
					} else if ("TSNF".equalsIgnoreCase(input.toString())) {
						showPopup("	    That's so not fair");
					} else if ("TSTB".equalsIgnoreCase(input.toString())) {
						showPopup("	    The sooner, the better");
					} else if ("TTLY".equalsIgnoreCase(input.toString())) {
						showPopup("	    Totally");
					} else if ("TTTT".equalsIgnoreCase(input.toString())) {
						showPopup("	    These things take time");
					} else if ("TTUL".equalsIgnoreCase(input.toString())) {
						showPopup("	    Talk to you later");
					} else if ("TTG".equalsIgnoreCase(input.toString())) {
						showPopup("	    Time to go");
					} else if ("TTFN".equalsIgnoreCase(input.toString())) {
						showPopup("	    Ta-Ta for now");
					} else if ("TTT".equalsIgnoreCase(input.toString())) {
						showPopup("	    Thought that, too");
					} else if ("TTYL".equalsIgnoreCase(input.toString())) {
						showPopup("	    Talk to you later");
					} else if ("TTYS".equalsIgnoreCase(input.toString())) {
						showPopup("	    Talk to you soon");
					} else if ("TU".equalsIgnoreCase(input.toString())) {
						showPopup("	    Thank you");
					} else if ("TWSS".equalsIgnoreCase(input.toString())) {
						showPopup("	    That's what she said ");
					} else if ("TY".equalsIgnoreCase(input.toString())) {
						showPopup("	    Thank you ");
					} else if ("TYFYC".equalsIgnoreCase(input.toString())) {
						showPopup("	    Thank you for your comment");
					} else if ("TYS".equalsIgnoreCase(input.toString())) {
						showPopup("	    Told you so");
					} else if ("TYT".equalsIgnoreCase(input.toString())) {
						showPopup("	    Take your time");
					} else if ("TYT".equalsIgnoreCase(input.toString())) {
						showPopup("	    Take your time");
					} else if ("TYVM".equalsIgnoreCase(input.toString())) {
						showPopup("	    Thank you very much");
					} else if ("TYSM".equalsIgnoreCase(input.toString())) {
						showPopup("	    Thank you so much");
					} else if ("^URS".equalsIgnoreCase(input.toString())) {
						showPopup("	    Up yours");
					} else if ("UAPITA".equalsIgnoreCase(input.toString())) {
						showPopup("	    You're a pain in the ass");
					} else if ("UAF".equalsIgnoreCase(input.toString())) {
						showPopup("	    Until further notice");
					} else if ("UAF".equalsIgnoreCase(input.toString())) {
						showPopup("	    You crack me up");
					} else if ("UDI".equalsIgnoreCase(input.toString())) {
						showPopup("	    Unidentified drinking injury");
					} else if ("UDM".equalsIgnoreCase(input.toString())) {
						showPopup("	    You the man");
					} else if ("UDS".equalsIgnoreCase(input.toString())) {
						showPopup("	    Ugly domestic scene");
					} else if ("UFN".equalsIgnoreCase(input.toString())) {
						showPopup("	    Until further notice");
					} else if ("UGTBK".equalsIgnoreCase(input.toString())) {
						showPopup("	    You've got to be kidding");
					} else if ("UKTR".equalsIgnoreCase(input.toString())) {
						showPopup("	    You know that's right");
					} else if ("UL".equalsIgnoreCase(input.toString())) {
						showPopup("	    Upload");
					} else if ("U-L".equalsIgnoreCase(input.toString())) {
						showPopup("	    You will");
					} else if ("UNA".equalsIgnoreCase(input.toString())) {
						showPopup("	    Use no acronyms");
					} else if ("UN4TUN8".equalsIgnoreCase(input.toString())) {
						showPopup("	    Unfortunate");
					} else if ("UNBLEFBLE".equalsIgnoreCase(input.toString())) {
						showPopup("	    Unbelievable");
					} else if ("UNCRTN".equalsIgnoreCase(input.toString())) {
						showPopup("	    Uncertain");
					} else if ("UNPC".equalsIgnoreCase(input.toString())) {
						showPopup("	    Not politically correct");
					} else if ("UOK".equalsIgnoreCase(input.toString())) {
						showPopup("	    Are you ok?");
					} else if ("UR".equalsIgnoreCase(input.toString())) {
						showPopup("	    Your / You're");
					} else if ("UR2YS4ME".equalsIgnoreCase(input.toString())) {
						showPopup("	    You are too wise for me");
					} else if ("URA*".equalsIgnoreCase(input.toString())) {
						showPopup("	    You are a star");
					} else if ("URH".equalsIgnoreCase(input.toString())) {
						showPopup("	    You are hot");
					} else if ("URL".equalsIgnoreCase(input.toString())) {
						showPopup("	    Uniform Resource Locator");
					} else if ("URSKTM".equalsIgnoreCase(input.toString())) {
						showPopup("	    You are so kind to me");
					} else if ("URTM".equalsIgnoreCase(input.toString())) {
						showPopup("	    You are the man");
					} else if ("URW".equalsIgnoreCase(input.toString())) {
						showPopup("	    You are welcome");
					} else if ("USBCA".equalsIgnoreCase(input.toString())) {
						showPopup("	    Until something better comes along");
					} else if ("USU".equalsIgnoreCase(input.toString())) {
						showPopup("	    Usually");
					} else if ("UT2L".equalsIgnoreCase(input.toString())) {
						showPopup("	    You take too long");
					} else if ("UV".equalsIgnoreCase(input.toString())) {
						showPopup("	    Unpleasant visual");
					} else if ("UW".equalsIgnoreCase(input.toString())) {
						showPopup("	    Unpleasant visual");
					} else if ("VBS".equalsIgnoreCase(input.toString())) {
						showPopup("	    Very big smile");
					} else if ("VEG".equalsIgnoreCase(input.toString())) {
						showPopup("	    Very evil grin");
					} else if ("VFF".equalsIgnoreCase(input.toString())) {
						showPopup("	    Very freaking funny");
					} else if ("VFM".equalsIgnoreCase(input.toString())) {
						showPopup("	    Value for money");
					} else if ("VGC".equalsIgnoreCase(input.toString())) {
						showPopup("	    Very good condition");
					} else if ("VIP".equalsIgnoreCase(input.toString())) {
						showPopup("	    Very important person");
					} else if ("VM".equalsIgnoreCase(input.toString())) {
						showPopup("	    Voice mail");
					} else if ("VRY".equalsIgnoreCase(input.toString())) {
						showPopup("	    Very");
					} else if ("VSC".equalsIgnoreCase(input.toString())) {
						showPopup("	    Very soft chuckle");
					} else if ("VSF".equalsIgnoreCase(input.toString())) {
						showPopup("	    Very sad face");
					} else if ("VBG".equalsIgnoreCase(input.toString())) {
						showPopup("	    Very big grin");
					} else if ("W@".equalsIgnoreCase(input.toString())) {
						showPopup("	    What?");
					} else if ("W/B".equalsIgnoreCase(input.toString())) {
						showPopup("	    Welcome back");
					} else if ("W3".equalsIgnoreCase(input.toString())) {
						showPopup("	   World wide web / web address");
					} else if ("WWW".equalsIgnoreCase(input.toString())) {
						showPopup("	   World wide web / web address");
					} else if ("WAG".equalsIgnoreCase(input.toString())) {
						showPopup("	   Wild a** guess");
					} else if ("W8".equalsIgnoreCase(input.toString())) {
						showPopup("	   Wait");
					} else if ("WAYD".equalsIgnoreCase(input.toString())) {
						showPopup("	   What are you doing");
					} else if ("WAH".equalsIgnoreCase(input.toString())) {
						showPopup("	   Working at home");
					} else if ("WAJ".equalsIgnoreCase(input.toString())) {
						showPopup("	   What a Jerk");
					} else if ("WAM".equalsIgnoreCase(input.toString())) {
						showPopup("	  Wait a minute");
					} else if ("WAN2".equalsIgnoreCase(input.toString())) {
						showPopup("	  Want to? (SMS)");
					} else if ("WAN2TLK".equalsIgnoreCase(input.toString())) {
						showPopup("	  Want to talk");
					} else if ("WAREZ".equalsIgnoreCase(input.toString())) {
						showPopup("	  Pirated");
					} else if ("WAS".equalsIgnoreCase(input.toString())) {
						showPopup("	  Wait a second");
					} else if ("WAG".equalsIgnoreCase(input.toString())) {
						showPopup("	  Wild ass guess");
					} else if ("WAWA".equalsIgnoreCase(input.toString())) {
						showPopup("	  Where are we at?");
					} else if ("WAYF".equalsIgnoreCase(input.toString())) {
						showPopup("	  Where are you from?");
					} else if ("WB".equalsIgnoreCase(input.toString())) {
						showPopup("	  Welcome back");
					} else if ("WBS".equalsIgnoreCase(input.toString())) {
						showPopup("	  Write back soon");
					} else if ("W/B".equalsIgnoreCase(input.toString())) {
						showPopup("	  Write back");
					} else if ("WBU".equalsIgnoreCase(input.toString())) {
						showPopup("	   What about you?");
					} else if ("WC".equalsIgnoreCase(input.toString())) {
						showPopup("	   Welcome" + "\n" + "\n" + "Who cares");
					} else if ("WCA".equalsIgnoreCase(input.toString())) {
						showPopup("	   Who cares anyway");
					} else if ("WDALYIC".equalsIgnoreCase(input.toString())) {
						showPopup("	   Who died and left you in charge");
					} else if ("WDYK".equalsIgnoreCase(input.toString())) {
						showPopup("	   What do you know?");
					} else if ("WDYT".equalsIgnoreCase(input.toString())) {
						showPopup("	   What do you think?");
					} else if ("WE".equalsIgnoreCase(input.toString())) {
						showPopup("	   Whatever");
					} else if ("W/E".equalsIgnoreCase(input.toString())) {
						showPopup("	   Whatever");
					} else if ("W/END".equalsIgnoreCase(input.toString())) {
						showPopup("	   Weekend");
					} else if ("WFM".equalsIgnoreCase(input.toString())) {
						showPopup("	   Works for me");
					} else if ("WIBNI".equalsIgnoreCase(input.toString())) {
						showPopup("	   Wouldn't it be nice if");
					} else if ("WH5".equalsIgnoreCase(input.toString())) {
						showPopup("	   Who, what, when, where, why");
					} else if ("WIBNI".equalsIgnoreCase(input.toString())) {
						showPopup("	   Wouldn't it be nice if");
					} else if ("WITP".equalsIgnoreCase(input.toString())) {
						showPopup("	   What is the point?");
					} else if ("WITW".equalsIgnoreCase(input.toString())) {
						showPopup("	   What in the world");
					} else if ("WIU".equalsIgnoreCase(input.toString())) {
						showPopup("	   Wrap it up");
					} else if ("WK".equalsIgnoreCase(input.toString())) {
						showPopup("	   Week");
					} else if ("WKD".equalsIgnoreCase(input.toString())) {
						showPopup("	   Weekend");
					} else if ("WL".equalsIgnoreCase(input.toString())) {
						showPopup("	   Whatta loser");
					} else if ("W/O".equalsIgnoreCase(input.toString())) {
						showPopup("	   Without");
					} else if ("WOMBAT".equalsIgnoreCase(input.toString())) {
						showPopup("	   Waste of money, brains, and time");
					} else if ("WRK".equalsIgnoreCase(input.toString())) {
						showPopup("	   Work");
					} else if ("WRU@".equalsIgnoreCase(input.toString())) {
						showPopup("	   Where are you at?");
					} else if ("WRUD".equalsIgnoreCase(input.toString())) {
						showPopup("	   What are you doing?");
					} else if ("WTF".equalsIgnoreCase(input.toString())) {
						showPopup("	   What the *freak* ?");
					} else if ("WTFE".equalsIgnoreCase(input.toString())) {
						showPopup("	   What the *freak* ever");
					} else if ("WTG".equalsIgnoreCase(input.toString())) {
						showPopup("	   Way to go");
					} else if ("WTGP".equalsIgnoreCase(input.toString())) {
						showPopup("	   Want to go private ");
					} else if ("WTH".equalsIgnoreCase(input.toString())) {
						showPopup("	   What the heck?");
					} else if ("WTM".equalsIgnoreCase(input.toString())) {
						showPopup("	   Who's the man?");
					} else if ("WT?".equalsIgnoreCase(input.toString())) {
						showPopup("	  What the? / who the?");
					} else if ("WTG".equalsIgnoreCase(input.toString())) {
						showPopup("	   Way to go!");
					} else if ("WT".equalsIgnoreCase(input.toString())) {
						showPopup("	  What the? / who the?");
					} else if ("WUW".equalsIgnoreCase(input.toString())) {
						showPopup("	  What do (you) want?");
					} else if ("WU?".equalsIgnoreCase(input.toString())) {
						showPopup("	  What's up?");
					} else if ("WU".equalsIgnoreCase(input.toString())) {
						showPopup("	  What's up?");
					} else if ("WUU2".equalsIgnoreCase(input.toString())) {
						showPopup("	  What are you up to?");
					} else if ("WUF?".equalsIgnoreCase(input.toString())) {
						showPopup("	 Where are you from?");
					} else if ("WWNC".equalsIgnoreCase(input.toString())) {
						showPopup("	 Will wonders never cease");
					} else if ("WWYC".equalsIgnoreCase(input.toString())) {
						showPopup("	 Write when you can");
					} else if ("WYCM".equalsIgnoreCase(input.toString())) {
						showPopup("	 Will you call me?");
					} else if ("WYD".equalsIgnoreCase(input.toString())) {
						showPopup("	 What (are) you doing?");
					} else if ("WYGAM".equalsIgnoreCase(input.toString())) {
						showPopup("	 When you get a minute");
					} else if ("WYHAM".equalsIgnoreCase(input.toString())) {
						showPopup("	 When you have a minute");
					} else if ("WYLEI".equalsIgnoreCase(input.toString())) {
						showPopup("	 When you least expect it");
					} else if ("WYWH".equalsIgnoreCase(input.toString())) {
						showPopup("	 Wish you were here");
					} else if ("WYSITWIRL".equalsIgnoreCase(input.toString())) {
						showPopup(

						"	 What you see is totally worthless in real life!");
					} else if ("WYSIWYG".equalsIgnoreCase(input.toString())) {
						showPopup("	 What you see is what you get");
					} else if ("X-1-10".equalsIgnoreCase(input.toString())) {
						showPopup("	 Exciting");
					} else if ("X".equalsIgnoreCase(input.toString())) {
						showPopup("	 Kiss");
					} else if ("X!".equalsIgnoreCase(input.toString())) {
						showPopup("	 A typical woman");
					} else if ("XOXOXO".equalsIgnoreCase(input.toString())) {
						showPopup("	 Hugs & Kisses");
					} else if ("XD".equalsIgnoreCase(input.toString())) {
						showPopup("	 Really hard laugh" + "\n" + "\n"
								+ "Devilish smile");
					} else if ("XME".equalsIgnoreCase(input.toString())) {
						showPopup("	 Excuse Me");
					} else if ("XLNT".equalsIgnoreCase(input.toString())) {
						showPopup("	 Excellent");
					} else if ("XLR8".equalsIgnoreCase(input.toString())) {
						showPopup("	 Accelerate / going faster");
					} else if ("XLR8".equalsIgnoreCase(input.toString())) {
						showPopup("	 Accelerate / going faster");
					} else if ("XYL".equalsIgnoreCase(input.toString())) {
						showPopup("	 Ex-young lady, meaning wife.");
					} else if ("XYZ".equalsIgnoreCase(input.toString())) {
						showPopup("	 Examine your zipper");
					} else if ("Y?".equalsIgnoreCase(input.toString())) {
						showPopup("	 Why?");
					} else if ("Y".equalsIgnoreCase(input.toString())) {
						showPopup("	 Yawn" + "\n" + "\n" + "why");
					} else if ("Y2K".equalsIgnoreCase(input.toString())) {
						showPopup("	 You're too kind");
					} else if ("YA".equalsIgnoreCase(input.toString())) {
						showPopup("	 Your");
					} else if ("YAA".equalsIgnoreCase(input.toString())) {
						showPopup("	 Yet another acronym");
					} else if ("YABA".equalsIgnoreCase(input.toString())) {
						showPopup("	 Yet another bloody acronym");
					} else if ("YARLY".equalsIgnoreCase(input.toString())) {
						showPopup("	 Ya, really?");
					} else if ("YBIC".equalsIgnoreCase(input.toString())) {
						showPopup("	 Your brother in Christ");
					} else if ("YBS".equalsIgnoreCase(input.toString())) {
						showPopup("	 You'll be sorry");
					} else if ("YCDBWYCID".equalsIgnoreCase(input.toString())) {
						showPopup("	 You can't do business " + "\n" + "\n"
								+ "when your computer is down");
					} else if ("YCHT".equalsIgnoreCase(input.toString())) {
						showPopup("	 You can have them");
					} else if ("YCMU".equalsIgnoreCase(input.toString())) {
						showPopup("	 You crack me up");
					} else if ("YF".equalsIgnoreCase(input.toString())) {
						showPopup("	 Wife");
					} else if ("YG".equalsIgnoreCase(input.toString())) {
						showPopup("	 Young gentleman");
					} else if ("YGTBKM".equalsIgnoreCase(input.toString())) {
						showPopup("	 You've got to be kidding me");
					} else if ("YHBW".equalsIgnoreCase(input.toString())) {
						showPopup("	 You have been warned");
					} else if ("YHL".equalsIgnoreCase(input.toString())) {
						showPopup("	 You have lost");
					} else if ("YIU".equalsIgnoreCase(input.toString())) {
						showPopup("	 Yes, I understand");
					} else if ("YKW".equalsIgnoreCase(input.toString())) {
						showPopup("	 You know what");
					} else if ("YKWYCD".equalsIgnoreCase(input.toString())) {
						showPopup("	 You know what you can do");
					} else if ("YL".equalsIgnoreCase(input.toString())) {
						showPopup("	 Young lady");
					} else if ("YNK".equalsIgnoreCase(input.toString())) {
						showPopup("	 You never know");
					} else if ("YR".equalsIgnoreCase(input.toString())) {
						showPopup("	 Your " + "\n" + "\n" + "Yeah right");
					} else if ("YRYOCC".equalsIgnoreCase(input.toString())) {
						showPopup("	 You're running your" + "\n" + "\n"
								+ " own cuckoo clock ");
					} else if ("YSIC".equalsIgnoreCase(input.toString())) {
						showPopup("	 Your sister in Christ");
					} else if ("YSYD".equalsIgnoreCase(input.toString())) {
						showPopup("	 Yeah sure you do ");
					} else if ("YT".equalsIgnoreCase(input.toString())) {
						showPopup("	 You there?");
					} else if ("YTTL".equalsIgnoreCase(input.toString())) {
						showPopup("	 You take too long");
					} else if ("YTG".equalsIgnoreCase(input.toString())) {
						showPopup("	 You're the greatest");
					} else if ("YWHOL".equalsIgnoreCase(input.toString())) {
						showPopup("	 Yelling 'woohoo' out loud");
					} else if ("YWSYLS".equalsIgnoreCase(input.toString())) {
						showPopup("	 You win some, you lose some");
					} else if ("YYSSW".equalsIgnoreCase(input.toString())) {
						showPopup("	 Yeah, yeah, sure," + "\n" + "\n"
								+ " sure, whatever");
					} else if ("YBS".equalsIgnoreCase(input.toString())) {
						showPopup("	 You'll be sorry");
					} else if ("YMMV".equalsIgnoreCase(input.toString())) {
						showPopup("	 Your mileage may vary.");
					} else if ("YW".equalsIgnoreCase(input.toString())) {
						showPopup("	 You're welcome");
					} else if ("Z".equalsIgnoreCase(input.toString())) {
						showPopup("	 Zero");
					} else if ("Z".equalsIgnoreCase(input.toString())) {
						showPopup("	 Going to bed/sleep");
					} else if ("Z".equalsIgnoreCase(input.toString())) {
						showPopup("	 Said");
					} else if ("Z%".equalsIgnoreCase(input.toString())) {
						showPopup("	 Zoo");
					} else if ("ZH".equalsIgnoreCase(input.toString())) {
						showPopup("	 Sleeping Hour");
					} else if ("ZOT".equalsIgnoreCase(input.toString())) {
						showPopup("	 Zero tolerance");
					} else if ("ZUP".equalsIgnoreCase(input.toString())) {
						showPopup("	 What's up?");
					} else if ("ZZZ".equalsIgnoreCase(input.toString())) {
						showPopup("	 Sleeping / bored");
					}

					else {
						showPopup2();
					}
				}

			}

		});// button

		return v;

	}

	private void showPopup(final String input) {

		// // window = new PopupWindow(Main.this.getActivity());

		final PopupWindow window = new PopupWindow(this.getActivity());

		TextView text = new TextView(this.getActivity());

		text.setTextColor(getResources().getColor(R.color.whitesmoke));
		Button bt = new Button(this.getActivity());
		Button bt2 = new Button(this.getActivity());
		
		Typeface font = Typeface.createFromAsset(getActivity().getAssets(),
				"fonts/the beautiful ones.ttf");
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

		final int height = dm.heightPixels;
		final int width = dm.widthPixels;

		if ((height < 480) && (width <320)) {
			window.setWidth(718);
			window.setHeight(760);
			// } else if ((height == 1280) && (width > 800)) {
			// window.setWidth(718);
			// window.setHeight(760);
			// } else if ((height < 480) && (width < 320)) {
			window.setWidth(150);
			window.setHeight(213);
			text.setText("					TRANSLATED SLANG" + "\n" + "\n" + "\n" + input);
		} else if ((height == 480) && (width == 320)) {
			window.setWidth(150);
			window.setHeight(214);
			text.setText("					TRANSLATED SLANG" + "\n" + "\n" + "\n" + input
					+ "\n");
			
			// LayoutParams lparams2 = new LayoutParams();
			bt.setText("Cancel");
			bt.setWidth(102);
			bt.setHeight(44);
			
			bt2.setText("Copy Slang");
			bt2.setWidth(102);
			bt2.setHeight(44);

			
		} else {
			window.setWidth(450);
			window.setHeight(600);

		}

		LinearLayout layout = new LinearLayout(this.getActivity());
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.setLayoutParams(new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT));
		// window.setBackgroundDrawable(getResources().getDrawable(R.color.));

		window.setTouchable(true);
		window.setFocusable(true);

		text.setText("					TRANSLATED SLANG" + "\n" + "\n" + "\n" + input
				+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
				+ "\n");
		text.setTypeface(font);
		text.setTextAppearance(this.getActivity(),
				android.R.attr.textAppearanceLarge);
		text.setTextSize(17);
		layout.addView(text);
		// setContentView(layout);

		
		// LayoutParams lparams2 = new LayoutParams();
		bt.setText("Cancel");
		bt.setWidth(102);
		bt.setHeight(44);

		layout.addView(bt);

		bt.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				window.dismiss();
			}

		});// button

		
		// LayoutParams lparams2 = new LayoutParams();
		bt2.setText("Copy Slang");
		bt2.setWidth(102);
		bt2.setHeight(44);

		layout.addView(bt2);
		//
		// ClipboardManager clipboard = (ClipboardManager)
		// getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
		// ClipData clip = ClipData.newPlainText(input,input);
		// clipboard.setPrimaryClip(clip);

		bt2.setOnClickListener(new View.OnClickListener() {
			@SuppressLint({ "NewApi", "NewApi", "NewApi", "NewApi" })
			public void onClick(View v) {
				int currentapiVersion = android.os.Build.VERSION.SDK_INT;
				if (currentapiVersion >= android.os.Build.VERSION_CODES.HONEYCOMB) {
					android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getActivity()
							.getSystemService(Context.CLIPBOARD_SERVICE);
					ClipData clip = ClipData.newPlainText(input, input);
					clipboard.setPrimaryClip(clip);
				} else {
					android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getActivity()
							.getSystemService(Context.CLIPBOARD_SERVICE);
					clipboard.setText(input);
				}
				Toast.makeText(getActivity().getApplicationContext(),
						"Text copied to clipboard", Toast.LENGTH_SHORT).show();

			}

		});// button

		window.setContentView(layout);
		// // window.setContentView(bt);
		window.showAtLocation(text, Gravity.CENTER, 0, 0);

	}

	private void showPopup2() {
		final PopupWindow window = new PopupWindow(this.getActivity());
		DisplayMetrics dm = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

		final int height = dm.heightPixels;
		final int width = dm.widthPixels;

		if ((height > 960) && (width > 730)) {
			window.setWidth(718);
			window.setHeight(760);
			// } else if ((height == 1280) && (width == 800)) {
			 
			 } else if ((height < 480) && (width < 320)) {
			window.setWidth(150);
			window.setHeight(213);
		} else {
			window.setWidth(430);
			window.setHeight(600);

		}
		window.setTouchable(true);
		window.setFocusable(true);

		TextView text2 = new TextView(this.getActivity());
		text2.setTextColor(getResources().getColor(R.color.Cream));

		text2.setTextSize(16);

		text2.setText("\n" + "\n" + "\n" + "\n"
				+ "Sorry, Could not Translate this Slang." + "\n"
				+ "Please Scroll to 'Add Slang Page', " + "\n"
				+ " to send new Slang to developer");

		window.setContentView(text2);
		// window.setContentView(bt);
		window.showAtLocation(text2, Gravity.CENTER, 0, 0);

	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// getActivity().getMenuInflater().inflate(R.menu.main, menu);
	// return true;
	// }
}
