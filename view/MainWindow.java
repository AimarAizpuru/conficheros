/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import controller.Gestioa;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import model.ModTableCell;

import model.Coches;

/**
 *
 * @author idoia
 */
public class MainWindow extends Application {

    private final TableView<Coches> table = new TableView<>();

    final HBox hb = new HBox();

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());

        stage.setTitle("Tabla de caracteristicas");
        stage.setWidth(700);
        stage.setHeight(550);
        final Label label = new Label("Coches");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        Callback<TableColumn<Coches, String>, TableCell<Coches, String>> comboBoxCellFactory
                = (TableColumn<Coches, String> param) -> new ModTableCell();

        TableColumn<Coches, String> firstNameCol = new TableColumn<>("Marca");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("Marca"));
        firstNameCol.setCellFactory(TextFieldTableCell.<Coches>forTableColumn());
        firstNameCol.setOnEditCommit((TableColumn.CellEditEvent<Coches, String> t) -> {
            ((Coches) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setMarca(t.getNewValue());
        });

        TableColumn<Coches, String> especieCol
                = new TableColumn<>("Modelo");
        especieCol.setMinWidth(100);
        especieCol.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getModelo()));
        especieCol.setCellFactory(comboBoxCellFactory);
        especieCol.setOnEditCommit((TableColumn.CellEditEvent<Coches, String> t) -> {
            ((Coches) t.getTableView().getItems()
                    .get(t.getTablePosition().getRow()))
                    .setModelo(t.getNewValue());
        });

        TableColumn<Coches, String> elementoCol = new TableColumn<>("Matricula");
        elementoCol.setMinWidth(150);
        elementoCol.setCellValueFactory(
                new PropertyValueFactory<>("matricula"));
        elementoCol.setCellFactory(TextFieldTableCell.<Coches>forTableColumn());
        elementoCol.setOnEditCommit((TableColumn.CellEditEvent<Coches, String> t) -> {
            ((Coches) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setMatricula(t.getNewValue());
        });
        TableColumn<Coches, String> WeaknessCol = new TableColumn<>("Color");
        WeaknessCol.setMinWidth(150);
        WeaknessCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        WeaknessCol.setCellFactory(TextFieldTableCell.<Coches>forTableColumn());
        WeaknessCol.setOnEditCommit((TableColumn.CellEditEvent<Coches, String> t) -> {
            ((Coches) t.getTableView().getItems().get(
                    t.getTablePosition().getRow())).setColor(t.getNewValue());
        });

        table.setItems(FXCollections.observableList(Gestioa.cargarDatos()));
        table.getColumns().addAll(firstNameCol, especieCol, elementoCol, WeaknessCol);
        final TextField addMarca = new TextField();
        addMarca.setPromptText("Marca");
        addMarca.setMaxWidth(firstNameCol.getPrefWidth());

        final ComboBox addModelo = new ComboBox(FXCollections.observableList(Gestioa.cargarDatos()));
        addModelo.setMaxWidth(100);
        addModelo.setPromptText("Modelo");

        final TextField addMatricula = new TextField();
        addMatricula.setMaxWidth(elementoCol.getPrefWidth());
        addMatricula.setPromptText("Matricula");

        final TextField addColor = new TextField();
        addColor.setMaxWidth(WeaknessCol.getPrefWidth());
        addColor.setPromptText("Color");

        final Button addButton = new Button("Añadir");
        addButton.setOnAction((ActionEvent e) -> {
            if ("".equals(addMarca.getText()) || addModelo.getSelectionModel().isEmpty() || addMatricula.getText() == "" || addColor.getText() == "") {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Ezin da gehitu!");
                alert.setContentText("Ezin da daturik gorde taulan guztiak bete barik.");
                alert.showAndWait();
            } else {
                Coches p = new Coches(addMarca.getText(), addModelo.getSelectionModel().getSelectedItem().toString(), addMatricula.getText(), addColor.getText());
                table.getItems().add(p);
                addMarca.clear();
                addModelo.getSelectionModel().clearSelection();
                addMatricula.clear();
                addColor.clear();
            }
        });

        final Button removeButton = new Button("Borrar");
        removeButton.setOnAction((ActionEvent e) -> {
            Coches mon = table.getSelectionModel().getSelectedItem();
            table.getItems().remove(mon);
        });

        hb.getChildren().addAll(addMarca, addModelo, addMatricula, addColor, addButton, removeButton);
        hb.setSpacing(3);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest((WindowEvent event) -> {
            try {
                PrintWriter pw = new PrintWriter("Coches.txt");
                for (int i = 0; i < table.getItems().size(); i++) {
                    pw.println(table.getItems().get(i).getMarca() + ","
                            + table.getItems().get(i).getModelo() + ","
                            + table.getItems().get(i).getMatricula() + ","
                            + table.getItems().get(i).getColor() + ","
                    );

                }
                pw.close();
            } catch (FileNotFoundException ex) {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setContentText("Ez da artxiboa aurkitu datuak gordetzeko.");
                error.showAndWait();
            }

        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Exception e) {
            if (e instanceof InvocationTargetException) {
                e = (Exception) e.getCause();
            }
            throw new RuntimeException("Unable to inject views for " + e);
        }

    }

}
