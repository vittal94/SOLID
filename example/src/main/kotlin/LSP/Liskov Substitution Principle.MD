Extended classes shouldn't contradict with base classes.
This principle describes how properly extend the classes.
The behaviour of inheritors should be expected for  the base classes.

This principle is associated with covariance, contravariance and contract programming. It's useful relationship
between precondition and post condition:
 -preconditions should not be strengthened in subclasses
 -post conditions should not be weakened in subclasses

In the example of Rectangle and Square the last one is weakened the post condition by the methods setHeight()
and setWidth()

Precondition  is a certain condition to be guaranteed on entry by any client module that calls it.
Post condition is guaranteed a certain property on exit.

LSP recommends using composition instead of inheritance.
For example, the inheritance suppose to design systems like from general to private: Vehicle -> Car -> Mazda.
Composition - from the particular to the general in the form of the set of several separate features:
Mazda = engine + body + transmission + etc.