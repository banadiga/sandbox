package com.banadiga.caching.serializer;

import com.banadiga.caching.dto.Item;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Component
public class ItemKryoSerializer implements StreamSerializer<Item> {
  private static final ThreadLocal<Kryo> kryoThreadLocal = ThreadLocal.withInitial(() -> {
    Kryo kryo = new Kryo();
    kryo.register(Item.class);
    return kryo;
  });

  public ItemKryoSerializer() {
  }

  @Override
  public int getTypeId() {
    return 55;
  }

  @Override
  public void write(ObjectDataOutput objectDataOutput, Item item) throws IOException {
    Kryo kryo = kryoThreadLocal.get();
    Output output = new Output((OutputStream) objectDataOutput);
    kryo.writeObject(output, item);
    output.flush();
  }

  @Override
  public Item read(ObjectDataInput objectDataInput) throws IOException {
    InputStream in = (InputStream) objectDataInput;
    Input input = new Input(in);
    Kryo kryo = kryoThreadLocal.get();
    return kryo.readObject(input, Item.class);
  }

  @Override
  public void destroy() {
  }
}
