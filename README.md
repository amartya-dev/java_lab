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
    
    - Allows importing constants to a class without having to declare the class name
    
    - Eg:- 
    
      ```java
      import static java.lang.Math.PI;
      import static java.lang.Math.pow;
      
      // Can cause ambiguity at certain places
      
      import static java.lang.Integer.*;
      import static java.lang.Long.*;
      
      public class HelloWorld {
          public static void main(String[] args) {
              System.out.println(MAX_VALUE);
          }
      }
      
      // Here MAX_VALUE is both for Integer and Long and there is no way to know for // sure, the solution is to specify class name which makes static import
      // redunant
      ```
    
      
- Static initilization blocks
  - Perform one-time type initialization
    - Execute before type's first use
    - Has access to static members only
    
  - Statements enclosed in brackets
    - Preceded by static keyword
    - Outside of any method or constructor
    
    A *static initialization block* is a normal block of code enclosed in braces, `{ }`, and preceded by the `static` keyword. Here is an example:
    
    ```java
    static {
        // whatever code is needed for initialization goes here
    }
    ```
    
    A class can have any number of static initialization blocks, and they can appear anywhere in the class body. The runtime system guarantees that static initialization blocks are called in the order that they appear in the source code.
    
    There is an alternative to static blocks — you can write a private static method:
    
    ```java
    class Whatever {
        public static varType myVar = initializeClassVariable();
            
        private static varType initializeClassVariable() {
    
            // initialization code goes here
        }
    }
    ```
    
    The advantage of private static methods is that they can be reused later if you need to reinitialize the class variable.

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

# Inheritance concepts

## Method overriding

### Instance Methods

- An instance method in subclass with same signature and return type as super class is said to override the superclass' method.
- An overriding method can also return a subtype of the type returned by the overridden method. This subtype is called a *covariant return type*.
- ```@Override``` annotation can be used when overriding methods.

## Static Methods

- If the subclass defines a static method with same signature as the super class, then the method in *hides* the one in the superclass.

- The distinction between hiding a static method and overriding an instance method has important implications:

  - The version of the overridden instance method that gets invoked is the one in the subclass.
  - The version of the hidden static method that gets invoked depends on whether it is invoked from the superclass or the subclass.

- Example: (Declaring a superclass Animal with one instance method and one static method)

  ```java
  public class Animal {
      public static void testClassMethod() {
          System.out.println("The static method in Animal");
      }
      public void testInstanceMethod() {
          System.out.println("The instance method in Animal");
      }
  }
  ```

  Declaring a second class (Sub class called cat):

  ```java
  public class Cat extends Animal {
      public static void testClassMethod() {
          System.out.println("The static method in Cat");
      }
      public void testInstanceMethod() {
          System.out.println("The instance method in Cat");
      }
  
      public static void main(String[] args) {
          Cat myCat = new Cat();
          Animal myAnimal = myCat;
          Animal.testClassMethod();
          myAnimal.testInstanceMethod();
      }
  }
  ```

  The cat class overrides the instance method in ```Animal``` and hides the static method. he `main` method in this class creates an instance of `Cat` and invokes `testClassMethod()` on the class and `testInstanceMethod()` on the instance.

  Output:

  ```
  The static method in Animal
  The instance method in Cat
  ```

  The version of the hidden static method that gets invoked is the one in the superclass, and the version of the overridden instance method that gets invoked is the one in the subclass.

## Interface methods

- [Default methods](https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html) and [abstract methods](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html) in interfaces are inherited like instance methods. However, when the supertypes of a class or interface provide multiple default methods with the same signature, the Java compiler follows inheritance rules to resolve the name conflict. These rules are driven by the following two principles:

  - Instance methods are preferred over interface default methods.

    Consider the following classes and interfaces:

    ```java
    public class Horse {
        public String identifyMyself() {
            return "I am a horse.";
        }
    }
    ```

    ```java
    public interface Flyer {
        default public String identifyMyself() {
            return "I am able to fly.";
        }
    }
    ```

    ```java
    public interface Mythical {
        default public String identifyMyself() {
            return "I am a mythical creature.";
        }
    }
    ```

    ```java
    public class Pegasus extends Horse implements Flyer, Mythical {
        public static void main(String... args) {
            Pegasus myApp = new Pegasus();
            System.out.println(myApp.identifyMyself());
        }
    }
    ```

    The method `Pegasus.identifyMyself` returns the string `I am a horse.`

  - Methods that are already overridden by other candidates are ignored. This circumstance can arise when supertypes share a common ancestor.

    Consider the following interfaces and classes:

    ```java
    public interface Animal {
        default public String identifyMyself() {
            return "I am an animal.";
        }
    }
    ```

    ```java
    public interface EggLayer extends Animal {
        default public String identifyMyself() {
            return "I am able to lay eggs.";
        }
    }
    ```

    ```java
    public interface FireBreather extends Animal { }
    ```

    ```java
    public class Dragon implements EggLayer, FireBreather {
        public static void main (String... args) {
            Dragon myApp = new Dragon();
            System.out.println(myApp.identifyMyself());
        }
    }
    ```

    The method `Dragon.identifyMyself` returns the string `I am able to lay eggs.`

- If two or more independently defined default methods conflict, or a default method conflicts with an abstract method, then the Java compiler produces a compiler error. You must explicitly override the supertype methods.

  Consider the example about computer-controlled cars that can now fly. You have two interfaces (`OperateCar` and `FlyCar`) that provide default implementations for the same method, (`startEngine`):

  ```java
  public interface OperateCar {
      // ...
      default public int startEngine(EncryptedKey key) {
          // Implementation
      }
  }
  public interface FlyCar {
      // ...
      default public int startEngine(EncryptedKey key) {
          // Implementation
      }
  }
  ```

  A class that implements both `OperateCar` and `FlyCar` must override the method `startEngine`. You could invoke any of the of the default implementations with the `super` keyword.

  ```java
  public class FlyingCar implements OperateCar, FlyCar {
      // ...
      public int startEngine(EncryptedKey key) {
          FlyCar.super.startEngine(key);
          OperateCar.super.startEngine(key);
      }
  }
  ```

  The name preceding `super` (in this example, `FlyCar` or `OperateCar`) must refer to a direct superinterface that defines or inherits a default for the invoked method. This form of method invocation is not restricted to differentiating between multiple implemented interfaces that contain default methods with the same signature. You can use the `super` keyword to invoke a default method in both classes and interfaces.

  Inherited instance methods from classes can override abstract interface methods. Consider the following interfaces and classes:

  ```java
  public interface Mammal {
      String identifyMyself();
  }
  public class Horse {
      public String identifyMyself() {
          return "I am a horse.";
      }
  }
  public class Mustang extends Horse implements Mammal {
      public static void main(String... args) {
          Mustang myApp = new Mustang();
          System.out.println(myApp.identifyMyself());
      }
  }
  ```

  The method `Mustang.identifyMyself` returns the string `I am a horse.` The class `Mustang` inherits the method `identifyMyself` from the class `Horse`, which overrides the abstract method of the same name in the interface `Mammal`.

  **Note**: Static methods in interfaces are never inherited.