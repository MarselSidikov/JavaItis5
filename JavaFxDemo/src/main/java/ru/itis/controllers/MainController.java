package ru.itis.controllers;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import ru.itis.vk.api.VkApi;
import ru.itis.vk.api.builders.VkApiBuilder;
import ru.itis.vk.api.models.Friend;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainController {

    private VkApi vkApi;

    @FXML
    private AnchorPane pane;

    @FXML
    private Button buttonFriends;

    @FXML
    private TextField countFriends;

    private List<TitledPane> panes = new ArrayList<>();

    @FXML
    public void initialize() {

        vkApi = VkApiBuilder.buildRestTemplate();
        buttonFriends.setOnAction(event -> {
            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    int countOfFriends = Integer.parseInt(countFriends.getText());
                    pane.getChildren().removeAll(panes);
                    List<Friend> friends = vkApi
                            .getUserFriends(176050764, countOfFriends, "photo_200_orig");
                    double lastY = 0;
                    VBox vBox = new VBox();
                    ScrollPane scrollPane = new ScrollPane(vBox);
                    for (Friend friend : friends) {
                        ImageView imageView = new ImageView(friend.getPhoto());
                        TitledPane friendPane = new TitledPane(friend.getFirstName() +
                                " " + friend.getLastName(), imageView);
                        friendPane.setLayoutY(lastY);
                        lastY = lastY + imageView.getImage().getHeight();
                        friendPane.setExpanded(false);
                        panes.add(friendPane);
                        vBox.getChildren().add(friendPane);
                        System.out.println("Processed");
                    }
                    scrollPane.setFitToHeight(true);
                    Platform.runLater(() -> pane.getChildren().add(scrollPane));
                    this.done();
                    return null;
                }
            };
            ProgressBar bar = new ProgressBar();
            bar.progressProperty().bind(task.progressProperty());
            pane.getChildren().add(bar);
            Thread thread = new Thread(task);
            thread.start();
        });
    }
}
