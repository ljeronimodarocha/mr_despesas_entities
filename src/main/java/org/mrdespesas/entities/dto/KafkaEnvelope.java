package org.mrdespesas.entities.dto;

public class KafkaEnvelope<T> {
    private T payload;

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}