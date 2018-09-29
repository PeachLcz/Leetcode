/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.

Example 1: 

Given buf = "abc"
read("abc", 1) // returns "a"
read("abc", 2); // returns "bc"
read("abc", 1); // returns ""
Example 2: 

Given buf = "abc"
read("abc", 4) // returns "abc"
read("abc", 1); // returns ""
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int buffPtr=0;
    int buffCnt=0;
    char[] buff=new char[4];
    public int read(char[] buf, int n) {
        int total=0;
        while(total<n){
            if(buffPtr==0)
                buffCnt=read4(buff);
            if(buffCnt==0)
                break;
            while(total<n&&buffPtr<buffCnt)
                buf[total++]=buff[buffPtr++];
            if(buffPtr>=buffCnt) buffPtr=0;
        }
        return total;
    }
}
