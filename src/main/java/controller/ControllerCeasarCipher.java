/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CeaserCipherview;

// Lớp điều khiển cho Ceaser Cipher, thực hiện lắng nghe sự kiện từ giao diện
public class ControllerCeasarCipher implements ActionListener {
    private CeaserCipherview ceasarCipherview; // Giao diện đồ họa của Ceaser Cipher

    // Hàm khởi tạo, nhận đối tượng giao diện và gán cho biến `ceasarCipherview`
    public ControllerCeasarCipher(CeaserCipherview ceasarCipherview) {
        this.ceasarCipherview = ceasarCipherview;
    }

    // Phương thức xử lý sự kiện khi người dùng nhấn vào các nút Encrypt, Decrypt, hoặc Set
    @Override
    public void actionPerformed(ActionEvent e) {
        // Lấy lệnh từ sự kiện nút nhấn
        String command = e.getActionCommand().toString();
        
        // Nếu lệnh là "Encrypt", gọi phương thức mã hóa và hiển thị kết quả mã hóa lên giao diện
        if (command == "Encrypt") {
            this.ceasarCipherview.seteCipherTextField(this.ceasarCipherview.encrypt());
        }
        // Nếu lệnh là "Decrypt", gọi phương thức giải mã và hiển thị kết quả giải mã lên giao diện
        else if (command == "Decrypt") {
            this.ceasarCipherview.setdPlainTextField(this.ceasarCipherview.decrypt());
        }
        // Nếu lệnh là "Set", đặt giá trị Cipher Text vào trường dCipherText
        else if (command == "Set") {
            this.ceasarCipherview.setdCipherText(this.ceasarCipherview.set());
        }
    }
}
