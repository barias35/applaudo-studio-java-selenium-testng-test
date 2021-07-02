# This project was a challenge from Applaudo Studio
markdown: kramdown

For following api doc site: https://breakingbadapi.com/documentation build a class with tests that resolve below exercises:

- Get Walter White information and print in console birthday only

- Get all characters information store them into a POJO/Model/DTO and print all characters information as below:

Display format in the console must be like this

Character name: "Walter White"

Portrayed: "Bryan Cranston"

------------------------------------------------------

Character name: "Jesse Pinkman"

Portrayed: "Aaron Paul"

-----------------------------------------------------

...

## How i did it? 

I needed TestNG and Rest Assured i configured [pom file](/pom.xml) with the plugins and dependencies needed,
I also needed "jackson-databind" dependency for mapping json response into a list of class "Character"

*After I finished the configuration i created the [model](src/main/java/models/Character.java), this with the purpose of cast a json response data to a class*

*My next step was create my [testcase](src/test/java/ApplaudoStudioTest.java) class*,
*this was a very challenging task because this was my first time seeing Rest Assured*

*After I finished of creating my testcase, i realize that i repeated these lines in both test cases* ![image](https://user-images.githubusercontent.com/47786738/124062013-fb3d8b80-d9fd-11eb-997b-3f0c7f321fc0.png)


*Here i just implemented "@BeforeClass" decorator in order to be used automatically for the test runner in Java*

*This is how it look now*


![image](https://user-images.githubusercontent.com/47786738/124062443-c4b44080-d9fe-11eb-8d2e-caedd7c49aa1.png)


*Now i can use the request in both cases*


*I used IntelliJ, if you clone this project you must run maven for automatically install dependencies and plugins already in the pom file*

* Then open IntelliJ go to this option

![image](https://user-images.githubusercontent.com/47786738/124063522-12ca4380-da01-11eb-9bef-25bdd0e4e997.png)


* Then click on + button 


![image](https://user-images.githubusercontent.com/47786738/124063610-3c836a80-da01-11eb-9046-39256073aefb.png)


* Then select TestNG and the option "Test king" select "All in package"


![image](https://user-images.githubusercontent.com/47786738/124063702-78b6cb00-da01-11eb-9959-9a9daf2d3c33.png)


* *You must select the sdk in my case i used Java 11 (11.0.7) if you do not have it* 
* [Dowload here](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html), *then install it after installation is completed go to the section on the image below:*

![image](https://user-images.githubusercontent.com/47786738/124156197-548cd580-da65-11eb-9f0d-29063a4457de.png)


* Then run and enjoy it!


![image](https://user-images.githubusercontent.com/47786738/124220368-c6980580-dacb-11eb-9383-3d824a0bde06.png)




Thank you! Applaudo Studio
