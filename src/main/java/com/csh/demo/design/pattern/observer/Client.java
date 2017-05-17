package com.csh.demo.design.pattern.observer;

/**
 * @author: shenghong.chen
 * Date: 16/7/31
 * time: 下午4:16
 */
public class Client {
    public static void main(String[] args) {
        Subject boss = new BossSubject();

        Observer stock = new StockObserver("看股票的同事", boss);

        Observer nba = new NBAObserver("看NBA的同事", boss);

        boss.attach(stock);
        boss.attach(nba);

        boss.Notify();

    }
}
