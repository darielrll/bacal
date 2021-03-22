package drll;

import java.io.IOException;
import java.io.InputStream;

public class FastReader {
    private InputStream inputStream;

    public FastReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int read() throws IOException {

        return inputStream.read();
    }
}
