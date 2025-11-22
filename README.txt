Customer Purchase Predictor

Author: 	Matthew Hogan
Student ID: c23433226
Module: 	Object Orientated Programming CMPU 2016
Course:		857/2

Project Overview
-----------------
This java application predicts whether a customer is likely to make a purchase based on 4 categorical
features:
			-Age
			-Income
			-Previous Purchase
			-Promotion Interest
It Uses a Naive bayes classifier for prediction and a GUI for user input.
Data frequency table:
----------------------						

						| Feature             | Possible Values | Description                          
|---------------------|------------------|---------------------------------------|
| Age group           | young, old       | customers age group                   |
| Income level        | high, low        | customers income level                |
| Previous purchases  | yes, no          | purchase history 	            	 |
| Promo interest      | yes, no          | customer showed interest in promotions|
| Made Purchase(Label)| yes, no          | final purchase outcome                |
						

A data set of 200 customers was generated using Gen AI using all potential combinations of these values with 
with randomised labels.

Java classes
-------------
>Customer 				- single customer record
>Dataset 				- list of customer loaded from csv
>NaiveBayesClassifeir 	- Trains the Dataset and predicts based on probability
>PredictorGUI			- Swing GUI for data entry adds new customers makes new predictions
>Main					- Loads Dataset, trains model, start GUI, splits data and runs accuracy

Level Functionality
--------------------

Level 1: Level one was removed to redundancy in level 2. Personally made code easier to manage.
level 2: Fully implemented data is loaded in from CSV which is then dynamically trained by the Niave bayes classifier.
Level 3: Fully implemented. New label customer can be added thus retraining the model.
level 4: Partially completed. Returns accuracy of the last 50 of the 200 row data set to console. Struggled with stratified sampling logic.

If I had more time i would add...		
---------------------------------
1.) Display prediction accuracy in GUI
2.)	Understand stratified logic accuracy further and apply it.
3.) Confidence percentage for predictions.
4.) Add reset button to GUI

Instructions:
-------------
1.) Place customerData.csv in a /data folder
2.) Run main class
3.) Enter values into GUI click 'Predict
4.) Prediction change enter same values change 'made Purchase' click 'add customer' 10+ times then click predict again.
5.) Observe accuracy in console.

Notes:
-------
> Predictions and training based off categorical data
> All coded with java. d
> Customer data values was AI generated and pasted into excel.
> Git used towards end to capture final development changes
> Level 1 was being worked on and hard coded but later removed as highlighted previously.Personal choice as I Wanted focus my energy on 
  the other levels.
>
 
