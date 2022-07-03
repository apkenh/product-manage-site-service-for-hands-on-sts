# product-manage-site-service-for-hands-on-sts


Product manage site service for hands-on


Pls. refer orginal https://github.com/TetsujiFurukawa/product-manage-site-service-for-hands-on


This repo revamp the original service below
1.  change IDE from Intellij to Spring Tool Suite
2.  change build tool from gradle to maven
3.  change database from h2/PostgreSQL to MySQL
4.  change module from multi to single
5.  upgrade to latest Spring Boot version


Update


20220703
1.	remove session storage
2.	revise tbl_user_mst to add token field
3.	add jwt handling for sign-in, sign-out and validation
4.	simplify ext entity class


20220626
1.	Rename TblUserMst for class
2.	Add sign-in controller


20220625
1.	add oauth2 jwt
2.	fix statics folder path


20220623
1.	add JPA feature
2.	add tables entity
3.	update tables schema


20220622
1.	temp. disable spring security
2.	relocate static folder outside classpath same as original version
3.	change swagger to springdoc-openapi-ui
4.	update MySQL database url to use local instead of remote ubuntu MySQL database

