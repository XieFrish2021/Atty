package io.atty.buffer;

/*
* @Description 字节缓冲区的默认实现
* @Author Frish2021
* @Time 2024/10/1
*/
@SuppressWarnings("all")
public class DefaultByteBuffer extends ByteBuffer {
    private final int capacity;
    private final java.nio.ByteBuffer buffer;
    private int writerIndex;
    private int readerIndex;

    public DefaultByteBuffer(int capacity) {
        if (capacity <= 0) throw new RuntimeException("The capacity cannot be 0.");
        this.capacity = capacity;
        this.buffer = java.nio.ByteBuffer.allocate(this.capacity);
    }

    @Override
    public byte readByte() {
        byte data = this.buffer.get(this.readerIndex);
        if (this.readerIndex + Byte.BYTES > this.writerIndex) {
            throw new WriterIndexOutOfBoundsException(
                    "ReaderIndex(" + this.readerIndex + ") + Bytes(" + Byte.BYTES + ") out of Bounds(" + this.writerIndex + ")."
            );
        }
        this.readerIndex = this.readerIndex + Byte.BYTES;
        return data;
    }

    @Override
    public ByteBuffer writeByte(byte value) {
        if (this.writerIndex + Byte.BYTES > this.capacity) {
            throw new WriterIndexOutOfBoundsException(
                    "WriterIndex(" + this.writerIndex + ") + Bytes(" + Byte.BYTES + ") out of Bounds(" + this.capacity + ")."
            );
        }
        this.buffer.put(this.writerIndex, value);
        this.writerIndex = this.writerIndex + Byte.BYTES;
        return this;
    }

    @Override
    public ByteBuffer readBytes(byte[] dest) {
        this.buffer.get(this.readerIndex, dest);
        if (this.readerIndex + dest.length > this.writerIndex) {
            throw new WriterIndexOutOfBoundsException(
                    "ReaderIndex(" + this.readerIndex + ") + Bytes(" + dest.length + ") out of Bounds(" + this.writerIndex + ")."
            );
        }
        this.readerIndex = this.readerIndex + dest.length;
        return this;
    }

    @Override
    public ByteBuffer readBytes(ByteBuffer buffer) {
        this.readBytes(buffer.array());
        return this;
    }

    @Override
    public ByteBuffer readBytes(java.nio.ByteBuffer buffer) {
        this.readBytes(buffer.array());
        return this;
    }

    @Override
    public ByteBuffer writeBytes(byte[] value) {
        if (this.writerIndex + value.length > this.capacity) {
            throw new WriterIndexOutOfBoundsException(
                    "WriterIndex(" + this.writerIndex + ") + Bytes(" + value.length + ") out of Bounds(" + this.capacity + ")."
            );
        }
        this.buffer.put(this.writerIndex, value);
        this.writerIndex = this.writerIndex + value.length;
        return this;
    }

    @Override
    public ByteBuffer writeBytes(ByteBuffer buffer) {
        byte[] array = buffer.array();
        this.writeBytes(array);
        return this;
    }

    @Override
    public ByteBuffer writeBytes(java.nio.ByteBuffer buffer) {
        byte[] array = buffer.array();
        this.writeBytes(array);
        return this;
    }

    @Override
    public int readInt() {
        if (this.readerIndex + Integer.BYTES > this.writerIndex) {
            throw new WriterIndexOutOfBoundsException(
                    "ReaderIndex(" + this.readerIndex + ") + Bytes(" + Integer.BYTES + ") out of Bounds(" + this.writerIndex + ")."
            );
        }
        int anInt = this.buffer.getInt(this.readerIndex);
        this.readerIndex = this.readerIndex + Integer.BYTES;
        return anInt;
    }

    @Override
    public ByteBuffer writeInt(int value) {
        if (this.writerIndex + Integer.BYTES > this.capacity) {
            throw new WriterIndexOutOfBoundsException(
                    "WriterIndex(" + this.writerIndex + ") + Bytes(" + Integer.BYTES + ") out of Bounds(" + this.capacity + ")."
            );
        }
        this.buffer.putInt(this.writerIndex, value);
        this.writerIndex = this.writerIndex + Integer.BYTES;
        return this;
    }

    @Override
    public long readLong() {
        if (this.readerIndex + Long.BYTES > this.writerIndex) {
            throw new WriterIndexOutOfBoundsException(
                    "ReaderIndex(" + this.readerIndex + ") + Bytes(" + Long.BYTES + ") out of Bounds(" + this.writerIndex + ")."
            );
        }
        long aLong = this.buffer.getLong(this.readerIndex);
        this.readerIndex = this.readerIndex + Long.BYTES;
        return aLong;
    }

    @Override
    public ByteBuffer writeLong(long value) {
        if (this.writerIndex + Long.BYTES > this.capacity) {
            throw new WriterIndexOutOfBoundsException(
                    "WriterIndex(" + this.writerIndex + ") + Bytes(" + Long.BYTES + ") out of Bounds(" + this.capacity + ")."
            );
        }
        this.buffer.putLong(this.writerIndex, value);
        this.writerIndex = this.writerIndex + Long.BYTES;
        return this;
    }

    @Override
    public char readChar() {
        if (this.readerIndex + Character.BYTES > this.writerIndex) {
            throw new WriterIndexOutOfBoundsException(
                    "ReaderIndex(" + this.readerIndex + ") + Bytes(" + Character.BYTES + ") out of Bounds(" + this.writerIndex + ")."
            );
        }
        char aChar = this.buffer.getChar(this.readerIndex);
        this.readerIndex = this.readerIndex + Character.BYTES;
        return aChar;
    }

