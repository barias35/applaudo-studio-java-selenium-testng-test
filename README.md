
# This project was a challenge from Applaudo Studio

For following website: http://automationpractice.com/index.php build a solution to test below conditions:

1- Add item to shopping cart

2- Remove item inside shopping cart

3- Search item (include at least one positive and negative condition)

4- Validate store information (scroll down to footer and check for Store Information)

...

## How i did it? 

I needed TestNG and Selenium i configured [pom file](/pom.xml) with the plugins and dependencies needed,

*I used IntelliJ, if you clone this project you must run maven for automatically install dependencies and plugins already in the pom file*

* Then open IntelliJ go to this option

![image](https://user-images.githubusercontent.com/47786738/124221180-3a86dd80-dacd-11eb-8202-0725bd9898dc.png)



* Then click on + button 


![image](https://user-images.githubusercontent.com/47786738/124063610-3c836a80-da01-11eb-9046-39256073aefb.png)


* Then select TestNG and the option "Test king" select "All in package"


![image](https://user-images.githubusercontent.com/47786738/124220585-0eb72800-dacc-11eb-800f-1d9d9980c24e.png)



* *You must select the sdk in my case i used Java 11 (11.0.7) if you do not have it* 
* [Dowload here](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html), *then install it after installation is completed go to the section on the image below:*

![image](https://user-images.githubusercontent.com/47786738/124156197-548cd580-da65-11eb-9f0d-29063a4457de.png)

* Finally the last step go to [Config.java](src/main/java/utils/Config.java) and configure your path for the driver 


![image](https://user-images.githubusercontent.com/47786738/124222807-72435480-dad0-11eb-9c50-759a0e666245.png)



* Then run and enjoy it!


![image](https://user-images.githubusercontent.com/47786738/124220368-c6980580-dacb-11eb-9383-3d824a0bde06.png)


### Notes

- This project was build for Google Chrome, but if you want to change you're free 



### Important

My experience with this challenge was amazing, adding item to the shopping cart was a bit difficult due the unstability of the page, sometimes doesn't work i tried to figure out a way to avoid this but i couldn't most of the time will work.


I realize i can improve, more abstraction for the driver handler, parallel testing and so on.





Thank you! Applaudo Studio for this opportunity
