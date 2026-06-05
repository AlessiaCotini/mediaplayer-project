package entities.player;

import entities.MediaPlayerStartClass;
import entities.TypeOfMedia;
import entities.interfaceses.Bright;

public class Image extends MediaPlayerStartClass implements Bright {
    int brightness;
    public Image(String title, int brightness) {
        super(title, TypeOfMedia.Image);
        this.brightness= brightness;
    }

    public void show(){
        String showbr = "";
        for (int i=0; i< this.brightness; i++){
            showbr += "*";
        }
        System.out.println(this.getTitle()+" è la tua immagine con luminosità = "+showbr);
    }
    @Override
    public void selected() {
        System.out.println(this.getTitle() + " è l'immagine selezionata, luminosità a "+ this.brightness);
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
}
