import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author: WangYunxuan
 * @Date: 2021/11/2 19:09
 */
public class Monitor implements Monitorable{
    private int timeout = 5000;
    private Monitorable target;

    public Monitor(Monitorable o) {
        this.target = o;
    }

    public Monitor() {

    }

    public void start() throws InterruptedException, ExecutionException {
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
            if(target != null)
                target.run();
            else run();
            return 1;
        });
        try {
            cf.get(timeout, TimeUnit.MILLISECONDS);
        }catch (TimeoutException e){
            cf.cancel(true);
        }
    }

    public Monitor setTimeout(int timeout){
        this.timeout = timeout;
        return this;
    }

    public void run(){

    }

}
