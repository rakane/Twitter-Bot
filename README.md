# Twitter-Bot

## Overview
This is a twitter bot i am currently working on that retweets stock market news
from MarketWatch, WSJ Business, MSN money, and the Motley Fool. The objective
of this project is to familiarize myself with Maven. This project was created
on Ubutu through the terminal. If you want to try and use this project for
your own twitter account, instructions are below.

## How to install and run
1. Download/Clone repository
2. Make sure __JDK__ and __Maven__ are installed on your computer
3. Register your twitter app to the account, instructions on how to do so can
be found here: https://iag.me/socialmedia/how-to-create-a-twitter-app-in-8-easy-steps/
4. open App.java and input your authentication keys found by doing step 3 into
the correct fields marked with __*__
5. In the terminal navigate to __/Twitter-Bot__ and type __mvn clean package__
6. Once it is complete navigate to __/target__ and run the jar by typing
__java -jar Twitter-Bot-1.0-SNAPSHOT.jar__
