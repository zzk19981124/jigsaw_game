package lol;

import property.Item;

/**
 * @author hello word
 * @desc 护甲类
 * @date 2021/7/1
 */
public class Armor extends Item {
    private int ac; //护甲登记

    public static void main(String[] args) {
        Armor chain_mail =new Armor();
        chain_mail.name = "锁子甲";
        chain_mail.price = 500;
        chain_mail.ac = 40;

        Armor clothArmor = new Armor();
        clothArmor.name = "布甲";
        clothArmor.price = 300;
        clothArmor.ac = 15;

        System.out.println("物品名称："+ chain_mail.name+"，物品价格："+ chain_mail.price+",护甲等级："+chain_mail.ac);
        System.out.println("物品名称："+ clothArmor.name+"，物品价格："+ clothArmor.price+",护甲等级："+clothArmor.ac);
    }
}
