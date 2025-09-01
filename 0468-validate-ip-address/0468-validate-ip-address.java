class Solution {
    public String validIPAddress(String queryIP) {
        if (validIpv4(queryIP)) {
            return "IPv4";
        } else if (validIpv6(queryIP)) {
            return "IPv6";
        }

        return "Neither";
    }

    boolean validIpv4(String q) {
        String[] sq = q.split("\\.", -1);

        if (sq.length != 4) {
            return false;
        }

        for (String s : sq) {
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return false;
                }
            }

            if (s.length() > 1 && s.charAt(0) == '0') {
                return false;
            }

            if (s.isEmpty() || s.length() > 3 || Integer.parseInt(s) > 255) {
                return false;
            }
        }

        return true;
    }

    boolean validIpv6(String q) {
        String[] sq = q.split("\\:", -1);
        System.out.println(Arrays.toString(sq));
        if (sq.length != 8) {
            return false;
        }

        for (String s : sq) {
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c) && !((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                    return false;
                }
            }

            if (s.isEmpty() || s.length() > 4) {
                return false;
            }
        }

        return true;
    }
}