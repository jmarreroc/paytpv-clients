package com.paytpv.ws.facade;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.xmlbeans.XmlException;

import com.paytpv.Item;
import com.paytpv.ws.pojo.OperationState;
import com.paytpv.ws.pojo.SortOrder;
import com.paytpv.ws.pojo.Terminal;

/**
 * 
 * @author paytpv
 *
 */
public interface PaytpvFacadeService {

	/**
	 * Return Paytpv operations response in understandable pojo objects For more
	 * info: @see <a
	 * href="http://developers.paytpv.com/es/documentacion/operations">PayPTV
	 * operations</a>
	 * 
	 * @param merchantCode
	 * @param sortType
	 * @param order
	 * @param limit
	 * @param terminals
	 * @param operations
	 * @param minamount
	 * @param maxamount
	 * @param state
	 * @param fromDate
	 * @param toDate
	 * @param currency
	 * @param reference
	 * @param searchType
	 * @param version
	 * @return
	 * @throws XmlException
	 * @throws RemoteException
	 * @throws JAXBException
	 * @throws NoSuchAlgorithmException
	 */
	public List<Item> getOperations(String merchantCode, BigInteger sortType,
			SortOrder order, BigInteger limit, List<Terminal> terminals,
			List<BigInteger> operations, BigInteger minamount,
			BigInteger maxamount, OperationState state, Calendar fromDate,
			Calendar toDate, String currency, String reference,
			Boolean searchType, String version) throws XmlException,
			RemoteException, JAXBException, NoSuchAlgorithmException;

	/**
	 * Return Paytpv operations response in xml formated text For more info: @see
	 * <a href="http://developers.paytpv.com/es/documentacion/operations">PayPTV
	 * operations</a>
	 * 
	 * @param merchantCode
	 * @param sortType
	 * @param order
	 * @param limit
	 * @param terminals
	 * @param operations
	 * @param minamount
	 * @param maxamount
	 * @param state
	 * @param fromDate
	 * @param toDate
	 * @param currency
	 * @param reference
	 * @param searchType
	 * @param version
	 * @return
	 * @throws XmlException
	 * @throws NoSuchAlgorithmException
	 * @throws RemoteException
	 */
	public StringBuilder getXmlOperations(String merchantCode,
			BigInteger sortType, SortOrder order, BigInteger limit,
			List<Terminal> terminals, List<BigInteger> operations,
			BigInteger minamount, BigInteger maxamount, OperationState state,
			Calendar fromDate, Calendar toDate, String currency,
			String reference, Boolean searchType, String version)
			throws NoSuchAlgorithmException, XmlException, RemoteException;
}
