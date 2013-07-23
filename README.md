Geb Examples - Gr8Conf US 2013
===========

Contains sample Geb functional tests for a Grails application. There are tests written in both JUnit and Spock.

To execute all the tests in Firefox, run:
```
grails test-app functional:
```

Or to execute all the tests in Chrome, run:
```
grails -Dgeb.env=chrome test-app functional:
```

And to execute all the tests in Internet Explorer, run:
```
grails -Dgeb.env=ie test-app functional:
```

Finally, to execute all the tests in Phantom JS, run:
```
grails -Dgeb.env=phantomjs test-app functional:
```

See ```test/functional/GebConfig.groovy``` for details on how the different browsers are configured. GebConfig.groovy also has the code to automatically download the Chrome, IE, and PhantomJS driver libraries.