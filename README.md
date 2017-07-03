# PAYTPV CLIENTS

## About
These are free java distributable api clients to consume PAYTPV search_operations web service (https://secure.paytpv.com/gateway/xml-operations?wsdl).

More info about integration, account service and secure payment in http://developers.paytpv.com/

## Modules
- paytpv-ws-client: axis2 web service client for https://secure.paytpv.com/gateway/xml-operations?wsdl

- paytpv-ws-facade: Simple java facade for more customer-friendly consumption.
	dependency with 'paytpv-ws-client'

- paytpv-rest: Simple java rest client for more customer-friendly consumption.
	dependency with 'paytpv-ws-facade'
