package be.kapture.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ContactInfoTest {

    private ContactInfo contactInfo;

        @BeforeEach
        void setUp() {
        contactInfo = new ContactInfo();
    }

    @Test
    void validateEmail() {
        assertThat(contactInfo.validateEmail("matthias.ghys@hotmail.com")).isTrue();
        assertThat(contactInfo.validateEmail("matthias.ghyshotmail.com")).isFalse();
        assertThat(contactInfo.validateEmail("matthias.ghys@gmailcom")).isFalse();
        assertThat(contactInfo.validateEmail("matthiasghys@gmailcom.")).isFalse();

    }
    @Test
    void validateNumber() {
            assertThat(contactInfo.validateNumber("06f497e94")).isFalse();
            assertThat(contactInfo.validateNumber("036597823")).isTrue();

    }

    @Test
    void formatNumbers() {
            assertThat(contactInfo.formatNumbers("04 96 73 61 06")).isEqualTo("0496736106");
            assertThat(contactInfo.formatNumbers(" 04 96 73 61 06 ")).isEqualTo("0496736106");


    }
}
