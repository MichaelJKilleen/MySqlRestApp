#Create folders to generate all files (separated for client and server)
#mkdir ssl && cd ssl && mkdir client && mkdir server
mkdir ssl && cd ssl && mkdir client && mkdir admin && mkdir server

## Server
# Generate server private key and self-signed certificate in one step
openssl req -x509 -newkey rsa:4096 -keyout server/serverPrivateKey.pem -out server/server.crt -days 3650 -nodes

# Create PKCS12 keystore containing private key and related self-sign certificate
openssl pkcs12 -export -out server/keyStore.p12 -inkey server/serverPrivateKey.pem -in server/server.crt
#For .Net
openssl pkcs12 -export -out server/bottomfeeder.keystore.pfx -inkey server/serverPrivateKey.pem -in server/server.crt

# Generate server trust store from server certificate
keytool -import -trustcacerts -alias root -file server/server.crt -keystore server/trustStore.jks

## Client
# Generate client's private key and a certificate signing request (CSR)
openssl req -new -newkey rsa:4096 -out client/request.csr -keyout client/myPrivateKey.pem -nodes
openssl req -new -newkey rsa:4096 -out admin/request.csr -keyout admin/myPrivateKey.pem -nodes

## Server
# Sign client's CSR with server private key and a related certificate
openssl x509 -req -days 360 -in client/request.csr -CA server/server.crt -CAkey server/serverPrivateKey.pem -CAcreateserial -out client/custommodels.crt -sha256
openssl x509 -req -days 360 -in admin/request.csr -CA server/server.crt -CAkey server/serverPrivateKey.pem -CAcreateserial -out admin/bfsadmin.crt -sha256

## Client
# Verify client's certificate
openssl x509 -text -noout -in client/custommodels.crt
openssl x509 -text -noout -in admin/bfsadmin.crt

# Create PKCS12 keystore containing client's private key and related self-sign certificate
openssl pkcs12 -export -out client/client_custommodels.p12 -inkey client/myPrivateKey.pem -in client/custommodels.crt -certfile server/myCertificate.crt
openssl pkcs12 -export -out admin/client_bfsadmin.p12 -inkey admin/myPrivateKey.pem -in admin/bfsadmin.crt -certfile server/myCertificate.crt


#"I don't know why we are here, but I'm pretty sure that it is not in order to enjoy ourselves." -- Ludwig Wittgenstein, Cambridge philosopher

