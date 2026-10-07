# Hướng Dẫn Mở Project LTM Trong NetBeans

Dự án này là bài tập môn **Lập Trình Mạng (LTM)** được cấu trúc theo dạng **Maven Project**.

---

## 🚀 Các Bước Mở Và Sử Dụng Project Trong NetBeans

### 1. Clone Repository về máy
Mở Terminal / Git Bash và chạy lệnh:
```bash
git clone <URL_REPOSITORY>
```

### 2. Mở Project trong Apache NetBeans
1. Mở phần mềm **Apache NetBeans**.
2. Trên thanh menu, chọn **File** ➔ **Open Project...** (hoặc bấm tổ hợp phím `Ctrl + Shift + O`).
3. Tìm đến thư mục `LTM` vừa clone về.
   > **Lưu ý:** NetBeans sẽ tự động nhận diện đây là Maven Project (thư mục `LTM` sẽ có biểu tượng icon chữ **`m`** của Maven).
4. Chọn thư mục `LTM` và nhấn nút **Open Project**.

---

### 3. Tải phụ thuộc và Build Project (Clean and Build)
Khi mở project lần đầu tiên, hãy để Maven tải các thư viện / phụ thuộc cần thiết:
- Chuột phải vào tên Project **`LTM`** ở cột bên trái (**Projects** window).
- Chọn **Clean and Build** (hoặc bấm tổ hợp phím `Shift + F11`).

---

### 4. Cách Chạy Các Bài Tập (Run File)
Các bài tập được chia theo từng package trong `src/main/java`:

1. Mở cây thư mục: `LTM` ➔ `Source Packages` ➔ `lt_05` (hoặc các package bài tập tương ứng).
2. Chuột phải vào file `.java` chứa hàm `main` bạn muốn chạy (ví dụ: `VD05_4.java`, `VD05_2.java`, ...).
3. Chọn **Run File** (hoặc bấm tổ hợp phím `Shift + F6`).

---

## 📌 Các Lỗi Thường Gặp & Cách Khắc Phục

- **Project không hiện icon Maven (chữ m):**
  - Đảm bảo trong thư mục `LTM` có chứa file `pom.xml`.
- **Lỗi thiếu JDK / Java Version mismatch:**
  - Chuột phải vào Project `LTM` ➔ **Properties** ➔ **Libraries** ➔ Chọn đúng **Java Platform** (JDK 17 trở lên).
