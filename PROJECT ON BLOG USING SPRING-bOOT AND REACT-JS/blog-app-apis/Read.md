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

---------------------------------------------------------------------------------
session-4 ModelMapper dependency
--------------

	now to convert one object to other object we have create two method dtoTOUser() and userToDto() 	which are converting user object to userDto object and userDto object to user object but for more 	than two and many class or object it is not good to write code to achive it we are configurating 	the dependency of 	ModelMapper jar
	in pom.xml

for that we have to get it by offical maven website -> https://mvnrepository.com/artifact/org.modelmapper/modelmapper

<!-- https://mvnrepository.com/artifact/org.modelmapper/modelmapper -->
<dependency>
    <groupId>org.modelmapper</groupId>
    <artifactId>modelmapper</artifactId>
    <version>3.1.0</version>
</dependency>


------------------------------------------------------------------------------------------------------------------------------------
session-5 validation of data
---------------
we are going to validate the data so that data will be stored in well formate for that we are going to do validation at server 	side like- email validation ,number of charecter in name etc.

step1: inject dependecy of the hibernate spring-boot spring-boot-starter-validation
step-2: use the @Annocation on required files
step-3: enable the @Annocation by container
step-4: format the error 
-----------------
step-1 

<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
    <version>2.6.6</version>
</dependency>
----------------
step-2 : apply all the @Annotaion on required fileds on  UserDto.java class of com.blogapp.apis.payloads package.
step-3: to enable these Annotaion we have to use the @Valid annoation on Container from this method request is comming.

------------------------
step-4: format the error SMS to display the Error in well format
to handle the rise exception called MethodArgumentNotValidException by GlobleExceptionHandler class to create a method called 


----------------------------------------------------------------------------------------------------------------------------------
session-6 creating the Category APIS
----------------------
step-1: create class entity User.java
step-2: create class CategoryDto.java
step-3: create interface CategoryRepo.java
step-4: create interface CategoryService.java
step-5: create class CategoryServiceImpl.java
step-6: create CategoryController.java

-------------------------------------------------------------------------------------------------------------------
session-7 Creating Post class entity and Relationship between post , user and Category to maintain the join concept
---------------------------------------
step-1: create class entity Post.java
step-2: create class PostDto.java
step-3: create interface PostRepo.java
step-4: create interface PostService.java
step-5: create class PostServiceImpl.java
step-6: create PostController.java

----------------------------------------------------------------------------------------------------------------
session-8 Implement Pagination in very simple ways in API
-------------------------------

here we are going to apply the Pagination to filter the pages

	In your 'PostServiceImpl' class, you are creating a 'Pageable' object 'p' and passing it to the
	`findA11() ' method of your 'PostRepo' with 'pageNumber' and 'pageSize'. However, the
	'pageNumber' in 'PageRequest' is zero-based, meaning the first page is '0', not '1'. Therefore,
	when you pass 'pageNumber = 1', it will actually retrieve the second page.
	To fix this issue and retrieve the first page when `pageNumber = 1', you need to subtract '1' from
	the 'pageNumber' when creating the 'PageRequest'. Here's how you can fix it:
			 
to overcome the above we have to set the value of pageNumber 0 not 1 in container.

----------------------------------------------------------------------------------------------------------------------
session-9 Modifying Post Response in POST API | Its very important for creating API 
------------------------------------
to modify the Post API response we are creating a class called PostResponse which hold the content fileds  and some more
to send the data in more easy ways.so that we can apply the sorting and pagination 
after creating this class we have to change the return types of getAllPost() from PostServiceImpl class to PostResponse and implements code to return the PostResponse data and also change the return types of ResponseEntity<List<PostDto>>> getAllPost method(handler) of PostController to ResponseEntity<PostResponse> getAllPost . and implements the code.

after change this all run and test and also apply this one to two more method of PostService on 
1)List<PostDto> getPostsByCategory(Integer category_id); . 2)List<PostDto> getPostsByUser(Integer user_id);

apply it also on getallpost by users and category.



-------------------------------------------------------------------------------------------------------------
session-10 Implementing Sorting in Blogging Application in Spring Boot 
---------------------------------
for the sorting we have to implements one more arguments to List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);
based on sorting parameters

1)public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy); ---> to sort the data by either postId, postContent and postTitle 


2)public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir); --> to sort the data by either desc order or asc order 


---

------------------------------------------------------------------------------------------------
session-11 Implementing Searching in our Backend Application 
----------------------
step-1: we are creating a costume jpa method for perfomrms the like query on database called List<Post> findByPostTitleContaining(String postTitle); and here notes that to give the name be careful 

step-2: create a method is PostService interface called List<PostDto> searchPosts(String keyword); to override in its implemented class

step-3: override the List<PostDto> searchPosts(String keyword); method in PostServiceImpl and write the code.

step-4: create a handler in PostContainer called public ResponseEntity<List<PostDto>> serchPostByTitle to handle the search request.

---------------------------------------------------------------------------------------------------------
session-12 One Good Practice that makes your project best |
--------------------------
we are going to learn that how to remove and maintain the hardcode in your application for that we are create a separate constant for them.
which make code-reusable, less-code, easy-to-chnage or update etc.

step-1:creating a class AppConstants in packages-> com.blogapp.apis.config to implemts all constanst data
sep-2: change all the data which is hard-coded from PostController


-----------------------------------------------------------------------------------------------------------
session-13 Working on Post Image in one short | Uploading Image for Post | Serving Post Image
------------------------------
here we are going to insert the pics by post and store in directory.

step-1: creating a interface called FileService.java
step-2: creating a class which implemtns all the methods of FileService interface called FileServiceImpl.java.
step-3: provides the detalis of MUltitypes data in application.properties 

	like- 
# this is for image perpose 
spring.servlet.multipart.max-file-size = 20MB
spring.servlet.multipart.max-request-size = 20MB
project.image = image/

step-4: create a handler in PostController.java called ResponseEntity<PostDto> uploadPostImage
step-5: send the request and check the response.




























