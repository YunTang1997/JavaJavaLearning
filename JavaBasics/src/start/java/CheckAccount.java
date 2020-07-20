package start.java;

/**
 * @author YunTang
 * @create 2020-07-17 9:27
 */

/*
创建 Account 类的一个子类 CheckAccount代表可透支的账户，该账户中定义一个属性
overdraft代表可透支限额。在 CheckAccount类中重写withdraw方法，其算法如下：
    如果（取款金额<账户余额），
        可直接取款
    如果（取款金额>账户余额），
        计算需要透支的额度
    判断可透支额 overdraft 是否足够支付本次透支需要，
    如果可以
        将账户余额修改为 0，冲减可透支金额
    如果不可以
        提示用户超过可透支额的限额
 */
public class CheckAccount extends Account{

    private double overdraft; // 可透支限额

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft){
        super(id, balance, annualInterestRate); // 调用父类中带参构造器
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount) {
        // 余额足够消费(子类继承了父类中的getBalance方法,getBalance前面有个this,可省略)
        if (getBalance() >= amount){
//            // 方式一
//            setBalance(getBalance() - amount);

            // 方式二
            super.withdraw(amount); // 调用父类中的withdraw方法
        }
        // 透支额度+余额足够消费
        else if(overdraft >= (amount - getBalance())){

            overdraft -= (amount - getBalance());

            // 方式一
            setBalance(0); // 将余额取空
            // 方式二
            super.withdraw(getBalance()); // 调用父类中的withdraw方法
        }
        else{
            System.out.println("超过可透支限额");
        }
    }
}
