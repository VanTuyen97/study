## Bài tập tô màu đồ thị
**Mệnh đề**: Cho G là đồ thị với mọi đỉnh đều có bậc ≤ k. Nếu G liên thông và không chính quy, vậy thì χ(G) ≤ k.<br>
Chứng minh của mệnh đề này cho chúng ta cách xây dựng thứ tự các đỉnh để thuật toán tham lam tô màu đỉnh dùng không quá k màu cho đồ thị không chính quy. Bài tập này yêu cầu bạn cài đặt thuật toán này.<br><br>

**Nhiệm vụ"**: Nhập đồ thị từ bàn phím dưới dạng danh sách cạnh. Đưa ra màn hình một cách tô màu đồ thị dùng
- không nhiều hơn k màu nếu G liên thông và không chính quy;
- không nhiều hơn k+1 màu nếu G không liên thông hoặc là chính quy.<br>

**Dữ liệu vào**: từ file dothi.txt trong đó
- Dòng đầu tiên ghi hai số nguyên n và m là số đỉnh và số cạnh của đồ thị;
- Ở m dòng tiếp theo, mỗi dòng ghi 2 số nguyên tương ứng với một cạnh của đồ thị.<br>

**Dữ liệu ra**: file dothitomau.dot biểu diễn đồ thị ở dạng ngôn ngữ DOT với các đỉnh đã được tô màu.