    @Override
    public ByteBuffer writeChar(char value) {
        if (this.writerIndex + Character.BYTES > this.capacity) {
            throw new WriterIndexOutOfBoundsException(
                    "WriterIndex(" + this.writerIndex + ") + Bytes(" + Character.BYTES + ") out of Bounds(" + this.capacity + ")."
            );
        }
        this.buffer.putChar(this.writerIndex, value);
        this.writerIndex = this.writerIndex + Character.BYTES;
        return this;
    }

    @Override
    public float readFloat() {
        if (this.readerIndex + Float.BYTES > this.writerIndex) {
            throw new WriterIndexOutOfBoundsException(
                    "ReaderIndex(" + this.readerIndex + ") + Bytes(" + Float.BYTES + ") out of Bounds(" + this.writerIndex + ")."
            );
        }
        float aFloat = this.buffer.getFloat(this.readerIndex);
        this.readerIndex = this.readerIndex + Float.BYTES;
        return aFloat;
    }

    @Override
    public ByteBuffer writeFloat(float value) {
        if (this.writerIndex + Float.BYTES > this.capacity) {
            throw new WriterIndexOutOfBoundsException(
                    "WriterIndex(" + this.writerIndex + ") + Bytes(" + Float.BYTES + ") out of Bounds(" + this.capacity + ")."
            );
        }
        this.buffer.putFloat(this.writerIndex, value);
        this.writerIndex = this.writerIndex + Float.BYTES;
        return this;
    }

    @Override
    public double readDouble() {
        if (this.readerIndex + Double.BYTES > this.writerIndex) {
            throw new WriterIndexOutOfBoundsException(
                    "ReaderIndex(" + this.readerIndex + ") + Bytes(" + Double.BYTES + ") out of Bounds(" + this.writerIndex + ")."
            );
        }
        double aDouble = this.buffer.getDouble(this.readerIndex);
        this.readerIndex = this.readerIndex + Double.BYTES;
        return aDouble;
    }

    @Override
    public ByteBuffer writeDouble(double value) {
        if (this.writerIndex + Double.BYTES > this.capacity) {
            throw new WriterIndexOutOfBoundsException(
                    "WriterIndex(" + this.writerIndex + ") + Bytes(" + Double.BYTES + ") out of Bounds(" + this.capacity + ")."
            );
        }
        this.buffer.putDouble(this.writerIndex, value);
        this.writerIndex = this.writerIndex + Double.BYTES;
        return this;
    }

    @Override
    public short readShort() {
        if (this.readerIndex + Short.BYTES > this.writerIndex) {
            throw new WriterIndexOutOfBoundsException(
                    "ReaderIndex(" + this.readerIndex + ") + Bytes(" + Short.BYTES + ") out of Bounds(" + this.writerIndex + ")."
            );
        }
        short aShort = this.buffer.getShort(this.readerIndex);
        this.readerIndex = this.readerIndex + Short.BYTES;
        return aShort;
    }

    @Override
    public int readUnsignedShort() {
        return readShort();
    }

    @Override
    public ByteBuffer writeShort(short value) {
        if (this.writerIndex + Short.BYTES > this.capacity) {
            throw new WriterIndexOutOfBoundsException(
                    "WriterIndex(" + this.writerIndex + ") + Bytes(" + Short.BYTES + ") out of Bounds(" + this.capacity + ")."
            );
        }
        this.buffer.putShort(this.writerIndex, value);
        this.writerIndex = this.writerIndex + Short.BYTES;
        return this;
    }

    @Override
    public byte[] array() {
        return this.buffer.array();
    }

    @Override
    public int writerIndex() {
        return this.writerIndex;
    }

    @Override
    public int readerIndex() {
        return this.readerIndex;
    }

    @Override
    public ByteBuffer writerIndex(int index) {
        if (index > this.capacity) throw new WriterIndexOutOfBoundsException();
        this.writerIndex = index;
        return this;
    }

    @Override
    public ByteBuffer readerIndex(int index) {
        if (index > this.writerIndex) throw new ReaderIndexOutOfBoundsException();
        this.readerIndex = index;
        return this;
    }

    @Override
    public int readableIndex() {
        return this.writerIndex - this.readerIndex;
    }

    @Override
    public int writeableIndex() {
        return this.capacity - this.writerIndex;
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public void clear() {
        for (int i = 0;i < this.capacity;i++) {
            this.buffer.array()[i] = 0;
        }
        this.buffer.clear();
    }

    @Override
    public ByteBuffer copy() {
        return ByteBuffer.allocate(this.capacity)
                .writeBytes(this);
    }

    @Override
    public ByteBuffer reset() {
        this.readerIndex = 0;
        return this;
    }

    @SuppressWarnings("unused")
    private static class ReaderIndexOutOfBoundsException extends ArrayIndexOutOfBoundsException {
        public ReaderIndexOutOfBoundsException(String message) {
            super(message);
        }

        public ReaderIndexOutOfBoundsException() {
        }
    }

    @SuppressWarnings("unused")
    private class WriterIndexOutOfBoundsException extends ArrayIndexOutOfBoundsException {
        public WriterIndexOutOfBoundsException(String message) {
            super(message);
        }

        public WriterIndexOutOfBoundsException() {
        }
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " - ReaderIndex(" + this.readerIndex + "):WriterIndex(" + this.writerIndex + "):Capacity(" + this.capacity + ").";
    }
}
