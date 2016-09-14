public class Base64 {

  private static final String base64code = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
      + "abcdefghijklmnopqrstuvwxyz"
      + "0123456789" + "+/";

  private static final int maxLineLength = 76;

  /**
   * Returns copy of the bytes array with zeros if bytes' length is less than length parameter
   *
   * @param bytes
   * @param length
   * @return
   */
  public static byte[] zeroPad(byte[] bytes, int length) {
    byte[] padded = new byte[length]; // initialized to zero by JVM
    System.arraycopy(bytes, 0, padded, 0, bytes.length);
    return padded;
  }

  public static String encodeBase64(String msg) {
    String encoded = "";
    byte[] msgBytes;
    try {
      msgBytes = msg.getBytes("UTF-8");
    } catch (Exception ignored) {
      // use locale default rather than utf-8
      msgBytes = msg.getBytes();
    }

    // determine how many padding bytes to add to the output
    int paddingCount = (3 - msgBytes.length % 3) % 3;
    // add any necessary padding to the input
    msgBytes = zeroPad(msgBytes, msgBytes.length + paddingCount);

    // process 3 bytes at a time, churning out 4 output bytes
    // worry about CRLF insertions later
    for (int i = 0; i < msgBytes.length; i += 3) {
      int j = ((msgBytes[i] & 0xff) << 16)
          + ((msgBytes[i + 1] & 0xff) << 8)
          + (msgBytes[i + 2] & 0xff);

      encoded = encoded
          + base64code.charAt(j >> 18 & 0x3f)
          + base64code.charAt(j >> 12 & 0x3f)
          + base64code.charAt(j >> 6 & 0x3f)
          + base64code.charAt(j & 0x3f);
    }
    // replace encoded padding nulls with "="
    return splitLines(
        encoded.substring(0, encoded.length() - paddingCount)
            + "==".substring(0, paddingCount));
  }

  public static String splitLines(String string) {
    String lines = "";
    for (int i = 0; i < string.length(); i += maxLineLength) {
      lines += string.substring(i, Math.min(string.length(), i + maxLineLength));
      lines += "\r\n";
    }
    return lines;
  }

  public static void main(String[] args) {
    System.out.println(encodeBase64("Amr Alaa"));
  }
}