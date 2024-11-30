According to Bob Martin - class should have one reason to change.

   Why it's so important to have only one reason to change?
    In statically typed and compiled languages, several reasons may lead to several unwanted redeployments.
If there are two reasons to change, it is conceivable that two different teams are working on the same
code for two different reasons. Each will have to deploy its solution, which in case of compiled languages
may lead to incompatible modules with other teams and other modules of application.
Even though  you may not use of compiled languages, you may need to retest the same class for different
reasons.
   How to find the reason for change?
   Analyze the audience for the class. The users of  application and  system we are develop who are served
as a particular module will be the ones requesting changes to it. Those served will ask for change.
Here are a couple of modules and their possible audience:
 -Persistence module - audience include DBAs and software architect
 -Reporting module - audience include clerks, accountants and operation
 -Payment computation module for a payroll system - may include lawyers, managers and accountants.
 -Book search module for library management system - may include librarian or/and clients themselves.

  What is the role? How do we find it?
  It's much easier to imagine actors doing those roles and associating our audience with those actors.
So if our audience defines reasons for change, the actors defines the audience. This greatly helps us to
reduce the concept of concrete persons like "John the architect" to Architecture or "Mary the referent" 
to Operations.
  
  So responsibility is a family of functions that serves one particular actor.

Source of change - in the sense of this reasoning, the actors becomes the source of change for the family of 
functions that serves them. As their need change, that specific family of functions must accommodate their needs.

  An actor for a responsibility is a single source of change for that responsibility.


