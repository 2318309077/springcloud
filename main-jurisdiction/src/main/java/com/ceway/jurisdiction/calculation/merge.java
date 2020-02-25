package com.ceway.jurisdiction.calculation;

/**
 * 归并
 */
public class merge {
    public  static  int[] tmp;
    public  void guibing(int[] data,int start,int end){
           if(start < end){
                //创建中间分割
                int mid = (start+end)/2;
                //左分支递归分为最小级别
                guibing(data,start,mid);
               //右分支递归分为最小级别
                guibing(data,mid+1,end);
                tmp = new int[data.length]; //定义零时数组存 排序 - 聚拢的数据
                //把左右的最小分支（合并 - 排序 - 聚拢）
                branch(data,start,mid,end);
           }
    }
    public  void branch(int[] data,int start,int mid,int end){

        int left = start;//左边开始位置
        int right = mid+1;//右边开始位置

        int ioc = start;//当前所在位置（下标）
        while (left <= mid && right<=end){
            if(data[left]<data[right]){
                  tmp[ioc] = data[right];
                  ioc++;
                  right++;
            }else{
                tmp[ioc] = data[left];
                ioc++;
                left++;
            }
        }
        while (left <=mid){
            tmp[ioc++] = data[left++];
        }
        while (right<end){
            tmp[ioc++] = data[right++];
        }
        for(int i=left;i<=right;i++){
            data[i] = tmp[i];
        }
    }
}
