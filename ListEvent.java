package earthquakemonitoring;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Richard and Aileen
 */
public class ListEvent implements Initializable {
 private TextField nam_o;
 private TextField val_col;
 private Button query;
 private TableView table_id;
 private TableView[] table;
    Galamseydb g_db;
    private TableColumn i_id;
    private TableColumn v_id;
    private TableColumn c_id;
    private TableColumn l_id;
    private TableColumn o_id;
    private TableColumn y_id;

    /**
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /**
     *This method changes the screen to "Observatory_Data.fxml"
     * @param actionEvent
     * @throws IOException
     */
    public void back(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent screen_two= FXMLLoader.load(getClass().getResource("Observatory_Data.fxml"));
        Scene scene = new Scene(screen_two);
        Stage s_two=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        s_two.setScene(scene);
        s_two.show();
    }

    /**
     *This method prints out a list of galamsey events greater than the value inputted
     * @param actionEvent
     * @throws IOException
     * @throws SQLException
     */
    public void que(javafx.event.ActionEvent actionEvent) throws IOException, SQLException {
       try {
           String query = "select * from galamsey where col_val >" + col_id.getText();
           Statement st = g_db.connect().createStatement();
           st.executeQuery(query);
           ResultSet rs = st.executeQuery(query);//executes the query
           String galamseyData = "";//assigns data fetched from database
           while (rs.next()) {// shifts pointer to next row and returns true if there
               //is a next row
               galamseyData +=  rs.getString("GID")+":"+ rs.getString("veg_col")+":"+rs.getString("col_val")+":"+
                       Double.parseDouble(rs.getString("latitude"))+":"+Double.parseDouble(rs.getString("longitude"))+":"+
                       Integer.parseInt(rs.getString("year_started")) + "\n";

           }
        
       public void initialize(URL url, ResourceBundle){
   
           p_id.setCellValueFactory(new PropertyValueFactory<TableContent, Integer>("i_id"));
           m_id.setCellValueFactory(new PropertyValueFactory<TableContent, String>("v_id"));
           k_id.setCellValueFactory(new PropertyValueFactory<TableContent, String>("c_id"));
           n_id.setCellValueFactory(new PropertyValueFactory<TableContent, Double>("l_id"));
           j_id.setCellValueFactory(new PropertyValueFactory<TableContent, Double>("o_id"));
           u_id.setCellValueFactory(new PropertyValueFactory<TableContent, Integer>("y_id"));

           table_id.setItems(getContent())
       }
     
     public ObservableList<TableContent> getContent() {
      ArrayList<string[]> list = g_db.getAllGal1();
      for(String[] p:list ){
       data.add(new TableContent( Integer.parseInt(p[0]),p[1],p[2],
                                 Double.parseDouble(p[3]), Double.ParseDouble(p[4])'
                                 Integer.parseInt(p[5])));
      
      }
     
     }



       } catch (Exception e) {
           System.out.println(e);
       }
   }



  
}
