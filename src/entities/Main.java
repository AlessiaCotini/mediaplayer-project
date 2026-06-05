import java.util.Scanner;
import entities.MediaPlayerStartClass;
import entities.interfaceses.Player;
import entities.player.Audio;
import entities.player.Image;
import entities.player.Video;

void main() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Creiamo la tua compilation: ");
    System.out.println("- per inserire un file Audio inserire il numero 1");
    System.out.println("- per inserire un file Video inserire il numero 2");
    System.out.println("- per inserire un file Immagine inserire il numero 3");
    System.out.println("hai a disposizione cinque spazi di memoria.");
    MediaPlayerStartClass[] file = new MediaPlayerStartClass[5];

    for (int i = 0; i < file.length; i++) {
        System.out.println("Elemento della playlist n " + (i + 1) + "/5 , se non volessi proseguire inserisci 0!");
        int fileDaInserire = scanner.nextInt();
        scanner.nextLine();

        if (fileDaInserire == 1) {
            System.out.println("Inserire nome del file Audio:");
            String nameAudio = scanner.nextLine();
            System.out.println("Inserire la durata:");
            int durationAudio = scanner.nextInt();
            System.out.println("Inserire il volume desiderato:");
            int volumeAudio = scanner.nextInt();
            file[i] = new Audio(nameAudio, durationAudio, volumeAudio);

        } else if (fileDaInserire == 2) {
            System.out.println("Inserire nome del file Video:");
            String nameVideo = scanner.nextLine();
            System.out.println("Inserire la durata:");
            int durationVideo = scanner.nextInt();
            System.out.println("Inserire il volume desiderato:");
            int volumeVideo = scanner.nextInt();
            System.out.println("Inserire la luminosità desiderata:");
            int brVideo = scanner.nextInt();
            file[i] = new Video(nameVideo, durationVideo, volumeVideo, brVideo);

        } else if (fileDaInserire == 3) {
            System.out.println("Inserire il nome dell'immagine:");
            String nomeImmagine = scanner.nextLine();
            System.out.println("Inserire la luminosità desiderata:");
            int brImg = scanner.nextInt();
            file[i] = new Image(nomeImmagine, brImg);
        } else if (fileDaInserire == 0) {
            System.out.println("Inserimento interrotto dall'utente.");
            break;
        } else {
            System.out.println("Questo spazio rimarrà vuoto.");
        }
    }

    boolean inEsecuzione = true;
    while (inEsecuzione) {
        System.out.println("\n--- I TUOI MEDIA IN MEMORIA ---");
        for (int k = 0; k < file.length; k++) {
            if (file[k] != null) {
                System.out.println((k + 1) + ". [" + file[k].getClass().getSimpleName() + "] " + file[k].getTitle());
            } else {
                System.out.println((k + 1) + ". [Qui non hai inserito media!]");
            }
        }
        System.out.println("Quale file vuoi visualizzare?");
        System.out.print("Inserisci un numero da 1 a 5, oppure 0 per uscire: ");
        int input = scanner.nextInt();

        if (input == 0) {
            inEsecuzione = false;
        } else if (input >= 1 && input <= 5) {
            MediaPlayerStartClass selectedInput = file[input - 1];

            if (selectedInput != null) {
                if (selectedInput instanceof Player) {
                    Player selectedInputRip = (Player) selectedInput;
                    selectedInputRip.play();
                } else if (selectedInput instanceof Image) {
                    Image selectedInputBr = (Image) selectedInput;
                    selectedInputBr.show();
                }
            } else {
                System.out.println("Scegli un file valido.");
            }
            System.out.println("------------------------------");
        } else {
            System.out.println("Inserisci un numero tra 0 e 5.");
        }
    }
    System.out.println("Playlist terminata.");
    scanner.close();
}


//AUDIO TEST
//  Audio canzone = new Audio("One",3,6);
//  canzone.selected();
//  canzone.play();
//  canzone.volumeDown(2);
//  canzone.volumeUp(1);
//  canzone.volumeDown(6);
//VIDEO TEST
//  Video video = new Video("Shrek",2,4,3);
//  video.selected();
//  video.play();
//IMAGE TEST
//  Image image = new Image("Concerto",5);
//  image.selected();
//  image.show();

