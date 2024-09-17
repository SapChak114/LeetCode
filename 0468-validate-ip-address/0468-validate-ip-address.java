import java.util.regex.Pattern;
class Solution {
    public String validIPAddress(String IP) {

        String v4Pattern = "(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        
        String v6Pattern = "((([0-9a-fA-F]){1,4})\\:){7}([0-9a-fA-F]){1,4}";

        Pattern v4 = Pattern.compile(v4Pattern);
        Pattern v6 = Pattern.compile(v6Pattern);

        if (v4.matcher(IP).matches()) {
            return "IPv4";
        }

        if (v6.matcher(IP).matches()) {
            return "IPv6";
        }

        return "Neither";
    }
}