package com.github.sasachichito.event;

import java.time.LocalDateTime;

/**
 * The representation of event in the domain.
 */
public interface DomainEvent {

    /**
     * Gets this event version.
     *
     * @return the version
     */
    public Integer version();

    /**
     * Gets datetime when this event occurred.
     *
     * @return the event occurrence time
     */
    public LocalDateTime occurredOn();
}