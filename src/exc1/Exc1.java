/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exc1;

/**
 *
 * @author Bancho
 */
public class Exc1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());
        
        ByteCalculator b1 = new ByteCalculator("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
        ByteCalculator b2 = new ByteCalculator("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png");
        ByteCalculator b3 = new ByteCalculator("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");
        
        System.out.println("Staring sequential.");
        long start = System.nanoTime();
        b1.run();
        b2.run();
        b3.run();
        b1.join();
        b2.join();
        b3.join();
        long end = System.nanoTime();
        double time1 = (end - start) / 1000000000.0;
        int result1 = 0;
        result1 += b1.getSum();
        result1 += b2.getSum();
        result1 += b3.getSum();
        System.out.println("Done sequential. Time elapsed: " + time1 + " seconds");
        System.out.println("Result: " + result1);
        System.out.println("");
        
        b1.resetSum();
        b2.resetSum();
        b3.resetSum();
        
        System.out.println("Staring parallel.");
        start = System.nanoTime();
        b1.run();
        b2.run();
        b3.run();
        b1.join();
        b2.join();
        b3.join();
        end = System.nanoTime();
        double time2 = (end - start) / 1000000000.0;
        int result2 = 0;
        result2 += b1.getSum();
        result2 += b2.getSum();
        result2 += b3.getSum();
        System.out.println("Done parallel. Time elapsed: " + time2 + " seconds");
        System.out.println("Result: " + result2);
        System.out.println("");
        
        System.out.println("Parallel was faster by " + (time1 - time2) + " seconds");
        System.out.println("The difference in result between the two is: " + (result1 - result2));
    }
    
}
