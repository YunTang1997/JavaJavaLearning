package senior.java.generic.exer;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author YunTang
 * @create 2020-07-27 21:28
 */
public class DAOTest {

    @Test
    public void test1(){
        CustomerDAO dao1 = new CustomerDAO();

        dao1.add(new Customer());
        List<Customer> list = dao1.getForList(10);


        StudentDAO dao2 = new StudentDAO();
        Student student = dao2.getIndex(1);
    }
}
