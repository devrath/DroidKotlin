# DroidKotlin
Demo of concepts in kotlin

![kotlin](https://img.shields.io/badge/Kotlin-language-blue)
![coroutines](https://img.shields.io/badge/Coroutines-Tool-orange)

## Project has implementation of the concepts below

- [x]  Exception handeling in Co-Routine
- [x]  Cancelation handeling in Co-Routine
- [x]  Object class in kotlin
- [x]  Companion object in kotlin

### Exception Handeling: 
We have used 2 jobs, Job1 executes in 1 second and Job2 executes in 3 seconds. Now we throw an exception in Job1.

```
com.kotlin.demo D/ExceptionDemo: Before parent Co routine
com.kotlin.demo D/ExceptionDemo: After parent Co routine
com.kotlin.demo D/ExceptionDemo: Error getting Job-2: Parent job is Cancelling
com.kotlin.demo D/ExceptionDemo: Error getting Job-1: User threw a exception
com.kotlin.demo D/ExceptionDemo: Parent job failed: User threw a exception
```
*observation:* Here anything after Job1 is cancelled, Suppose we had another job prior to this Job0, then Job0 would have been successful. Now in our case, exception is thrown in Job2 and Job2 wont be successful. Exception will be thrown in Job1 indicating the exception. Finally the parent is not successfull and the error is propogated to parent and which throw in Job1, also thus parent throws exception.


### Cancelation Handeling: 
We have used 2 jobs, Job1 executes in 1 second and Job2 executes in 3 seconds. Now we cancel in Job1.

```
com.kotlin.demo D/CancelDemo: Before parent Co routine
com.kotlin.demo D/CancelDemo: After parent Co routine
com.kotlin.demo D/CancelDemo: Error getting Job-1: User cancelled from JOB1
com.kotlin.demo D/CancelDemo: Job-2 is Success
com.kotlin.demo D/CancelDemo: Parent job is Success
```
*observation:* Here we will get a error in Job1, Then Job2 is successful. finally the Parent Job is is successful

### Object class in kotlin: 

```
com.kotlin.demo I/System.out: Value of counter: 0
com.kotlin.demo I/System.out: Value of counter: 1
com.kotlin.demo I/System.out: Value of counter: 2
com.kotlin.demo I/System.out: Value of counter: 3
```
*observation:* We can clearly see that the init block is executed only once no matter how many times we use singleton


### Companion object class in kotlin: 

```
com.kotlin.demo I/System.out: Demo value when class loaded is: 50
com.kotlin.demo I/System.out: Current value is: 1
com.kotlin.demo I/System.out: Current value is: 1
com.kotlin.demo I/System.out: Current value is: 1
com.kotlin.demo I/System.out: Current value is: 2
```
*observation:* Companion objects are similar to Object class in kotlin but they are used inside the class and are loaded once the class is loaded





