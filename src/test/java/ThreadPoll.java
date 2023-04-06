import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreadPoll {

    private List<ThreadWorker> threads;

    public ThreadPoll() {
        this.threads = new ArrayList<>();
    }

    public void add(ThreadWorker ...threads) {
        this.threads.addAll(Arrays.asList(threads));
    }

    public List<Object> requestMessage() {
        return threads.stream()
                .map(ThreadWorker::requestMessage)
                .collect(Collectors.toList());
    }
}
