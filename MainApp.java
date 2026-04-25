import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    DAO dao = new DAO();

    @Override
    public void start(Stage stage) {

        TextField nameField = new TextField();
        nameField.setPromptText("Item Name");

        TextField priceField = new TextField();
        priceField.setPromptText("Price");

        TextField resIdField = new TextField();
        resIdField.setPromptText("Restaurant ID");

        TextField idField = new TextField();
        idField.setPromptText("Item ID (for update/delete)");

        Button insertBtn = new Button("Insert");
        Button selectBtn = new Button("Select");
        Button updateBtn = new Button("Update");
        Button deleteBtn = new Button("Delete");

        // INSERT
        insertBtn.setOnAction(e -> {
            dao.insertMenuItem(
                nameField.getText(),
                Double.parseDouble(priceField.getText()),
                Integer.parseInt(resIdField.getText())
            );
        });

        // SELECT
        selectBtn.setOnAction(e -> {
            dao.selectMenuItems();
        });

        // UPDATE
        updateBtn.setOnAction(e -> {
            dao.updatePrice(
                Integer.parseInt(idField.getText()),
                Double.parseDouble(priceField.getText())
            );
        });

        // DELETE
        deleteBtn.setOnAction(e -> {
            dao.deleteItem(Integer.parseInt(idField.getText()));
        });

        VBox root = new VBox(10,
                nameField, priceField, resIdField, idField,
                insertBtn, selectBtn, updateBtn, deleteBtn
        );

        stage.setScene(new Scene(root, 300, 300));
        stage.setTitle("Inventory Management (JavaFX)");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}