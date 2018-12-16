package com.github.sasachichito.validator;

public interface ValidationNotificationHandler {
    public void handleError(String notificationMessage);

    public void handleError(String notification, Object object);

    public void handleInfo(String notificationMessage);

    public void handleInfo(String notification, Object object);

    public void handleWarning(String notificationMessage);

    public void handleWarning(String notification, Object object);
}
