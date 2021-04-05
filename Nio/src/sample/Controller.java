package sample;

import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.imageio.ImageIO;
import java.awt.*;


import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import  javafx.scene.shape.Rectangle;


import static sample.Encryption.*;


public class Controller extends Component {

    @FXML
    private TextField UsernameLog;

    @FXML
    private PasswordField passwordLog;

    @FXML
    private Label label;

    @FXML
    private TextArea text;

    @FXML
    private Pane pane;

    @FXML
    private Pane paneLogin;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button myLoginButton;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField psw;

    @FXML
    private Rectangle box;

    @FXML
    private TextField emailAddress;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private Button logButton;

    @FXML
    private TextField userRole;


    private Connection con = null;
    private PreparedStatement pst = null;




    @FXML
    private void initialize() {
        pane.setVisible(false);
        myLoginButton.setVisible(false);


    }
    @FXML
    public void registerBtn(ActionEvent event)  {
        con = DBConnection.partConnection();

        pane.setVisible(true);
        myLoginButton.setVisible(true);
        pane.toFront();



    }
    @FXML
    private ImageView imageview;

    @FXML
    void showLoginScreen(ActionEvent event) {
        pane.toBack();
        pane.setVisible(false);

    }
    public byte[] extractBytes (String ImageName) throws IOException {
        // open image
        File imgPath = new File(ImageName);
        BufferedImage bufferedImage = ImageIO.read(imgPath);

        // get DataBufferBytes from Raster
        WritableRaster raster = bufferedImage .getRaster();
        DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

        return ( data.getData() );
    }
    @FXML
    void regSubmit(ActionEvent event) throws SQLException, NoSuchAlgorithmException, IOException {
        String sql = "Insert into SystemUsers(Username, FirstName, LastName, Pwd, EmailAddress,userRole) values (?,?,?,?,?,?);";
        String uN = userName.getText();
        String fN = firstName.getText();
        String lN = lastName.getText();
        String pw = psw.getText();
        String em = emailAddress.getText();
        Double us = Double.valueOf(userRole.getText());


        Encryption encryption = new Encryption();
        String ar = encrypt(encryption.key, encryption.initVector,pw);

     System.out.println(ar);
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, uN);
            pst.setString(2, fN);
            pst.setString(3, lN);
            pst.setString(4, ar);
            pst.setString(5, em);
            pst.setDouble(6, us);

            int i = pst.executeUpdate();
            if(i == 1){
                System.out.println("Data Insert Successfully");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            pst.close();

        }
    }

    @FXML
    void logButton(ActionEvent event) throws SQLException, NoSuchAlgorithmException {
        con = DBConnection.partConnection();

        String userNameLogin;
        userNameLogin = UsernameLog.getText();
        String passwordLogin = passwordLog.getText();
        Encryption encryption = new Encryption();
        try{
                String SQL = "Select * from SystemUsers where Username ='"+ userNameLogin +"'";
                Statement pst = con.createStatement();
                ResultSet rs = pst.executeQuery(SQL);

                if(rs.next()) {
                    // if username and password is true than go to HomePage
                    String EncryptedPassword = rs.getString("Pwd");
                    String ar = decrypt(encryption.key, encryption.initVector,EncryptedPassword);
                    System.out.println(passwordLogin.equals(ar));
                    if(passwordLogin.equals(ar)) {

                        System.out.println("yes");
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader();
                            fxmlLoader.setLocation(getClass().getResource("main.fxml"));
                            /*
                             * if "fx:controller" is not set in fxml
                             * fxmlLoader.setController(NewWindowController);
                             */
                            Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
                            Scene mainscene = new Scene(root, 630, 400);
                            Stage stage = new Stage();
                            stage.setTitle("New Window");
                            stage.setScene(mainscene);
                            stage.setMaximized(true);
                            stage.show();

                            // hide first login screen
                            ((Node)event.getSource()).getScene().getWindow().hide();



                        } catch (IOException e) {
                            Logger logger = Logger.getLogger(getClass().getName());
                            logger.log(Level.SEVERE, "Failed to create new Window.", e);
                        }
                    }


                }else {

                    System.out.println("Username or password wrong");
                    UsernameLog.setText(" ");
                    passwordLog.setText(" ");
                }



            }
            catch(SQLException e) {

                e.printStackTrace();

            }

            con.close();

        }


}


