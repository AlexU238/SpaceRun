package sample;

import javafx.scene.control.Alert;

public abstract class CommonAlerts {


    public static void loadDefaultTextureAlert() {
        Alert loadDefaultAlert = new Alert(Alert.AlertType.WARNING);
        loadDefaultAlert.setTitle("Texture loader warning");
        loadDefaultAlert.setContentText("WARNING!");
        loadDefaultAlert.setContentText("Default texture not found. This may lead to possible errors while running the program.");
        loadDefaultAlert.showAndWait();
    }

    public static void loadInterfaceTexturesAlert() {
        Alert loadInterfaceAlert = new Alert(Alert.AlertType.WARNING);
        loadInterfaceAlert.setTitle("Texture loader warning");
        loadInterfaceAlert.setContentText("WARNING!");
        loadInterfaceAlert.setContentText("Some of the interface textures are missing. This may affect several aspects of the game.");
        loadInterfaceAlert.showAndWait();
    }

    public static void loadGameTexturesAlert() {
        Alert loadGameAlert = new Alert(Alert.AlertType.WARNING);
        loadGameAlert.setTitle("Texture loader warning");
        loadGameAlert.setContentText("WARNING!");
        loadGameAlert.setContentText("Some of the game textures are missing. This may affect several aspects of the game.");
        loadGameAlert.showAndWait();
    }



}
