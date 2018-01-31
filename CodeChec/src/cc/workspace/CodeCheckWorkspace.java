/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.workspace;

import cc.CodeCheckApp;
import static cc.CodeCheckProp.APP_AUTHOR;
import static cc.CodeCheckProp.APP_DISC;
import static cc.CodeCheckProp.APP_TITLE;
import static cc.CodeCheckProp.APP_YEAR;
import static cc.CodeCheckProp.CODE_CHECK_BUTTON_TEXT;
import static cc.CodeCheckProp.CODE_CHECK_DISC_TEXT;
import static cc.CodeCheckProp.CODE_CHECK_LABEL_TEXT;
import static cc.CodeCheckProp.CODE_CHECK_PROGLABEL_TEXT;
import static cc.CodeCheckProp.EXTRACT_CODE_BUTTON_TEXT;
import static cc.CodeCheckProp.EXTRACT_CODE_DISC_TEXT;
import static cc.CodeCheckProp.EXTRACT_CODE_LABEL_TEXT;
import static cc.CodeCheckProp.EXTRACT_CODE_PROGLABEL_TEXT;
import static cc.CodeCheckProp.EXTRACT_SUB_BUTTON_TEXT;
import static cc.CodeCheckProp.EXTRACT_SUB_DISC_TEXT;
import static cc.CodeCheckProp.EXTRACT_SUB_LABEL_TEXT;
import static cc.CodeCheckProp.EXTRACT_SUB_PROGLABEL_TEXT;
import static cc.CodeCheckProp.HOME_BUTTON_TEXT;
import static cc.CodeCheckProp.NEXT_BUTTON_TEXT;
import static cc.CodeCheckProp.PREVIOUS_BUTTON_TEXT;
import static cc.CodeCheckProp.REFRESH_BUTTON_TEXT;
import static cc.CodeCheckProp.REMOVE_BUTTON_TEXT;
import static cc.CodeCheckProp.RENAME_DISC_TEXT;
import static cc.CodeCheckProp.RENAME_LABEL_TEXT;
import static cc.CodeCheckProp.RENAME_PROGLABEL_TEXT;
import static cc.CodeCheckProp.RENAME_SUB_BUTTON_TEXT;
import static cc.CodeCheckProp.UNZIP_BUTTON_TEXT;
import static cc.CodeCheckProp.UNZIP_DISC_TEXT;
import static cc.CodeCheckProp.UNZIP_LABEL_TEXT;
import static cc.CodeCheckProp.UNZIP_PROGLABEL_TEXT;
import static cc.CodeCheckProp.VIEW_BUTTON_TEXT;
import cc.data.CodeCheckData;
import static cc.style.SlideshowCreatorStyle.CLASS_ACTION_BUTTON;
import static cc.style.SlideshowCreatorStyle.CLASS_DISC_LABEL;
import static cc.style.SlideshowCreatorStyle.CLASS_EDIT_BUTTON;
import static cc.style.SlideshowCreatorStyle.CLASS_PROMPT_LABEL;
import djf.components.AppDataComponent;
import djf.components.AppWorkspaceComponent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import properties_manager.PropertiesManager;


/**
 *
 * @author Yogi
 */
public class CodeCheckWorkspace  extends AppWorkspaceComponent{
    
    CodeCheckApp app;
    CodeCheckController controller;
    
    GridPane stepOneExtractSub;
    Label extractSubLabel; 
    Label extractSubDiscLabel; 
    ListView extractSubList;
    TextField extractSubText;
    Button extractSubButton; 
    Label extractSubProgLabel;
    ProgressBar extractSubProgBar;
    VBox extractSubLeft;
    GridPane extractSubRight;
    HBox stepOne;
    Button removeExtractSubButton; 
    Button refreshExtractSubButton;
    Button viewExtractSubButton; 
    

    GridPane stepTwoRenameSub;
    Label renameLabel;
    Label renameDiscLabel;
    ListView renameList; 
    TextField renameText; 
    Button renameButton; 
    Label renameProgLabel; 
    ProgressBar renameProgBar; 
    VBox renameLeft;
    GridPane renameRight;
    HBox stepTwo;
    Button removeRenameButton; 
    Button refreshRenameButton;
    Button viewRenameButton; 

