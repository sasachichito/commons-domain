package com.github.sasachichito.validator;

/**
 * The notificationHandler of validation.
 */
public interface ValidationNotificationHandler {

    /**
     * NullObject of this.
     */
    public static final ValidationNotificationHandler NOT_HANDLE = new ValidationNotificationHandler() {
        @Override
        public void handleError(String notificationMessage) {}

        @Override
        public void handleError(String notification, Object object) {}

        @Override
        public void handleInfo(String notificationMessage) {}

        @Override
        public void handleInfo(String notification, Object object) {}

        @Override
        public void handleWarning(String notificationMessage) {}

        @Override
        public void handleWarning(String notification, Object object) {}
    };

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
