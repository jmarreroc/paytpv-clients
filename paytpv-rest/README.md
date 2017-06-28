# PAYTPV REST API 

## Description
Simple java rest client to consume 'paytpv-ws-client'.

## Requirements
mvn version >= 3.1.1
Java >= 6
Tomcat >= 5.0

## Execution
- mvn -clean install

## Testing
- Startup Tomcat server with war deployed
- check the URL: http://<host>:<port>/paytpv-rest/api/version
 

## Example for developers:

Consumes this api using jersey or whatever you need
```xml
	<dependency>
		<groupId>com.sun.jersey</groupId>
		<artifactId>jersey-client</artifactId>
		<version>1.8</version>
	</dependency>
```
```java
	WebResource webResource = client.resource("http://localhost:8088/paytpv-rest/api/rwks4zgt/4795/sdwzy7mpkt69rfb5083q/1"
					+ "?fromDate=20170101113210"
					+ "&toDate=20170208233215");
	
	ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
	String output = response.getEntity(String.class);

```

Also you can use a simple json serialization/deserialization library as google gson
```xml
	<dependency>
		<groupId>com.google.code.gson</groupId>
		<artifactId>gson</artifactId>
		<version>2.8.0</version>
	</dependency>
```
```java
	JsonParser jsonParser = new JsonParser();
	JsonElement element = jsonParser.parse(output);

	JsonArray array= element.getAsJsonArray();
		
	for (int i = 0; i< array.size(); i++) {
		JsonElement arrayElement = array.get(i);
		JsonObject jsonObject = arrayElement.getAsJsonObject();
		JsonElement operationId = jsonObject.get("PAYTPV_OPERATION_ID");		
	}
```