    GridPane stepThreeUnzip; 
    Label unzipLabel; 
    Label unzipDiscLabel; 
    ListView unzipList; 
    TextField unzipText;
    Button unzipButton; 
    Label unzipProgLabel; 
    ProgressBar unzipProgBar; 
    VBox unzipLeft;
    GridPane unzipRight;
    HBox stepThree;
    Button removeUnzipButton; 
    Button refreshUnzipButton;
    Button viewUnzipButton; 

    GridPane stepFourExtractCode;
    Label extractCodeLabel;
    Label extractCodeDiscLabel; 
    ListView extractCodeList;
    TextField extractCodeText; 
    Button extractCodeButton; 
    Label extractCodeProgLabel; 
    ProgressBar extractCodeProgBar; 
    Label sourceFileTypeLabel; 
    CheckBox javaBox; 
    CheckBox jsBox; 
    CheckBox csBox; 
    CheckBox customBox; 
    VBox extractCodeLeft;
    GridPane extractCodeRight;
    HBox stepFour;
    Button removeExtractCodeButton; 
    Button refreshExtractCodeButton;
    Button viewExtractCodeButton; 
    

    GridPane stepFiveCodeCheck;
    Label codeCheckLabel;
    Label codeCheckDiscLabel;
    ListView codeCheckList;
    TextField codeCheckText; 
    Button codeCheckButton;
    Button viewResultsButton;
    Label codeCheckProgLabel; 
    ProgressBar codeCheckProgBar; 
    VBox codeCheckLeft;
    GridPane codeCheckRight;
    HBox stepFive;
    Button removeCodeCheckButton; 
    Button refreshCodeCheckButton;
    Button viewCodeCheckButton; 
    
    
    ProgressIndicator indicator; 
    Button nextButton; 
    Button prevButton; 
    Button homeButton;
    HBox navigate;
    
    Label aboutTitle;
    Label aboutAuthor;
    Label aboutYear;
    Label aboutDisc;
    VBox aboutbox;
    Stage primary;
    Scene ab;
    
    
    public CodeCheckWorkspace(CodeCheckApp initapp){
        app = initapp;
        
        initLayout();
        
        initContollers();
        initStyle();
        //updateButtons();
        
    }

