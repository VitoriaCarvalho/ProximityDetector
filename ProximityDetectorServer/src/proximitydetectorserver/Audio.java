/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proximitydetectorserver;

import java.io.File; 
import java.io.IOException; 
import java.util.Scanner; 
  
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 

/**
 *
 * @author vitoria
 */
public class Audio {
    
    // to store current position 
    Long currentFrame; 
    Clip clip; 
      
    // current status of clip 
    String status; 
      
    AudioInputStream audioInputStream; 
    static String filePath; 
  
    // constructor to initialize streams and clip 
    public Audio() 
        throws UnsupportedAudioFileException, 
        IOException, LineUnavailableException  
    { 
        // create AudioInputStream object
        filePath = "/home/vitoria/git/ProximityDetector/danger-alarm-23793.wav";
        audioInputStream =  
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile()); 
          
        // create clip reference 
        clip = AudioSystem.getClip();
        
        // open audioInputStream to the clip 
        clip.open(audioInputStream); 
          
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
    } 
  
    /*public static void main(String[] args)  
    { 
        try
        { 
            filePath = "/home/vitoria/Downloads/1.wav"; 
            Audio audioPlayer =  new Audio(); 
              
            audioPlayer.play(); 
            Scanner sc = new Scanner(System.in);
            
            while (true) 
            { 
                System.out.println("1. pause"); 
                System.out.println("2. resume"); 
                System.out.println("3. restart"); 
                System.out.println("4. stop"); 
                System.out.println("5. Jump to specific time"); 
                int c = sc.nextInt(); 
                audioPlayer.gotoChoice(c); 
                if (c == 4) 
                break; 
            } 
            sc.close(); 
        }  
          
        catch (Exception ex)  
        { 
            System.out.println("Error with playing sound."); 
            ex.printStackTrace(); 
          
         }
    }
    
    private void gotoChoice(int c) 
            throws IOException, LineUnavailableException, UnsupportedAudioFileException  
    { 
        switch (c)  
        { 
            case 1: 
                pause(); 
                break; 
            case 2: 
                resumeAudio(); 
                break; 
            case 3: 
                restart(); 
                break; 
            case 4: 
                stop(); 
                break; 
            case 5:
                System.out.println("Enter time (" + 0
                        + ", " + clip.getMicrosecondLength() + ")");
                Scanner sc = new Scanner(System.in);
                long c1 = sc.nextLong();
                jump(c1);
                break;

        }

    }*/
    
    // Method to play the audio 
    public void play()  
    { 
        /*try {
            filePath = "/home/vitoria/git/ProximityDetector/danger-alarm-23793.wav"; 
            clip.start();
            System.out.println("Chegou aqui");
        } catch (Exception ex) {
            System.out.println("Error with playing sound."); 
            ex.printStackTrace();
        }*/
        //start the clip 
        clip.start(); 
          
        //status = "play"; 
    } 
    
    // Method to stop the audio 
    public void stop() throws UnsupportedAudioFileException, 
    IOException, LineUnavailableException  
    { 
        currentFrame = 0L; 
        clip.stop(); 
        clip.close(); 
    }

    /*
    // Method to pause the audio 
    public void pause()  
    { 
        if (status.equals("paused"))  
        { 
            System.out.println("audio is already paused"); 
            return; 
        } 
        this.currentFrame =  
        this.clip.getMicrosecondPosition(); 
        clip.stop(); 
        status = "paused"; 
    }
    
    // Method to resume the audio 
    public void resumeAudio() throws UnsupportedAudioFileException, 
                                IOException, LineUnavailableException  
    { 
        if (status.equals("play"))  
        { 
            System.out.println("Audio is already "+ 
            "being played"); 
            return; 
        } 
        clip.close(); 
        resetAudioStream(); 
        clip.setMicrosecondPosition(currentFrame); 
        this.play(); 
    }
    
    // Method to restart the audio 
    public void restart() throws IOException, LineUnavailableException, 
                                            UnsupportedAudioFileException  
    { 
        clip.stop(); 
        clip.close(); 
        resetAudioStream(); 
        currentFrame = 0L; 
        clip.setMicrosecondPosition(0); 
        this.play(); 
    }
    
    // Method to jump over a specific part 
    public void jump(long c) throws UnsupportedAudioFileException, IOException, 
                                                        LineUnavailableException  
    { 
        if (c > 0 && c < clip.getMicrosecondLength())  
        { 
            clip.stop(); 
            clip.close(); 
            resetAudioStream(); 
            currentFrame = c; 
            clip.setMicrosecondPosition(c); 
            this.play(); 
        } 
    } 
      
    // Method to reset audio stream 
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, 
                                            LineUnavailableException  
    { 
        audioInputStream = AudioSystem.getAudioInputStream( 
        new File(filePath).getAbsoluteFile()); 
        clip.open(audioInputStream); 
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
    } */
}
