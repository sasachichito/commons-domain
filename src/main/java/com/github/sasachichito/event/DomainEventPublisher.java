package com.github.sasachichito.event;

import java.util.ArrayList;
import java.util.List;

public class DomainEventPublisher {

    private static final ThreadLocal<DomainEventPublisher> instance = new ThreadLocal<DomainEventPublisher>() {
        @Override
        protected DomainEventPublisher initialValue() {
            return new DomainEventPublisher();
        }
    };

    private List<DomainEventSubscriber> subscribers = new ArrayList<>();

    public static DomainEventPublisher instance() {
        return instance.get();
    }

    public void publish(DomainEvent domainEvent) {

        if (!this.hasSubscribers()) {
            return;
        }

        for (DomainEventSubscriber subscriber : this.subscribers) {
            subscriber.handleEvent(domainEvent);
        }
    }

    public boolean hasSubscribers() {
        return !(subscribers == null || subscribers.isEmpty());
    }

    public DomainEventPublisher setSubscriber(DomainEventSubscriber domainEventSubscriber) {
        this.subscribers.add(domainEventSubscriber);
        return this;
    }
}