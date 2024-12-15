
Entities should not depend on interface's methods that they don't use. ISP splits large interfaces into smallest that are
more specific ones, so the clients only will have to know about methods that they interested in. ISP keeps the system
decouple so thus easy to refactor. ISP is key principle in distributed system like microservices.

In object-oriented design, interfaces are layers of abstractions it creates a barrier preventing coupling to 
dependencies. If the system couple in multiple levels, changing code in one place causing changes in other
many places.