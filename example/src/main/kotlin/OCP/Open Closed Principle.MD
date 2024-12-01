  Modules that conform to open-close principle have two primary attributes:
  -They are open for extension. This means that the behavior of the module can be extended. That we can make 
  module behave in a new and different ways as the requirements of the application change, or meet the needs of 
  new applications.
  -They are closed for modification. The source code of such module is inviolate. No ones allowed to make source
  code changes to it.
  
The essence of the open/close principle is to minimize the number of changes required to add new features of the app.

Open for extension means that we should add new features to the application without breaking existing code.

Close for modification means that we should not introduce breaking changes to the existing code, because that would
force you to refactor a lot of existing code, and in a case of public API, would probably break a lot of 
software consumers.

Meyers's open/close principle - proposed solution to this problem relied on the notion of object-oriented inheritance.

Polymorphic open/closed principle - in contrast to the Meyer's usage, this definition advocates inheritance from 
abstract base classes. Interface specifications can be reused through inheritance but implementation need not be. 
The existing interface should be closed for modification, and the new implementations must, minimum, implement
that interface.
