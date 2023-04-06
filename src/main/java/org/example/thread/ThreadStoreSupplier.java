package org.example.thread;

import java.util.AbstractMap;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class ThreadStoreSupplier<T> implements Supplier<T> {

    private static final long BASE_VALUE = 0x11111L;

    private static final AtomicReference<AbstractMap<Long, Object>> dataStore =
            new AtomicReference<>(new ConcurrentHashMap<>());

    private static final AtomicLong atomicLong = new AtomicLong(BASE_VALUE);

    private Long currentThreadValue;

    public ThreadStoreSupplier(final T data) {
        dataStore.get().put(retrieveHashCode(), data);
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get() {
        return (T) dataStore.get().get(retrieveCurrentValue());
    }

    private long retrieveHashCode() {
        currentThreadValue = atomicLong.getAndUpdate(this::retrieveKey);
        return retrieveCurrentValue();
    }

    private long retrieveKey(long prev) {
        return Objects.hash(Thread.currentThread()) + prev / 2;
    }

    public long retrieveCurrentValue() {
        return currentThreadValue;
    }
}
