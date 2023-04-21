import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;

public class ObjectPool <T extends Poolable> {

    private BlockingQueue<T> availablePool;

    public ObjectPool(Supplier<T> creator, int count) {
        availablePool = new LinkedBlockingQueue<>();
        for (int i = 0; i < count; i++) {
            availablePool.offer(creator.get());
        }
    }

    public T get() {
        try {
            // you can make decision here if pool is empty:
            // 1-create new object
            // 2-wait until release by external resource (you are limit to create new object)
            // we are simply going to wait until some object becomes available.
            return availablePool.take();
        } catch (InterruptedException ex) {
            System.err.println("take() was interrupted!");
        }
        return null;
    }

    public void release(T obj) {
        obj.reset();
        try {
            availablePool.put(obj);
        } catch (InterruptedException e) {
            System.err.println("put() was interrupted!");
        }
    }
}
