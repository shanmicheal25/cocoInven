package com.inven.coco.common.constants;

public class GenericConstant {

	public static final String USER_REG_USER_LEVEL = "USER001";
	public static final String USER_REG_USER_GROUP_LEVEL = "USER002";
	public static final String USER_REG_MANAGER_LEVEL = "USER003";
	public static final String USER_REG_MANAGER_GROUP_LEVEL = "USER004";

	public static final String ENQUIRY_SMS_USER_GROUP = "EnquirySMS";

	public static final int INPUT_TEXT = 1;
	public static final int RICHINPUT_TEXT = 2;
	public static final int DATE_TEXT = 3;
	public static final int INPUT_TEXTAREA = 4;
	public static final int OUTPUT_TEXT = 5;
	public static final int START_TIMESTAMP = 6;
	public static final int END_TIMESTAMP = 7;
	public static final int UNIKEY = 8;

	public static int IMAGE_UPLOAD = 9;

	public static int BROWSE_UPLOAD = 10;
	public static int COMBO_LIST = 11;
	public static int DROPDOWNLIST = 11;
	public static int RADIO_LIST = 12;
	public static int CHECK_LIST = 13;

	public static int SINGLE_COLUMN_LIST = 14;

	public static int LOCATION_PICKER = 21;

	public static final int CREATE_USER_ID = 15;
	public static final int CREATE_USER_NAME = 16;
	public static final int CREATE_DATE_TIME = 17;
	public static final int UPDATE_USER_ID = 18;
	public static final int UPDATE_USER_NAME = 19;
	public static final int UPDATE_DATE_TIME = 20;

	public static int getOptionTypeCode(String optionId) {
		int optionCode = 0;
		
		if ("ELEPT001".equals(optionId)) {
			optionCode = INPUT_TEXT;
		} else if ("ELEPT002".equals(optionId)) {
			optionCode = RICHINPUT_TEXT;
		} else if ("ELEPT004".equals(optionId)) {
			optionCode = DATE_TEXT;
		} else if ("ELEPT005".equals(optionId)) {
			optionCode = OUTPUT_TEXT;
		} else if ("ELEPT006".equals(optionId)) {
			optionCode = START_TIMESTAMP;
		} else if ("ELEPT007".equals(optionId)) {
			optionCode = END_TIMESTAMP;
		} else if ("ELEPT008".equals(optionId)) {
			optionCode = UNIKEY;
		} else if ("ELEI001".equals(optionId)) {
			optionCode = IMAGE_UPLOAD;
		} else if ("ELESL002".equals(optionId)) {
			optionCode = BROWSE_UPLOAD;
		} else if ("ELESL006".equals(optionId)) {
			optionCode = COMBO_LIST;
		} else if ("ELESL004".equals(optionId)) {
			optionCode = RADIO_LIST;
		} else if ("ELESL003".equals(optionId)) {
			optionCode = CHECK_LIST;
		} else if ("ELESL005".equals(optionId)) {
			optionCode = SINGLE_COLUMN_LIST;
		} else if ("ELED001".equals(optionId)) {
			optionCode = CREATE_USER_ID;
		} else if ("ELED002".equals(optionId)) {
			optionCode = CREATE_USER_NAME;
		} else if ("ELED003".equals(optionId)) {
			optionCode = CREATE_DATE_TIME;
		} else if ("ELED004".equals(optionId)) {
			optionCode = UPDATE_USER_ID;
		} else if ("ELED005".equals(optionId)) {
			optionCode = UPDATE_USER_NAME;
		} else if ("ELED006".equals(optionId)) {
			optionCode = UPDATE_DATE_TIME;
		} else if ("LOCP001".equals(optionId)) {
			optionCode = 21;
		}

		return optionCode;
	}

}
