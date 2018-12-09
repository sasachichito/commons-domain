package com.github.sasachichito.event;

public interface DomainEventSubscriber {
    public void handleEvent(final DomainEvent domainEvent);
}