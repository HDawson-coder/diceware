package edu.cnm.deepdive.diceware.view;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import edu.cnm.deepdive.diceware.model.entity.Word;
import java.io.IOException;

public class WordSerializer<T extends Word> extends StdSerializer<T> {

  public WordSerializer() {
    this(null);
  }

  public WordSerializer(Class<T> t) {
    super(t);
  }

  @Override
  public void serialize(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {
    jsonGenerator.writeString(t.getContent());
  }
}
