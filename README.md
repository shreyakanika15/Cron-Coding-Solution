# Deliveroo Coding Test Solution

#### A Command line application or script which parses a cron string and expands each field to show the times at which it will run.

#### To consider standard cron format with five time fields(minute, hour, day of month, month, and day of week) and a command.

### Requirements
  - Java 11
  
### Steps to run the program

  - Build the code to have the executable jar
    ```
    $ mvn clean package
    ```
  - Run the program
    ```
    $ java -jar deliveroo-test-1.0-SNAPSHOT.jar {String_to_be_tested}
    EX: java -jar deliveroo-test-1.0-SNAPSHOT.jar ＂*/15 0 1,15 * 1-5 /usr/bin/find＂
    ```  
  - Note : Input will be on a single line
    
    

