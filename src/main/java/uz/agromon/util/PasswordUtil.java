package uz.agromon.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    //
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public static boolean isValidPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
