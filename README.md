IntelligentSystems
==================

Intelligent Systems project

##To do list:

* [x] redefine gatherInitialPercepts() within the BlWhSquaresProblem class to create an initial problem state
* [x] redefine equals() in each object that makes up the problem environment
* [x] define the Operator subclass/es you deem necessary in accordance with the actions you defined in your previous homework. This involves defining methods isApplicable() and effect() of Operator [comply to the “don’t talk to strangers” design pattern by adding extra methods in your Environment object if necessary]
* [x] define a method createOperators() within the BlWhSquaresProblem class that creates the necessary instances of your Operator subclass/es and assigns them to the BlWhSquaresProblem instance.
* [x] redefine isFinalState() within the BlWhSquaresProblem class [we’ll discuss it in class]. It’s advisable to redefine toString() as well.
* [ ] do unit testing (or similar) for the BlWhSquaresProblem and Operator objects in order to:
	- [x] Check gatherInitialPercepts() of BlWhSquaresProblem and make sure you have a correct initial state assigned to your instance of BlWhSquaresProblem.
	- [x] Check isFinalState() both on the initial state you created and on a “madeup” final state.
	- [x] Check method createOperators().
	- [x] Check the methods isApplicable() and effect() of instances of your Operator subclasses.
