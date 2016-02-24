## TravelDestinations

This is a simple android travel application that list the travel destinations. The user can select the name of the city to get a detailed view. 

It reads the list of destinations from CSV file. 
  - Backward Compatible (minSDKVersion 15 targetSDKVersion 23)
  - The image for the city get downloaded asynchronously.
  
 
![Travel Destinations](https://cloud.githubusercontent.com/assets/16673483/13273618/d146effa-da72-11e5-8063-f1cd929bfcbe.png)

Clicking on any city in the list will display the image and additional description 

![ColorPicker](https://cloud.githubusercontent.com/assets/16673483/13273904/ee3a21ca-da74-11e5-99a3-2006a39ececf.png)

###  Running the app
To run the app, clone the TravelDestination repo and import the project into Android Studio.

###  Improvements
Following changes can be added to improve the performance and quality of this application but couldn't be covered due to time constraints
  - The images for the city are currently loaded asynchronously. To improve the performance, the images can also be cached using LRU cache in memory and disk if there are lots of images. 
  - A thumbnail for the images for city can be added to the listview to improve the user experience.
  - Add the capability to handle the case gracefully when the device does not have network connection (display a message, prompting the user to turn on the network connection etc.).
  - Adding the unit test cases to improve the quality of the application. Following unit test can be added
     1. Testing the application with large CSV file. 
     2. Test the input data read from CSV file for missing or invalid values.
     3. Curently the data frm CSV file is delimited by ",". The application must handle comma in the data.

### Author
Prerana Desai