    private void initLayout() {
        PropertiesManager props = PropertiesManager.getPropertiesManager();
        navigate = new HBox();
        homeButton = new Button(props.getProperty(HOME_BUTTON_TEXT));
        nextButton = new Button(props.getProperty(NEXT_BUTTON_TEXT)); 
        prevButton = new Button(props.getProperty(PREVIOUS_BUTTON_TEXT));
        navigate.getChildren().add(homeButton);
        navigate.getChildren().add(nextButton);
        navigate.getChildren().add(prevButton);
        app.getGUI().getTopToolbarPane().getChildren().add(navigate);
        
        removeExtractSubButton = new Button(props.getProperty(REMOVE_BUTTON_TEXT));
        refreshExtractSubButton = new Button(props.getProperty(REFRESH_BUTTON_TEXT));
        viewExtractSubButton = new Button(props.getProperty(VIEW_BUTTON_TEXT));
        stepOne = new HBox();
        stepOne.setSpacing(50);
        stepOne.getChildren().addAll(removeExtractSubButton, refreshExtractSubButton, viewExtractSubButton);
        
        stepOneExtractSub = new GridPane();
        extractSubLabel = new Label(props.getProperty(EXTRACT_SUB_LABEL_TEXT)); 
        extractSubDiscLabel = new Label(props.getProperty(EXTRACT_SUB_DISC_TEXT)); 
        extractSubList = new ListView();
        extractSubText = new TextField();
        extractSubText.setPrefHeight(424);
        extractSubText.setPrefWidth(650);
        extractSubButton = new Button (props.getProperty(EXTRACT_SUB_BUTTON_TEXT)); 
        extractSubProgLabel = new Label(props.getProperty(EXTRACT_SUB_PROGLABEL_TEXT));
        extractSubProgBar = new ProgressBar();
        extractSubProgBar.setMaxWidth(400);
        extractSubLeft = new VBox();
        extractSubLeft.setPrefWidth(650);
        extractSubLeft.setSpacing(3);
        extractSubRight = new GridPane();
        extractSubRight.setVgap(5);
        
        extractSubLeft.getChildren().addAll(extractSubLabel, extractSubDiscLabel,extractSubList, stepOne);
        extractSubRight.add(extractSubProgLabel, 0, 0);
        extractSubRight.add(extractSubProgBar, 1, 0);
        extractSubRight.add(extractSubButton, 0, 1);
        extractSubRight.add(extractSubText, 0, 3, 2, 1);
        
        stepOneExtractSub.setHgap(20);
        stepOneExtractSub.add(extractSubLeft, 0, 0);
        stepOneExtractSub.add(extractSubRight, 1, 0);
        
        workspace = stepOneExtractSub;
        
        //app.getGUI().getAppPane().setCenter(stepOneExtractSub);
        GridPane.setVgrow(extractSubLeft, Priority.ALWAYS);
        GridPane.setVgrow(extractSubRight, Priority.ALWAYS);
        GridPane.setHgrow(extractSubLeft, Priority.ALWAYS);
        GridPane.setHgrow(extractSubRight, Priority.ALWAYS);
        
        
        //
        
        
        
        stepTwoRenameSub = new GridPane();
        renameLabel = new Label(props.getProperty(RENAME_LABEL_TEXT)); 
        renameDiscLabel = new Label(props.getProperty(RENAME_DISC_TEXT)); 
        renameList = new ListView();
        renameText = new TextField();
        renameText.setPrefHeight(424);
        renameText.setPrefWidth(650);
        renameButton = new Button (props.getProperty(RENAME_SUB_BUTTON_TEXT)); 
        renameProgLabel = new Label(props.getProperty(RENAME_PROGLABEL_TEXT));
        renameProgBar = new ProgressBar();
        renameProgBar.setMaxWidth(400);
        renameLeft = new VBox();
        renameLeft.setPrefWidth(650);
        renameLeft.setSpacing(3);
        renameRight = new GridPane();
        renameRight.setVgap(5);
        
        removeRenameButton = new Button(props.getProperty(REMOVE_BUTTON_TEXT));
        refreshRenameButton = new Button(props.getProperty(REFRESH_BUTTON_TEXT));
        viewRenameButton = new Button(props.getProperty(VIEW_BUTTON_TEXT));
        stepTwo = new HBox();
        stepTwo.setSpacing(50);
        stepTwo.getChildren().addAll(removeRenameButton, refreshRenameButton, viewRenameButton);
        
        renameLeft.getChildren().addAll(renameLabel, renameDiscLabel,renameList, stepTwo);
        renameRight.add(renameProgLabel, 0, 0);
        renameRight.add(renameProgBar, 1, 0);
        renameRight.add(renameButton, 0, 1);
        renameRight.add(renameText, 0, 3, 2, 1);
        
        stepTwoRenameSub.setHgap(20);
        stepTwoRenameSub.add(renameLeft, 0, 0);
        stepTwoRenameSub.add(renameRight, 1, 0);
        
        //
        
        stepThreeUnzip = new GridPane();
        unzipLabel = new Label(props.getProperty(UNZIP_LABEL_TEXT)); 
        unzipDiscLabel = new Label(props.getProperty(UNZIP_DISC_TEXT)); 
        unzipList = new ListView();
        unzipText = new TextField();
        unzipText.setPrefHeight(424);
        unzipText.setPrefWidth(650);
        unzipButton = new Button (props.getProperty(UNZIP_BUTTON_TEXT)); 
        unzipProgLabel = new Label(props.getProperty(UNZIP_PROGLABEL_TEXT));
        unzipProgBar = new ProgressBar();
        unzipProgBar.setMaxWidth(400);
        
        removeUnzipButton = new Button(props.getProperty(REMOVE_BUTTON_TEXT));
        refreshUnzipButton = new Button(props.getProperty(REFRESH_BUTTON_TEXT));
        viewUnzipButton = new Button(props.getProperty(VIEW_BUTTON_TEXT));
        stepThree = new HBox();
        stepThree.setSpacing(50);
        stepThree.getChildren().addAll(removeUnzipButton, refreshUnzipButton, viewUnzipButton);
        
        unzipLeft = new VBox();
        unzipLeft.setPrefWidth(650);
        unzipLeft.setSpacing(3);
        unzipLeft.getChildren().addAll(unzipLabel, unzipDiscLabel,unzipList, stepThree);
        
        unzipRight = new GridPane();
        unzipRight.setVgap(5);
        unzipRight.add(unzipProgLabel, 0, 0);
        unzipRight.add(unzipProgBar, 1, 0);
        unzipRight.add(unzipButton, 0, 1);
        unzipRight.add(unzipText, 0, 3, 2, 1);
       
        stepThreeUnzip.setHgap(20);
        stepThreeUnzip.add(unzipLeft, 0, 0);
        stepThreeUnzip.add(unzipRight, 1, 0);
        
        //
        
        stepFourExtractCode = new GridPane();
        extractCodeLabel = new Label(props.getProperty(EXTRACT_CODE_LABEL_TEXT)); 
        extractCodeDiscLabel = new Label(props.getProperty(EXTRACT_CODE_DISC_TEXT)); 
        extractCodeList = new ListView();
        extractCodeText = new TextField();
        extractCodeText.setPrefHeight(424);
        extractCodeText.setPrefWidth(650);
        extractCodeButton = new Button (props.getProperty(EXTRACT_CODE_BUTTON_TEXT)); 
        extractCodeProgLabel = new Label(props.getProperty(EXTRACT_CODE_PROGLABEL_TEXT));
        extractCodeProgBar = new ProgressBar();
        extractCodeProgBar.setMaxWidth(400);
        
        removeExtractCodeButton = new Button(props.getProperty(REMOVE_BUTTON_TEXT));
        refreshExtractCodeButton = new Button(props.getProperty(REFRESH_BUTTON_TEXT));
        viewExtractCodeButton = new Button(props.getProperty(VIEW_BUTTON_TEXT));
        stepFour = new HBox();
        stepFour.setSpacing(50);
        stepFour.getChildren().addAll(removeExtractCodeButton, refreshExtractCodeButton, viewExtractCodeButton);
        
        extractCodeLeft = new VBox();
        extractCodeLeft.setPrefWidth(650);
        extractCodeLeft.setSpacing(3);
        extractCodeLeft.getChildren().addAll(extractCodeLabel, extractCodeDiscLabel,extractCodeList, stepFour);
        
        extractCodeRight = new GridPane();
        extractCodeRight.setVgap(5);
        extractCodeRight.add(extractCodeProgLabel, 0, 0);
        extractCodeRight.add(extractCodeProgBar, 1, 0);
        extractCodeRight.add(extractCodeButton, 0, 1);
        extractCodeRight.add(extractCodeText, 0, 3, 2, 1);
       
        stepFourExtractCode.setHgap(20);
        stepFourExtractCode.add(extractCodeLeft, 0, 0);
        stepFourExtractCode.add(extractCodeRight, 1, 0);
        
        //
        
        
        stepFiveCodeCheck = new GridPane();
        codeCheckLabel = new Label(props.getProperty(CODE_CHECK_LABEL_TEXT)); 
        codeCheckDiscLabel = new Label(props.getProperty(CODE_CHECK_DISC_TEXT)); 
        codeCheckList = new ListView();
        codeCheckText = new TextField();
        codeCheckText.setPrefHeight(424);
        codeCheckText.setPrefWidth(650);
        codeCheckButton = new Button (props.getProperty(CODE_CHECK_BUTTON_TEXT)); 
        codeCheckProgLabel = new Label(props.getProperty(CODE_CHECK_PROGLABEL_TEXT));
        codeCheckProgBar = new ProgressBar();
        codeCheckProgBar.setMaxWidth(400);
        
        removeCodeCheckButton = new Button(props.getProperty(REMOVE_BUTTON_TEXT));
        refreshCodeCheckButton = new Button(props.getProperty(REFRESH_BUTTON_TEXT));
        viewCodeCheckButton = new Button(props.getProperty(VIEW_BUTTON_TEXT));
        stepFive = new HBox();
        stepFive.setSpacing(50);
        stepFive.getChildren().addAll(removeCodeCheckButton, refreshCodeCheckButton, viewCodeCheckButton);
        
        codeCheckLeft = new VBox();
        codeCheckLeft.setPrefWidth(650);
        codeCheckLeft.setSpacing(3);
        codeCheckLeft.getChildren().addAll(codeCheckLabel, codeCheckDiscLabel,codeCheckList, stepFive);
        
        codeCheckRight = new GridPane();
        codeCheckRight.setVgap(5);
        codeCheckRight.add(codeCheckProgLabel, 0, 0);
        codeCheckRight.add(codeCheckProgBar, 1, 0);
        codeCheckRight.add(codeCheckButton, 0, 1);
        codeCheckRight.add(codeCheckText, 0, 3, 2, 1);
        
        stepFiveCodeCheck.setHgap(20);
        stepFiveCodeCheck.add(codeCheckLeft, 0, 0);
        stepFiveCodeCheck.add(codeCheckRight, 1, 0);
        
        aboutTitle = new Label(props.getProperty(APP_TITLE));
        aboutAuthor = new Label(props.getProperty(APP_AUTHOR));
        aboutYear = new Label(props.getProperty(APP_YEAR));
        
        
        aboutDisc = new Label(props.getProperty(APP_DISC));
        aboutbox = new VBox();
        aboutbox.getChildren().addAll(aboutTitle, aboutAuthor, aboutYear, aboutDisc);
        aboutDisc.setPrefHeight(250);
        //aboutDisc.setEditable(false);
        aboutDisc.setWrapText(true);
        
        //aboutDisc.appendText(props.getProperty(APP_DISC));
        primary = new Stage();
        ab = new Scene(aboutbox, 400,350);
        
        
        
    }

