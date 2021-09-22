package co.unicauca.commandRestaurant.infra;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Utilidades varias utilizadas por otras clases
 *
 * @author Michel Andrea Gutierrez Vallejo, Mannuel Fernando Granoble Pino 
 */
public class Utilities {

    /**
     * Cargar una propiedadd de config.properties
     *
     * @param key llave de la propiedad
     * @return valor de la propiedad
     */
    public static String loadProperty(String key) {
        Properties prop = new Properties();
        InputStream is;

        try {
            is = new FileInputStream("./config.properties");
            prop.load(is);
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo");
        }

        return prop.getProperty(key);
    }

    /**
     * Verifica si un String contiene sólo digitos
     *
     * @param str Cadena a verificvar
     * @return true si contiene sólo digitos, false en caso contrario
     */
    public static boolean isNumeric(String str) {

        boolean resultado;

        try {
            Long.parseLong(str);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    /**
     * Pone en mayúsculas la primera letra de una frase
     *
     * @param text texto ser capitalizado
     * @return texto capitalizado
     */
    public static String capitalize(String text) {
        if (!text.isEmpty()) {
            StringBuffer sbt = new StringBuffer();
            String[] partialText = text.split(" ");
            for (int i = 0; i < partialText.length; i++) {
                if (!partialText[i].equals("")) {

                    if (partialText[i].contains("-")) { //composite words
                        sbt.append(capitalizeWithLine(partialText[i]));
                    } else {
                        sbt.append(capitalizeWord(partialText[i]));
                        sbt.append(" ");
                    }
                }
            }
            return sbt.toString().trim(); //only for entire phrase
        }
        return text;
    }

    /**
     * Método privado utilizado por capitalize(String text)
     *
     * @param word
     * @return
     */
    private static String capitalizeWord(String word) {
        if (!word.isEmpty()) {
            StringBuffer sb = new StringBuffer();
            sb.append(String.valueOf(word.charAt(0)).toUpperCase());

            if (word.length() >= 2) {
                sb.append(word.substring(1).toLowerCase());
            }

            return sb.toString();
        }
        return word;
    }

    /**
     * Método privado utilizado por capitalize(String text)
     *
     * @param word
     * @return
     */
    private static String capitalizeWithLine(String wordWithLine) {
        StringBuffer res = new StringBuffer();
        String[] partialTextWithLine = wordWithLine.split("-");
        for (int r = 0; r < partialTextWithLine.length; r++) {
            res.append(capitalizeWord(partialTextWithLine[r]));
            if (r + 1 < partialTextWithLine.length) //not append to end
            {
                res.append("-");
            }
        }
        return res.toString();
    }
    
    /**
     * Metodo encargado de encriptar una cadena
     * @param sinCifrar Cadena a encriptar
     * @return un arreglo encriptado
     * @throws Exception 
     */
    public static byte[] encriptar(String sinCifrar) throws Exception {
        final byte[] bytes = sinCifrar.getBytes("UTF-8");
        final Cipher aes = obtieneCipher(true);
        final byte[] cifrado = aes.doFinal(bytes);
        return cifrado;
    }

    /**
     * Metodo que desencripta una cadena cifrada
     * @param cifrado Cadena cifrada
     * @return  Cadena decifrada
     * @throws Exception 
     */
    public static String desEncriptar(byte[] cifrado) throws Exception {
        final Cipher aes = obtieneCipher(false);
        final byte[] bytes = aes.doFinal(cifrado);
        final String sinCifrar = new String(bytes, "UTF-8");
        return sinCifrar;
    }

    public static Cipher obtieneCipher(boolean paraCifrar) throws Exception {
        final String frase = "FraseLargaConDiferentesLetrasNumerosYCaracteresEspeciales_áÁéÉíÍóÓúÚüÜñÑ1234567890!#%$&()=%_NO_USAR_ESTA_FRASE!_";
        final MessageDigest digest = MessageDigest.getInstance("SHA");
        digest.update(frase.getBytes("UTF-8"));
        final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");

        final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        if (paraCifrar) {
            aes.init(Cipher.ENCRYPT_MODE, key);
        } else {
            aes.init(Cipher.DECRYPT_MODE, key);
        }

        return aes;
    }
}
