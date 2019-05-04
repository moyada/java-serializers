/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package io.moyada.serializer.data.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class User extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1826676517528916163L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"User\",\"namespace\":\"io.moyada.serializer.data.avro\",\"fields\":[{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"name\",\"type\":[\"string\",\"null\"]},{\"name\":\"age\",\"type\":\"int\"},{\"name\":\"gender\",\"type\":[\"boolean\",\"null\"]},{\"name\":\"scope\",\"type\":[\"double\",\"null\"]},{\"name\":\"identifies\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"info\",\"type\":{\"type\":\"map\",\"values\":\"string\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<User> ENCODER =
      new BinaryMessageEncoder<User>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<User> DECODER =
      new BinaryMessageDecoder<User>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<User> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<User> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<User>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this User to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a User from a ByteBuffer. */
  public static User fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public long id;
  @Deprecated public java.lang.CharSequence name;
  @Deprecated public int age;
  @Deprecated public java.lang.Boolean gender;
  @Deprecated public java.lang.Double scope;
  @Deprecated public java.util.List<java.lang.CharSequence> identifies;
  @Deprecated public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> info;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public User() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param name The new value for name
   * @param age The new value for age
   * @param gender The new value for gender
   * @param scope The new value for scope
   * @param identifies The new value for identifies
   * @param info The new value for info
   */
  public User(java.lang.Long id, java.lang.CharSequence name, java.lang.Integer age, java.lang.Boolean gender, java.lang.Double scope, java.util.List<java.lang.CharSequence> identifies, java.util.Map<java.lang.CharSequence,java.lang.CharSequence> info) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.scope = scope;
    this.identifies = identifies;
    this.info = info;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name;
    case 2: return age;
    case 3: return gender;
    case 4: return scope;
    case 5: return identifies;
    case 6: return info;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Long)value$; break;
    case 1: name = (java.lang.CharSequence)value$; break;
    case 2: age = (java.lang.Integer)value$; break;
    case 3: gender = (java.lang.Boolean)value$; break;
    case 4: scope = (java.lang.Double)value$; break;
    case 5: identifies = (java.util.List<java.lang.CharSequence>)value$; break;
    case 6: info = (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.Long value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'age' field.
   * @return The value of the 'age' field.
   */
  public java.lang.Integer getAge() {
    return age;
  }

  /**
   * Sets the value of the 'age' field.
   * @param value the value to set.
   */
  public void setAge(java.lang.Integer value) {
    this.age = value;
  }

  /**
   * Gets the value of the 'gender' field.
   * @return The value of the 'gender' field.
   */
  public java.lang.Boolean getGender() {
    return gender;
  }

  /**
   * Sets the value of the 'gender' field.
   * @param value the value to set.
   */
  public void setGender(java.lang.Boolean value) {
    this.gender = value;
  }

  /**
   * Gets the value of the 'scope' field.
   * @return The value of the 'scope' field.
   */
  public java.lang.Double getScope() {
    return scope;
  }

  /**
   * Sets the value of the 'scope' field.
   * @param value the value to set.
   */
  public void setScope(java.lang.Double value) {
    this.scope = value;
  }

  /**
   * Gets the value of the 'identifies' field.
   * @return The value of the 'identifies' field.
   */
  public java.util.List<java.lang.CharSequence> getIdentifies() {
    return identifies;
  }

  /**
   * Sets the value of the 'identifies' field.
   * @param value the value to set.
   */
  public void setIdentifies(java.util.List<java.lang.CharSequence> value) {
    this.identifies = value;
  }

  /**
   * Gets the value of the 'info' field.
   * @return The value of the 'info' field.
   */
  public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getInfo() {
    return info;
  }

  /**
   * Sets the value of the 'info' field.
   * @param value the value to set.
   */
  public void setInfo(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
    this.info = value;
  }

  /**
   * Creates a new User RecordBuilder.
   * @return A new User RecordBuilder
   */
  public static io.moyada.serializer.data.avro.User.Builder newBuilder() {
    return new io.moyada.serializer.data.avro.User.Builder();
  }

  /**
   * Creates a new User RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new User RecordBuilder
   */
  public static io.moyada.serializer.data.avro.User.Builder newBuilder(io.moyada.serializer.data.avro.User.Builder other) {
    return new io.moyada.serializer.data.avro.User.Builder(other);
  }

  /**
   * Creates a new User RecordBuilder by copying an existing User instance.
   * @param other The existing instance to copy.
   * @return A new User RecordBuilder
   */
  public static io.moyada.serializer.data.avro.User.Builder newBuilder(io.moyada.serializer.data.avro.User other) {
    return new io.moyada.serializer.data.avro.User.Builder(other);
  }

  /**
   * RecordBuilder for User instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<User>
    implements org.apache.avro.data.RecordBuilder<User> {

    private long id;
    private java.lang.CharSequence name;
    private int age;
    private java.lang.Boolean gender;
    private java.lang.Double scope;
    private java.util.List<java.lang.CharSequence> identifies;
    private java.util.Map<java.lang.CharSequence,java.lang.CharSequence> info;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(io.moyada.serializer.data.avro.User.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.age)) {
        this.age = data().deepCopy(fields()[2].schema(), other.age);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.gender)) {
        this.gender = data().deepCopy(fields()[3].schema(), other.gender);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.scope)) {
        this.scope = data().deepCopy(fields()[4].schema(), other.scope);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.identifies)) {
        this.identifies = data().deepCopy(fields()[5].schema(), other.identifies);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.info)) {
        this.info = data().deepCopy(fields()[6].schema(), other.info);
        fieldSetFlags()[6] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing User instance
     * @param other The existing instance to copy.
     */
    private Builder(io.moyada.serializer.data.avro.User other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.age)) {
        this.age = data().deepCopy(fields()[2].schema(), other.age);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.gender)) {
        this.gender = data().deepCopy(fields()[3].schema(), other.gender);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.scope)) {
        this.scope = data().deepCopy(fields()[4].schema(), other.scope);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.identifies)) {
        this.identifies = data().deepCopy(fields()[5].schema(), other.identifies);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.info)) {
        this.info = data().deepCopy(fields()[6].schema(), other.info);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.Long getId() {
      return id;
    }

    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public io.moyada.serializer.data.avro.User.Builder setId(long value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public io.moyada.serializer.data.avro.User.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public io.moyada.serializer.data.avro.User.Builder setName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public io.moyada.serializer.data.avro.User.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'age' field.
      * @return The value.
      */
    public java.lang.Integer getAge() {
      return age;
    }

    /**
      * Sets the value of the 'age' field.
      * @param value The value of 'age'.
      * @return This builder.
      */
    public io.moyada.serializer.data.avro.User.Builder setAge(int value) {
      validate(fields()[2], value);
      this.age = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'age' field has been set.
      * @return True if the 'age' field has been set, false otherwise.
      */
    public boolean hasAge() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'age' field.
      * @return This builder.
      */
    public io.moyada.serializer.data.avro.User.Builder clearAge() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'gender' field.
      * @return The value.
      */
    public java.lang.Boolean getGender() {
      return gender;
    }

    /**
      * Sets the value of the 'gender' field.
      * @param value The value of 'gender'.
      * @return This builder.
      */
    public io.moyada.serializer.data.avro.User.Builder setGender(java.lang.Boolean value) {
      validate(fields()[3], value);
      this.gender = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'gender' field has been set.
      * @return True if the 'gender' field has been set, false otherwise.
      */
    public boolean hasGender() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'gender' field.
      * @return This builder.
      */
    public io.moyada.serializer.data.avro.User.Builder clearGender() {
      gender = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'scope' field.
      * @return The value.
      */
    public java.lang.Double getScope() {
      return scope;
    }

    /**
      * Sets the value of the 'scope' field.
      * @param value The value of 'scope'.
      * @return This builder.
      */
    public io.moyada.serializer.data.avro.User.Builder setScope(java.lang.Double value) {
      validate(fields()[4], value);
      this.scope = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'scope' field has been set.
      * @return True if the 'scope' field has been set, false otherwise.
      */
    public boolean hasScope() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'scope' field.
      * @return This builder.
      */
    public io.moyada.serializer.data.avro.User.Builder clearScope() {
      scope = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'identifies' field.
      * @return The value.
      */
    public java.util.List<java.lang.CharSequence> getIdentifies() {
      return identifies;
    }

    /**
      * Sets the value of the 'identifies' field.
      * @param value The value of 'identifies'.
      * @return This builder.
      */
    public io.moyada.serializer.data.avro.User.Builder setIdentifies(java.util.List<java.lang.CharSequence> value) {
      validate(fields()[5], value);
      this.identifies = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'identifies' field has been set.
      * @return True if the 'identifies' field has been set, false otherwise.
      */
    public boolean hasIdentifies() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'identifies' field.
      * @return This builder.
      */
    public io.moyada.serializer.data.avro.User.Builder clearIdentifies() {
      identifies = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'info' field.
      * @return The value.
      */
    public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getInfo() {
      return info;
    }

    /**
      * Sets the value of the 'info' field.
      * @param value The value of 'info'.
      * @return This builder.
      */
    public io.moyada.serializer.data.avro.User.Builder setInfo(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
      validate(fields()[6], value);
      this.info = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'info' field has been set.
      * @return True if the 'info' field has been set, false otherwise.
      */
    public boolean hasInfo() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'info' field.
      * @return This builder.
      */
    public io.moyada.serializer.data.avro.User.Builder clearInfo() {
      info = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public User build() {
      try {
        User record = new User();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Long) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.age = fieldSetFlags()[2] ? this.age : (java.lang.Integer) defaultValue(fields()[2]);
        record.gender = fieldSetFlags()[3] ? this.gender : (java.lang.Boolean) defaultValue(fields()[3]);
        record.scope = fieldSetFlags()[4] ? this.scope : (java.lang.Double) defaultValue(fields()[4]);
        record.identifies = fieldSetFlags()[5] ? this.identifies : (java.util.List<java.lang.CharSequence>) defaultValue(fields()[5]);
        record.info = fieldSetFlags()[6] ? this.info : (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>) defaultValue(fields()[6]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<User>
    WRITER$ = (org.apache.avro.io.DatumWriter<User>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<User>
    READER$ = (org.apache.avro.io.DatumReader<User>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
