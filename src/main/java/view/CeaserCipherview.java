/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ControllerCeasarCipher;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import model.CeaserCiperModel;

public class CeaserCipherview extends JFrame {
    // Các thuộc tính của giao diện GUI và mô hình Ceaser Cipher
    private CeaserCiperModel ceaserCipherModel; // Model chứa logic mã hóa
    private JTextField shiftKeyTextField; // Trường nhập khóa dịch chuyển
    private JTextField ePlainTextField; // Trường nhập văn bản gốc để mã hóa
    private JTextField eCipherTextField; // Trường hiển thị kết quả mã hóa
    private JTextField dCipherText; // Trường nhập văn bản đã mã hóa để giải mã
    private JTextField dPlainTextField; // Trường hiển thị kết quả giải mã
    private JPanel ceaserPanel; // Bảng chính chứa các thành phần giao diện

    // Constructor tạo và khởi tạo giao diện
    public CeaserCipherview() throws HeadlessException {
        this.ceaserCipherModel = new CeaserCiperModel(); // Khởi tạo đối tượng mô hình Ceaser Cipher
        this.init(); // Gọi phương thức khởi tạo giao diện
    }

    // Phương thức khởi tạo giao diện người dùng
    public void init() {
        this.setTitle("Ceaser Cipher"); // Thiết lập tiêu đề cửa sổ
        this.setSize(500, 300); // Thiết lập kích thước cửa sổ
        this.setLocationRelativeTo(null); // Cửa sổ hiển thị giữa màn hình
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Đóng chương trình khi tắt cửa sổ

        // Tạo border cho các panel
        Border border = BorderFactory.createLineBorder(Color.gray);

        // Khởi tạo đối tượng điều khiển (controller) để lắng nghe sự kiện
        ControllerCeasarCipher CipherListener = new ControllerCeasarCipher(this);

        // Tạo JPanel chính và thiết lập bố cục
        ceaserPanel = new JPanel();
        ceaserPanel.setBorder(new EmptyBorder(5,5,5,5)); // Khoảng cách biên
        this.setContentPane(ceaserPanel);
        ceaserPanel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel mainPanel = new JPanel(); // Panel chính
        ceaserPanel.add(mainPanel);
        mainPanel.setLayout(new BorderLayout(10, 10)); // Bố cục BorderLayout

        // Panel chứa tiêu đề
        JPanel namePanel = new JPanel();
        namePanel.setBorder(border);
        mainPanel.add(namePanel, BorderLayout.NORTH);

        JLabel ceasarCipherPanel = new JLabel("Ceasar Cipher"); // Tiêu đề
        namePanel.add(ceasarCipherPanel);

        // Panel chứa các phần chính của giao diện
        JPanel borderPanel = new JPanel();
        borderPanel.setBorder(border);
        mainPanel.add(borderPanel, BorderLayout.CENTER);
        borderPanel.setLayout(new BorderLayout(0, 0));

        // Panel chứa phần nhập khóa
        JPanel keyGenPanel = new JPanel();
        borderPanel.add(keyGenPanel, BorderLayout.NORTH);

        JLabel shiftKeyLabel = new JLabel("Shift key"); // Nhãn cho khóa dịch chuyển
        keyGenPanel.add(shiftKeyLabel);

        shiftKeyTextField = new JTextField(10); // Trường nhập khóa dịch chuyển
        keyGenPanel.add(shiftKeyTextField);

        // Panel chứa phần mã hóa và giải mã
        JPanel cipherPanel = new JPanel();
        borderPanel.add(cipherPanel, BorderLayout.CENTER);
        cipherPanel.setLayout(new GridLayout(0, 2, 10, 10)); // Bố cục lưới 2 cột

        // Panel mã hóa
        JPanel encryptPanel = new JPanel();
        cipherPanel.add(encryptPanel);
        encryptPanel.setLayout(new BorderLayout(10, 10));

        JLabel eLabel = new JLabel("Encrypt"); // Tiêu đề phần mã hóa
        eLabel.setHorizontalAlignment(SwingConstants.CENTER); // Canh giữa
        encryptPanel.add(eLabel, BorderLayout.NORTH);

        JPanel eTextPanel = new JPanel(); // Panel chứa trường nhập
        encryptPanel.add(eTextPanel, BorderLayout.CENTER);
        eTextPanel.setLayout(new GridLayout(2, 2, 10, 10));

        // Nhãn và trường nhập văn bản gốc
        JLabel ePlainLabel = new JLabel("Plaint Text");
        ePlainLabel.setVerticalAlignment(SwingConstants.TOP);
        ePlainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        eTextPanel.add(ePlainLabel);

        ePlainTextField = new JTextField(); // Trường nhập văn bản gốc
        ePlainTextField.setColumns(50);
        eTextPanel.add(ePlainTextField);

        // Nhãn và trường hiển thị kết quả mã hóa
        JLabel eCipherLabel = new JLabel("Cipher Text:");
        eCipherLabel.setVerticalAlignment(SwingConstants.TOP);
        eCipherLabel.setHorizontalAlignment(SwingConstants.CENTER);
        eTextPanel.add(eCipherLabel);

        eCipherTextField = new JTextField(); // Trường hiển thị kết quả mã hóa
        eCipherTextField.setColumns(50);
        eTextPanel.add(eCipherTextField);

        // Panel chứa các nút bấm của phần mã hóa
        JPanel eButtPanel = new JPanel();
        encryptPanel.add(eButtPanel, BorderLayout.SOUTH);

        JButton eButt = new JButton("Encrypt"); // Nút mã hóa
        eButtPanel.add(eButt);
        eButt.addActionListener(CipherListener); // Thêm sự kiện lắng nghe cho nút

        JButton eSetButt = new JButton("Set"); // Nút đặt kết quả
        eButtPanel.add(eSetButt);
        eSetButt.addActionListener(CipherListener); // Thêm sự kiện lắng nghe cho nút

        // Panel giải mã
        JPanel decryptPanel = new JPanel();
        cipherPanel.add(decryptPanel);
        decryptPanel.setLayout(new BorderLayout(10, 10));

        JLabel dLabel = new JLabel("Decrypt"); // Tiêu đề phần giải mã
        dLabel.setHorizontalAlignment(SwingConstants.CENTER);
        decryptPanel.add(dLabel, BorderLayout.NORTH);

        JPanel dTextPanel = new JPanel(); // Panel chứa trường nhập cho giải mã
        decryptPanel.add(dTextPanel, BorderLayout.CENTER);
        dTextPanel.setLayout(new GridLayout(2, 2, 10, 10));

        // Nhãn và trường nhập văn bản mã hóa để giải mã
        JLabel dCipherLabel = new JLabel("Cipher Text:");
        dCipherLabel.setVerticalAlignment(SwingConstants.TOP);
        dCipherLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dTextPanel.add(dCipherLabel);

        dCipherText = new JTextField(); // Trường nhập văn bản mã hóa
        dTextPanel.add(dCipherText);
        dCipherText.setColumns(10);

        // Nhãn và trường hiển thị kết quả giải mã
        JLabel dPlainLabel = new JLabel("Plaint Text");
        dPlainLabel.setVerticalAlignment(SwingConstants.TOP);
        dPlainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dTextPanel.add(dPlainLabel);

        dPlainTextField = new JTextField(); // Trường hiển thị kết quả giải mã
        dPlainTextField.setColumns(10);
        dTextPanel.add(dPlainTextField);

        // Panel chứa các nút bấm của phần giải mã
        JPanel dButtPanel = new JPanel();
        decryptPanel.add(dButtPanel, BorderLayout.SOUTH);

        JButton dButt = new JButton("Decrypt"); // Nút giải mã
        dButtPanel.add(dButt);
        dButt.addActionListener(CipherListener); // Thêm sự kiện lắng nghe cho nút

        this.setVisible(true); // Hiển thị giao diện
    }

