# RabbitMq
# Tutorial for Rabbit Mq
Rabbit MQ is the most widely deployed open source message broker. <br/>
<b>What is the message broker?</b><br/>
A message broker is software that enables applications, systems, and services to communicate with each other and exchange information. <br/>
The message broker does this by translating messages between formal messaging protocols. <br/>
This allows interdependent services to “talk” with one another directly, even if they were written in different languages or implemented on different platforms.<br/>
<b>Introduction –</b> <br/>
	Rabbit Mq act as a message broker ie it accept the message and forward the message to the destination.<br/> 
  A application that sends a message is called Publisher. An application which receive message are known as Consumer. <br/>
  Now to communicate between producer and consumer we required a medium. That medium is nothing but the rabbit mq. Message flowing through rabbit mq store msg in queue only.<br/>
  The below diagram give an overview. 

 

<img width="457" alt="Project1" src="https://user-images.githubusercontent.com/79270180/111520541-969c4080-872e-11eb-8272-7a6a4a146a83.PNG">

Example1 - Welcome to Rabbit Mq Tutorial
1.	Publisher will send a single message
2.	Consumer will consume the message
3.	Queue – A message buffer in rabbit mq, where message are stored
<br />•	Note -<br /> 	
o	QUEUE_NAME must be same on both publisher and consumer side

