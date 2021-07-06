package property;

/**
 * @author hello word
 * @desc 作用描述
 * @date 2021/7/2
 */
public class MagicPotion extends Item{
    @Override
    public void effect() {
        System.out.println("使用蓝瓶后，恢复魔力");
    }
}
