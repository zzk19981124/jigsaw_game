package lol;

/**
 * @author hello word
 * @desc 英雄类
 * @date 2021/7/1
 */
public class Hero {
    String name;
    float hp; //血量
    float armor; //护甲
    int moveSpeed; //移动速度
    int xp;
    private Hero(){
    }
    private static Hero instance;
    private static Hero getInstance(){
        if (instance == null){
            instance = new Hero();
        }
        return instance;
    }
}
