Overview
========
Metafour PAF Service Demo project using Spring Boot.

Change Log
==========
0.0.1-M1
--------
Spring Boot with two RESTfull service endpoints:


*   http://localhost:8080/address/GB/W148EZ/part
*   http://localhost:8080/address/GB/W148EZ/full

Both returns JSON data by default or if Accept header is application/json.

Both returns HTTP error code 406 (Not Acceptable) if Accept header is application/xml or text/xml.
