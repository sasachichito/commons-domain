package com.github.sasachichito.event;

import java.util.ArrayList;
import java.util.List;

/**
 * The publisher of event that occurred in this domain.
 */
public class DomainEventPublisher {

    /**
     * The ThreadLocal instance of this.
     */
    private static final ThreadLocal<DomainEventPublisher> instance = new ThreadLocal<DomainEventPublisher>() {
        @Override
        protected DomainEventPublisher initialValue() {
            return new DomainEventPublisher();
        }
    };

    /**
     * The subscribers of this publisher.
     */
    private List<DomainEventSubscriber> subscribers = new ArrayList<>();

    /**
     * Gets ThreadLocal instance of this.
     *
     * @return this instance, not null
     */
    public static DomainEventPublisher instance() {
        return instance.get();
    }

    /**
     * Notifies event to subscribers.
     *
     * @param domainEvent the domain event, not null
     */
    public void publish(DomainEvent domainEvent) {

        if (domainEvent == null) {
            return;
        }

        if (!this.hasSubscribers()) {
            return;
        }

        for (DomainEventSubscriber subscriber : this.subscribers) {
            subscriber.handleEvent(domainEvent);
        }
    }

    /**
     * Checks if this publisher has subscriber.
     *
     * @return true if this publisher has subscriber
     */
    public boolean hasSubscribers() {
        return !(subscribers == null || subscribers.isEmpty());
    }

    /**
     * Appends the subscriber to the end of this subscribers list.
     *
     * @param domainEventSubscriber the subscriber, not null
     * @return publisher after appended subscriber, not null
     */
    public DomainEventPublisher setSubscriber(DomainEventSubscriber domainEventSubscriber) {
        this.subscribers.add(domainEventSubscriber);
        return this;
    }
}