package sample.UserInterface;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;

public class PlayerInfoBackgroundFactory implements BackgroundFactory {
    @Override
    public Background createBackground() {
        return new Background(new BackgroundImage(UITextureLoader.loadMainMenuPlayerInfoTexture(), null, null, null, BackgroundSize.DEFAULT));
    }
}
