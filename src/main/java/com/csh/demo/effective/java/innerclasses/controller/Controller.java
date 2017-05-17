package com.csh.demo.effective.java.innerclasses.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: shenghong.chen
 * Date: 2017/2/26
 * time: 下午5:37
 */
public class Controller {
    private List<Event> eventList = new ArrayList<Event>();
    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run(){
        while (eventList.size() > 0)
            for (Event e : new ArrayList<Event>(eventList)) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
    }
}