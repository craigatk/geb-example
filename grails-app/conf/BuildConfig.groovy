grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
        // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
        //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

        // configure settings for the test-app JVM, uses the daemon by default
        test: false,
        // configure settings for the run-app JVM
        run: false,
        // configure settings for the run-war JVM
        war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
        // configure settings for the Console UI JVM
        console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

def gebVersion = "0.13.1"
def ghostDriverVersion = "1.2.0"
def webdriverVersion = "2.52.0"

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
    }

    dependencies {
        test "org.gebish:geb-junit3:${gebVersion}"
        test "org.gebish:geb-junit4:${gebVersion}"
        test "org.gebish:geb-spock:${gebVersion}"

        test "org.seleniumhq.selenium:selenium-support:${webdriverVersion}"
        test "org.seleniumhq.selenium:selenium-chrome-driver:${webdriverVersion}"
        test "org.seleniumhq.selenium:selenium-firefox-driver:${webdriverVersion}"
        test "org.seleniumhq.selenium:selenium-ie-driver:${webdriverVersion}"

        /*test("com.github.detro:phantomjsdriver:${ghostDriverVersion}") {
            transitive = false
        }*/

        // Patched version of Ghostdriver until this issue is fixed https://github.com/detro/ghostdriver/issues/397
        test("com.codeborne:phantomjsdriver:1.2.1") {
            transitive = false
        }

        test "org.grails:grails-datastore-test-support:1.0.2-grails-2.4"
    }

    plugins {
        // plugins for the build system only
        build ":tomcat:7.0.55"

        // plugins for the compile step
        compile ":scaffolding:2.1.2"
        compile ':cache:1.1.8'

        // plugins needed at runtime but not for compilation
        runtime ":hibernate4:4.3.6.1" // or ":hibernate:3.6.10.18"
        runtime ":database-migration:1.4.0"

        compile ":asset-pipeline:2.3.8"

        test ":remote-control:1.5"
        test ":geb:${gebVersion}"
    }
}
