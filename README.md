
# performance_atf

This project is an automation framework for functional testing of the OrangeHRM site:

-


## Content

1. [Introduction](#introduction)
2. [How to Set Up the framework](#setup)
3. [Configuration](#configuration)
4. [How to run tests](#howToRun)
    1. [From IDE](#ide)
       1. [Test evidences](#test-evidences)
    2. [From Jenkins](#jenkins)
5. [Framework Architecture](#architecture)

## How to Set Up the framework
> **Prerequisites**
> <details>
> <summary>Install JDK and setup JAVA_HOME</summary>
>
> 1. Download [Java SE Development Kit](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html?printOnly=1)
> 2. Click on the radio button next to Accept License Agreement
> 3. Download the 64-bit installer <br/>
> 4. Run the installer and follow the wizard steps
> 5. Setup JAVA_HOME. Click on the search button. Then type **environment**
> 6. Click on the **Edit environment variables for your account** <br/>
     > ![edit variables](https://downlinko.com/assets/images/posts/development/windows-search-env.png "edit variables")
> 7. Click on **New…** <br/>
     > ![environment variables](https://downlinko.com/assets/images/posts/development/windows-account-environment-variables-new.png "environment variables")
> 8. Enter **JAVA_HOME** as variable name. Enter the java installation directory as variable value. Click **OK**. <br/>
     > ![JAVA_HOME var](https://downlinko.com/assets/images/posts/development/jdk/jdk-8-home-variable.png "JAVA_HOME var")
> 9. Configure the PATH environment variable. Select the **Path** variable. Click on **Edit…** <br/>
     > ![edit path](https://downlinko.com/assets/images/posts/development/jdk/jdk-8-edit-path-variable.png "edit path")
> 10. Click on **New** and type **%JAVA_HOME%\bin** as shown below. Click **OK**. <br/>
      > ![new env variable](https://downlinko.com/assets/images/posts/development/jdk/jdk-edit-path-variable-add-java-home.png "new env variable")
>
> **Verification**
> 1. Click on the search button. Then type **cmd**
> 2. Click on the Command Prompt shortcut. <br/>
     > ![windows cmd](https://downlinko.com/assets/images/posts/development/windows-search-cmd.png "windows cmd")
> 3. Type **java -version** and press ENTER. The above command prints the installed JDK version:
     >
>   ```
>   C:\Users\janedoe>java -version
>   java version "1.8.0_211"
>   Java(TM) SE Runtime Environment (build 1.8.0_211-b12)
>   Java HotSpot(TM) 64-Bit Server VM (build 25.211-b12, mixed mode)
>   ```
>
> The JDK is successfully installed!
>
> </details>
>
