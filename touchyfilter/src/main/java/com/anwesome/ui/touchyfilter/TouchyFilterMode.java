package com.anwesome.ui.touchyfilter;

/**
 * Created by anweshmishra on 17/01/17.
 */
public enum TouchyFilterMode {
    GREEN(0),RED(1),BLUE(2);
    private int mode;
    TouchyFilterMode(int mode) {
        this.mode = mode;
    }
    public int getMode() {
        return mode;
    }
    public TouchyFilterMode getTouchyMode(int mode) {
        for(TouchyFilterMode touchyFilterMode:TouchyFilterMode.values()) {
            if(mode == touchyFilterMode.getMode()) {
                return touchyFilterMode;
            }
        }
        return null;
    }
}
