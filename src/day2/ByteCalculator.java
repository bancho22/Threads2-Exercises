/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *
 * @author Bancho
 */
public class ByteCalculator extends Thread {

    private String url;
    private int sum;

    public ByteCalculator(String url) {
        this.url = url;
        sum = 0;
    }

    @Override
    public void run() {
        byte[] byteArr = getBytesFromUrl(url);
        sum = 0;
        for (byte b : byteArr) {
            sum += b;
        }
    }

    public int getSum() {
        return sum;
    }
    
    public void resetSum(){
        sum = 0;
    }

    protected byte[] getBytesFromUrl(String url) {
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        try {
            InputStream is = new URL(url).openStream();
            byte[] bytebuff = new byte[4096];
            int read;
            while ((read = is.read(bytebuff)) > 0) {
                bis.write(bytebuff, 0, read);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return bis.toByteArray();

    }
}