    // Các getter và setter cho các trường và thành phần giao diện
    public JPanel getCeasarPanel() {
        return ceaserPanel;
    }

    public JTextField getShiftKeyTextField() {
        return shiftKeyTextField;
    }

    public void setShiftKeyTextField(String str) {
        this.shiftKeyTextField.setText(str);
    }

    public JTextField getdCipherText() {
        return dCipherText;
    }

    public void setdCipherText(String str) {
        this.dCipherText.setText(str);
    }

    public CeaserCiperModel getCeasarModel() {
        return ceaserCipherModel;
    }

    public void setCeasarModel(CeaserCiperModel ceasarModel) {
        this.ceaserCipherModel = ceasarModel;
    }

    public JTextField getePlainTextField() {
        return ePlainTextField;
    }

    public void setePlainTextField(JTextField ePlainTextField) {
        this.ePlainTextField = ePlainTextField;
    }

    public JTextField geteCipherTextField() {
        return eCipherTextField;
    }

    public void seteCipherTextField(String str) {
        this.eCipherTextField.setText(str);
    }

    public JTextField getdPlainTextField() {
        return dPlainTextField;
    }

    public void setdPlainTextField(String str) {
        this.dPlainTextField.setText(str);
    }

    // Phương thức mã hóa văn bản
        
   public String encrypt() {
        // Lấy giá trị khóa dịch chuyển từ trường nhập
        int shiftKey = Integer.valueOf(this.getShiftKeyTextField().getText().toString());
        // Thiết lập giá trị khóa cho mô hình mã hóa
        this.ceaserCipherModel.setKey(shiftKey);
        // Lấy văn bản gốc từ trường nhập
        String plain = this.getePlainTextField().getText().toString();
        // Mã hóa văn bản nếu nó không rỗng
        String cipher = (plain.length() > 0 ) ? this.ceaserCipherModel.encrypt(plain) : "";
        return cipher; // Trả về kết quả đã mã hóa
    }

    // Phương thức giải mã văn bản
    public String decrypt() {
        // Lấy giá trị khóa dịch chuyển từ trường nhập
        int shiftKey = Integer.valueOf(this.getShiftKeyTextField().getText().toString());
        // Thiết lập giá trị khóa cho mô hình giải mã
        this.ceaserCipherModel.setKey(shiftKey);
        // Lấy văn bản mã hóa từ trường nhập
        String cipher = this.getdCipherText().getText().toString();
        // Giải mã văn bản nếu nó không rỗng
        String plain = (cipher.length() > 0 ) ? this.ceaserCipherModel.decrypt(cipher) : "";
        return plain; // Trả về kết quả đã giải mã
    }

    // Phương thức đặt kết quả mã hóa vào trường Cipher Text
    public String set() {
        String cipher = this.geteCipherTextField().getText().toString();
        return cipher; // Trả về văn bản đã mã hóa
    }
}
