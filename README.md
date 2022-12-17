# BookKeeper  
Data Structure in java i.e book recommendation  
In this project we have following classes i.e   
## Main()  
as you can see we are working on three dataset i.e amazon, ZStore and UrdUBazar
![main](https://user-images.githubusercontent.com/104616632/208170778-41e1282b-8bf9-4ad5-9f83-3857a3a112f2.PNG)
There are two classes in it  
### Node:  
In the pictures below we can see that we are using Nodes for storing multiple attributes of a book.
Attributes of a Book are Book Name, Author Name, Price, Rating, Purchase Ratio and Number of Reviews
![Capture](https://user-images.githubusercontent.com/104616632/208160771-86f53cfb-58d2-4f93-b8d0-696e45d35287.PNG)
![Node2](https://user-images.githubusercontent.com/104616632/208161062-3bc37421-54b8-4419-bdc7-903c8ce5008b.PNG)
### Re:  
In this picture you will see a class re which is used in recommanding by scores which you will see below later  
![re](https://user-images.githubusercontent.com/104616632/208162274-9f95c2a9-270d-4ec7-bf19-f7c02ab1b51e.PNG)  
## General():  
General class is used for extract and formatting the dataset which is being used by using csv files in the requried form by using differet function as :  
### Filing():  
This Function is used for scanning a csv file and separating the data by commas  
![filing](https://user-images.githubusercontent.com/104616632/208227663-334dbe0e-f1a0-48a6-92ce-0c158a4a00fc.PNG)  
### Extract():  
This function was used for extracting the data into a specified fromat  
![extract](https://user-images.githubusercontent.com/104616632/208227736-691ff4e3-1f1b-4c59-b447-c777b32997a5.PNG)  
### Fi():  
This function is used to input the extract data of all three file in Nodes, As all three dataset have same books but have differnt price, Purchase Ratio, Number of reviews and are from different source i.e Amazon, ZStore and Urdu Bazar. You will see below that i am using a max function to get the maximum value out of all the three dataset of Purchase Ratio, Reviews and Rating. In case of price i am extracting the minimum price out of all and from which souce i get the minimum price i am also maintaining it   
![Fi](https://user-images.githubusercontent.com/104616632/208227889-bcea9a1c-ef3c-417f-9bab-f029b534db5a.PNG)  
Here a function is being used for geting the max  
![max](https://user-images.githubusercontent.com/104616632/208228062-340d38b5-d4f7-4020-bfc4-572c95a8d8d8.PNG)