    private void initContollers() {
        
        Node currentPane = app.getGUI().getAppPane().getCenter();
        
        nextButton.setOnAction(e->{
            
            if(app.getGUI().getAppPane().getCenter().equals(stepOneExtractSub)){
                app.getGUI().getAppPane().setCenter(stepTwoRenameSub);
                
            }else if (app.getGUI().getAppPane().getCenter().equals(stepTwoRenameSub)){
               app.getGUI().getAppPane().setCenter(stepThreeUnzip);
                
            }else if (app.getGUI().getAppPane().getCenter().equals(stepThreeUnzip)){
               app.getGUI().getAppPane().setCenter(stepFourExtractCode);
            
            }else if (app.getGUI().getAppPane().getCenter().equals(stepFourExtractCode)){ 
                app.getGUI().getAppPane().setCenter(stepFiveCodeCheck);
                
            }
            updateButtons();
        });
        
        prevButton.setOnAction(e->{
            
            if(app.getGUI().getAppPane().getCenter().equals(stepFiveCodeCheck)){
                app.getGUI().getAppPane().setCenter(stepFourExtractCode);
                
            }else if (app.getGUI().getAppPane().getCenter().equals(stepFourExtractCode)){
               app.getGUI().getAppPane().setCenter(stepThreeUnzip);
                
            }else if (app.getGUI().getAppPane().getCenter().equals(stepThreeUnzip)){
               app.getGUI().getAppPane().setCenter(stepTwoRenameSub);
            
            }else if (app.getGUI().getAppPane().getCenter().equals(stepTwoRenameSub)){ 
                app.getGUI().getAppPane().setCenter(stepOneExtractSub);
               
                
            }
            updateButtons();
        });
        
        homeButton.setOnAction(e->{
            if(!app.getGUI().getAppPane().getCenter().equals(stepOneExtractSub)){
                app.getGUI().getAppPane().setCenter(stepOneExtractSub);
                
            }
            
            updateButtons();
            
        });
        
        
        app.getGUI().getAboutButton().setOnAction(e->{
            
            primary.setScene(ab);
            primary.show();
        });
        
    
    }

