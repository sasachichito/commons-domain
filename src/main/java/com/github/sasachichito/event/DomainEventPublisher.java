package com.github.sasachichito.event;

import java.util.ArrayList;
import java.util.List;

public class DomainEventPublisher {

    private List<DomainEventSubscriber> subscribers = new ArrayList<>();

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

    public DomainEventPublisher setSubscribers(DomainEventSubscriber domainEventSubscriber) {
        this.subscribers.add(domainEventSubscriber);
        return this;
    }
}