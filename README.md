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

# Interfaces

- Interfaces are used for full abstraction.

- The variables in an interface are public, static and final by default.

- Interface is a reference type similar to a class, that contains only constants, method signatures, default methods, and static methods.

- Interfaces cannot be instantiated, they can only be implemented by classes or extended by other interfaces.

- Example:

  ```java
  public interface OperateCar {
  
     // constant declarations, if any
  
     // method signatures
     
     // An enum with values RIGHT, LEFT
     int turn(Direction direction,
              double radius,
              double startSpeed,
              double endSpeed);
     int changeLanes(Direction direction,
                     double startSpeed,
                     double endSpeed);
     int signalTurn(Direction direction,
                    boolean signalOn);
     int getRadarFront(double distanceToCar,
                       double speedOfCar);
     int getRadarRear(double distanceToCar,
                      double speedOfCar);
           ......
     // more method signatures
  }
  ```

- To use an interface, there must be a class that implements the interface, example:

  ```java
  public class OperateBMW760i implements OperateCar {
  
      // the OperateCar method signatures, with implementation --
      // for example:
      int signalTurn(Direction direction, boolean signalOn) {
         // code to turn BMW's LEFT turn indicator lights on
         // code to turn BMW's LEFT turn indicator lights off
         // code to turn BMW's RIGHT turn indicator lights on
         // code to turn BMW's RIGHT turn indicator lights off
      }
  
      // other members, as needed -- for example, helper classes not 
      // visible to clients of the interface
  }
  ```

- When a class implements an interface, it must provide a method body for each of the methods declared in the interface.

- Inheritance in interfaces: Example: 

  ```java
  interface Inf1{
     public void method1();
  }
  interface Inf2 extends Inf1 {
     public void method2();
  }
  public class Demo implements Inf2{
     /* Even though this class is only implementing the
      * interface Inf2, it has to implement all the methods 
      * of Inf1 as well because the interface Inf2 extends Inf1
      */
      public void method1(){
  	System.out.println("method1");
      }
      public void method2(){
  	System.out.println("method2");
      }
      public static void main(String args[]){
  	Inf2 obj = new Demo();
  	obj.method2();
      }
  }
  ```

- Interface cannot be declared as private, protected or transient.

- All the interface methods are by default **abstract and public**.

- Variables declared in interface are **public, static and final** by default.

- Interface variables must be initialized at the time of declaration otherwise compiler will throw an error.

  ```java
  interface Try
  {
        int x;//Compile-time error
  }
  ```

- Inside any implementation class, you cannot change the variables declared in interface because by default, they are public, static and final. 

- A class cannot implement two interfaces that have methods with same name but different return type.

  ```java
  interface A
  {
     public void aaa();
  }
  interface B
  {
     public int aaa();
  }
  
  class Central implements A,B
  {
  
     public void aaa() // error
     {
     }
     public int aaa() // error
     {
     }
     public static void main(String args[])
     {
  
     }
  }
  ```

- Interfaces are used to support multiple inheritance in Java

## Nested Interfaces

