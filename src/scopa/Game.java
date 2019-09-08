package scopa;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import scopa.logichandler.LogicHandler;

public final class Game extends Application {
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 800;
	
	@Override
	public void start(Stage stage) throws Exception {
		
		//stage.setWidth(WIDTH);
		//stage.setHeight(HEIGHT);
		//stage.setTitle("Scopa");
		//stage.setResizable(false);
		//stage.setScene(new Scene(createContent()));
		//stage.show();
		
		
		Label label = new Label("Bella");
		label.setAlignment(Pos.CENTER);
		
		StackPane root = new StackPane();
		root.getChildren().add(label);
		
		stage.setScene(new Scene(root, 300, 250));
		stage.show();
	}
	
	private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(WIDTH, HEIGHT);
		
		Region background = new Region();
		background.setPrefSize(WIDTH, HEIGHT);
		background.setStyle("-fx-background-color: rgba(0,0,0,1)");
		
		return root;
	}
	
	private static void launchConsoleApplication() {
		LogicHandler lh = new LogicHandler();
		lh.play();
	}
	
	public static void main(String[] args) {
		Application.launch();
	}
}


/*
public final class Game {
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 800;
	
	private static void launchConsoleApplication() {
		LogicHandler lh = new LogicHandler();
		lh.play();
	}
	
	public static void main(String[] args) {
		launchConsoleApplication();
	}
}
*/