package test;

import main.FilePartReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    FilePartReader filePartReader = new FilePartReader();

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenToLineIsSmallerThenFromLine() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("/home/kuba/Pulpit/filepartreader-testing-with-junit-KubaL92/src/resources/test.txt", 5, 1));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenFromLineIsSmallerThen1() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("/home/kuba/Pulpit/filepartreader-testing-with-junit-KubaL92/src/resources/test.txt", - 1, 1));
    }

    @Test
    public void shouldThrowIOException() {
        filePartReader.setup("resources/nope.txt", 1, 2);
        assertThrows(IOException.class, () -> filePartReader.read());
    }


    @Test
    public void testReader() throws IOException {
        filePartReader.setup("/home/kuba/Pulpit/filepartreader-testing-with-junit-KubaL92/src/resources/test.txt", 1, 1);

        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                "Integer tempor pulvinar nunc, et malesuada quam convallis blandit.\n" +
                "Proin blandit pellentesque nulla nec aliquam.\n" +
                "Ut ac tincidunt erat. Donec sed non eleifend dolor.\n" +
                "In justo mauris, laoreet eu urna sit amet, egestas porttitor arcu.\n" +
                "Morbi pharetra, neque vitae pellentesque posuere, justo dui suscipit justo, vitae convallis eros felis sed arcu.\n" +
                "Pellentesque sit amet ultrices erat, nec aliquam nulla.\n" +
                "Proin et tellus non quam interdum luctus nec quis lectus.\n" +
                "Praesent porttitor urna et elit egestas, at rutrum nisl vehicula.\n" +
                "Proin gravida interdum rhoncus. Pellentesque efficitur neque ut viverra volutpat.\n", filePartReader.read());
    }

    @Test
    public void testReadLines() throws IOException {
        filePartReader.setup("/home/kuba/Pulpit/filepartreader-testing-with-junit-KubaL92/src/resources/test.txt", 2, 2);

        assertEquals("Integer tempor pulvinar nunc, et malesuada quam convallis blandit.", filePartReader.readLines());
    }


}