package com.paytpv.ws.facade;

import static org.junit.Assert.assertNotNull;

import java.io.StringReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.axis2.AxisFault;
import org.apache.axis2.databinding.types.soapencoding.Array;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlsoap.schemas.soap.envelope.SearchOperationsDocument;
import org.xmlsoap.schemas.soap.envelope.SearchOperationsResponseDocument;
import org.xmlsoap.schemas.soap.envelope.SearchOperationsResponseDocument.SearchOperationsResponse;

import paytpv.PAYTPV_OperationsGatewayServiceStub;
import paytpv_operationsgateway.Operation;
import paytpv_operationsgateway.PayArray;

import com.paytpv.Item;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaytpvDirectConsumesTest {

	private PAYTPV_OperationsGatewayServiceStub paytpvGateway;

	@Before
	public void init() throws AxisFault {
		paytpvGateway = new PAYTPV_OperationsGatewayServiceStub();
	}

	@Test
	public void query() throws Exception {
		SearchOperationsDocument req = SearchOperationsDocument.Factory
				.newInstance();
		SearchOperationsDocument.SearchOperations data = req
				.addNewSearchOperations();

		/**
		 * WSDL: https://secure.paytpv.com/gateway/xml-operations?wsdl REQUEST:
		 * Try this
		 * 
		 * <?xml version="1.0" encoding="UTF-8"?> <soapenv:Envelope
		 * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		 * xmlns:xsd="http://www.w3.org/2001/XMLSchema"
		 * xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
		 * xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/">
		 * <soapenv:Header/> <soapenv:Body> <soapenv:search_operations
		 * soapenv:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/">
		 * <PAYTPV_OPERATIONS_MERCHANTCODE
		 * xsi:type="xsd:string">rwks4zgt</PAYTPV_OPERATIONS_MERCHANTCODE>
		 * <PAYTPV_OPERATIONS_SORTYPE
		 * xsi:type="xsd:integer">1</PAYTPV_OPERATIONS_SORTYPE>
		 * 
		 * <PAYTPV_OPERATIONS_SORTORDER
		 * xsi:type="xsd:string">ASC</PAYTPV_OPERATIONS_SORTORDER>
		 * <PAYTPV_OPERATIONS_LIMIT
		 * xsi:type="xsd:integer">100</PAYTPV_OPERATIONS_LIMIT>
		 * 
		 * <PAYTPV_OPERATIONS_TERMINAL xsi:type="urn:PayArray"
		 * soapenc:arrayType="xsd:integer[1]"
		 * xmlns:urn="urn:PAYTPV_OperationsGateway"> <item
		 * xsi:type="xsd:int">4795</item> </PAYTPV_OPERATIONS_TERMINAL>
		 * 
		 * <PAYTPV_OPERATIONS_OPERATIONS xsi:type="urn:PayArray"
		 * soapenc:arrayType="xsd:integer[1]"
		 * xmlns:urn="urn:PAYTPV_OperationsGateway"> <item
		 * xsi:type="xsd:int">1</item> </PAYTPV_OPERATIONS_OPERATIONS>
		 * 
		 * <PAYTPV_OPERATIONS_MINAMOUNT
		 * xsi:type="xsd:integer">0</PAYTPV_OPERATIONS_MINAMOUNT>
		 * <PAYTPV_OPERATIONS_MAXAMOUNT
		 * xsi:type="xsd:integer">999999999</PAYTPV_OPERATIONS_MAXAMOUNT>
		 * 
		 * <PAYTPV_OPERATIONS_STATE
		 * xsi:type="xsd:integer">1</PAYTPV_OPERATIONS_STATE>
		 * 
		 * <PAYTPV_OPERATIONS_FROMDATE
		 * xsi:type="xsd:string">20170101000000</PAYTPV_OPERATIONS_FROMDATE>
		 * <PAYTPV_OPERATIONS_TODATE
		 * xsi:type="xsd:string">20170208000000</PAYTPV_OPERATIONS_TODATE>
		 * 
		 * <PAYTPV_OPERATIONS_CURRENCY
		 * xsi:type="xsd:string">EUR</PAYTPV_OPERATIONS_CURRENCY>
		 * 
		 * <PAYTPV_OPERATIONS_SIGNATURE
		 * xsi:type="xsd:string">906a2a703a7a0a1f2d84da622b32cb6b5f845930
		 * </PAYTPV_OPERATIONS_SIGNATURE>
		 * 
		 * </soapenv:search_operations> </soapenv:Body> </soapenv:Envelope>
		 */

		data.setPAYTPVOPERATIONSMERCHANTCODE("rwks4zgt");
		data.setPAYTPVOPERATIONSSORTYPE(BigInteger.ONE);
		data.setPAYTPVOPERATIONSSORTORDER("ASC");
		data.setPAYTPVOPERATIONSLIMIT(BigInteger.valueOf(100));

		PayArray terminals = PayArray.Factory
				.parse("<item xsi:type=\"xsd:int\">4795</item>");
		data.addNewPAYTPVOPERATIONSTERMINAL();
		data.setPAYTPVOPERATIONSTERMINAL(terminals);

		PayArray operations = PayArray.Factory
				.parse("<item xsi:type=\"xsd:int\">1</item>");
		data.addNewPAYTPVOPERATIONSOPERATIONS();
		data.setPAYTPVOPERATIONSOPERATIONS(operations);

		data.setPAYTPVOPERATIONSMINAMOUNT(BigInteger.ZERO);
		data.setPAYTPVOPERATIONSMAXAMOUNT(BigInteger.valueOf(999999999));
		data.setPAYTPVOPERATIONSSTATE(BigInteger.ONE);
		data.setPAYTPVOPERATIONSFROMDATE("20170101000000");
		data.setPAYTPVOPERATIONSTODATE("20170208000000");
		data.setPAYTPVOPERATIONSCURRENCY("EUR");
		data.setPAYTPVOPERATIONSSIGNATURE("906a2a703a7a0a1f2d84da622b32cb6b5f845930");

		SearchOperationsResponseDocument responseDocument = paytpvGateway
				.search_operations(req);
		SearchOperationsResponse response = responseDocument
				.getSearchOperationsResponse();

		paytpv_operationsgateway.OperationArray operationsReponse = response
				.getReturn();

		List<Item> result = new ArrayList<Item>();
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
				
				System.out.println(item);
				
				result.add(item);				
			}
		}
		System.out.println(result.size());
		assertNotNull(result);
	}

}
