package sample.Game;

import java.util.LinkedList;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public final class Space {

    private LinkedList<Star>starLinkedList;
    private LinkedList<Rock>rockLinkedList;
    private Ship player;
    private int score;
    private Rectangle background;

     private Space( ) {
        this.starLinkedList = new LinkedList<>();
        this.rockLinkedList = new LinkedList<>();
        this.background = new Rectangle();
        this.background.setY(0);
        this.background.setX(-100);
        this.background.setWidth(1080);
        this.background.setHeight(720);
        this.background.setFill(Color.BLACK);
        TextureLoader.loadMainThreeTextures();
    }

    public static Space connectToSpace(){
        return new Space();
    }

     private Group generateStars(){
        Group stars=new Group();
        int x=0;
        int y=0;
        for(int i=0; i<=11; i++){
            starLinkedList.add(new Star(x,y,new ImageView(TextureLoader.getStar())));
            x+=100;
        }
        for(Star s:starLinkedList){
            stars.getChildren().add(s.getTexture());
        }
        return stars;
    }

    void generateRocks(){

    }

    void checkReset(){

    }

    void countScore(){

    }

    void collide(){

    }

    public Group getStars() {
        return generateStars();
    }

    public LinkedList<Rock> getRockLinkedList() {
        return rockLinkedList;
    }

    public void setPlayer(Ship player) {
        this.player = player;
    }

    public Ship getPlayer() {
        return player;
    }

    public int getScore() {
        return score;
    }

    public Rectangle getBackground() {
        return background;
    }
}
