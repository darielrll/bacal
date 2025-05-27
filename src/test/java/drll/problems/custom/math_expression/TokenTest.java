package drll.problems.custom.math_expression;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TokenTest {
    @Test
    void should_return_true_when_operator_is_plus() {
        assertThat(Token.isOperator("+")).isTrue();
    }

    @Test
    void should_return_true_when_operator_is_minus() {
        assertThat(Token.isOperator("-")).isTrue();
    }

    @Test
    void should_return_true_when_operator_is_multiplication() {
        assertThat(Token.isOperator("*")).isTrue();
    }

    @Test
    void should_return_true_when_operator_is_divide() {
        assertThat(Token.isOperator("/")).isTrue();
    }

    @Test
    void should_return_false_when_operator_is_unknown() {
        assertThat(Token.isOperator("a")).isFalse();
    }
}