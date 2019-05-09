# JAVA实现8种排序算法
## 1 冒泡排序 【时间复杂度：O(N^2),空间复杂度 ：O(1) ,稳定排序，实际运行中效果最差】
## 2 插入排序 【时间复杂度：O(N^2),空间复杂度：O(1),稳定排序】
## 3 选择排序 【时间复杂度：O(N^2),空间复杂度：O(1),不稳定排序】
## 4 快速排序 【时间复杂度：O(NlogN)，空间复杂度：O(logN)~O(N)，不稳定排序】
## 5 归并排序 【时间复杂度：O(NlogN)，空间复杂度：O(N)，稳定排序】
              【归并排序中，辅助数组的长度取值不要取整个数组的长度，应该是需要合并的那一部分的长度，否则数组的写入会消耗很多时间】
## 6 堆排序   【时间复杂度：O(NlogN)，空间复杂度：O(1),不稳定排序】
## 7 希尔排序 【时间复杂度：O(N^1.3)，空间复杂度：O(1)，不稳定排序】
## 8 基数排序 【时间复杂度：0(d(n+r))，空间复杂度：O(rd+n)，稳定排序，实际运行中效果最好】
              【其中d表示数组中最大数的位数，n表示关键字的个数，r表示每个关键字每一位可能的取值个数，十进制就是10（0-9）
                字母就是26（a-z）】


## 实际运行结果
### 数组长度为1w时：
![image](https://github.com/LiuJie6/sort/raw/master/img/1w.png)
### 数组长度为10w时：
![image](https://github.com/LiuJie6/sort/raw/master/img/10w.png)
### 数组长度为100w时：
![image](https://github.com/LiuJie6/sort/raw/master/img/100w.png)
### 数组长度为1000w时：
![image](https://github.com/LiuJie6/sort/raw/master/img/1000w.png)
### 各算法复杂度：
![image](https://github.com/LiuJie6/sort/raw/master/img/复杂度.png)