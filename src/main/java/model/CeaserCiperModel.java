/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model; // Khai báo package nơi lưu trữ lớp này.

public class CeaserCiperModel {
    // Chuỗi hằng số chứa bảng chữ cái tiếng Anh viết thường.
    public static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
    
    // Thuộc tính text lưu trữ văn bản cần mã hóa hoặc giải mã.
    private String text;
    
    // Thuộc tính Key lưu trữ khóa dịch chuyển (khoảng cách dịch trong bảng chữ cái).
    private int Key;
    
    // Hàm khởi tạo mặc định không tham số.
    public CeaserCiperModel() {
    }
    
    // Phương thức getter để lấy giá trị của thuộc tính text.
    public String getText(){
        return this.text;
    }
    
    // Phương thức setter để gán giá trị cho thuộc tính text.
    public void setText(String x){
        this.text = x;
    }
    
    // Phương thức getter để lấy giá trị của thuộc tính Key.
    public int getKey(){
        return this.Key;
    }
    
    // Phương thức setter để gán giá trị cho thuộc tính Key.
    public void setKey(int y){
        this.Key = y;
    }

    // Phương thức mã hóa văn bản bằng cách sử dụng thuật toán Caesar Cipher.
    public String encrypt(String plaintText){
        String result = ""; // Chuỗi kết quả sau khi mã hóa.
        
        // Chuyển đổi văn bản đầu vào thành mảng các ký tự.
        char[] charplaintText = plaintText.toCharArray();
        
        // Duyệt qua từng ký tự trong mảng ký tự.
        for(char c : charplaintText){
            // Nếu ký tự là chữ in hoa (A-Z).
            if(c >= 'A' && c <= 'Z'){
                // Thực hiện dịch chuyển ký tự trong bảng chữ cái và cộng vào kết quả.
                char encryptedChar = (char) ((c - 'A' + Key) % 26 + 'A');
                result += encryptedChar;
            }
            // Nếu ký tự là chữ thường (a-z).
            else if (c >= 'a' && c <= 'z') {
                // Thực hiện dịch chuyển ký tự trong bảng chữ cái và cộng vào kết quả.
                char encryptedChar = (char) ((c - 'a' + Key) % 26 + 'a');
                result += encryptedChar;
            }
            // Nếu không phải chữ cái, giữ nguyên ký tự.
            else {
                result += c;
            }
        }
        // Trả về chuỗi kết quả sau khi mã hóa.
        return result;
    }

    // Phương thức giải mã văn bản đã mã hóa bằng thuật toán Caesar Cipher.
    public String decrypt(String CipherText){
        String result = ""; // Chuỗi kết quả sau khi giải mã.
        
        // Chuyển đổi văn bản đầu vào thành mảng các ký tự.
        char[] charCipherText = CipherText.toCharArray();
        
        // Duyệt qua từng ký tự trong mảng ký tự.
        for(char c : charCipherText){
            // Nếu ký tự là chữ in hoa (A-Z).
            if(c >= 'A' && c <= 'Z'){
                // Thực hiện dịch chuyển ngược ký tự trong bảng chữ cái và cộng vào kết quả.
                char encryptedChar = (char) ((c - 'A' - Key + 26) % 26 + 'A');
                result += encryptedChar;
            }
            // Nếu ký tự là chữ thường (a-z).
            else if (c >= 'a' && c <= 'z') {
                // Thực hiện dịch chuyển ngược ký tự trong bảng chữ cái và cộng vào kết quả.
                char encryptedChar = (char) ((c - 'a' - Key + 26) % 26 + 'a');
                result += encryptedChar;
            }
            // Nếu không phải chữ cái, giữ nguyên ký tự.
            else {
                result += c;
            }
        }
        // Trả về chuỗi kết quả sau khi giải mã.
        return result;
    }
}