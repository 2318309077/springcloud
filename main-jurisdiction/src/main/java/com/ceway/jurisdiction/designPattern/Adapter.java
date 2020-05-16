package com.ceway.jurisdiction.designPattern;

/**
 * @author 伍金亮
 * @version 适配器模式 电压转化  220为原本  在不干扰220转换为5v
 * @date 2020/5/15 11:18 下午
 */
public class Adapter {
    public static void main(String[] args) {
        Adapters adapters = new Adapters();
        Target target = new Adapteres(adapters);
        target.output5v();
    }
}

class  Adapters{
    public  int output220v(){
        return  220;
    }
}
interface  Target{
    int output5v();
}
class  Adapteres implements Target{
    private  Adapters adapters;

    public Adapteres(Adapters adapter){
        this.adapters = adapter;
    }

    @Override
    public int output5v() {
        int i = adapters.output220v();
        System.out.println(String.format("转换前======== %d v 转换======== %d",i,5));
        return 5;
    }
}