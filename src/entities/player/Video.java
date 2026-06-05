package entities.player;

import entities.MediaPlayerStartClass;
import entities.TypeOfMedia;
import entities.interfaceses.Bright;
import entities.interfaceses.Player;

public class Video extends MediaPlayerStartClass implements Player, Bright {
    int duration;
    int volume;
    int brightness;
    public Video(String title, int duration, int volume, int brightness) {
        super(title, TypeOfMedia.Video);
        this.duration= duration;
        this.volume= volume;
        this.brightness= brightness;
    }
    @Override
    public void selected() {
        System.out.println(this.getTitle() + " è il video in riproduzione, durata di "+ this.duration +" minuti.");
    }

    @Override
    public void lightUp(int plus) {
        this.brightness += plus;
        System.out.println("Stai alzando la luminosità a "+ this.brightness);
    }

    @Override
    public void lightDown(int minus) {
        this.brightness -= minus;
        if(this.brightness< 0){ this.brightness = 0;}
        System.out.println("Stai abbassando la luminosità a "+ this.brightness);
    }

    @Override
    public void play() {
        if(this.volume < 0){this.volume = 0;}
        String vol = "";
        for (int y=0; y< this.volume; y++){
            vol += "!";
        }
        String br = "";
        for (int z = 0; z<this.brightness; z++){
            br += "*";
        }
        int[] durations = new int[duration];
        for (int i = 0; i <durations.length; i++ ){
            System.out.println(getTitle()+" in riproduzione, vol = "+vol+", luminosità = "+ br);
        }
        System.out.println("Il volume attuale è "+this.volume);
        System.out.println("La luminosità a "+this.brightness);
    }

    @Override
    public void volumeUp(int plus) {
        this.volume += plus;
        System.out.println("Stai alzando il volume a "+ this.volume);
    }

    @Override
    public void volumeDown(int minus) {
        this.volume -= minus;
        if(this.volume< 0){ this.volume = 0;}
        System.out.println("Stai abbassando il volume a "+ this.volume);
    }
}
