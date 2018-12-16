package com.github.sasachichito.validator;

/**
 * The validator of specific-domain.
 */
public abstract class Validator {

    /**
     * The notificationHandler of this validation result.
     */
    private ValidationNotificationHandler notificationHandler;

    /**
     * Constructor.
     *
     * @param handler the notificationHandler, not null
     */
    public Validator(ValidationNotificationHandler handler) {
        this.notificationHandler = handler;
    }

    /**
     * Validates domain object.
     */
    public abstract void validate();
}
