package charactor;

/**
 * @author hello word
 * @desc 作用描述
 * @date 2021/7/2
 */
public class TestGiantDragon {
    public static void main(String[] args) {
        //GiantDragon g1 = new GiantDragon();
        GiantDragon g2 = GiantDragon.getInstance();
        GiantDragon g3 = GiantDragon.getInstance();

        System.out.println(g2 == g3);
    }
}
