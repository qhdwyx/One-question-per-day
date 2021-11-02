/**
 * @Author: WangYunxuan
 * @Date: 2021/11/2 19:07
 */
public class MyBusiness {
    public int getFunction(){
        try {
            for (int i = 0; i < 1000; i++) {
                Thread.sleep(1000);
                System.out.println(i);
            }
        }catch (Exception ignored){}
        return 100;
    }
}
