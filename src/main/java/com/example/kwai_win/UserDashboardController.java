package com.example.kwai_win;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.chart.*;

// These imports are for using JDBC
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDashboardController implements Initializable{

    KWAiUser user = loginController.user;
    int userID = user.getUID();

    private Stage stage;
    private Scene scene;
    private Parent root;

//    @FXML
//    private LineChart lineChart;
    @FXML
    private Label aro;
    @FXML
    private Label val;
    @FXML
    private Label avg;
    @FXML
    private Label viz;
    @FXML
    private LineChart lineChart;

    @FXML
    private Parent rooter;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginMessagelabel;
    @FXML
    private TextField usernameTextfield;
    @FXML
    private PasswordField passwordPasswordField;

    @Override
    public void initialize(URL url, ResourceBundle rb)  {

        int arousal = 0;
        int valence = 0;

        try {
            // Database Connection stuff
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try {
                String lastArousal = "SELECT aScore FROM Takes WHERE uID = " + userID + " ORDER BY date DESC LIMIT 1;";
                Statement statement = connectDB.createStatement();
                ResultSet queryResult1 = statement.executeQuery(lastArousal);

                while(queryResult1.next()) {
                    if (queryResult1.getInt(1) == 1) {
                        arousal = queryResult1.getInt("aScore");
                    } else {
                        aro.setText("N/A");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Database Connection stuff
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try {
                String lastValence = "SELECT vScore FROM Takes WHERE uID = " + userID + " ORDER BY date DESC LIMIT 1;";
                Statement statement = connectDB.createStatement();
                ResultSet queryResult2  = statement.executeQuery(lastValence);

                while(queryResult2.next()) {
                    if (queryResult2.getInt(1) == 1) {
                        valence = queryResult2.getInt("vScore");
                    } else {
                        val.setText("N/A");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // if query was successful, these should set to the arousal and valence from the latest emotional assessment that the user completed
        aro.setText(" " + arousal + " ");
        val.setText(" " + valence + " ");

        int average = (arousal + valence)/ 2;
        avg.setText("" + average + "");


        String lastVisual = "";
        try {
            // Database Connection stuff
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try {
                String lastViz = "SELECT vID FROM Creates WHERE uID = " + userID + " ORDER BY date DESC LIMIT 1;";
                Statement statement = connectDB.createStatement();
                ResultSet queryResult2  = statement.executeQuery(lastViz);

                while(queryResult2.next()) {
                    if (queryResult2.getInt(1) == 1) {
                        lastVisual = queryResult2.getString("vID");
                    } else {
                        viz.setText("N/A");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        viz.setText(lastVisual);


        showLineCharts();


    }

    @FXML
    void showLineCharts(){
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("No of employees");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Revenue per employee");

        lineChart = new LineChart(xAxis, yAxis);
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("2014");

        dataSeries1.getData().add(new XYChart.Data( 1, 567));
        dataSeries1.getData().add(new XYChart.Data( 5, 612));
        dataSeries1.getData().add(new XYChart.Data(10, 800));
        dataSeries1.getData().add(new XYChart.Data(20, 780));
        dataSeries1.getData().add(new XYChart.Data(40, 810));
        dataSeries1.getData().add(new XYChart.Data(80, 850));

        lineChart.getData().add(dataSeries1);
    }

    // SQL Query for Last xx days: SELECT AVG(aScore) AS 'avgArousal' FROM Takes WHERE date >= DATE_ADD(NOW(), INTERVAL 30 DAY) AND uID = 50;

    @FXML
    void home(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        stage = (Stage)rooter.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void userDashboard(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("userdashboard.fxml"));
        stage = (Stage)rooter.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void login(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        stage = (Stage)rooter.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void latest(ActionEvent event) throws IOException {
        int arousal = 0;
        int valence = 0;

        try {
            // Database Connection stuff
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try {
                String lastArousal = "SELECT aScore FROM Takes WHERE uID = " + userID + " ORDER BY date DESC LIMIT 1;";
                Statement statement = connectDB.createStatement();
                ResultSet queryResult1 = statement.executeQuery(lastArousal);

                while(queryResult1.next()) {
                    if (queryResult1.getInt(1) == 1) {
                        arousal = queryResult1.getInt("aScore");
                    } else {
                        aro.setText("N/A");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Database Connection stuff
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try {
                String lastValence = "SELECT vScore FROM Takes WHERE uID = " + userID + " ORDER BY date DESC LIMIT 1;";
                Statement statement = connectDB.createStatement();
                ResultSet queryResult2  = statement.executeQuery(lastValence);

                while(queryResult2.next()) {
                    if (queryResult2.getInt(1) == 1) {
                        valence = queryResult2.getInt("vScore");
                    } else {
                        val.setText("N/A");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // if query was successful, these should set to the arousal and valence from the latest emotional assessment that the user completed
        aro.setText(" " + arousal + " ");
        val.setText(" " + valence + " ");

        int average = (arousal + valence)/ 2;
        avg.setText("" + average + "");


        String lastVisual = "";
        try {
            // Database Connection stuff
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try {
                String lastViz = "SELECT vID FROM Creates WHERE uID = " + userID + " ORDER BY date DESC LIMIT 1;";
                Statement statement = connectDB.createStatement();
                ResultSet queryResult2  = statement.executeQuery(lastViz);

                while(queryResult2.next()) {
                    if (queryResult2.getInt(1) == 1) {
                        lastVisual = queryResult2.getString("vID");
                    } else {
                        viz.setText("N/A");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        viz.setText(lastVisual);


        showLineCharts();
    }
    @FXML
    void oneWeek(ActionEvent event) throws IOException {
        int arousal = 0;
        int valence = 0;

        try {
            // Database Connection stuff
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try {
                String lastArousal = "SELECT AVG(aScore) as aScore FROM Takes WHERE uID = " + userID + " AND Date(date) >= CURDATE() - INTERVAL 7 day;";
                Statement statement = connectDB.createStatement();
                ResultSet queryResult1 = statement.executeQuery(lastArousal);

                while(queryResult1.next()) {
                    if (queryResult1.getInt(1) == 1) {
                        arousal = queryResult1.getInt("aScore");
                    } else {
                        aro.setText("N/A");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Database Connection stuff
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try {
                String lastValence = "SELECT AVG(vScore) as vScore FROM Takes WHERE uID = " + userID + " AND Date(date) >= CURDATE() - INTERVAL 7 day;";
                Statement statement = connectDB.createStatement();
                ResultSet queryResult2  = statement.executeQuery(lastValence);

                while(queryResult2.next()) {
                    if (queryResult2.getInt(1) == 1) {
                        valence = queryResult2.getInt("vScore");
                    } else {
                        val.setText("N/A");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // if query was successful, these should set to the arousal and valence from the latest emotional assessment that the user completed
        aro.setText(" " + arousal + " ");
        val.setText(" " + valence + " ");

        int average = (arousal + valence)/ 2;
        avg.setText("" + average + "");


        String lastVisual = "";
        try {
            // Database Connection stuff
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try {
                String lastViz = "SELECT vID FROM Creates WHERE uID = " + userID + " ORDER BY date DESC LIMIT 1;";
                Statement statement = connectDB.createStatement();
                ResultSet queryResult2  = statement.executeQuery(lastViz);

                while(queryResult2.next()) {
                    if (queryResult2.getInt(1) == 1) {
                        lastVisual = queryResult2.getString("vID");
                    } else {
                        viz.setText("N/A");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        viz.setText(lastVisual);


        showLineCharts();
    }
    @FXML
    void oneMonth(ActionEvent event) throws IOException {
        // NOTE: We define one month as the past 30 days
        int arousal = 0;
        int valence = 0;

        try {
            // Database Connection stuff
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try {
                String lastArousal = "SELECT AVG(aScore) as aScore FROM Takes WHERE uID = " + userID + " AND Date(date) >= CURDATE() - INTERVAL 30 day;";
                Statement statement = connectDB.createStatement();
                ResultSet queryResult1 = statement.executeQuery(lastArousal);

                while(queryResult1.next()) {
                    if (queryResult1.getInt(1) == 1) {
                        arousal = queryResult1.getInt("aScore");
                    } else {
                        aro.setText("N/A");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Database Connection stuff
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try {
                String lastValence = "SELECT AVG(vScore) as vScore FROM Takes WHERE uID = " + userID + " AND Date(date) >= CURDATE() - INTERVAL 30 day;";
                Statement statement = connectDB.createStatement();
                ResultSet queryResult2  = statement.executeQuery(lastValence);

                while(queryResult2.next()) {
                    if (queryResult2.getInt(1) == 1) {
                        valence = queryResult2.getInt("vScore");
                    } else {
                        val.setText("N/A");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // if query was successful, these should set to the arousal and valence from the latest emotional assessment that the user completed
        aro.setText(" " + arousal + " ");
        val.setText(" " + valence + " ");

        int average = (arousal + valence)/ 2;
        avg.setText("" + average + "");


        String lastVisual = "";
        try {
            // Database Connection stuff
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try {
                String lastViz = "SELECT vID FROM Creates WHERE uID = " + userID + " ORDER BY date DESC LIMIT 1;";
                Statement statement = connectDB.createStatement();
                ResultSet queryResult2  = statement.executeQuery(lastViz);

                while(queryResult2.next()) {
                    if (queryResult2.getInt(1) == 1) {
                        lastVisual = queryResult2.getString("vID");
                    } else {
                        viz.setText("N/A");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        viz.setText(lastVisual);


        showLineCharts();

    }
    @FXML
    void threeMonth(ActionEvent event) throws IOException {
        // NOTE: We define 3 months as the past 90 days
        int arousal = 0;
        int valence = 0;

        try {
            // Database Connection stuff
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try {
                String lastArousal = "SELECT AVG(aScore) as aScore FROM Takes WHERE uID = " + userID + " AND Date(date) >= CURDATE() - INTERVAL 90 day;";
                Statement statement = connectDB.createStatement();
                ResultSet queryResult1 = statement.executeQuery(lastArousal);

                while(queryResult1.next()) {
                    if (queryResult1.getInt(1) == 1) {
                        arousal = queryResult1.getInt("aScore");
                    } else {
                        aro.setText("N/A");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Database Connection stuff
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try {
                String lastValence = "SELECT AVG(vScore) as vScore FROM Takes WHERE uID = " + userID + " AND Date(date) >= CURDATE() - INTERVAL 90 day;";
                Statement statement = connectDB.createStatement();
                ResultSet queryResult2  = statement.executeQuery(lastValence);

                while(queryResult2.next()) {
                    if (queryResult2.getInt(1) == 1) {
                        valence = queryResult2.getInt("vScore");
                    } else {
                        val.setText("N/A");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // if query was successful, these should set to the arousal and valence from the latest emotional assessment that the user completed
        aro.setText(" " + arousal + " ");
        val.setText(" " + valence + " ");

        int average = (arousal + valence)/ 2;
        avg.setText("" + average + "");


        String lastVisual = "";
        try {
            // Database Connection stuff
            DatabaseConnection connection = new DatabaseConnection();
            Connection connectDB = connection.getConnection();

            try {
                String lastViz = "SELECT vID FROM Creates WHERE uID = " + userID + " ORDER BY date DESC LIMIT 1;";
                Statement statement = connectDB.createStatement();
                ResultSet queryResult2  = statement.executeQuery(lastViz);

                while(queryResult2.next()) {
                    if (queryResult2.getInt(1) == 1) {
                        lastVisual = queryResult2.getString("vID");
                    } else {
                        viz.setText("N/A");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        viz.setText(lastVisual);


        showLineCharts();
    }


}
