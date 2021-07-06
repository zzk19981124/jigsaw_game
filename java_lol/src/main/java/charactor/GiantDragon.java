package charactor;

/**
 * @author hello word
 * @desc 大龙类
 *          单例模式
 * @date 2021/7/2
 */
public class GiantDragon {
    private GiantDragon(){
    }
    private static GiantDragon instance = new GiantDragon();
    public static GiantDragon getInstance(){
        return instance;
    }
}
