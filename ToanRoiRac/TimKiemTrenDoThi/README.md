# Tìm kiếm trên đồ thị lớn
## Đầu bài

Xét tập dữ liệu [sgb-words.txt](../ToanRoiRac/src/sgb-words.txt).
Tập dữ liệu này chứa phần lớn các từ tiếng Anh độ dài 5. Từ dữ liệu này, ta xây dựng đồ thị G = (V, E) với tập đỉnh V = “mọi từ trong sgb-words”, và giữa hai từ u và v trong G có cạnh nối nếu u, v khác nhau ở đúng một vị trí.
Dễ thấy, trong đồ thị G, dãy từ
```
words, wolds, golds, goads, grads, grade, grape, graph
```
là một đường đi với đỉnh bắt đầu là từ words và đỉnh kết thúc là từ graph.
1. Hãy viết chương trình đếm số thành phần liên thông của đồ thị G.
2. Hãy viết chương trình nhập vào từ bắt đầu u và từ kết thúc v; hiện ra màn hình một đường đi ngắn nhất từ u tới v.

## Lời giải
### Theo đầu bài ta có:
- Dữ liệu đọc từ file.
- Mỗi đỉnh là một từ gồm 5 ký tự trong file sgb-words.
- Từ u, v là một cạnh nếu u, v khác nhau đúng một vị trí.
### Phân tích:
Nếu trong file có hai từ giống nhau sẽ không ảnh hưởng đến các cạnh ⇒ gộp đỉnh trùng sẽ không ảnh hưởng  đồ thị.
### Vấn đề cần giải quyết:
- **Lưu trữ đồ thị**:<br>
  Vì dữ liệu thuật toán quá lớn (5,757) nên không cần lưu trữ đồ thị (danh sách cạnh, ma trận kề). Chỉ cần lưu trữ các đỉnh.<br>
  ![tree](../../../../blob/master/resources/tree.png)
- **Thuật toán tìm đỉnh kề của đồ thị**:
  - **Bước 1**: Duyệt đến hết tất cả các từ. Mỗi lần duyệt, xóa từ đó khỏi bộ chứa.
  - **Bước 2**: So sánh từ đó với tất cả các từ trong bộ chứa để xác định cạnh.
  Lưu trữ các từ trong bộ chứa sử dụng cây, mỗi nút chứa một ký tự. Một từ được tạo từ sát gốc qua các nút đến nút nhánh. Lần lượt tìm đỉnh kề của một đỉnh với vị trí khác là từ 1 đến 5.<br>
  Giả sử độ sâu của nút x là khoảng cách từ gốc đến nút hiện tại.<br>
  Duyệt qua các nhánh:<br>
  ```
  Th1: Nếu nút có độ sâu là vị trí ký tự khác thì duyệt tiếp các nút phía dưới.
  Th2: Nếu nút có ký tự khác với ký tự trong đỉnh cần tìm thì bỏ qua nhánh này.
  Th3: Nếu duyệt đến nút lá thì lấy đỉnh này.
  ```
- **Đếm số thành phần liên thông**.<br>
Lấy một đỉnh chưa duyệt và dùng thuật toán bfs duyệt hết từng thành phần liên thông, lặp đến khi duyệt hết tất cả các đỉnh.<br>
⇒số thành phần liên thông.<br>
Với mỗi nút trong cây thêm các biến đã duyệt, đã xóa.
- **Đường đi ngắn nhất từ u đến v**.<br>
Dùng thuật toán dijkstra bắt đầu từ đỉnh u đến hết thành phần liên thông, độ dài các cạnh là 1. Mỗi đỉnh đánh dấu.<br>
Thêm vào mỗi nút xâu nút trước đó, khoảng cách từ u, tạo một vector chứa các đỉnh đã được duyệt và chưa duyệt đỉnh kề.
- Từ đó từ đỉnh v lấy các nút trước đó đến u, đảo ngược <br>
⇒ đường đi ngắn nhất.
