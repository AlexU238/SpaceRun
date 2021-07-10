package sample.Game;

import java.util.*;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public final class Space {

    private LinkedList<Star>starLinkedList;
    private LinkedList<Rock>rockLinkedList;
    private Ship player;
    private float difficulty;
    private Rectangle background;
    private static final int NUMBER_OF_ROCKS=10;//initially it was 20, but it was unreal to beat, so it was changed to 10
    private static final int NUMBER_OF_STARS=11;

     private Space( ) {
        this.starLinkedList = new LinkedList<>();
        this.rockLinkedList = new LinkedList<>();
        this.background = new Rectangle();
        this.background.setY(0);
        this.background.setX(-100);
        this.background.setWidth(1180);
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
        for(int i=0; i<=NUMBER_OF_STARS; i++){
            starLinkedList.add(new Star(x,y,new ImageView(TextureLoader.getStar())));
            x+=100;
        }
        for(Star s:starLinkedList){
            stars.getChildren().add(s.getTexture());
        }
        return stars;
    }

    private Group generateRocks(){
        Group rocks=new Group();
        Random rnd = new Random();
        int x=1140;
        for(int i=0;i<=NUMBER_OF_ROCKS;i++){
            rockLinkedList.add(new Rock(x,rnd.nextInt(720),new ImageView(TextureLoader.getRock())));
        }
        for (Rock r:rockLinkedList){
            rocks.getChildren().addAll(r.getHitbox(),r.getTexture());
        }
        return rocks;
    }

    void checkReset(){

    }

    void collide(){

    }

    public void adjustDifficulty(){
        difficulty+=0.0015;
        if((int)difficulty>=20){
            difficulty=20;
        }
    }

    public void moveBackGround(){
         for(Star s:starLinkedList){
            s.move();
         }
    }

    public void moveRocks(){
        for (int i=0;i<=difficulty-1;i++){
            launchRocks(i);
        }
    }

    private void launchRocks(int starter){
        for(int i=0; i<=starter;i++){
                rockLinkedList.get(i).move();
            }
    }

    public Group getStars() {
        return generateStars();
    }

    public Group getRocks(){
        return generateRocks();
    }

    public LinkedList<Rock> getRockLinkedList() {
        return rockLinkedList;
    }

    public LinkedList<Star> getStarLinkedList() {
        return starLinkedList;
    }

    public void setPlayer(Ship player) {
        this.player = player;
    }

    public Ship getPlayer() {
        return player;
    }

    public float getDifficulty() {
        return difficulty;
    }

    public Rectangle getBackground() {
        return background;
    }

}

