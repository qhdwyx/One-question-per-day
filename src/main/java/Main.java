import java.util.concurrent.ExecutionException;

/**
 * @Author: WangYunxuan
 * @Date: 2021/11/2 19:06
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Monitor(() -> new MyBusiness().getFunction()).setTimeout(2000).start();
    }
}
