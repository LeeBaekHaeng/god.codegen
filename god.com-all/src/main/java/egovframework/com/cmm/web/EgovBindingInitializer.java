package egovframework.com.cmm.web;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;

/**
 * 파일 조회, 삭제, 다운로드 처리를 위한 컨트롤러 클래스
 * 
 * @author 표준프레임워크팀 이삼섭
 * @since 2022.12.22
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일          수정자        수정내용
 *  ----------     --------    ---------------------------
 *  2022.12.22     신용호        atchFileId 파라미터 추가 보완
 *
 *      </pre>
 */

public class EgovBindingInitializer implements WebBindingInitializer {

    @Override
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));

        binder.registerCustomEditor(String.class, "atchFileId", new EgovAtchFileIdPropertyEditor());

        binder.registerCustomEditor(LocalDateTime.class, new EgovLocalDateTimePropertyEditor());
    }

    /**
     * LocalDateTime
     * 
     * @author 이백행
     *
     */
    /* default */ static class EgovLocalDateTimePropertyEditor extends PropertyEditorSupport {

        /**
         * 로거
         */
        private static final Logger LOGGER = LoggerFactory.getLogger(EgovLocalDateTimePropertyEditor.class);

        @Override
        public void setAsText(final String text) throws IllegalArgumentException {
            LOGGER.debug("text={}", text);
            if (text.isEmpty()) {
                setValue(null);
            } else {
                try {
                    setValue(LocalDateTime.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")));
                } catch (DateTimeParseException e) {
                    LOGGER.error("DateTimeParseException");
                    throw e;
                }
            }
        }

        @Override
        public String getAsText() {
            final Object value = getValue();
            LOGGER.debug("value={}", value);
            return (value != null ? value.toString() : "");
        }

    }

}