    @Override
    public void resetWorkspace() {
        CodeCheckData data = (CodeCheckData)app.getDataComponent();
        data.resetData();
    
    
    }

    @Override
    public void reloadWorkspace(AppDataComponent dataComponent) {
        
    
    }

    private void initStyle() {
        nextButton.getStyleClass().add(CLASS_EDIT_BUTTON);
        prevButton.getStyleClass().add(CLASS_EDIT_BUTTON);
        homeButton.getStyleClass().add(CLASS_EDIT_BUTTON);
        
        extractSubLabel.getStyleClass().add(CLASS_PROMPT_LABEL);
        extractSubDiscLabel.getStyleClass().add(CLASS_DISC_LABEL);
        extractSubButton.getStyleClass().add(CLASS_ACTION_BUTTON);
        extractSubProgLabel.getStyleClass().add(CLASS_DISC_LABEL);
        removeExtractSubButton.getStyleClass().add(CLASS_ACTION_BUTTON);
        refreshExtractSubButton.getStyleClass().add(CLASS_ACTION_BUTTON);
        viewExtractSubButton.getStyleClass().add(CLASS_ACTION_BUTTON); 
        
        renameLabel.getStyleClass().add(CLASS_PROMPT_LABEL);
        renameDiscLabel.getStyleClass().add(CLASS_DISC_LABEL);
        renameButton.getStyleClass().add(CLASS_ACTION_BUTTON);
        renameProgLabel.getStyleClass().add(CLASS_DISC_LABEL);
        removeRenameButton.getStyleClass().add(CLASS_ACTION_BUTTON);
        refreshRenameButton.getStyleClass().add(CLASS_ACTION_BUTTON);
        viewRenameButton.getStyleClass().add(CLASS_ACTION_BUTTON); 
        
        unzipLabel.getStyleClass().add(CLASS_PROMPT_LABEL);
        unzipDiscLabel.getStyleClass().add(CLASS_DISC_LABEL);
        unzipButton.getStyleClass().add(CLASS_ACTION_BUTTON);
        unzipProgLabel.getStyleClass().add(CLASS_DISC_LABEL);
        removeUnzipButton.getStyleClass().add(CLASS_ACTION_BUTTON);
        refreshUnzipButton.getStyleClass().add(CLASS_ACTION_BUTTON);
        viewUnzipButton.getStyleClass().add(CLASS_ACTION_BUTTON); 
        
        extractCodeLabel.getStyleClass().add(CLASS_PROMPT_LABEL);
        extractCodeDiscLabel.getStyleClass().add(CLASS_DISC_LABEL);
        extractCodeButton.getStyleClass().add(CLASS_ACTION_BUTTON);
        extractCodeProgLabel.getStyleClass().add(CLASS_DISC_LABEL);
        removeExtractCodeButton.getStyleClass().add(CLASS_ACTION_BUTTON);
        refreshExtractCodeButton.getStyleClass().add(CLASS_ACTION_BUTTON);
        viewExtractCodeButton.getStyleClass().add(CLASS_ACTION_BUTTON); 
        
        codeCheckLabel.getStyleClass().add(CLASS_PROMPT_LABEL);
        codeCheckDiscLabel.getStyleClass().add(CLASS_DISC_LABEL);
        codeCheckButton.getStyleClass().add(CLASS_ACTION_BUTTON);
        codeCheckProgLabel.getStyleClass().add(CLASS_DISC_LABEL);
        removeCodeCheckButton.getStyleClass().add(CLASS_ACTION_BUTTON);
        refreshCodeCheckButton.getStyleClass().add(CLASS_ACTION_BUTTON);
        viewCodeCheckButton.getStyleClass().add(CLASS_ACTION_BUTTON);
        
        
        
        aboutTitle.getStyleClass().add(CLASS_PROMPT_LABEL); 
        aboutAuthor.getStyleClass().add(CLASS_PROMPT_LABEL);
        aboutYear.getStyleClass().add(CLASS_PROMPT_LABEL);
        
        aboutDisc.getStyleClass().add(CLASS_DISC_LABEL);
        
    
    
    }

    private void updateButtons() {
        if(!app.getGUI().getAppPane().getCenter().equals(stepOneExtractSub)){
            prevButton.setDisable(false);
            homeButton.setDisable(false);
        }else{
            homeButton.setDisable(true);
            prevButton.setDisable(true);
        }
        
        if(!app.getGUI().getAppPane().getCenter().equals(stepFiveCodeCheck)){
            nextButton.setDisable(false);
        }else{
            nextButton.setDisable(true);
        }
        
        
    
    
    
    }
    
    
    
}


