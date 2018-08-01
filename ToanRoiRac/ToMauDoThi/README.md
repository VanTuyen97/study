## Bài tập tô màu đồ thị
**Mệnh đề**: Cho G là đồ thị với mọi đỉnh đều có bậc ≤ k. Nếu G liên thông và không chính quy, vậy thì χ(G) ≤ k.<br>
Chứng minh của mệnh đề này cho chúng ta cách xây dựng thứ tự các đỉnh để thuật toán tham lam tô màu đỉnh dùng không quá k màu cho đồ thị không chính quy. Bài tập này yêu cầu bạn cài đặt thuật toán này.

**Nhiệm vụ"**: Nhập đồ thị từ bàn phím dưới dạng danh sách cạnh. Đưa ra màn hình một cách tô màu đồ thị dùng
- không nhiều hơn k màu nếu G liên thông và không chính quy;
- không nhiều hơn k+1 màu nếu G không liên thông hoặc là chính quy.

**Dữ liệu vào**: từ file dothi.txt trong đó
- Dòng đầu tiên ghi hai số nguyên n và m là số đỉnh và số cạnh của đồ thị;
- Ở m dòng tiếp theo, mỗi dòng ghi 2 số nguyên tương ứng với một cạnh của đồ thị.

**Dữ liệu ra**: file dothitomau.dot biểu diễn đồ thị ở dạng ngôn ngữ DOT với các đỉnh đã được tô màu.

**ví dụ**:
```dot
Dữ liệu vào dothi.txt         Dữ liệu ra dothitomau.dot
5 5                           graph dothi
1 2                           {
2 3                                 5 [fillcolor=red, style=filled];
3 4                                 4 [fillcolor=red, style=filled];
4 1                                 1 [fillcolor=green, style=filled];
1 5                                 3 [fillcolor=green, style=filled];
                                    2 [fillcolor=red, style=filled];
                                    1 -- 2;
                                    2 --3;
                                    3 -- 4;
                                    4 -- 1;
                                    1 --5;
                              }
```
**Giải**:<br>
- Dựa theo "nhiệm vụ", ta cần sắp xếp dãy các đỉnh theo thứ tự phù hợp: chứng minh cho biểu đồ **liên thông** và **không chính quy**.
  - Chọn một đỉnh trong G có bậc ≤ k − 1. Gán nó là v(n).
  - Liệt kê cho các hàng xóm của vn theo thứ tự là: v(n−1); v(n−2); · · · ; v(n−r):
  - Liệt kê các hàng xóm của v(n−1) (trừ v(n)). Có ≤ k − 1 đỉnh.
  - Liệt kê các hàng xóm của v(n−2) chưa được liệt kê. Có ≤ k − 1 đỉnh.
  - Và cứ thế đến khi mọi đỉnh của G được liệt kê. (do G liên thông)
  
nếu là biểu đồ **không liên thông** thì duyệt tương tự cho tất cả các thành phần liên thông từ bất kỳ một đỉnh.<br>
nếu **chính quy** chọn một đỉnh bất kỳ rồi làm tương tự.
 - Gán màu cho các đỉnh bằng các số > 0, đỉnh có màu bằng 0 là chưa gán màu.
 - gán đỉnh đầu tiên là 1. Duyệt các đỉnh còn lại, gán màu cho đỉnh đó bằng số nhỏ nhất khác 0 mà các **đỉnh kề** chưa gán.
