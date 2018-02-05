package com.inven.coco.common.util;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;

public class RandomGuidUtil {

	static Logger log = Logger.getLogger(RandomGuidUtil.class);
	private String guid;

	public static String fnGuidUsingUUID() {
		return UUID.randomUUID().toString();
	}

	public static String fnGuidWithDate() {

		String sRecId = "";
		String sRecId1 = "";
		String sRecId2 = "";

		try {

			Date currDt = new Date();

			SimpleDateFormat dfs = new SimpleDateFormat("yyMMdd");
			sRecId1 = dfs.format(currDt);

			String YY = sRecId1.substring(0, 2);
			String MM = sRecId1.substring(2, 4);
			String DD = sRecId1.substring(4, 6);

			switch (BaseUtil.getInt(MM)) {
			case 1:
				MM = "A";
				break;
			case 2:
				MM = "B";
				break;
			case 3:
				MM = "C";
				break;
			case 4:
				MM = "D";
				break;
			case 5:
				MM = "E";
				break;
			case 6:
				MM = "F";
				break;
			case 7:
				MM = "G";
				break;
			case 8:
				MM = "H";
				break;
			case 9:
				MM = "J";
				break;
			case 10:
				MM = "K";
				break;
			case 11:
				MM = "L";
				break;
			case 12:
				MM = "M";
				break;
			}

			DD = BaseUtil
					.getStrUpper(Integer.toString(BaseUtil.getInt(DD), 36));

			sRecId1 = BaseUtil.getStr(YY) + BaseUtil.getStr(MM)
					+ BaseUtil.getStr(DD);

			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			int lGen = BaseUtil.getInt(random.nextInt());

			if (lGen < 0) {
				lGen = lGen * -1;
				sRecId2 = "E"
						+ BaseUtil.getStrUpper(Integer.toString(lGen, 36));
			} else {
				sRecId2 = BaseUtil.getStrUpper(Integer.toString(lGen, 36));
			}

			sRecId = sRecId1 + sRecId2;

			sRecId = sRecId.replace("O", "-");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return sRecId;
		}
	}

