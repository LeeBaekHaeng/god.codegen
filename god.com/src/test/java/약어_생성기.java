import org.junit.Test;

/**
 * 약어 생성기
 * 
 * @author 이백행
 * @since 2023-07-19
 */
public class 약어_생성기 {

    /**
     * 약어 생성기
     */
    @Test
    public void test() {
        String string = "pesticide";
        string = string.toUpperCase();
        string = string.replaceAll("A", "");
        string = string.replaceAll("E", "");
        string = string.replaceAll("I", "");
        string = string.replaceAll("O", "");
        string = string.replaceAll("U", "");
        System.out.println(string);
    }

}