An interface which is declared inside another interface or class is called [nested](https://beginnersbook.com/2016/03/nested-or-inner-interfaces-in-java/) interface. They are also known as inner interface. For example Entry interface in collections framework is declared inside Map interface, that’s why we don’ use it directly, rather we use it like this: `Map.Entry`.

```java
interface Showable {  
  void show();  
  interface Message {  
    	void msg();  
	}  
}

class TestNestedInterface1 implements Showable.Message
{  
 	public void msg(){System.out.println("Hello nested interface");}  
  
 	public static void main(String args[]){  
  		Showable.Message message=new TestNestedInterface1();//upcasting here  
		message.msg();  
	}  
} 
```

- **Upcasting:** Upcasting is the [typecasting](https://www.geeksforgeeks.org/type-conversion-java-examples/) **of a child object to a parent object**. Upcasting can be done implicitly. Upcasting gives us the flexibility to access the parent class members but it is not possible to access all the child class members using this feature. Instead of all the members, we can access some specified members of the child class. For instance, we can access the overridden methods.
- **Downcasting:** Similarly, downcasting means the typecasting of a **parent object to a child object**. Downcasting cannot be implicitly.

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

- Final keyword can be used to prevent overriding



# Packages

- Group of related types are bundled into packages.
- **Definition:** A *package* is a grouping of related types providing access protection and name space management. Note that *types* refers to classes, interfaces, enumerations, and annotation types. Enumerations and annotation types are special kinds of classes and interfaces, respectively

## Creating a package

- To create a package, we name the package, and put a package statement with that name at top of every source file that contains its types.

- The package statement has to be the first line in the source files.

- If you put multiple types in a single source file, only one can be `public`, and it must have the same name as the source file. 

- Example:

  ```java
  //in the Draggable.java file
  package graphics;
  public interface Draggable {
      . . .
  }
  
  //in the Graphic.java file
  package graphics;
  public abstract class Graphic {
      . . .
  }
  
  //in the Circle.java file
  package graphics;
  public class Circle extends Graphic
      implements Draggable {
      . . .
  }
  
  //in the Rectangle.java file
  package graphics;
  public class Rectangle extends Graphic
      implements Draggable {
      . . .
  }
  
  //in the Point.java file
  package graphics;
  public class Point extends Graphic
      implements Draggable {
      . . .
  }
  
  //in the Line.java file
  package graphics;
  public class Line extends Graphic
      implements Draggable {
      . . .
  }
  ```

## Naming a package

- It is likely that many programmers will use same name for different types (classes and interfaces).

- Example: the ```Rectangle``` class in the above example is also present in the ```java.awt``` package, Java still allows the names of the classes to be same if they are in different packages.

- The fully qualified name of each `Rectangle` class includes the package name. That is, the fully qualified name of the `Rectangle` class in the `graphics` package is `graphics.Rectangle`, and the fully qualified name of the `Rectangle` class in the `java.awt` package is `java.awt.Rectangle`.

  ### Naming conventions

  - Package names are written in all lower case to avoid confusion with class names and interfaces.

  - Companies use their reserved domain name to begin their package names - ```com.example.mypackage```

  - Packages in java begin with ```java.``` or ```javax.```

  - The package name does not allow hyphen or other special characters

  - If package name begins with reserved keywords or digits or characters the convention is to add an underscore with the name:

    | Domain Name                   | Package Name Prefix           |
    | ----------------------------- | ----------------------------- |
    | `hyphenated-name.example.org` | `org.example.hyphenated_name` |
    | `example.int`                 | `int_.example`                |
    | `123name.example.com`         | `com.example._123name`        |

## Using package members

- The types that comprise a package are called package members

- To use a `public` package member from outside its package, you must do one of the following:

  - Refer to the member by its fully qualified name
  - Import the package member
  - Import the member's entire package

  ### Refer to the member by its fully qualified name

  - If we try to use a member from different package and that package has not been imported, we need to use the fully qualified name for it example:

    ```java
    graphics.Rectangle
    ```

  - This name can also be used to create an instance of ```graphics.Rectangle``` :

    ```java
    graphics.Rectangle myRect = new graphics.Rectangle();
    ```

  - This is ok for infrequent use.

  ### Importing a Package Member

  - To import a specific member, put an import statement at the beginning of file.

  - Example:

    ```java
    import graphics.Rectangle;
    
    // Now you can refer to the Rectangle class by its simple name.
    
    Rectangle myRectangle = new Rectangle();
    ```

  ### Importing an Entire package

  - To import all types contained in a package, we use (*) wildcard character

  - Example:

    ```java
    import graphics.*;
    
    // Now you can refer to any class or interface in the graphics package by its simple name.
    
    Circle myCircle = new Circle();
    Rectangle myRectangle = new Rectangle();
    ```

  - (*) cannot be used for subset of classes in a package, example:

    ```java
    // does not work
    import graphics.A*;
    ```

  - Public nested class of an enclosing class can be imported. Example: if the ```graphics.Rectangle``` class contained useful nested classes, such as `Rectangle.DoubleWide` and `Rectangle.Square`, you could import `Rectangle` and its nested classes by using the following *two* statements.

    ```java
    import graphics.Rectangle;
    
    // This will not import Rectangle
    import graphics.Rectangle.*;
    ```

  - Java automatically imports ```java.lang``` and current package (the package of the current file)

  ### Apparent Hierarchies of Packages

  - Packages might appear to be hierarchical but they are seldom not. Example Importing `java.awt.*` imports all of the types in the `java.awt` package, but it *does not import* `java.awt.color`, `java.awt.font`, or any other `java.awt.xxxx` packages. 

  - The `java.awt.color` package, the `java.awt.font` package, and other `java.awt.xxxx` packages are *not included* in the `java.awt` package.

  - For using both color and awt, we need to import both:

    ```java
    import java.awt.*;
    import java.awt.color.*;
    ```

  ### Name Ambiguities

  - If there are multiple packages with same types' names, it is recommended to use the fully qualified name Example:

    ```java
    graphics.Rectangle rect;
    ```

- A package can be created and later compiled using command line by the following command:

  ```bash
  javac -d directory javafilename
  ```



# Exception Handling

- **Definition:** An *exception* is an event, which occurs during the execution of a program, that disrupts the normal flow of the program's instructions.
- During an error, an object is created and handed to the runtime which contains info on type of exception, state of program etc.
- Creating an exception object and handing it to the system is called *throwing an exception*
- List of methods called to get to the method where the error occurred are known as the *call stack*
- <img src="https://docs.oracle.com/javase/tutorial/figures/essential/exceptions-callstack.gif" alt="The call stack showing three method calls, where the first method called has the exception handler." />

- The runtime system searches the call stack for a method that contains a block of code that can handle the exception. This block of code is called an *exception handler*. 
- ![The call stack showing three method calls, where the first method called has the exception handler.](https://docs.oracle.com/javase/tutorial/figures/essential/exceptions-errorOccurs.gif)
- The exception handler chosen is said to *catch the exception*

## Catch or Specify Requirement

- The code that might throw exceptions must be enclosed by wither of the following:
  - A `try` statement that catches the exception. The `try` must provide a handler for the exception, as described in [Catching and Handling Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/handling.html).
  - A method that specifies that it can throw the exception. The method must provide a `throws` clause that lists the exception, as described in [Specifying the Exceptions Thrown by a Method](https://docs.oracle.com/javase/tutorial/essential/exceptions/declaring.html).
- Code that fails to honor the Catch or Specify Requirement will not compile.

## Three Kinds of Exceptions

### Checked Exception

- These are exceptional conditions that a well-written application should anticipate and recover from.
- Checked exceptions *are subject* to the Catch or Specify Requirement. All exceptions are checked exceptions, except for those indicated by `Error`, `RuntimeException`, and their subclasses.

### Error

- These are exceptional conditions that are external to the application, and that the application usually cannot anticipate or recover from. 
- Errors *are not subject* to the Catch or Specify Requirement. Errors are those exceptions indicated by `Error` and its subclasses.

### Runtime Exception

- These are exceptional conditions that are internal to the application, and that the application usually cannot anticipate or recover from.
- These usually indicate programming bugs, such as logic errors or improper use of an API.
- Runtime exceptions *are not subject* to the Catch or Specify Requirement. Runtime exceptions are those indicated by `RuntimeException` and its subclasses.

- Errors and runtime exceptions are collectively known as *unchecked exceptions*.

## Catching and Handling Exceptions

- The three exception handlers are the `try`, `catch`, and `finally` blocks.

- Example

  ```java
  // Note: This class will not compile yet.
  import java.io.*;
  import java.util.List;
  import java.util.ArrayList;
  
  public class ListOfNumbers {
  
      private List<Integer> list;
      private static final int SIZE = 10;
  
      public ListOfNumbers () {
          list = new ArrayList<Integer>(SIZE);
          for (int i = 0; i < SIZE; i++) {
              list.add(new Integer(i));
          }
      }
  
      public void writeList() {
  	// The FileWriter constructor throws IOException, which must be caught.
          PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
  
          for (int i = 0; i < SIZE; i++) {
              // The get(int) method throws IndexOutOfBoundsException, which must be caught.
              out.println("Value at: " + i + " = " + list.get(i));
          }
          out.close();
      }
  }
  ```

  - If we try to compile this, an exception will be thrown by `FileWriter` constructor.
  - The two exceptions thrown here are `IOException` and `IndexOutOfBoundsException` .
  - The exception thrown by the constructor, `IOException`, is a checked exception, and the one thrown by the `get` method, `IndexOutOfBoundsException`, is an unchecked exception, thus the compiler only prints an error message about the exception thrown by `FileWriter` and not the `get` method

  

