package god.com;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 약어 생성기
 * 
 * @author 이백행
 * @since 2023-07-19
 */
@NoArgsConstructor
@Slf4j
public class 약어_생성기 {

    /**
     * 약어 생성기
     */
    @Test
    public void test() {
        String string = "pesticide";

        if (string != null) {
            string = string.toUpperCase(Locale.getDefault());
            string = string.replaceAll("A", "");
            string = string.replaceAll("E", "");
            string = string.replaceAll("I", "");
            string = string.replaceAll("O", "");
            string = string.replaceAll("U", "");
        }

        log.debug(string);

        assertEquals("", "", "");
    }

}
