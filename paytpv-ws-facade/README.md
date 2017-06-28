# PAYTPV WEB SERVICE FACADE 

## Description
Simple java facade for more customer-friendly consumption.
 
## Requirements 
- Maven version installed >= 3.2.5
- Java 7

## Execution
- mvn -clean install

## Example for developers:
```java
	PaytpvFacadeService paytpvFacadeService = new PaytpvFacadeServiceImpl();
	
	List<Terminal> terminals = new ArrayList<Terminal>();
	terminals.add(new Terminal("********************",BigInteger.valueOf(****)));
	
	List<BigInteger> operations = new ArrayList<BigInteger>();
	operations.add(BigInteger.valueOf(1));
	
	List<Item> searchOperations = paytpvFacadeService.getOperations(
			"********",
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
			 null, /*optional*/ 
			 null, /*optional*/
			 null  /*optional*/);
	
```

For more info about paytpv client: http://developers.paytpv.com/es/documentacion/operations