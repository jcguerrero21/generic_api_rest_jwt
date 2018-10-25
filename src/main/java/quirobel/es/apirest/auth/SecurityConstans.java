package quirobel.es.apirest.auth;

public class SecurityConstans {

    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 60000L;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/rest/insertar-usuario";
    public static final String REFRES_TOKEN = "/rest/refrescar";

}
