package io.atty.buffer;

/*
 * @Description 字节缓冲区的调用API
 * @Author Frish2021
 * @Time 2024/10/1
 */
@SuppressWarnings("all")
public abstract class ByteBuffer {
    public abstract byte readByte();

    public abstract ByteBuffer writeByte(byte value);

    public abstract ByteBuffer readBytes(byte[] dest);

    public abstract ByteBuffer readBytes(ByteBuffer buffer);

    public abstract ByteBuffer readBytes(java.nio.ByteBuffer buffer);

    public abstract ByteBuffer writeBytes(byte[] value);

    public abstract ByteBuffer writeBytes(ByteBuffer buffer);

    public abstract ByteBuffer writeBytes(java.nio.ByteBuffer buffer);

    public abstract int readInt();

    public abstract ByteBuffer writeInt(int value);

    public abstract long readLong();

    public abstract ByteBuffer writeLong(long value);

    public abstract char readChar();

    public abstract ByteBuffer writeChar(char value);

    public abstract float readFloat();

    public abstract ByteBuffer writeFloat(float value);

    public abstract double readDouble();

    public abstract ByteBuffer writeDouble(double value);

    public abstract short readShort();

    public abstract int readUnsignedShort();

    public abstract ByteBuffer writeShort(short value);

    public abstract byte[] array();

    public abstract int writerIndex();

    public abstract int readerIndex();

    public abstract ByteBuffer writerIndex(int index);

    public abstract ByteBuffer readerIndex(int index);

    public abstract int readableIndex();

    public abstract int writeableIndex();

    public abstract int capacity();

    public abstract void clear();

    public abstract ByteBuffer copy();

    public abstract ByteBuffer reset();

    public static ByteBuffer allocate(int capacity) {
        return new DefaultByteBuffer(capacity);
    }

    public static ByteBuffer allocate() {
        return allocate(1024);
    }

    public static ByteBuffer wrap(java.nio.ByteBuffer buffer) {
        return allocate(buffer.capacity()).writeBytes(buffer);
    }

    public static ByteBuffer wrap(byte[] buffer) {
        return allocate(buffer.length).writeBytes(buffer);
    }
}
