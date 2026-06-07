# Hướng Dẫn Thực Hành Design Patterns 🚀

Chào mừng bạn đến với chuỗi bài tập thực hành về **Design Patterns (Mẫu thiết kế phần mềm)**. Thư mục này chứa các bài tập tự luyện được thiết kế giúp bạn nắm vững cách áp dụng các mẫu thiết kế vào các bài toán thực tế.

## 📁 Cấu Trúc Thư Mục

Mỗi thư mục con đại diện cho một mẫu thiết kế hoặc mô hình kiến trúc. Hãy tạo các class Java bên trong từng thư mục tương ứng để hoàn thành bài tập:

*   [Singleton](file:///c:/Users/Admin/IdeaProjects/JavaCoding/src/main/java/DesignPattern/Singleton) - Đảm bảo một lớp chỉ có một thực thể duy nhất.
*   [Strategy](file:///c:/Users/Admin/IdeaProjects/JavaCoding/src/main/java/DesignPattern/Strategy) - Thay đổi linh hoạt thuật toán/hành vi lúc runtime.
*   [Observer](file:///c:/Users/Admin/IdeaProjects/JavaCoding/src/main/java/DesignPattern/Observer) - Cơ chế đăng ký và nhận thông báo khi có sự thay đổi trạng thái.
*   [Factory](file:///c:/Users/Admin/IdeaProjects/JavaCoding/src/main/java/DesignPattern/Factory) - Tạo đối tượng mà không để lộ logic khởi tạo cho client.
*   [Adapter](file:///c:/Users/Admin/IdeaProjects/JavaCoding/src/main/java/DesignPattern/Adapter) - Chuyển đổi giao diện của một lớp thành giao diện mà client mong muốn.
*   [Decorator](file:///c:/Users/Admin/IdeaProjects/JavaCoding/src/main/java/DesignPattern/Decorator) - Động gắn thêm trách nhiệm (hành vi) mới cho đối tượng mà không làm ảnh hưởng đến các đối tượng khác.
*   [Composite](file:///c:/Users/Admin/IdeaProjects/JavaCoding/src/main/java/DesignPattern/Composite) - Thiết lập cấu trúc phân cấp dạng cây (Tree structure).
*   [State](file:///c:/Users/Admin/IdeaProjects/JavaCoding/src/main/java/DesignPattern/State) - Cho phép đối tượng thay đổi hành vi khi trạng thái nội bộ của nó thay đổi.
*   [Template](file:///c:/Users/Admin/IdeaProjects/JavaCoding/src/main/java/DesignPattern/Template) - Định nghĩa bộ khung thuật toán, cho phép lớp con ghi đè các bước cụ thể.
*   [Iterator](file:///c:/Users/Admin/IdeaProjects/JavaCoding/src/main/java/DesignPattern/Iterator) - Truy cập tuần tự các phần tử của một tập hợp mà không lộ cấu trúc bên dưới.
*   [Visitor](file:///c:/Users/Admin/IdeaProjects/JavaCoding/src/main/java/DesignPattern/Visitor) - Tách biệt thuật toán khỏi cấu trúc đối tượng mà nó hoạt động trên đó.
*   [MVCSwing](file:///c:/Users/Admin/IdeaProjects/JavaCoding/src/main/java/DesignPattern/MVCSwing) - Thiết kế ứng dụng GUI với mô hình Model-View-Controller bằng Java Swing.

---

## 🎯 Danh Sách Bài Tập Thực Hành

### 1. Singleton Pattern: Quản lý Cấu hình Hệ thống (Configuration Manager)
*   **Mô tả**: Viết một class `ConfigurationManager` để quản lý các cấu hình của ứng dụng (như `db.url`, `app.name`, `app.version`). Đảm bảo rằng chỉ có đúng một thực thể duy nhất của class này được khởi tạo và chia sẻ trong suốt vòng đời của ứng dụng.
*   **Class Diagram**:
    ```mermaid
    classDiagram
        class ConfigurationManager {
            -static ConfigurationManager instance
            -Map~String, String~ settings
            -ConfigurationManager()
            +static ConfigurationManager getInstance()
            +String getSetting(String key)
            +void setSetting(String key, String value)
        }
    ```
*   **Gợi ý**:
    *   Sử dụng `private` constructor để ngăn chặn việc khởi tạo đối tượng bằng từ khóa `new` từ bên ngoài.
    *   Đảm bảo an toàn đa luồng (Thread-safety) bằng cách sử dụng *Double-Checked Locking* hoặc áp dụng *Initialization-on-demand holder idiom*.

---

### 2. Strategy Pattern: Hệ thống Tính phí Vận chuyển (Shipping Fee Calculator)
*   **Mô tả**: Xây dựng module tính toán phí vận chuyển cho một hệ thống thương mại điện tử. Hệ thống hỗ trợ 3 phương thức vận chuyển: Giao hàng Tiết kiệm (Economy), Giao hàng Nhanh (Express), và Giao hàng Hỏa tốc (Instant). Mỗi phương thức sẽ áp dụng công thức tính toán khác nhau dựa trên khối lượng (kg) của đơn hàng.
*   **Class Diagram**:
    ```mermaid
    classDiagram
        class ShippingStrategy {
            <<interface>>
            +double calculate(double weight)
        }
        class EconomyShipping {
            +double calculate(double weight)
        }
        class ExpressShipping {
            +double calculate(double weight)
        }
        class InstantShipping {
            +double calculate(double weight)
        }
        class Order {
            -double weight
            -ShippingStrategy shippingStrategy
            +void setShippingStrategy(ShippingStrategy strategy)
            +double calculateTotalShippingFee()
        }
        ShippingStrategy <|.. EconomyShipping
        ShippingStrategy <|.. ExpressShipping
        ShippingStrategy <|.. InstantShipping
        Order --> ShippingStrategy
    ```
*   **Gợi ý**:
    *   Định nghĩa interface `ShippingStrategy` làm kiểu dữ liệu chung.
    *   Các class cụ thể thực thi interface này để triển khai thuật toán tính phí riêng.
    *   Trong `Order`, giữ một tham chiếu đến `ShippingStrategy` và cho phép thay đổi chiến lược linh hoạt thông qua setter `setShippingStrategy(...)`.

---

### 3. Observer Pattern: Hệ thống Theo dõi Kho & Đăng ký Nhận tin (Inventory System)
*   **Mô tả**: Khi số lượng của một sản phẩm trong kho thay đổi hoặc giảm xuống dưới mức cảnh báo, hệ thống cần tự động cập nhật và gửi thông báo tới các bộ phận đăng ký theo dõi: Bộ phận Thu mua (Purchasing Department), Bộ phận Bán hàng (Sales Department), và Bộ phận Tiếp thị (Marketing Department).
*   **Class Diagram**:
    ```mermaid
    classDiagram
        class Subject {
            <<interface>>
            +attach(Observer o)
            +detach(Observer o)
            +notifyObservers()
        }
        class Observer {
            <<interface>>
            +update(String productName, int stockCount)
        }
        class ProductInventory {
            -List~Observer~ observers
            -String productName
            -int stockCount
            +void changeStock(int count)
        }
        class PurchasingDepartment {
            +update(String productName, int stockCount)
        }
        class SalesDepartment {
            +update(String productName, int stockCount)
        }
        Subject <|.. ProductInventory
        Observer <|.. PurchasingDepartment
        Observer <|.. SalesDepartment
        ProductInventory --> Observer
    ```
*   **Gợi ý**:
    *   `ProductInventory` (Subject) quản lý danh sách các `Observer`.
    *   Khi gọi phương thức `changeStock(...)`, đối tượng Subject sẽ duyệt qua danh sách và gọi phương thức `update(...)` trên tất cả các `Observer` để đồng bộ thông tin.

---

### 4. Factory Pattern: Dịch vụ Gửi Thông báo (Notification Service)
*   **Mô tả**: Viết một module gửi thông báo đến khách hàng qua nhiều kênh khác nhau: SMS, Email, và Push Notification. Client chỉ cần yêu cầu loại kênh gửi và nội dung, hệ thống sẽ tự động tạo và gửi thông báo qua kênh thích hợp mà không cần client biết logic khởi tạo bên trong.
*   **Class Diagram**:
    ```mermaid
    classDiagram
        class Notification {
            <<interface>>
            +void send(String message)
        }
        class EmailNotification {
            +void send(String message)
        }
        class SMSNotification {
            +void send(String message)
        }
        class PushNotification {
            +void send(String message)
        }
        class NotificationFactory {
            +static Notification createNotification(String type)
        }
        Notification <|.. EmailNotification
        Notification <|.. SMSNotification
        Notification <|.. PushNotification
        NotificationFactory ..> Notification : Creates
    ```
*   **Gợi ý**:
    *   Sử dụng static method `createNotification(type)` trong `NotificationFactory` để trả về đúng đối tượng thực thi `Notification` dựa vào tham số truyền vào (ví dụ: `"EMAIL"`, `"SMS"`, `"PUSH"`).

---

### 5. Adapter Pattern: Tích hợp Cổng thanh toán Bên thứ ba (Payment Integration)
*   **Mô tả**: Hệ thống thanh toán hiện tại của bạn đang sử dụng interface `PaymentProcessor` có phương thức `pay(double amount)`. Bạn cần tích hợp thêm một thư viện SDK thanh toán bên thứ ba mới tên là `StripeSDK` để xử lý giao dịch. Tuy nhiên, thư viện này lại có hàm thực thi là `makePayment(String currency, double val)`. Hãy viết một Adapter để tích hợp nó mà không cần sửa đổi mã nguồn cũ của hệ thống.
*   **Class Diagram**:
    ```mermaid
    classDiagram
        class PaymentProcessor {
            <<interface>>
            +void pay(double amount)
        }
        class StripeSDK {
            +void makePayment(String currency, double val)
        }
        class StripeAdapter {
            -StripeSDK stripeSDK
            +StripeAdapter(StripeSDK stripeSDK)
            +void pay(double amount)
        }
        PaymentProcessor <|.. StripeAdapter
        StripeAdapter --> StripeSDK
    ```
*   **Gợi ý**:
    *   `StripeAdapter` sẽ kế thừa/thực thi `PaymentProcessor`.
    *   Adapter này chứa một instance của `StripeSDK` bên trong để thực hiện việc chuyển đổi từ lời gọi hàm `pay(amount)` sang `stripeSDK.makePayment("USD", amount)`.

---

### 6. Composite Pattern: Cấu trúc Thư mục và Tập tin (File System Structure)
*   **Mô tả**: Thiết lập một mô hình quản lý cây thư mục máy tính, bao gồm các Thư mục (Folder) và các File. Thư mục có thể chứa nhiều File hoặc chứa các Thư mục con khác. Hãy thiết kế để client có thể gọi chung một phương thức `printInfo()` hoặc `getSize()` cho cả File và Folder mà không cần phân biệt đối xử.
*   **Class Diagram**:
    ```mermaid
    classDiagram
        class FileSystemComponent {
            <<abstract>>
            +String getName()
            +long getSize()*
            +void printInfo(String indent)*
        }
        class File {
            -String name
            -long size
            +long getSize()
            +void printInfo(String indent)
        }
        class Folder {
            -String name
            -List~FileSystemComponent~ components
            +void add(FileSystemComponent c)
            +void remove(FileSystemComponent c)
            +long getSize()
            +void printInfo(String indent)
        }
        FileSystemComponent <|-- File
        FileSystemComponent <|-- Folder
        Folder --> FileSystemComponent
    ```
*   **Gợi ý**:
    *   `FileSystemComponent` đóng vai trò là Base Component khai báo các tác vụ chung.
    *   `File` là Leaf (không chứa phần tử con).
    *   `Folder` là Composite duy trì danh sách chứa các `FileSystemComponent` khác và triển khai đệ quy các hàm tính toán dung lượng (`getSize`) và in cấu trúc (`printInfo`).

---

### 7. State Pattern: Quản lý Trạng thái Đơn hàng (Order State Flow)
*   **Mô tả**: Một đơn hàng trên ứng dụng mua sắm trực tuyến trải qua các trạng thái tuần tự: Khởi tạo (Initial), Đã thanh toán (Paid), Chờ xử lý/Đã xác nhận (Pending), Đang giao hàng (Shipped), Đã nhận hàng (Delivered), và Hủy đơn hàng (Canceled). Hành vi của đơn hàng sẽ thay đổi tùy thuộc vào trạng thái hiện tại (ví dụ: Không thể hủy đơn hàng khi đang giao hàng, không thể xác nhận đơn hàng khi chưa thanh toán).
*   **Class Diagram**:
    ```mermaid
    classDiagram
        class OrderState {
            <<interface>>
            +void pay(OrderContext ctx)
            +void confirm(OrderContext ctx)
            +void ship(OrderContext ctx)
            +void deliver(OrderContext ctx)
            +void cancel(OrderContext ctx)
        }
        class OrderContext {
            -OrderState orderState
            +void setOrderState(OrderState state)
            +void pay()
            +void confirm()
            +void ship()
            +void deliver()
            +void cancel()
        }
        class InitialState { ... }
        class PaidState { ... }
        class PendingState { ... }
        class ShippedState { ... }
        class DeliveredState { ... }
        class CanceledState { ... }
        OrderState <|.. InitialState
        OrderState <|.. PaidState
        OrderState <|.. PendingState
        OrderState <|.. ShippedState
        OrderState <|.. DeliveredState
        OrderState <|.. CanceledState
        OrderContext --> OrderState
    ```
*   **Gợi ý**:
    *   Tránh sử dụng cấu trúc rẽ nhánh `if-else` hay `switch-case` phức tạp trong class Đơn hàng.
    *   Đại diện mỗi trạng thái bằng một class cụ thể kế thừa interface `OrderState`. Trạng thái hiện tại của đơn hàng được lưu giữ trong `OrderContext` và ủy thác hành vi xử lý cho trạng thái đó.

---

### 8. Template Method Pattern: Quy trình Xuất Báo Cáo (Report Generator)
*   **Mô tả**: Xây dựng công cụ tự động xuất báo cáo theo các bước cố định: 1. Lấy dữ liệu (`fetchData`), 2. Định dạng dữ liệu (`formatData`), 3. Xuất file (`exportFile`). Các bước 1 và 2 sẽ khác nhau tùy thuộc định dạng báo cáo (ví dụ: báo cáo PDF thì lấy từ SQL Server và định dạng PDF, báo cáo Excel thì lấy từ File CSV và định dạng lưới Excel). Quy trình thực thi chung vẫn được quản lý cố định.
*   **Class Diagram**:
    ```mermaid
    classDiagram
        class ReportGenerator {
            <<abstract>>
            +generateReport() void
            #fetchData()* void
            #formatData()* void
            #exportFile()* void
        }
        class PDFReportGenerator {
            #fetchData() void
            #formatData() void
            #exportFile() void
        }
        class ExcelReportGenerator {
            #fetchData() void
            #formatData() void
            #exportFile() void
        }
        ReportGenerator <|-- PDFReportGenerator
        ReportGenerator <|-- ExcelReportGenerator
    ```
*   **Gợi ý**:
    *   Phương thức `generateReport()` trong class cha `ReportGenerator` nên được đánh dấu là `final` để tránh việc lớp con ghi đè cấu trúc quy trình chính.
    *   Các bước cụ thể cần định nghĩa là `abstract` để lớp con bắt buộc phải tự triển khai chi tiết.

---

### 9. Iterator Pattern: Duyệt Danh sách Kênh Phát thanh (Radio Channels)
*   **Mô tả**: Viết chương trình lưu trữ danh sách các kênh Radio. Cung cấp một Iterator cho phép người dùng duyệt qua tất cả các kênh, hoặc chỉ duyệt qua các kênh theo một thể loại cụ thể (như *Music*, *News*) mà không cần biết danh sách được lưu trữ bằng Array, List hay Set bên trong.
*   **Class Diagram**:
    ```mermaid
    classDiagram
        class ChannelIterator {
            <<interface>>
            +boolean hasNext()
            +Channel next()
        }
        class ChannelCollection {
            <<interface>>
            +ChannelIterator iterator(String type)
        }
        class Channel {
            -double frequency
            -String type
            +getType() String
        }
        class ChannelCollectionImpl {
            -List~Channel~ channels
            +addChannel(Channel c)
            +ChannelIterator iterator(String type)
        }
        class ChannelIteratorImpl {
            -List~Channel~ channels
            -String type
            -int position
            +boolean hasNext()
            +Channel next()
        }
        ChannelIterator <|.. ChannelIteratorImpl
        ChannelCollection <|.. ChannelCollectionImpl
        ChannelCollectionImpl ..> ChannelIteratorImpl : Creates
        ChannelIteratorImpl --> Channel
    ```

---

### 10. Visitor Pattern: Tính Thuế cho các Loại Mặt Hàng (Tax Calculator)
*   **Mô tả**: Một siêu thị bán nhiều mặt hàng khác nhau: Sách (Book), Điện tử (Electronics), Thực phẩm (Food). Quy định tính thuế VAT của mỗi loại mặt hàng là khác nhau và thường xuyên thay đổi theo luật. Để tránh việc liên tục sửa đổi code trong các class thực thể mặt hàng, hãy sử dụng Visitor Pattern để tách rời thuật toán tính thuế ra khỏi cấu trúc dữ liệu của mặt hàng.
*   **Class Diagram**:
    ```mermaid
    classDiagram
        class Visitor {
            <<interface>>
            +double visit(Book book)
            +double visit(Electronics electronics)
            +double visit(Food food)
        }
        class Visitable {
            <<interface>>
            +double accept(Visitor visitor)
        }
        class Book {
            -double price
            +double accept(Visitor visitor)
            +getPrice() double
        }
        class Electronics {
            -double price
            +double accept(Visitor visitor)
            +getPrice() double
        }
        class Food {
            -double price
            +double accept(Visitor visitor)
            +getPrice() double
        }
        class TaxVisitor {
            +double visit(Book book)
            +double visit(Electronics electronics)
            +double visit(Food food)
        }
        Visitor <|.. TaxVisitor
        Visitable <|.. Book
        Visitable <|.. Electronics
        Visitable <|.. Food
    ```

---

### 11. MVC (Model-View-Controller) với Java Swing: Bộ Đếm (Counter App)
*   **Mô tả**: Xây dựng một ứng dụng đếm số đơn giản có giao diện đồ họa sử dụng Java Swing. Ứng dụng có một nhãn hiển thị số hiện tại, một nút "Tăng" và một nút "Giảm". Triển khai ứng dụng tuân thủ nghiêm ngặt mô hình MVC:
    *   **Model**: Giữ trạng thái của bộ đếm (ví dụ: biến `int count`).
    *   **View**: Thành phần giao diện (JFrame, JLabel, JButton) chịu trách nhiệm hiển thị trạng thái và lắng nghe sự kiện từ người dùng.
    *   **Controller**: Tiếp nhận tương tác của người dùng từ View, xử lý logic nghiệp vụ bằng cách cập nhật Model, sau đó thông báo để View cập nhật lại màn hình.
*   **Class Diagram**:
    ```mermaid
    classDiagram
        class CounterModel {
            -int value
            +int getValue()
            +void increment()
            +void decrement()
        }
        class CounterView {
            -JButton btnIncrement
            -JButton btnDecrement
            -JLabel lblValue
            +void setController(CounterController controller)
            +void updateValue(int value)
        }
        class CounterController {
            -CounterModel model
            -CounterView view
            +void handleIncrement()
            +void handleDecrement()
        }
        CounterController --> CounterModel
        CounterController --> CounterView
        CounterView --> CounterController
    ```

---

### 12. Decorator Pattern: Hệ thống Gọi món Trà sữa (Milk Tea Ordering System)
*   **Mô tả**: Thiết kế hệ thống gọi món cho một cửa hàng trà sữa. Đồ uống cơ bản bao gồm Trà sữa đen (BlackMilkTea) và Trà sữa xanh (GreenMilkTea). Khách hàng có thể thêm các loại topping như Trân châu (Bubble), Pudding (Pudding), và Kem cheese (CheeseFoam). Mỗi loại topping được thêm vào sẽ cộng thêm tiền vào giá của đồ uống cơ bản và thay đổi mô tả của đồ uống một cách động.
*   **Class Diagram**:
    ```mermaid
    classDiagram
        class MilkTea {
            <<interface>>
            +double getCost()
            +String getDescription()
        }
        class BlackMilkTea {
            +double getCost()
            +String getDescription()
        }
        class GreenMilkTea {
            +double getCost()
            +String getDescription()
        }
        class MilkTeaDecorator {
            <<abstract>>
            #MilkTea milkTea
            +MilkTeaDecorator(MilkTea milkTea)
            +double getCost()
            +String getDescription()
        }
        class Bubble {
            +Bubble(MilkTea milkTea)
            +double getCost()
            +String getDescription()
        }
        class Pudding {
            +Pudding(MilkTea milkTea)
            +double getCost()
            +String getDescription()
        }
        class CheeseFoam {
            +CheeseFoam(MilkTea milkTea)
            +double getCost()
            +String getDescription()
        }
        MilkTea <|.. BlackMilkTea
        MilkTea <|.. GreenMilkTea
        MilkTea <|.. MilkTeaDecorator
        MilkTeaDecorator <|-- Bubble
        MilkTeaDecorator <|-- Pudding
        MilkTeaDecorator <|-- CheeseFoam
        MilkTeaDecorator --> MilkTea
    ```
*   **Gợi ý**:
    *   `MilkTea` đóng vai trò là Component interface.
    *   Các lớp `BlackMilkTea` và `GreenMilkTea` triển khai trực tiếp `MilkTea`.
    *   `MilkTeaDecorator` là lớp Decorator trừu tượng, bọc một đối tượng `MilkTea` và chuyển tiếp lời gọi hàm cho đối tượng được bọc.
    *   Các lớp topping (`Bubble`, `Pudding`, `CheeseFoam`) kế thừa `MilkTeaDecorator`, thực hiện bổ sung giá tiền và mô tả tương ứng.

---

## 🛠️ Hướng Dẫn Thực Hiện

1.  Mở thư mục tương ứng với Design Pattern bạn muốn thực hành.
2.  Tạo các file `.java` cho các interface và class theo sơ đồ lớp được mô tả.
3.  Tạo thêm một class `Main` chứa phương thức `public static void main(String[] args)` để khởi chạy thử nghiệm cấu trúc code của bạn.
4.  Đối với **MVCSwing**, bạn hãy viết chương trình chính khởi tạo 3 thành phần Model, View, Controller và kết nối chúng lại với nhau rồi chạy ứng dụng giao diện trực quan.

Chúc bạn luyện tập tốt và làm chủ các Design Patterns! 💪
