/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myjava;

import java.util.GregorianCalendar;

/**
 *
 * @author Alexander
 */
public class BrowserData {
    private int countsBrowser;
    private GregorianCalendar lastTime;
    
    public BrowserData(int countsBrowser, GregorianCalendar lastTime){
       this.countsBrowser = countsBrowser;
       this.lastTime = lastTime;
    }

    public int getCountsBrowser() {
        return countsBrowser;
    }

    public GregorianCalendar getLastTime() {
        return lastTime;
    }
    
}
