package com.paytpv.ws.pojo;

/**
 * 
 * @author paytpv
 *
 */
public enum OperationState {
	FALLIDA(0),CORRECTA(1),TODAS(2);
	private long state;
	OperationState(long state) {
		this.state = state;
	}
	public long getState() {
		return state;
	}
	
	public static OperationState from(long state) {
		for (OperationState opState: OperationState.values()) 
			if (opState.getState() == state)
				return opState;
		return null;
	}
}
