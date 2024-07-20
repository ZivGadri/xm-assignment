# xm-assignment
#### Testing project assignment on mobile and web platforms
The project consists of two modules - Web-Testing and Mobile-Testing\
Each module has its own TestNG xml file for running.\
The files found in _src/test/test-suite/_ respectively to each module.\

\
Disclosure -

As discussed in my first session with Vicky, my experience with mobile testing
was mainly using existing infrastructures of mobile cloud providers setups (Experitest and Perfecto).\
I was mostly running those environments, debugging, and contributing needed additions to it.\
Therefor, this was my first Appium infrastructure built solo 😊

I had to figure it all out from scratch, which was highly challenging in the given\
amount of time.\
I learn to set up my environment, and obviously learn to work with the tools need to extract
the elements.

### Mobile project

#### Sub-disclosure
As the time ran out, while I was encountering a technical issue with the Android studio, I could not complete the flow in time.
Meaning it should mainly run the general flow, but some things like scrolling to the last ingredient, assertions, and some general
code improvements, unfortunately could not be done.


### Prerequisites:
* Java 17 and up
* A running AVD
* Yummly app .apk file

#### What was created?
I chose to run the test over Android platform since I am using a Windows\
machine and the time schedule did not allow me to set up an environment\
to run on top of iOS platform.\
Nonetheless, The main infrastructure can support ios testing if the setup\
of the environment would allow that.\
Of course, there are modifications to be made, especially for the actual test,\
in order to run with iOS.

The mobile module consists the infrastructure for starting the Appium server\
and connect to the AVD that's running. It will install the app from the path\
specified in the _APK_APP_PATH_ found in Constants class.
The Yummly apk file was used locally, but unfortunately could not be pushed\
to the repository due to its size.\
Download link is in the resources section.

The actual test runs the flow provided with two exceptions
1. There are two tasks that could not be done due to application updates\
that probably changed its UI (sections 3, 10, 11 and 12)
2. As mentioned in the disclosure, unresolved technical issues left me no\
time to finish with the assertions, and some other operations I wanted to insert

********************************************************************************
### Web project

### Prerequisites:
* Java 17 and up

#### What was created?
This web responsive test can run on top of three different browsers (chrome, firefox and edge)\
specified from the BrowserTypes class.\
It runs the flow, as requested, using three different screen resolutions by using\
TestNG *@Factory* annotation:\
1. it fetches the running machine max resolution and instantiate the\
*maxWidth* and *maxHeight* variables.
2. (1024, 768)
3. (800, 600) 

The test runs three times using different resolution for each test run.
Different dummy assertions are made along the way.