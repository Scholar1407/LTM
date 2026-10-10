# Hướng dẫn chạy Bài tập 2 Package lt_06.lt_06_2 (Truyền đối tượng ArrayObject qua TCP Socket)

## 1. Biên dịch dự án:
Mở Terminal tại thư mục `LTM` và chạy lệnh:
```bash
javac -encoding UTF-8 -d target/classes src/main/java/lt_06/lt_06_2/*.java
```

## 2. Chạy Server:
Mở Terminal và khởi chạy `ArrayServer`:
```bash
java -Dfile.encoding=UTF-8 -cp target/classes lt_06.lt_06_2.ArrayServer
```

## 3. Chạy Client:
Mở một Terminal khác và khởi chạy `ArrayClient`:
```bash
java -Dfile.encoding=UTF-8 -cp target/classes lt_06.lt_06_2.ArrayClient
```
- Khi màn hình hiển thị `Nhập số lượng phần tử: `, nhập số lượng phần tử (ví dụ: `5`) và bấm Enter.
