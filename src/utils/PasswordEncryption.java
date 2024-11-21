package utils;
import utils.bcrypt.BCrypt;
public class PasswordEncryption {
    
    public PasswordEncryption(){}
     public static String hashPassword(String plainPassword) {
        int saltRounds = 12; 
        String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt(saltRounds));
        return hashedPassword;
    }

    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }  
}
