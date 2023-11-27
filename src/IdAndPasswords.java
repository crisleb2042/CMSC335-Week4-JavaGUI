import java.util.HashMap;

public class IdAndPasswords {

    //Creates a copy of the HashMap of the login info
    HashMap<String, String> loginInfo = new HashMap<>();

    // Constructor uses .put method to put Credentials in HashMap.
    IdAndPasswords(){
        loginInfo.put("Student", "UMGC"); //ToDo: enable salted + encrypted passwords
    }

    protected HashMap getLoginInfo(){
        return loginInfo;
    }
}
