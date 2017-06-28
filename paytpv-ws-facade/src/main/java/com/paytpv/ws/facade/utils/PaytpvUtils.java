package com.paytpv.ws.facade.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.xmlbeans.XmlException;

import com.paytpv.ws.pojo.Terminal;

import paytpv_operationsgateway.PayArray;

/**
 * 
 * @author paytpv
 *
 */
public class PaytpvUtils {

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String parse(Calendar date) {
		String year = String.format("%04d", date.get(Calendar.YEAR));
		String month = String.format("%02d",date.get(Calendar.MONTH));
		String day = String.format("%02d",date.get(Calendar.DAY_OF_MONTH));
		String hour = String.format("%02d",date.get(Calendar.HOUR_OF_DAY));
		String minute = String.format("%02d",date.get(Calendar.MINUTE));
		String second = String.format("%02d",date.get(Calendar.SECOND));
		return year+month+day+hour+minute+second;
	}
	
	public static Calendar parse (String date) {
		Calendar instance = Calendar.getInstance();
		
		if (date.length() != 14) 
			throw new IllegalArgumentException("date format must be 'YYYYMMDDHHmmSS'."); 
		
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(4,6));
		int day = Integer.parseInt(date.substring(6, 8));
		int hour = Integer.parseInt(date.substring(8, 10));
		int minute = Integer.parseInt(date.substring(10, 12));
		int second = Integer.parseInt(date.substring(12, 14));
		
		instance.set(Calendar.YEAR,year);
		instance.set(Calendar.MONTH,month);
		instance.set(Calendar.DAY_OF_MONTH,day);
		instance.set(Calendar.HOUR_OF_DAY,hour);
		instance.set(Calendar.MINUTE,minute);
		instance.set(Calendar.SECOND,second);
		return instance;
	}
	
	/**
	 * Parse PayArray
	 * @param items
	 * @return
	 * @throws XmlException
	 */
	public static PayArray parse(List<BigInteger> items) throws XmlException {
		String itemsToParse = "";
		for (BigInteger item : items) {
			itemsToParse += "<item xsi:type=\"xsd:int\">"+item.toString()+"</item>";
		}
		PayArray reqTerminals = PayArray.Factory.parse(itemsToParse);
		return reqTerminals;
	}
	
	public static PayArray parseTerminals(List<Terminal> items) throws XmlException {
		List<BigInteger> terminals = new ArrayList<BigInteger>();
		for (Terminal terminal: items) {
			terminals.add(terminal.getTerminalCode());
		}
		return parse(terminals);
	}
	
	/**
	 * @see <a href="http://developers.paytpv.com/es/documentacion/operations">PayPTV operations</a>
	 * 
	 * SHA1(PAYTPV_OPERATIONS_MERCHANTCODE + ((TERMINAL_ID1 + TERMINAL_PASSWORD1) + (TERMINAL_ID2 + TERMINAL_PASSWORD2) + (TERMINAL_ID3 + TERMINAL_PASSWORD3)... + OPERATION_ID1 + OPERATION_ID2 + OPERATION_ID3... + PAYTPV_OPERATIONS_FROMDATE + PAYTPV_OPERATIONS_TODATE)
	 * 
	 * @param merchantCode
	 * @param terminals
	 * @param operations
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public static String getSignature(String merchantCode,List<Terminal> terminals, List<BigInteger> operations, Calendar fromDate, Calendar toDate) 
			throws NoSuchAlgorithmException {
		String signature = merchantCode;
		for (Terminal terminal:terminals) {
			signature+=(terminal.getTerminalCode()+terminal.getPassword());
		}
		for (BigInteger operation: operations) {
			signature+=operation.toString();
		}
		signature+= parse(fromDate);
		signature+= parse(toDate);
		
		System.out.println("encoded: "+signature);
		return SHA1(signature);
	}
	
	/**
	 * 
	 * @param message
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private static String SHA1(String message) throws NoSuchAlgorithmException {
		byte[] buffer = message.getBytes();
		MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(buffer);
        byte[] digest = md.digest();
        String hash = "";
        for(byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }
     return hash;
	}
	
}
