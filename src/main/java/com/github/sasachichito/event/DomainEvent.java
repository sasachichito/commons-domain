package com.github.sasachichito.event;

import java.time.LocalDateTime;

public interface DomainEvent {
    public Integer version();
    public LocalDateTime occurredOn();
}