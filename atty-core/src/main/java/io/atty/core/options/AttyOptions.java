package io.atty.core.options;

@SuppressWarnings("all")
public class AttyOptions<T> {
    private T value;

    public AttyOptions(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static AttyOptions<Boolean> TCP_NO_DELAY = new AttyOptions<>(false);
    public static AttyOptions<Boolean> KEEP_ALIVE = new AttyOptions<>(false);

    public static AttyOptions<Integer> WRITER_BUFFER_SIZE = new AttyOptions<>(256);
    public static AttyOptions<Integer> READER_BUFFER_SIZE = new AttyOptions<>(256);
}
