/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.file;

import cc.CodeCheckApp;
import cc.data.CodeCheckData;
import cc.workspace.CodeCheckWorkspace;
import djf.components.AppDataComponent;
import djf.components.AppFileComponent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonWriter;
import javax.json.JsonWriterFactory;
import javax.json.stream.JsonGenerator;

/**
 *
 * @author Yogi
 */
public class CodeCheckFiles implements AppFileComponent{
    CodeCheckApp app;
    static final String JSON_SLIDES = "slides";
    static final String JSON_SLIDE = "slide";
    static final String JSON_FILE_NAME = "file_name";
    static final String JSON_PATH = "path";
    static final String JSON_TITLE = "title";
    static final String JSON_RECENT = "recent_files";
    
    public CodeCheckFiles(CodeCheckApp initapp){
        app = initapp;
    }

    @Override
    public void saveData(AppDataComponent data, String filePath) throws IOException {
        // GET THE DATA
        
	CodeCheckData dataManager = (CodeCheckData)data;
        CodeCheckWorkspace workspace = (CodeCheckWorkspace)app.getWorkspaceComponent();
        
	// NOW BUILD THE SLIDES JSON OBJECTS TO SAVE
	JsonArrayBuilder slidesArrayBuilder = Json.createArrayBuilder();
	ObservableList<GridPane> panes = dataManager.getPanes();
	/*for (GridPane gridpane : panes) {	    
	    JsonObject slideJson = Json.createObjectBuilder()
		    .add(JSON_FILE_NAME, slide.getFileName())
                    .add(JSON_PATH, slide.getPath())
                    .add(JSON_CAPTION, slide.getCaption())
                    .add(JSON_ORIGINAL_WIDTH, slide.getOriginalWidth())
                    .add(JSON_ORIGINAL_HEIGHT, slide.getOriginalHeight())
                    .add(JSON_CURRENT_WIDTH, slide.getCurrentWidth())
                    .add(JSON_CURRENT_HEIGHT, slide.getCurrentHeight()).build();
	    slidesArrayBuilder.add(slideJson);
	}*/
	JsonArray slidesArray = slidesArrayBuilder.build();
        //JsonObject titleJson = Json.createObjectBuilder().add(JSON_TITLE, workspace.);
        
        
	// THEN PUT IT ALL TOGETHER IN A JsonObject
        JsonObject dataManagerJSO;
        
	dataManagerJSO = Json.createObjectBuilder()
		.add(JSON_TITLE, app.getGUI().getAppTitle())
		.build();
        //JsonObject recentFiles = Json.createObjectBuilder().
        
	// AND NOW OUTPUT IT TO A JSON FILE WITH PRETTY PRINTING
	Map<String, Object> properties = new HashMap<>(1);
	properties.put(JsonGenerator.PRETTY_PRINTING, true);
	JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
	StringWriter sw = new StringWriter();
	JsonWriter jsonWriter = writerFactory.createWriter(sw);
	jsonWriter.writeObject(dataManagerJSO);
	jsonWriter.close();

	// INIT THE WRITER
	OutputStream os = new FileOutputStream(filePath);
	JsonWriter jsonFileWriter = Json.createWriter(os);
	jsonFileWriter.writeObject(dataManagerJSO);
	String prettyPrinted = sw.toString();
	PrintWriter pw = new PrintWriter(filePath);
	pw.write(prettyPrinted);
	pw.close();
    
    
    
    }

    @Override
    public void loadData(AppDataComponent data, String filePath) throws IOException {
        // LOAD THE JSON FILE WITH ALL THE DATA
	JsonObject json = loadJSONFile(filePath);
System.out.println("nisnwci");
      
        File f = new File("recentFiles");
        if(!f.exists()){
           f = new File("recentFiles");
        }
        
        //JsonObject recentFiles = loadJSONFile("recentFiles");
        
        //recentFiles = Json.createObjectBuilder().add(JSON_RECENT, filePath).build();
        
        
        /*
        Map<String, Object> properties = new HashMap<>(1);
	properties.put(JsonGenerator.PRETTY_PRINTING, true);
	JsonWriterFactory writerFactory = Json.createWriterFactory(properties);
	StringWriter sw = new StringWriter();
	JsonWriter jsonWriter = writerFactory.createWriter(sw);
	//jsonWriter.writeObject(recentFiles);
	jsonWriter.close();

	// INIT THE WRITER
	OutputStream os = new FileOutputStream(filePath);
	JsonWriter jsonFileWriter = Json.createWriter(os);
	//jsonFileWriter.writeObject(recentFiles);
	String prettyPrinted = sw.toString();
	PrintWriter pw = new PrintWriter(filePath);
	pw.write(prettyPrinted);
	pw.close();        
        */
        
	// CLEAR THE OLD DATA OUT
	CodeCheckData dataManager = (CodeCheckData)data;
        dataManager.resetData();

        // NOW LOAD ALL THE DATA FROM THE json OBJECT
        JsonArray jsonSlidesArray = json.getJsonArray(JSON_SLIDES);
        /*for (int i = 0; i < jsonSlidesArray.size(); i++) {
            JsonObject jsonSlide = jsonSlidesArray.getJsonObject(i);
            String fileName = jsonSlide.getString(JSON_FILE_NAME);
            String path = jsonSlide.getString(JSON_PATH);
            String caption = jsonSlide.getString(JSON_CAPTION);
            int originalWidth = jsonSlide.getInt(JSON_ORIGINAL_WIDTH);
            int originalHeight = jsonSlide.getInt(JSON_ORIGINAL_HEIGHT);
            int currentWidth = jsonSlide.getInt(JSON_CURRENT_WIDTH);
            int currentHeight = jsonSlide.getInt(JSON_CURRENT_HEIGHT);
            dataManager.addSlide(fileName, path, caption, originalWidth, originalHeight, currentWidth, currentHeight);
        }*/
        
        
        CodeCheckWorkspace workspace = (CodeCheckWorkspace)app.getWorkspaceComponent();
        JsonString jsontitle = json.getJsonString(JSON_TITLE);
        String tit = jsontitle.getString();
        app.getGUI().setAppTitle(tit);
       
        
    
    
    
    }

    @Override
    public void exportData(AppDataComponent data, String filePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void importData(AppDataComponent data, String filePath) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     private JsonObject loadJSONFile(String jsonFilePath) throws IOException {
	InputStream is = new FileInputStream(jsonFilePath);
	JsonReader jsonReader = Json.createReader(is);
	JsonObject json = jsonReader.readObject();
	jsonReader.close();
	is.close();
	return json;
    }
    
}
