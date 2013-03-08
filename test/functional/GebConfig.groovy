/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/


import org.apache.commons.lang.SystemUtils
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver

// Use Firefox as the default driver
// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
driver = { new FirefoxDriver() }

// Automatic driver download code adapted from
// http://fbflex.wordpress.com/2013/01/06/geb-quickie-automatically-download-drivers-for-chrome-and-internet-explorer/
environments {

  // run as “grails -Dgeb.env=chrome test-app”
  // See: http://code.google.com/p/selenium/wiki/ChromeDriver
  chrome {
    String chromeDriverVersion = "26.0.1383.0"

    String chromeDriverZipFileName
    String chromeDriverExecFileName

    if (SystemUtils.IS_OS_WINDOWS) {
      chromeDriverZipFileName = "chromedriver_win_${chromeDriverVersion}.zip"
      chromeDriverExecFileName = "chromedriver.exe"
    } else if (SystemUtils.IS_OS_MAC_OSX) {
      chromeDriverZipFileName = "chromedriver_mac_${chromeDriverVersion}.zip"
      chromeDriverExecFileName = "chromedriver"
    } else if (SystemUtils.IS_OS_LINUX) {
      chromeDriverZipFileName = "chromedriver_linux32_${chromeDriverVersion}.zip"
      chromeDriverExecFileName = "chromedriver"
    } else {
      throw new RuntimeException("Unknown operating system [${SystemUtils.OS_NAME}]")
    }

    String chromeDriverDownloadFullPath = "https://chromedriver.googlecode.com/files/${chromeDriverZipFileName}"

    File chromeDriverLocalFile = downloadDriver(chromeDriverDownloadFullPath, chromeDriverExecFileName)

    System.setProperty('webdriver.chrome.driver', chromeDriverLocalFile.absolutePath)
    driver = { new ChromeDriver() }
  }
}

private File downloadDriver(String driverDownloadFullPath, String driverFileName) {
  File destinationDirectory = new File("target/webdriver")
  if (!destinationDirectory.exists()) {
    destinationDirectory.mkdirs()
  }

  File driverFile = new File(destinationDirectory, driverFileName)

  String localZipPath = 'target/driver.zip'

  if (!driverFile.exists()) {
    def ant = new AntBuilder()
    ant.get(src: driverDownloadFullPath, dest: localZipPath)
    ant.unzip(src: localZipPath, dest: destinationDirectory)
    ant.delete(file: localZipPath)
    ant.chmod(file: driverFile, perm: '700')
  }

  return driverFile
}