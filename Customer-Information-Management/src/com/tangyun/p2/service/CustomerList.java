package com.tangyun.p2.service;

import com.tangyun.p2.bean.Customer;

import java.io.FileReader;

/**
 * @author YunTang
 * @create 2020-07-15 15:42
 */

public class CustomerList {
    private Customer[] customers; // 保存客户对象的数组
    private int total; // 记录已保存客户对象的数量

    /**
     * 用来初始化customers数组的构造器
     * @param totalCustomer：指定数组的长度
     */
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }

    /**
     * 将指定的客户添加到数组中
     * @param customer
     * @return：true，添加成功，false，添加失败
     */
    public boolean addCustomer(Customer customer){
        if (total >= customers.length){
            return false;
        }
        else{
//            customers[total] = customer;
//            total++;
            customers[total++] = customer;
            return true;
        }
    }

    /**
     * 修改指定索引位置的客户信息
     * @param index
     * @param cust
     * @return：true，修改成功，false，添加失败
     */
    public boolean replaceCustomer(int index, Customer cust){
        if (index < 0 || index >= total){
            return false;
        }
        else{
            customers[index] = cust;
            return true;
        }
    }

    /**
     * 删除指定位置上的客户
     * @param index
     * @return：true，删除成功，false，添加失败
     */
    public boolean deleteCustomer(int index){
        if (index < 0 || index >= total){
            return false;
        }
        for (int i = 0; i < total - 1; i++) {
            customers[i] = customers[i + 1];
        }

//        // 最后的元素设置为null
//        customers[total - 1] = null;
//        // 计数减1
//        total--;
        customers[--total] = null;
        return true;
    }

    /**
     * 索取所有的客户信息
     * @return
     */
    public Customer[] getAllCustomers(){
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * 获取指定索引位置上的客户
     * @param index
     * @return：如果找到了元素就返回，没有找到就返回null
     */
    public Customer getCustomer(int index){
        if (index < 0 || index >= total){
            return null;
        }
        else{
            return customers[index];
        }
    }

    /**
     * 获取存储的客户的数量
     * @return
     */
    public int getTotal(){
        return total;
    }
}
