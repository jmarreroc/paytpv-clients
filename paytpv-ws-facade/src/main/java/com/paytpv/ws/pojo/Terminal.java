package com.paytpv.ws.pojo;

import java.math.BigInteger;

/**
 * 
 * @author paytpv
 *
 */
public class Terminal {

	private String password;
	private BigInteger terminalCode;

	public Terminal(String password, BigInteger terminalCode) {
		super();
		this.password = password;
		this.terminalCode = terminalCode;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BigInteger getTerminalCode() {
		return terminalCode;
	}
	public void setTerminalCode(BigInteger terminalCode) {
		this.terminalCode = terminalCode;
	}
	
	
	
}
