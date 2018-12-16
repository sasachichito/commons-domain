package com.github.sasachichito.validator;

/**
 * The notificationHandler of validation.
 */
public interface ValidationNotificationHandler {

    /**
     * Handles validation error.
     *
     * @param notificationMessage the notification message, not null, not empty
     */
    public void handleError(String notificationMessage);

    /**
     * Handles validation error.
     *
     * @param notification the notification message, not null, not empty
     * @param object target domain object, not null
     */
    public void handleError(String notification, Object object);

    /**
     * Handles validation info.
     *
     * @param notificationMessage the notification message, not null, not empty
     */
    public void handleInfo(String notificationMessage);

    /**
     * Handles validation info.
     *
     * @param notification the notification message, not null, not empty
     * @param object target domain object, not null
     */
    public void handleInfo(String notification, Object object);

    /**
     * Handles validation warning.
     *
     * @param notificationMessage the notification message, not null, not empty
     */
    public void handleWarning(String notificationMessage);

    /**
     * Handles validation warning.
     *
     * @param notification the notification message, not null, not empty
     * @param object target domain object, not null
     */
    public void handleWarning(String notification, Object object);
}
