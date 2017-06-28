package com.paytpv.ws.facade;

import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.paytpv.Item;
import com.paytpv.ws.facade.impl.PaytpvFacadeServiceImpl;
import com.paytpv.ws.facade.utils.PaytpvUtils;
import com.paytpv.ws.pojo.OperationState;
import com.paytpv.ws.pojo.SortOrder;
import com.paytpv.ws.pojo.Terminal;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaytpvTest {

	private PaytpvFacadeService paytpvFacadeService;
	
	@Before
	public void init() throws AxisFault {
		paytpvFacadeService = new PaytpvFacadeServiceImpl();
	}
	
	@Test
	public void query() throws Exception {
		
		List<Terminal> terminals = new ArrayList<Terminal>();
		terminals.add(new Terminal("sdwzy7mpkt69rfb5083q",BigInteger.valueOf(4795)));
		
		List<BigInteger> operations = new ArrayList<BigInteger>();
		operations.add(BigInteger.valueOf(1));

		List<Item> searchOperations = paytpvFacadeService.getOperations(
				"rwks4zgt",
				BigInteger.ONE, 
				SortOrder.ASC,
				BigInteger.valueOf(100),
				terminals, 
				operations, 
				BigInteger.ZERO,
				BigInteger.valueOf(999999999),
				OperationState.CORRECTA, 
				PaytpvUtils.parse("20170525000000"),
				PaytpvUtils.parse("20170525233215"),
				"EUR",				 
				 "203/0/123123123123", null, null);
		
		assertNotNull(searchOperations);
		System.out.println("Operations returned: "+searchOperations.size());
		
		for (Item item: searchOperations) {
			System.out.println("AUTH_CODE: "+item.getPAYTPVOPERATIONAUTHCODE());
		}
		
		
	}

	@Test
	public void text() throws Exception {
		
		List<Terminal> terminals = new ArrayList<Terminal>();
		terminals.add(new Terminal("sdwzy7mpkt69rfb5083q",BigInteger.valueOf(4795)));
		
		List<BigInteger> operations = new ArrayList<BigInteger>();
		operations.add(BigInteger.valueOf(1));
		
		StringBuilder searchOperations = paytpvFacadeService.getXmlOperations(
				"rwks4zgt",
				BigInteger.ONE, 
				SortOrder.ASC,
				BigInteger.valueOf(100),
				terminals, 
				operations, 
				BigInteger.ZERO,
				BigInteger.valueOf(999999999),
				OperationState.CORRECTA, 
				PaytpvUtils.parse("20170101000000"),
				PaytpvUtils.parse("20170208000000"),
				"EUR",				 
				 null, null, null);
		
		assertNotNull(searchOperations);
		System.out.println("Operations returned: "+searchOperations.toString());
	}
	
}
