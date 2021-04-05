//Credit: https://bittlife.com/aes-encryption-with-source-code-javafx/#comment-7157

package sample;


import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {

    public String key = "Jar12345Jar12345";
    public String initVector = "RandomInitVector";

    public static String encrypt(String key, String initVector, String value)
    {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(1, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());

            
           // return Base64.encode(encrypted);
            return Base64.getEncoder().encodeToString(encrypted);  
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String key, String initVector, String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, skeySpec, iv);
            
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
            
           

            return new String(original);
        } catch (Exception ex) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Input length must be multiple of 16",
                    ButtonType.CANCEL);
            a.show();
        }

        return null;
    }

    public static String encryptByte(String key, String initVector, byte[] value)
    {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = javax.crypto.Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(1, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value);

            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }



}
