# Spring Web Tutorial

**Spring Web Tutorial** là một ứng dụng quản lý phát triển web được xây dựng bằng **Spring Framework**. Dự án này không chỉ giúp người dùng thực hành các kỹ thuật CRUD (Create, Read, Update, Delete) trong phát triển ứng dụng web mà còn là một công cụ học tập hiệu quả để nắm vững các khái niệm và công nghệ liên quan đến Spring.

## Chức Năng Chính
- **Quản lý Dữ liệu**: Cung cấp các chức năng để thêm, xem, chỉnh sửa và xóa dữ liệu.
- **Giao diện Người dùng**: Sử dụng Thymeleaf để tạo giao diện thân thiện và dễ sử dụng.
- **Tương tác với Cơ sở dữ liệu**: Sử dụng Spring Data JPA để thực hiện các thao tác với cơ sở dữ liệu.

## Cấu Trúc Thư Mục
```
Spring-Web-Tutorial/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── controller/   // Chứa các lớp controller
│   │   │           ├── model/        // Định nghĩa các thực thể dữ liệu
│   │   │           ├── repository/    // Thực hiện các thao tác với cơ sở dữ liệu
│   │   │           └── service/       // Chứa logic nghiệp vụ
│   │   └── resources/
│   │       ├── templates/             // Chứa các file Thymeleaf
│   │       └── application.properties  // Cấu hình ứng dụng
│   └── test/                          // Các bài kiểm tra
│
├── pom.xml                             // Cấu hình Maven
└── README.md                           // Tài liệu hướng dẫn sử dụng
```

## Hướng Dẫn Cài Đặt
1. **Clone Repository**:
   ```bash
   git clone https://github.com/your_username/Spring-Web-Tutorial.git
   cd Spring-Web-Tutorial
   ```

2. **Cài đặt Maven**: Đảm bảo rằng Maven đã được cài đặt trên máy của bạn.


3. **Chạy Ứng Dụng**:
   ```bash
   mvn spring-boot:run
   ```

4. **Truy cập Ứng Dụng**: Mở trình duyệt và truy cập `http://localhost:8080`.

## Ghi chú
- Dự án này được phát triển với mục đích giáo dục và học tập. Vui lòng không sử dụng cho mục đích thương mại.
- Nếu bạn có bất kỳ câu hỏi hoặc phản hồi nào, hãy mở issue trên GitHub.

## Tác giả
- **Tên bạn**: Duy Chau Nhat ( DyuDev )

## Giấy phép
Dự án này được phát hành dưới giấy phép MIT. Vui lòng xem file [LICENSE](LICENSE) để biết thêm chi tiết.

## Liên hệ
- Email: chauunhatduyyit@gmail.com
- LinkedIn: www.linkedin.com/in/chauu-nhat-duyy-intech
