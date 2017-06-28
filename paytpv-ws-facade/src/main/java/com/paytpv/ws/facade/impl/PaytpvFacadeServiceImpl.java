package com.paytpv.ws.facade.impl;

import java.io.StringReader;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.axis2.AxisFault;
import org.apache.axis2.databinding.types.soapencoding.Array;
import org.apache.xmlbeans.XmlException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlsoap.schemas.soap.envelope.SearchOperationsDocument;
import org.xmlsoap.schemas.soap.envelope.SearchOperationsResponseDocument;
import org.xmlsoap.schemas.soap.envelope.SearchOperationsResponseDocument.SearchOperationsResponse;

import paytpv.PAYTPV_OperationsGatewayServiceStub;
import paytpv_operationsgateway.Operation;

import com.paytpv.Item;
import com.paytpv.ws.facade.PaytpvFacadeService;
import com.paytpv.ws.facade.utils.PaytpvUtils;
import com.paytpv.ws.pojo.OperationState;
import com.paytpv.ws.pojo.SortOrder;
import com.paytpv.ws.pojo.Terminal;

/**
 * 
 * @author paytpv
 *
 */
public class PaytpvFacadeServiceImpl implements PaytpvFacadeService {

	private PAYTPV_OperationsGatewayServiceStub paytpvGateway;
	
	public PaytpvFacadeServiceImpl() throws AxisFault {
		paytpvGateway = new PAYTPV_OperationsGatewayServiceStub();
	}

	public List<Item> getOperations(String merchantCode,
			BigInteger sortType, SortOrder order, BigInteger limit,
			List<Terminal> terminals, List<BigInteger> operations,
			BigInteger minamount, BigInteger maxamount, OperationState state,
			Calendar fromDate, Calendar toDate, String currency,
			String reference, Boolean searchType, String version)
			throws XmlException, RemoteException, JAXBException, NoSuchAlgorithmException {
		
		SearchOperationsDocument request = prepareRequest(merchantCode,
				sortType, order, limit, terminals, operations, minamount,
				maxamount, state, fromDate, toDate, currency,
				reference, searchType, version);
		
		SearchOperationsResponseDocument responseDocument = paytpvGateway.search_operations(request);
		return prepareResponse(responseDocument);
	}
		
	public StringBuilder getXmlOperations(String merchantCode,
			BigInteger sortType, SortOrder order, BigInteger limit,
			List<Terminal> terminals, List<BigInteger> operations,
			BigInteger minamount, BigInteger maxamount, OperationState state,
			Calendar fromDate, Calendar toDate, String currency,
			String reference, Boolean searchType, String version) 
			throws NoSuchAlgorithmException, XmlException, RemoteException {
		
		StringBuilder resultBuffer = new StringBuilder();
		
		SearchOperationsDocument request = prepareRequest(merchantCode,
				sortType, order, limit, terminals, operations, minamount,
				maxamount, state, fromDate, toDate, currency,
				reference, searchType, version);
		
		SearchOperationsResponseDocument responseDocument = paytpvGateway.search_operations(request);
		
		resultBuffer.append(responseDocument.getSearchOperationsResponse().toString());
		return resultBuffer;
	}
	
	/**
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
	 */
	private SearchOperationsDocument prepareRequest(String merchantCode,
			BigInteger sortType, SortOrder order, BigInteger limit,
			List<Terminal> terminals, List<BigInteger> operations,
			BigInteger minamount, BigInteger maxamount, OperationState state,
			Calendar fromDate, Calendar toDate, String currency,
			String reference, Boolean searchType, String version) throws XmlException, NoSuchAlgorithmException {
		
		SearchOperationsDocument req = SearchOperationsDocument.Factory.newInstance();
		SearchOperationsDocument.SearchOperations data = req.addNewSearchOperations();
		data.setPAYTPVOPERATIONSMERCHANTCODE(merchantCode);
		data.setPAYTPVOPERATIONSSORTYPE(sortType);
		data.setPAYTPVOPERATIONSSORTORDER(order.name());
		data.setPAYTPVOPERATIONSLIMIT(limit);

		data.addNewPAYTPVOPERATIONSTERMINAL();
		data.setPAYTPVOPERATIONSTERMINAL(PaytpvUtils.parseTerminals(terminals));
		
		data.addNewPAYTPVOPERATIONSOPERATIONS();
		data.setPAYTPVOPERATIONSOPERATIONS(PaytpvUtils.parse(operations));
		
		data.setPAYTPVOPERATIONSMINAMOUNT(minamount);
		data.setPAYTPVOPERATIONSMAXAMOUNT(maxamount);
		data.setPAYTPVOPERATIONSSTATE(BigInteger.valueOf(state.getState()));
		
		data.setPAYTPVOPERATIONSFROMDATE(PaytpvUtils.parse(fromDate));
		data.setPAYTPVOPERATIONSTODATE(PaytpvUtils.parse(toDate));
		data.setPAYTPVOPERATIONSCURRENCY(currency);
		data.setPAYTPVOPERATIONSSIGNATURE(PaytpvUtils.getSignature(merchantCode, terminals, operations, fromDate, toDate));
		
		if (reference != null)
			data.setPAYTPVOPERATIONSREFERENCE(reference);
		
		if (searchType != null)
			data.setPAYTPVOPERATIONSSEARCHTYPE(BigInteger.valueOf(((searchType) ? 1 : 0)));
		
		if (version != null)
			data.setPAYTPVOPERATIONSVERSION(version);
		
		System.out.println(data.toString());
		
		return req;
	}
	
	/**
	 * 
	 * @param paytpvResponse
	 * @return
	 * @throws XmlException
	 * @throws JAXBException
	 */
	private List<Item> prepareResponse(SearchOperationsResponseDocument paytpvResponse) throws XmlException, JAXBException {
		List<Item> result = new ArrayList<Item>();
		SearchOperationsResponse searchOperationsResponse = paytpvResponse.getSearchOperationsResponse();
		paytpv_operationsgateway.OperationArray operationsReponse = searchOperationsResponse.getReturn();

		NodeList nodes = operationsReponse.getDomNode().getChildNodes();
		
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (Array.CHILD_LOCAL_NAME.equals(node.getLocalName())) {
				Operation operation = Operation.Factory.parse(node);
				String xml = operation.toString();
				xml = xml.replace("xsd:", "");

				JAXBContext jaxbContext = JAXBContext.newInstance(Item.class);
				Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				StringReader reader = new StringReader(xml);
				Item item = (Item) unmarshaller.unmarshal(reader);
				
				result.add(item);				
			}
		}
		return result;
	}
	
}
