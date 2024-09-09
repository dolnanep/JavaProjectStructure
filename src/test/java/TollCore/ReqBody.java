package TollCore;

import org.json.JSONObject;

public class ReqBody {
        public static JSONObject requestBodyLoginSuccess(String EmployeeId, String Password){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("EmployeeId", "040001")
                    .put("Password", "1");
            return jsonObject;
        }
        public static JSONObject requestBodyLoginFail(String EmployeeId, String Password){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("EmployeeId", "040002")
                    .put("Password", "1");
            return jsonObject;
        }
}
