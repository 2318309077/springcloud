package com.ceway.jurisdiction.calculation;

public class QuickSort {
    public static void swap(int[] data, int left, int right) {
        //获取对比值（一般优化基本都是让这个值取中间值时效率最高）
        int tmp = data[left];

        //左边指针
        int ll = left;
        //右边指针
        int rr = right;
        while (ll < rr){
            //右边指针数据对比
            while (ll < rr && tmp <= data[rr]){
                 rr--;
            }
            if(ll < rr){
                 int a = data[rr];
                 data[rr] = data[ll];
                 data[ll] = a;
                 ll++;
            }
            //左边指针数据对比
            while (ll < rr && tmp <= data[ll]){
                 ll++;
            }
            if(ll < rr){
                int a = data[rr];
                data[rr] = data[ll];
                data[ll] = a;
                rr--;
            }
            //接下来的步骤递归就行
            swap(data,left,ll-1);
            swap(data,ll+1,right);
        }
    }

}
