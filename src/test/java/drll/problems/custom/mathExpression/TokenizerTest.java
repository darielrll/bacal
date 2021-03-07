package drll.problems.custom.mathExpression;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TokenizerTest {
    @Test
    void should_return_next_tokens_for_expression_3_plus_4() {
        Tokenizer tokenizer = new Tokenizer("3+4");

        assertThat(tokenizer.nextToken()).isEqualTo("3");
        assertThat(tokenizer.nextToken()).isEqualTo("+");
        assertThat(tokenizer.nextToken()).isEqualTo("4");
    }

    @Test
    void should_return_null_token_when_not_have_more_tokens() {
        Tokenizer tokenizer = new Tokenizer("3+4");
        tokenizer.nextToken();
        tokenizer.nextToken();
        tokenizer.nextToken();

        assertThat(tokenizer.nextToken()).isNull();
    }

    @Test
    void should_return_next_tokens_for_expression_has_spaces() {
        Tokenizer tokenizer = new Tokenizer(" 3 + 4 ");

        assertThat(tokenizer.nextToken()).isEqualTo("3");
        assertThat(tokenizer.nextToken()).isEqualTo("+");
        assertThat(tokenizer.nextToken()).isEqualTo("4");
    }

    @Test
    void should_return_next_tokens_for_expression_3dot2_plus_4() {
        Tokenizer tokenizer = new Tokenizer("3.2+4");

        assertThat(tokenizer.nextToken()).isEqualTo("3.2");
        assertThat(tokenizer.nextToken()).isEqualTo("+");
        assertThat(tokenizer.nextToken()).isEqualTo("4");
    }

    @Test
    void should_return_next_tokens_for_expression_3comma2_plus_4() {
        Tokenizer tokenizer = new Tokenizer("3,2+4");

        assertThat(tokenizer.nextToken()).isEqualTo("3.2");
        assertThat(tokenizer.nextToken()).isEqualTo("+");
        assertThat(tokenizer.nextToken()).isEqualTo("4");
    }

    @Test
    void should_have_more_tokens() {
        Tokenizer tokenizer = new Tokenizer("3,2+4");
        tokenizer.nextToken();

        assertThat(tokenizer.hasMoreTokens()).isTrue();
    }

    @Test
    void should_not_have_more_tokens() {
        Tokenizer tokenizer = new Tokenizer("3,2+4");
        tokenizer.nextToken();
        tokenizer.nextToken();
        tokenizer.nextToken();

        assertThat(tokenizer.hasMoreTokens()).isFalse();
    }
}