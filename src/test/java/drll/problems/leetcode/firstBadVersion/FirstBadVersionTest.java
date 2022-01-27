package drll.problems.leetcode.firstBadVersion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.assertj.core.api.Assertions.assertThat;

class FirstBadVersionTest {
    @Test
    void should_return_first_bad_deploy_4_when_last_deploy_is_5() {
        FirstBadVersion firstBadVersion = new FirstBadVersionTestable(4);
        int lastDeploy = 5;

        assertThat(firstBadVersion.firstBadVersion(lastDeploy)).isEqualTo(4);
    }

    @Test
    void should_return_first_bad_deploy_3_when_last_deploy_is_7() {
        FirstBadVersion firstBadVersion = new FirstBadVersionTestable(3);
        int lastDeploy = 7;

        assertThat(firstBadVersion.firstBadVersion(lastDeploy)).isEqualTo(3);
    }

    @Test
    void should_return_first_bad_deploy_2_when_last_deploy_is_2() {
        FirstBadVersion firstBadVersion = new FirstBadVersionTestable(2);
        int lastDeploy = 2;

        assertThat(firstBadVersion.firstBadVersion(lastDeploy)).isEqualTo(2);
    }

    @Test
    void should_return_first_bad_deploy_8_when_last_deploy_is_8() {
        FirstBadVersion firstBadVersion = new FirstBadVersionTestable(8);
        int lastDeploy = 8;

        assertThat(firstBadVersion.firstBadVersion(lastDeploy)).isEqualTo(8);
    }

    @Test
    void should_return_first_bad_deploy_1_when_last_deploy_is_8() {
        FirstBadVersion firstBadVersion = new FirstBadVersionTestable(1);
        int lastDeploy = 8;

        assertThat(firstBadVersion.firstBadVersion(lastDeploy)).isEqualTo(1);
    }

    @Test
    void should_return_first_bad_deploy_2_when_last_deploy_is_8() {
        FirstBadVersion firstBadVersion = new FirstBadVersionTestable(2);
        int lastDeploy = 8;

        assertThat(firstBadVersion.firstBadVersion(lastDeploy)).isEqualTo(2);
    }

    @Test
    void should_return_first_bad_deploy_1_when_last_deploy_is_1() {
        FirstBadVersion firstBadVersion = new FirstBadVersionTestable(1);
        int lastDeploy = 1;

        assertThat(firstBadVersion.firstBadVersion(lastDeploy)).isEqualTo(1);
    }

    @Test
    @Timeout(1)
    void should_return_first_bad_deploy_1702766719_when_last_deploy_is_2126753390() {
        FirstBadVersion firstBadVersion = new FirstBadVersionTestable(1702766719);
        int lastDeploy = 2126753390;

        assertThat(firstBadVersion.firstBadVersion(lastDeploy)).isEqualTo(1702766719);
    }

    static class FirstBadVersionTestable extends FirstBadVersion{
        private final int firstBadVersion;

        public FirstBadVersionTestable(int firstBadVersion) {
            this.firstBadVersion = firstBadVersion;
        }

        @Override
        protected boolean isBadVersion(int version) {
            return version >= firstBadVersion;
        }
    }
}