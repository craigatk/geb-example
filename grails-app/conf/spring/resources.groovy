import geb.example.mock.PatentServiceMock
import grails.util.Environment

// Place your Spring DSL code here
beans = {
    if (Environment.current == Environment.TEST) {
        // Override the PatentService with our mock version when running tests
        patentService(PatentServiceMock)
    }
}
