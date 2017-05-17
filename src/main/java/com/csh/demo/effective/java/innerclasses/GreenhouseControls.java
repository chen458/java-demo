package com.csh.demo.effective.java.innerclasses;

import com.csh.demo.effective.java.innerclasses.controller.Controller;
import com.csh.demo.effective.java.innerclasses.controller.Event;

/**
 * @author: shenghong.chen
 * Date: 2017/2/27
 * time: 下午11:27
 */
public class GreenhouseControls extends Controller {
    private boolean light = false;

    public class  LighiOn extends Event {

        public LighiOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "Light is on";
        }
    }

    public class LightOff extends Event {

        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "Light is off";
        }
    }

    private boolean water = false;

    public class WaterOn extends Event {

        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "water is on";
        }
    }

    public class WaterOff extends Event {

        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = false;
        }

        @Override
        public String toString() {
            return "water is off";
        }
    }
}
