package sample.UserInterface;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;


public class MenuBackgroundFactory implements BackgroundFactory {

    @Override
    public Background createBackground() {
        return new Background(new BackgroundImage(UITextureLoader.getBackground(), null, null, null, BackgroundSize.DEFAULT));
    }
}
