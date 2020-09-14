# java_lab
Programs for fulfilment of lab component for Java course in my university 

# Learning Java

## Java classes and interfaces
- Objects encapsulate data, operations and usage semantics.
- Allow storage and manipulation details to be hidden.
- Separates what is to be done from how it is done

### Classes

- A class is a template for creating objects
- Classes are made up of state and executable code states are data and executables are methods which manipulate the state of the object.
- Constructors are executable codes that are automatically run when we create an object. Constructor name is same as a class and no return statement.
- Declaring a variable of class type does not create an object, it creates a variable that can hold a reference to the class object
- Creating an object requires the use of new keyword.
- When we use the new keyword, it creates a memory space of the instance and the variable stores a reference to that memory space.
- Classes are often called reference types because they are accessed by references.
- When assigning one variable to other, the reference to the class object is assigned to the variable rather than copying the value.

#### Encapsulation and access modifiers
- Encapsulation refers to hiding the implementation details of a class

- Access modifiers :

  | Modifier           | Visibility                                    | Usable on classes | Usable on members |
  | ------------------ | --------------------------------------------- | ----------------- | ----------------- |
  | No access modifier | Only within its own package (package private) | Y                 | Y                 |
  | public             | Everywhere                                    | Y                 | Y                 |
  | private            | Only within the declaring class               | N*                | Y                 |

  *Nested classes can be private

#### Special References by java

- this: used for reference to current object
- null: represents an uncreated object

#### Field Encapsulation

- Fields are implementation details

- In most cases we do not want our fields to be accessed outside of class.

  ##### Accessors and Mutators

  - Accessor / getter method retrieves field value
  - Mutator / setter method modifies field value

#### Initializing classes 

- Field Initializers 

  Specify a field's initial value as a part of field's declaration.

  - Can be an equation
  - Can include other fields.
  - Can include method calls

- Constructors

  - Named same as the class
  - No return type
  - Each class needs to have one constructor, if we do not write our own Java provides you with an empty constructor
  - A class can have multiple constructors but they should have a unique parameters list i.e.
    - They either have a different number of parameters or
    - They should have different types of parameters.
    - This is commonly referred to as the signature of the constructor.
  - Thus, constructors should have different signatures.
  - Constructors can be chained together i.e. one constructor can call the other constructor but in this case:
    - The calling of other constructor should be the first line of the constructor
    - Use the this keyword followed by parameter list eg: this(parameters...)
  - Constructors can be private too, depending upon the implementation.

- Initialization blocks

  - Share code across all constructors
  - They do not accept any parameters
  - The code is placed within brackets outside of any method or constructor
  - A class can have 0 or more initialization blocks, and all the initialization blocks always execute 
  - The order of execution starts at the top of the source file
  - The initialization blocks cannot replace the default constructor

  ##### Initialization and construction order

  1. Field initializers
  2. Initilization blocks
  3. Constructors

#### Static members

- Static members are shared class wide:
  - Not associated with individual instance

- Declared using the static keyword
  - Accessible using the class name

- Static fields
  - A value not associated with a specific instance
  - All instances access the same value
- Static methods
  - Perform an action not tied to a specific instance instead they are tied to the class
  - Have access to static members only
  - They are accessed using the class name

- Static import statements
  - Normal import statements
    - Allows a type name to be used without being package-qualified
  - Static import statements
    - Used with static methods
    - Allows method name to be used without being class-qualified
- Static initilization blocks
  - Perform one-time type initialization
    - Execute before type's first use
    - Has access to static members only
  - Statements enclosed in brackets
    - Preceded by static keyword
    - Outside of any method or constructor

#### Closer looks at methods

##### Passing objects as parameters

- Passed by reference (Parameter receives a copy of the reference)
- Changes to the reference within the method, the changes will not be visible outside of the method
- Changes to members are visible within and also outside the method as well.

##### Method overloading

- Multiple versions of method or constructor within a class.
- Each constructor and method should have a unique signature, signature refers to:
  - The number of parameters
  - The datatype of each parameter
  - The method name
- The call to other overloaded method does not have to be the first line in the overloaded method while in constructor overloading it has to be.
- When the compiler cannot find an exact match for the call of the method due to the use of datatypes, the compiler will start looking for opportunities with type conversions eg- short can be converted to int.

