package drll.problems.custom.mathExpression;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MathExpressionTest {

    @Test
    void should_return_39dot5_when_expression_is_4comma5plus35() throws Exception {
        assertThat(new MathExpression().evalMathExpression("4,5+35")).isEqualTo(39.5);
    }

    @Test
    void should_return_25dot29_when_expression_is_8dot29_plus_17() throws Exception {
        assertThat(new MathExpression().evalMathExpression("8.29 + 17")).isEqualTo(25.29);
    }

    @Test
    void should_return_XX_when_expression_is_3plus4divide3plus6multiplication8minus2() throws Exception {
        // infix:   3+4/3+6*8-2
        assertThat(new MathExpression().evalMathExpression("3+4/3+6*8-2")).isEqualTo(50.33);
    }

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
        // infix:   3+4/3+6*8-2   = 3 + 4 / 3 + 48 - 2
        // postfix: 343/+68*+2-
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
}