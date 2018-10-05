/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Gestioa;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableCell;

/**
 *
 * @author Casa
 */
public class ModTableCell extends TableCell<Coches, String>
{

//    private ComboBox<String> comboBox;
//
//    public ModTableCell()
//    {
//    }
//
//    @Override
//    public void startEdit()
//    {
//        if (!isEmpty()) {
//            super.startEdit();
//            setText(null);
//            setGraphic(comboBox);
//        }
//    }
//
//    @Override
//    public void cancelEdit()
//    {
//        super.cancelEdit();
//
//        setText(getModelo());
//        setGraphic(null);
//    }
//
//    @Override
//    public void updateItem(String item, boolean empty)
//    {
//        super.updateItem(item, empty);
//
//        if (empty) {
//            setText(null);
//            setGraphic(null);
//        } else {
//            if (isEditing()) {
//                if (comboBox != null) {
//                    comboBox.setValue(getModelo());
//                }
//                setText(getModelo());
//                setGraphic(comboBox);
//            } else {
//                setText(getModelo());
//                setGraphic(null);
//            }
//        }
//    }
//
//
//    private void comboBoxConverter(ComboBox<String> comboBox)
//    {
//        // Define rendering of the list of values in ComboBox drop down. 
//        comboBox.setCellFactory((c) -> {
//            return new ListCell<String>()
//            {
//                @Override
//                protected void updateItem(String item, boolean empty)
//                {
//                    super.updateItem(item, empty);
//
//                    if (item == null || empty) {
//                        setText(null);
//                    } else {
//                        setText(item);
//                    }
//                }
//            };
//        });
//    }
//
//    private String getModelo()
//    {
//        return getItem() == null ? "" : getItem();
//    }
}