	public static String fnGuidWithTimestamp() {

		String sRecId = "";
		String sRecId1 = "";
		String formNo = "";
		try {

			Date currDt = new Date();

			SimpleDateFormat dfs = new SimpleDateFormat("yyMMddHHmmsss");
			sRecId1 = dfs.format(currDt);

			String YY = sRecId1.substring(0, 2);
			String MM = sRecId1.substring(2, 4);
			String DD = sRecId1.substring(4, 6);
			String HH = sRecId1.substring(6, 8);
			String mm = sRecId1.substring(8, 10);
			String sss = sRecId1.substring(10, 13);
			if (HH.substring(0, 1).equals("0")) {
				HH = HH.substring(1, 2);
			}

			switch (BaseUtil.getInt(MM)) {
			case 1:
				MM = "1";
				break;
			case 2:
				MM = "2";
				break;
			case 3:
				MM = "3";
				break;
			case 4:
				MM = "4";
				break;
			case 5:
				MM = "5";
				break;
			case 6:
				MM = "6";
				break;
			case 7:
				MM = "7";
				break;
			case 8:
				MM = "8";
				break;
			case 9:
				MM = "9";
				break;
			case 10:
				MM = "A";
				break;
			case 11:
				MM = "B";
				break;
			case 12:
				MM = "C";
				break;
			}
			switch (BaseUtil.getInt(HH)) {
			case 10:
				HH = "A";
				break;
			case 11:
				HH = "B";
				break;
			case 12:
				HH = "C";
				break;
			case 13:
				HH = "D";
				break;
			case 14:
				HH = "E";
				break;
			case 15:
				HH = "F";
				break;
			case 16:
				HH = "G";
				break;
			case 17:
				HH = "H";
				break;
			case 18:
				HH = "J";
				break;
			case 19:
				HH = "K";
				break;
			case 20:
				HH = "L";
				break;
			case 21:
				HH = "M";
				break;
			case 22:
				HH = "N";
				break;
			case 23:
				HH = "P";
				break;
			case 24:
				HH = "Q";
				break;
			}
			switch (BaseUtil.getInt(YY)) {
			case 14:
				YY = "A";
				break;
			case 15:
				YY = "B";
				break;
			case 16:
				YY = "C";
				break;
			case 17:
				YY = "D";
				break;
			case 18:
				YY = "E";
				break;
			case 19:
				YY = "F";
				break;
			case 20:
				YY = "G";
				break;
			case 21:
				YY = "H";
				break;
			case 22:
				YY = "J";
				break;
			case 23:
				YY = "K";
				break;
			case 24:
				YY = "L";
				break;
			case 25:
				YY = "M";
				break;
			case 26:
				YY = "N";
				break;
			case 27:
				YY = "P";
				break;
			case 28:
				YY = "Q";
				break;
			}

			DD = BaseUtil
					.getStrUpper(Integer.toString(BaseUtil.getInt(DD), 36));

			sRecId1 = BaseUtil.getStr(YY) + BaseUtil.getStr(MM)
					+ BaseUtil.getStr(DD) + BaseUtil.getStr(HH);

			formNo = "E" + sRecId1 + mm + sss;
			log.info("formNo::" + formNo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return formNo;
		}
	}
	
	
	public static String fnGuidWithTimestampSmallAlpha() {

		String sRecId = "";
		String sRecId1 = "";
		String formNo = "";
		try {

			Date currDt = new Date();

			SimpleDateFormat dfs = new SimpleDateFormat("yyMMddHHmmsss");
			sRecId1 = dfs.format(currDt);

			String YY = sRecId1.substring(0, 2);
			String MM = sRecId1.substring(2, 4);
			String DD = sRecId1.substring(4, 6);
			String HH = sRecId1.substring(6, 8);
			String mm = sRecId1.substring(8, 10);
			String sss = sRecId1.substring(10, 13);
			if (HH.substring(0, 1).equals("0")) {
				HH = HH.substring(1, 2);
			}

			switch (BaseUtil.getInt(MM)) {
			case 1:
				MM = "1";
				break;
			case 2:
				MM = "2";
				break;
			case 3:
				MM = "3";
				break;
			case 4:
				MM = "4";
				break;
			case 5:
				MM = "5";
				break;
			case 6:
				MM = "6";
				break;
			case 7:
				MM = "7";
				break;
			case 8:
				MM = "8";
				break;
			case 9:
				MM = "9";
				break;
			case 10:
				MM = "A";
				break;
			case 11:
				MM = "B";
				break;
			case 12:
				MM = "C";
				break;
			}
			switch (BaseUtil.getInt(HH)) {
			case 10:
				HH = "a";
				break;
			case 11:
				HH = "b";
				break;
			case 12:
				HH = "c";
				break;
			case 13:
				HH = "d";
				break;
			case 14:
				HH = "e";
				break;
			case 15:
				HH = "f";
				break;
			case 16:
				HH = "g";
				break;
			case 17:
				HH = "h";
				break;
			case 18:
				HH = "j";
				break;
			case 19:
				HH = "k";
				break;
			case 20:
				HH = "l";
				break;
			case 21:
				HH = "m";
				break;
			case 22:
				HH = "n";
				break;
			case 23:
				HH = "p";
				break;
			case 24:
				HH = "q";
				break;
			}
			switch (BaseUtil.getInt(YY)) {
			case 14:
				YY = "a";
				break;
			case 15:
				YY = "b";
				break;
			case 16:
				YY = "c";
				break;
			case 17:
				YY = "d";
				break;
			case 18:
				YY = "e";
				break;
			case 19:
				YY = "f";
				break;
			case 20:
				YY = "g";
				break;
			case 21:
				YY = "h";
				break;
			case 22:
				YY = "j";
				break;
			case 23:
				YY = "k";
				break;
			case 24:
				YY = "l";
				break;
			case 25:
				YY = "m";
				break;
			case 26:
				YY = "n";
				break;
			case 27:
				YY = "p";
				break;
			case 28:
				YY = "q";
				break;
			}

			DD = BaseUtil
					.getStrUpper(Integer.toString(BaseUtil.getInt(DD), 36));

			sRecId1 = BaseUtil.getStr(YY) + BaseUtil.getStr(MM)
					+ BaseUtil.getStr(DD) + BaseUtil.getStr(HH);

			formNo = "e" + sRecId1 + mm + sss;
			log.info("formNo::" + formNo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return formNo;
		}
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getGuid() {
		guid = fnGuidWithTimestamp();
		return guid;
	}

	public static void main(String[] arg) {
		RandomGuidUtil randomGuid = new RandomGuidUtil();
		System.out.println(randomGuid.fnGuidWithTimestampSmallAlpha());
	}
}
