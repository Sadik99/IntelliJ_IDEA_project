public class Browser {
    public void navigate(String address){
      String ip= findIpAddress(address);
      String html=SendHttpRequest(ip);
        System.out.println(html);
    }

    private String SendHttpRequest(String ip) {
        return "<html></html>";
    }

    private String findIpAddress(String address) {
        return "127.0.0.1";
    }
}
