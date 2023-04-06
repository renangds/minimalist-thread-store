import org.example.thread.ThreadStoreSupplier;

import java.util.function.Supplier;

public class ThreadWorker<T> extends Thread {

    public Supplier<T> method;

    public ThreadWorker(final ThreadStoreSupplier<T> threadStoreSupplier) {
        this.method = threadStoreSupplier;
    }

    public void sendMessage(T message) {
        // pass
    }

    public T requestMessage() {
        return method.get();
    }
}
