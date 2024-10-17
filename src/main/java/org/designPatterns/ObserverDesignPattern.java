package org.designPatterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverDesignPattern {

    public static void main(String[] args) {
        SubjectClass subjectClass = new SubjectClass();
        SmsObserver smsObserver = new SmsObserver(subjectClass);
        EmailObserver emailObserver = new EmailObserver(subjectClass);
        subjectClass.update("Hello");
    }


}



class SubjectClass {
    private List<Observer> observerList;

    public SubjectClass() {
        this.observerList = new ArrayList<>();
    }

    public void addObservers (Observer observer) {
        this.observerList.add(observer);
    }

    public void update(String message) {
        this.notifyObservers(message);
    }

    private void notifyObservers(String message) {
        for (Observer observer: observerList) {
            observer.update(message);
        }
    }
}


interface Observer {
    public void update(String message);
}

class SmsObserver implements Observer {
    private SubjectClass subjectClass;

    public SmsObserver(SubjectClass subjectClass) {
        this.subjectClass = subjectClass;
        this.subjectClass.addObservers(this);
    }


    @Override
    public void update(String message) {
        System.out.println("Printing from SMS observer. Got a message from the subject: " + message);
    }
}

class EmailObserver implements Observer {
    private SubjectClass subjectClass;

    public EmailObserver(SubjectClass subjectClass) {
        this.subjectClass = subjectClass;
        this.subjectClass.addObservers(this);
    }

    @Override
    public void update(String message) {
        System.out.println("Printing from email observer. Got a message from the subject: " + message);
    }
}