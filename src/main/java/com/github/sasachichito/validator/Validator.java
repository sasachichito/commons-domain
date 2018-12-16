package com.github.sasachichito.validator;

public abstract class Validator {
    private ValidationNotificationHandler notificationHandler;

    public Validator(ValidationNotificationHandler handler) {
        this.notificationHandler = handler;
    }

    public abstract void validate();
}
