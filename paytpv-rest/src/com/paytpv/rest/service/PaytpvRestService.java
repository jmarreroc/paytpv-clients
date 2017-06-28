package com.paytpv.rest.service;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;

import com.paytpv.Item;
import com.paytpv.ws.facade.PaytpvFacadeService;
import com.paytpv.ws.facade.impl.PaytpvFacadeServiceImpl;
import com.paytpv.ws.facade.utils.PaytpvUtils;
import com.paytpv.ws.pojo.OperationState;
import com.paytpv.ws.pojo.SortOrder;
import com.paytpv.ws.pojo.Terminal;

@Path("/api")
public class PaytpvRestService {

	private Properties properties;
	
	private PaytpvFacadeService paytpvFacadeService;
	
	public PaytpvRestService() throws IOException {
		paytpvFacadeService = new PaytpvFacadeServiceImpl();
	}
	
	/**
	 * 
	 * @param terminal
	 * @param operation
	 * @param fromDate
	 * @param toDate
	 */
	private void validateInput(String terminal, String operation, String fromDate, String toDate) {
		if (!StringUtils.isNumeric(terminal)) {
			throw new IllegalArgumentException("'terminal' path param must be numeric");
		}
		
		if (!StringUtils.isNumeric(operation)) {
			throw new IllegalArgumentException("'operation' path param must be numeric");
		}
		if (fromDate != null) PaytpvUtils.parse(fromDate);
		if (toDate != null) PaytpvUtils.parse(toDate);
	}
	
	
	@GET
	@Path("/version")
	public Response version() throws IOException {
		properties = new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("project.properties"));
		} catch (Exception e) { 
			e.printStackTrace();
		}
		
		String version = (properties != null) && 
				(properties.getProperty("version") != null)
				? properties.getProperty("version")
				: "unknown";

		return Response.status(Status.OK).entity("Paytpv REST API "+version).build();
	}
	
	@GET
	@Path("/{merchantCode}/{terminal}/{pass}/{operation}")
	@Produces("application/json")
	public Response operations(
			@PathParam("merchantCode") String merchantCode,
			@PathParam("terminal") String terminal,
			@PathParam("pass") String pass,
			@PathParam("operation") String operation,
			@QueryParam("fromDate") String fromDate, 
			@QueryParam("toDate") String toDate,
			@QueryParam("reference") String reference) {
		
		try {
			validateInput(terminal, operation,fromDate, toDate);
		} catch (Exception e) {
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
		Calendar fromDateop = (fromDate != null) ? PaytpvUtils.parse(fromDate) : Calendar.getInstance();
		Calendar toDateop = (toDate != null) ? PaytpvUtils.parse(toDate) : Calendar.getInstance();
		
		if (fromDate == null) {
			fromDateop.add(Calendar.DATE, -1);
			fromDateop.add(Calendar.MONTH, 1);
		}
		
		if (toDate == null) {
			toDateop.add(Calendar.MONTH, 1);
		}
		
		List<Terminal> terminalsOp = new ArrayList<Terminal>();
		List<BigInteger> operationsOp = new ArrayList<BigInteger>();
		
		terminalsOp.add(new Terminal(pass, BigInteger.valueOf(Long.parseLong(terminal))));
		operationsOp.add(BigInteger.valueOf(Long.parseLong(operation)));
		
		try {
			List<Item> searchOperations = paytpvFacadeService.getOperations(
					merchantCode, 
					BigInteger.ONE, 
					SortOrder.ASC,
					BigInteger.valueOf(100), 
					terminalsOp, operationsOp, 
					BigInteger.ZERO,
					BigInteger.valueOf(999999999),
					OperationState.CORRECTA,  
					fromDateop, 
					toDateop, 
					"EUR",  
					reference, null, null);

			return Response.status(Status.OK).entity(searchOperations.toArray()).build();			
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}
	
}
