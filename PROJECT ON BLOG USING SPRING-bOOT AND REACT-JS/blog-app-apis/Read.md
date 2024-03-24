session-1 creating the user model and AIPS
------------------------------------------------
before create the userModel we have create a following packages to mantains the data 
1) com.blogapp.apis.entities -> this package will store all the java class which is used to create a table for 
	database and it should me secure 

2)com.blogapp.apis.payloads -> this package will store all the java class which can be used to communicate with service class to 
	entities to make the database secure.

2)com.blogapp.apis.repositories -> in this package we create a interface which extends the JPARepository interface which provides
	more methods to deails with database like - creating tables query method and CURD method and mores..

3)com.blogapp.apis.services -> it will store the a interface which extends the repositriy packages interface aso that we can use all the 
	importans method of JPA by it and it also store some addtional methods of its.
	
4)com.blogapp.apis.services.imps --> in this packages we create a class which implemts the services packages interface to implemts its all method and to use the JPA method to performs the business logics here.

-----------------------------------------------------------------
session -3 
-------------

create class to handle the Errors name as GlobleExceptionHandler  which handle the exception globlelly
so all the exception can be handle by here also and it  implemets the method to handle the Resource Not Found Exception so when ever the at client side Resource Not Found Exception is  happed then this method (resourceNotFoundExceptionHandler() ) will we execute than send the response. 
