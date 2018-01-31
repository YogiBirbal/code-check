/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.data;

import cc.CodeCheckApp;
import djf.components.AppDataComponent;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Yogi
 */
public class CodeCheckData implements AppDataComponent{
    
    CodeCheckApp app;
    ObservableList<GridPane> panes;
    String title;

    public ObservableList<GridPane> getPanes() {
        return panes;
    }
    
    public CodeCheckData(CodeCheckApp initapp){
        app = initapp;
    }

    @Override
    public void resetData() {
        
    
    }

   

    
    
}
