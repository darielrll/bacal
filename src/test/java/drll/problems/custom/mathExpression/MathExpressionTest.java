package drll.problems.custom.mathExpression;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MathExpressionTest {

    @Test
    void should_return_34plus_when_expression_is_3_plus_4() throws Exception {
        List<String> prefix = new ArrayList<>();
        prefix.add("3");
        prefix.add("4");
        prefix.add("+");

        assertThat(new MathExpression().toPostfixNotation("3+4")).isEqualTo(prefix);
    }

    @Test
    void should_return_342multiplicationplus_when_expression_is_3_plus_4_mult_2() throws Exception {
        List<String> prefix = new ArrayList<>();
        prefix.add("3");
        prefix.add("4");
        prefix.add("2");
        prefix.add("*");
        prefix.add("+");

        assertThat(new MathExpression().toPostfixNotation("3+4*2")).isEqualTo(prefix);
    }

    @Test
    void should_return_34multiplication2plus_when_expression_is_3_multiplication_4_plus_2() throws Exception {
        List<String> prefix = new ArrayList<>();
        prefix.add("3");
        prefix.add("4");
        prefix.add("*");
        prefix.add("2");
        prefix.add("+");

        assertThat(new MathExpression().toPostfixNotation("3*4+2")).isEqualTo(prefix);
    }

    @Test
    void should_return_4dot535plus_when_expression_is_4_dot_5_plus_35() throws Exception {
        List<String> prefix = new ArrayList<>();
        prefix.add("4.5");
        prefix.add("35");
        prefix.add("+");

        assertThat(new MathExpression().toPostfixNotation("4,5+35")).isEqualTo(prefix);
    }

    @Test
    void should_return_343divideplus68multiplicationplus2minus_when_expression_is_3plus4divide3plus6multiplication8minus2() throws Exception {
        // 3+4/3+6*8-2
        // 343/+68
        // 343/+68*+2-
        List<String> prefix = new ArrayList<>();
        prefix.add("3");
        prefix.add("4");
        prefix.add("3");
        prefix.add("/");
        prefix.add("+");
        prefix.add("6");
        prefix.add("8");
        prefix.add("*");
        prefix.add("+");
        prefix.add("2");
        prefix.add("-");

        assertThat(new MathExpression().toPostfixNotation("3+4/3+6*8-2")).isEqualTo(prefix);
    }

    @Test
    void should_return_next_tokens_for_expression_3_plus_4() {
        MathExpression.Tokenizer tokenizer = new MathExpression.Tokenizer("3+4");

        assertThat(tokenizer.nextToken()).isEqualTo("3");
        assertThat(tokenizer.nextToken()).isEqualTo("+");
        assertThat(tokenizer.nextToken()).isEqualTo("4");
    }

    @Test
    void should_return_null_token_when_not_have_more_tokens() {
        MathExpression.Tokenizer tokenizer = new MathExpression.Tokenizer("3+4");
        tokenizer.nextToken();
        tokenizer.nextToken();
        tokenizer.nextToken();

        assertThat(tokenizer.nextToken()).isNull();
    }

    @Test
    void should_return_next_tokens_for_expression_has_spaces() {
        MathExpression.Tokenizer tokenizer = new MathExpression.Tokenizer(" 3 + 4 ");

        assertThat(tokenizer.nextToken()).isEqualTo("3");
        assertThat(tokenizer.nextToken()).isEqualTo("+");
        assertThat(tokenizer.nextToken()).isEqualTo("4");
    }

    @Test
    void should_return_next_tokens_for_expression_3dot2_plus_4() {
        MathExpression.Tokenizer tokenizer = new MathExpression.Tokenizer("3.2+4");

        assertThat(tokenizer.nextToken()).isEqualTo("3.2");
        assertThat(tokenizer.nextToken()).isEqualTo("+");
        assertThat(tokenizer.nextToken()).isEqualTo("4");
    }

    @Test
    void should_return_next_tokens_for_expression_3comma2_plus_4() {
        MathExpression.Tokenizer tokenizer = new MathExpression.Tokenizer("3,2+4");

        assertThat(tokenizer.nextToken()).isEqualTo("3.2");
        assertThat(tokenizer.nextToken()).isEqualTo("+");
        assertThat(tokenizer.nextToken()).isEqualTo("4");
    }

    @Test
    void should_have_more_tokens() {
        MathExpression.Tokenizer tokenizer = new MathExpression.Tokenizer("3,2+4");
        tokenizer.nextToken();

        assertThat(tokenizer.hasMoreTokens()).isTrue();
    }

    @Test
    void should_not_have_more_tokens() {
        MathExpression.Tokenizer tokenizer = new MathExpression.Tokenizer("3,2+4");
        tokenizer.nextToken();
        tokenizer.nextToken();
        tokenizer.nextToken();

        assertThat(tokenizer.hasMoreTokens()).isFalse();
    }

    @Test
    void should_return_true_when_operator_is_plus() {
        assertThat(MathExpression.Token.isOperator("+")).isTrue();
    }

    @Test
    void should_return_true_when_operator_is_minus() {
        assertThat(MathExpression.Token.isOperator("-")).isTrue();
    }

    @Test
    void should_return_true_when_operator_is_multiplication() {
        assertThat(MathExpression.Token.isOperator("*")).isTrue();
    }

    @Test
    void should_return_true_when_operator_is_divide() {
        assertThat(MathExpression.Token.isOperator("/")).isTrue();
    }

    @Test
    void should_return_false_when_operator_is_unknow() {
        assertThat(MathExpression.Token.isOperator("a")).isFalse();
    }
}