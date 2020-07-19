package start.java;

import sun.util.locale.provider.FallbackLocaleProviderAdapter;

/**
 * @author YunTang
 * @create 2020-07-03 15:08
 */


public class FamilyAccount {

    public static void main(String[] args) {

        String details = "         收支\t账户金额\t收支金额\t说    明\n"; // 记录用户收入和支出的详情
        int balance = 10000; // 初始余额
        boolean isFlag = true;
        while (isFlag){

            System.out.println("\n-----------------家庭收支记账软件-----------------\n");
            System.out.println("                   1 收支明细");
            System.out.println("                   2 登记收入");
            System.out.println("                   3 登记支出");
            System.out.println("                   4 退   出\n");
            System.out.print("                   请选择(1-4)：");

            char selection = Utility.readMenuSelection();
            switch (selection){
                case '1':
                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.println(details);
                    System.out.println("------------------------------------------------");
                    break;
                case '2':
                    System.out.println("本次收入金额：");
                    int money = Utility.readNumber();
                    System.out.println("本次收入说明：");
                    String infor = Utility.readString();
                    // 处理balance
                    balance += money;
                    // 处理details
                    details += ("         收入\t" + balance + "\t" + money + "\t\t" + infor + "\n");
                    System.out.println("---------------------登记完成---------------------\n");
                    break;
                case '3':
                    System.out.println("本次支出说明：");
                    int moneyUse = Utility.readNumber();
                    System.out.println("本次支出说明：");
                    String inform = Utility.readString();
                    // 处理balance
                    if (balance >= moneyUse){
                        balance -= moneyUse;
                    }
                    else {
                        System.out.println("额度不足！");
                    }
                    // 处理details
                    details += ("         支出\t" + balance + "\t" + moneyUse + "\t\t" + inform + "\n");
                    System.out.println("---------------------登记完成---------------------\n");
                    break;
                case '4':
                    System.out.println("确认是否退出（Y/N）：");
                    char isExit = Utility.readConfirmSelection();
                    isFlag = (isExit == 'Y') ? false : isFlag;

            }
        }

    }

}


