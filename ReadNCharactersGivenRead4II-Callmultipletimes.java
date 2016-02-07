/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] buffer = new char[4];
    private int bufferBytes = 0;
    private int bufferPointer = 0;

    public int read(char[] buf, int n) {
        int copy = Math.min(n, bufferBytes);
        System.arraycopy(buffer, bufferPointer, buf, 0, copy);
        bufferBytes -= copy;
        bufferPointer += copy;

        int total = copy;
        int readBytes = 4;
        while (total < n && readBytes == 4) {
            readBytes = read4(buffer);
            copy = Math.min(n-total, readBytes);
            bufferBytes = readBytes - copy;
            bufferPointer = copy;
            System.arraycopy(buffer, 0, buf, total, copy);
            total += copy;
        }

        return total;
    }
}
