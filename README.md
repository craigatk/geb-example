# Geb Examples

Contains sample Geb functional tests for a Grails application. There are tests written in both JUnit and Spock.

## Running tests in Firefox

To execute all the tests in Firefox, run:
```
grails test-app functional:
```

## Running tests in Chrome

Tto execute all the tests in Chrome, run:
```
grails -Dgeb.env=chrome test-app functional:
```

## Running tests in Internet Explorer

And to execute all the tests in Internet Explorer, run:
```
grails -Dgeb.env=ie test-app functional:
```

When running tests in IE for the first time you may see an error like this on test startup:

```
Caused by: org.openqa.selenium.remote.SessionNotFoundException: Unexpected error launching Internet Explorer. Protected Mode settings are not the same for all zones. Enable Protected Mode must be set to the same value (enabled or disabled) for all zones. (WARNING: The server did not provide any stacktrace information)
```

To resolve this error, open IE, click on the settings gear icon, click 'Internet options', go to the 'Security' tab, and either check or uncheck the 'Enable Protected Mode' checkbox in all four zones (Internet, Local Intranet, Trusted Sites, and Restricted Sites).

## Running tests in Phantom JS

### Ghostdriver won't work until this issue is fixed https://github.com/detro/ghostdriver/issues/397

Finally, to execute all the tests in Phantom JS, run:
```
grails -Dgeb.env=phantomjs test-app functional:
```

## Browser config

See ```test/functional/GebConfig.groovy``` for details on how the different browsers are configured. GebConfig.groovy also has the code to automatically download the Chrome, IE, and PhantomJS driver libraries.