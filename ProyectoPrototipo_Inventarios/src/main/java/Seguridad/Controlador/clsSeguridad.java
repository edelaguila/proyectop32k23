
package seguridad.controlador;

import java.io.UnsupportedEncodingException;
import java.util.Base64;


public class clsSeguridad {

    
 public String encode(String s) {
String respuesta = "error";
try {
respuesta = new String(Base64.getEncoder().encode(s.getBytes("UTF8")),"UTF-8");
} catch (UnsupportedEncodingException e) {
e.printStackTrace();
}
return respuesta;
}
        
public String decode(String s) {
String respuesta = "error";
try {
respuesta = new String(Base64.getDecoder().decode(s.getBytes("UTF8")),"UTF-8");
} catch (UnsupportedEncodingException e) {
e.printStackTrace();
}
return respuesta;
}        
      
    
}
