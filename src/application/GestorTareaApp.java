package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GestorTareaApp extends Application{
	private Gestor gestor = new Gestor();
    private TextArea textArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestor de Tareas");

        Label lblDescripcion = new Label("Descripción:");
        TextField txtDescripcion = new TextField();
        Label lblPrioridad = new Label("Prioridad:");
        Spinner<Integer> spnPrioridad = new Spinner<>(1, 10, 1);  
        Button btnAgregar = new Button("Agregar Tarea");
        Button btnResolver = new Button("Resolver Tarea");
        textArea.setEditable(false);


        VBox vbox = new VBox(10);
        HBox hboxDescripcion = new HBox(10, lblDescripcion, txtDescripcion);
        HBox hboxPrioridad = new HBox(10, lblPrioridad, spnPrioridad);
        HBox hboxBotones = new HBox(10, btnAgregar, btnResolver);
        vbox.getChildren().addAll(hboxDescripcion, hboxPrioridad, hboxBotones, textArea);


        btnAgregar.setOnAction(e -> {
            String descripcion = txtDescripcion.getText();  
            int prioridad = spnPrioridad.getValue(); 
            gestor.agregarTarea(descripcion, prioridad);  
            textArea.appendText("Tarea añadida: " + descripcion + " (Prioridad: " + prioridad + ")\n"); 
            txtDescripcion.clear();  
            System.out.println(gestor.toString());
        });

        btnResolver.setOnAction(e -> {
            if (!gestor.vacia()) {
            	System.out.println("entro");
                Tarea tarea = gestor.resolverTarea();  
                if (tarea != null) {
                    textArea.appendText("Resolviendo tarea: " + tarea.getDescripcion() + " (Prioridad: " + tarea.getPrioridad() + ")\n");  
                }
                
                if (gestor.vacia()) {
                    textArea.appendText("Todas las tareas han sido resueltas.\n");  
                }
            } else {
                textArea.appendText("No hay tareas pendientes para resolver.\n");  
            }
        });

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
