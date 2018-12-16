package com.github.sasachichito.event;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DomainEventPublisherTest {

    @Test
    void setSubscribersSuccess() {

        DomainEventSubscriber subscriber = new DomainEventSubscriber() {
            @Override
            public void handleEvent(DomainEvent domainEvent) {}
        };

        DomainEventPublisher publisher = DomainEventPublisher.instance();
        publisher.setSubscriber(subscriber);

        assertTrue(publisher.hasSubscribers());
    }

    @Test
    void domainEventPublishSuccess() {

        DomainEventSubscriber subscriber1 = new DomainEventSubscriber() {
            @Override
            public void handleEvent(DomainEvent domainEvent) {
                domainEvent.version();
                domainEvent.occurredOn();
            }
        };

        DomainEventSubscriber subscriber2 = new DomainEventSubscriber() {
            @Override
            public void handleEvent(DomainEvent domainEvent) {
                domainEvent.version();
                domainEvent.occurredOn();
            }
        };


        DomainEvent mockEvent = mock(DomainEvent.class);
        when(mockEvent.version()).thenReturn(1);
        when(mockEvent.occurredOn()).thenReturn(LocalDateTime.of(2018, 12, 25, 21, 0, 0, 0));

        DomainEventPublisher publisher = DomainEventPublisher.instance();
        publisher
                .setSubscriber(subscriber1)
                .setSubscriber(subscriber2)
                .publish(mockEvent);

        verify(mockEvent, times(2)).version();
        verify(mockEvent, times(2)).occurredOn();
    }
}