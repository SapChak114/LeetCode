public class Codec {
    Map<String, String> enec = new HashMap<>();
    Map<String, String> deco = new HashMap<>();
    String baseUrl = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (!enec.containsKey(longUrl)) {
            String shortUrl = baseUrl + (enec.size() + 1);
            enec.put(longUrl, shortUrl);
            deco.put(shortUrl, longUrl);
            return shortUrl;
        } else {
            return enec.get(longUrl);
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return deco.getOrDefault(shortUrl, "");
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));