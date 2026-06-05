package entities.player;

import entities.MediaPlayerStartClass;
import entities.TypeOfMedia;
import entities.interfaceses.Player;

public class Audio extends MediaPlayerStartClass implements Player {
    int duration;
    int volume;
    public Audio(String title, int duration, int volume) {
        super(title, TypeOfMedia.Audio);
        this.duration= duration;
        this.volume= volume;
    }
    @Override
    public void selected() {
        System.out.println(this.getTitle() + " è il brano in riproduzione, durata di "+ this.duration +" minuti.");
    }

    @Override
    public void play() {
        if(this.volume < 0){this.volume = 0;}
        String vol = "";
        for (int y=0; y< this.volume; y++){
           vol += "!";
        }
        int[] durations = new int[duration];
        for (int i = 0; i <durations.length; i++ ){
            System.out.println(getTitle()+" in riproduzione, vol :"+vol);
        }
        System.out.println("Il volume attuale è "+this.volume);
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
