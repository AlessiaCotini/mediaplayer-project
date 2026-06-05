package entities;

public abstract class MediaPlayerStartClass {
    private TypeOfMedia type ;
    private String title;

    public MediaPlayerStartClass(String title, TypeOfMedia type){
        this.type = type;
        this.title = title;
    }

    public TypeOfMedia getType() {
        return type;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public abstract void selected();
}
