package geb.example.mock

import geb.example.Idea
import geb.example.PatentService

class PatentServiceMock extends PatentService {
    List<Idea> ideasSentToPatentOffice = []

    @Override
    def sendToPatentOffice(Idea idea) {
        ideasSentToPatentOffice << idea
    }
}
