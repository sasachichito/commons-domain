package com.github.sasachichito.event;

/**
 * The subscriber of event that occurred in this domain.
 */
public interface DomainEventSubscriber {

    /**
     * Handles event.
     *
     * @param domainEvent the event, not null
     */
    public void handleEvent(final DomainEvent domainEvent);
}