import cn.hutool.crypto.digest.BCrypt;
import org.junit.Test;

/**
 * @author NicholasLD
 * @createTime 2023/4/4 22:42
 */
public class TestPassword {
    @Test
    public void testPassword(){
        String password = "123abc";

        String hashpw = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashpw);

        boolean checkpw = BCrypt.checkpw(password, hashpw);
        System.out.println(checkpw);

        boolean checkpw2 = BCrypt.checkpw("123", hashpw);
        System.out.println(checkpw2);
    }
}
