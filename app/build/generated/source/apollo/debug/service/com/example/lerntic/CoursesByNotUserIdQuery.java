// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.lerntic;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser;
import com.apollographql.apollo.api.internal.UnmodifiableMapBuilder;
import com.apollographql.apollo.api.internal.Utils;
import com.apollographql.apollo.internal.QueryDocumentMinifier;
import com.apollographql.apollo.response.ScalarTypeAdapters;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CoursesByNotUserIdQuery implements Query<CoursesByNotUserIdQuery.Data, CoursesByNotUserIdQuery.Data, CoursesByNotUserIdQuery.Variables> {
  public static final String OPERATION_ID = "e3f729de9decf684700bfca31b858a1c6c804115f1769b68c81bcc90d5880db4";

  public static final String QUERY_DOCUMENT = QueryDocumentMinifier.minify(
    "query coursesByNotUserId($id:String!) {\n"
        + "  coursesByNotUserId(id: $id) {\n"
        + "    __typename\n"
        + "    course_id\n"
        + "    course_description\n"
        + "    course_name\n"
        + "    course_score\n"
        + "  }\n"
        + "}"
  );

  public static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "coursesByNotUserId";
    }
  };

  private final CoursesByNotUserIdQuery.Variables variables;

  public CoursesByNotUserIdQuery(@NotNull String id) {
    Utils.checkNotNull(id, "id == null");
    variables = new CoursesByNotUserIdQuery.Variables(id);
  }

  @Override
  public String operationId() {
    return OPERATION_ID;
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public CoursesByNotUserIdQuery.Data wrapData(CoursesByNotUserIdQuery.Data data) {
    return data;
  }

  @Override
  public CoursesByNotUserIdQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<CoursesByNotUserIdQuery.Data> responseFieldMapper() {
    return new Data.Mapper();
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public OperationName name() {
    return OPERATION_NAME;
  }

  @Override
  @NotNull
  public Response<CoursesByNotUserIdQuery.Data> parse(@NotNull final BufferedSource source,
      @NotNull final ScalarTypeAdapters scalarTypeAdapters) throws IOException {
    return SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters);
  }

  @Override
  @NotNull
  public Response<CoursesByNotUserIdQuery.Data> parse(@NotNull final BufferedSource source) throws
      IOException {
    return parse(source, ScalarTypeAdapters.DEFAULT);
  }

  public static final class Builder {
    private @NotNull String id;

    Builder() {
    }

    public Builder id(@NotNull String id) {
      this.id = id;
      return this;
    }

    public CoursesByNotUserIdQuery build() {
      Utils.checkNotNull(id, "id == null");
      return new CoursesByNotUserIdQuery(id);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @NotNull String id;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@NotNull String id) {
      this.id = id;
      this.valueMap.put("id", id);
    }

    public @NotNull String id() {
      return id;
    }

    @Override
    public Map<String, Object> valueMap() {
      return Collections.unmodifiableMap(valueMap);
    }

    @Override
    public InputFieldMarshaller marshaller() {
      return new InputFieldMarshaller() {
        @Override
        public void marshal(InputFieldWriter writer) throws IOException {
          writer.writeString("id", id);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forList("coursesByNotUserId", "coursesByNotUserId", new UnmodifiableMapBuilder<String, Object>(1)
      .put("id", new UnmodifiableMapBuilder<String, Object>(2)
        .put("kind", "Variable")
        .put("variableName", "id")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable List<CoursesByNotUserId> coursesByNotUserId;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Data(@Nullable List<CoursesByNotUserId> coursesByNotUserId) {
      this.coursesByNotUserId = coursesByNotUserId;
    }

    public @Nullable List<CoursesByNotUserId> coursesByNotUserId() {
      return this.coursesByNotUserId;
    }

    @SuppressWarnings("unchecked")
    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeList($responseFields[0], coursesByNotUserId, new ResponseWriter.ListWriter() {
            @Override
            public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
              for (Object item : items) {
                listItemWriter.writeObject(((CoursesByNotUserId) item).marshaller());
              }
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "coursesByNotUserId=" + coursesByNotUserId
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.coursesByNotUserId == null) ? (that.coursesByNotUserId == null) : this.coursesByNotUserId.equals(that.coursesByNotUserId));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (coursesByNotUserId == null) ? 0 : coursesByNotUserId.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final CoursesByNotUserId.Mapper coursesByNotUserIdFieldMapper = new CoursesByNotUserId.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final List<CoursesByNotUserId> coursesByNotUserId = reader.readList($responseFields[0], new ResponseReader.ListReader<CoursesByNotUserId>() {
          @Override
          public CoursesByNotUserId read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<CoursesByNotUserId>() {
              @Override
              public CoursesByNotUserId read(ResponseReader reader) {
                return coursesByNotUserIdFieldMapper.map(reader);
              }
            });
          }
        });
        return new Data(coursesByNotUserId);
      }
    }
  }

  public static class CoursesByNotUserId {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("course_id", "course_id", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("course_description", "course_description", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("course_name", "course_name", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forDouble("course_score", "course_score", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final int course_id;

    final @NotNull String course_description;

    final @NotNull String course_name;

    final double course_score;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public CoursesByNotUserId(@NotNull String __typename, int course_id,
        @NotNull String course_description, @NotNull String course_name, double course_score) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.course_id = course_id;
      this.course_description = Utils.checkNotNull(course_description, "course_description == null");
      this.course_name = Utils.checkNotNull(course_name, "course_name == null");
      this.course_score = course_score;
    }

    public @NotNull String __typename() {
      return this.__typename;
    }

    public int course_id() {
      return this.course_id;
    }

    public @NotNull String course_description() {
      return this.course_description;
    }

    public @NotNull String course_name() {
      return this.course_name;
    }

    public double course_score() {
      return this.course_score;
    }

    @SuppressWarnings("unchecked")
    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeInt($responseFields[1], course_id);
          writer.writeString($responseFields[2], course_description);
          writer.writeString($responseFields[3], course_name);
          writer.writeDouble($responseFields[4], course_score);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "CoursesByNotUserId{"
          + "__typename=" + __typename + ", "
          + "course_id=" + course_id + ", "
          + "course_description=" + course_description + ", "
          + "course_name=" + course_name + ", "
          + "course_score=" + course_score
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof CoursesByNotUserId) {
        CoursesByNotUserId that = (CoursesByNotUserId) o;
        return this.__typename.equals(that.__typename)
         && this.course_id == that.course_id
         && this.course_description.equals(that.course_description)
         && this.course_name.equals(that.course_name)
         && Double.doubleToLongBits(this.course_score) == Double.doubleToLongBits(that.course_score);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= course_id;
        h *= 1000003;
        h ^= course_description.hashCode();
        h *= 1000003;
        h ^= course_name.hashCode();
        h *= 1000003;
        h ^= Double.valueOf(course_score).hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<CoursesByNotUserId> {
      @Override
      public CoursesByNotUserId map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final int course_id = reader.readInt($responseFields[1]);
        final String course_description = reader.readString($responseFields[2]);
        final String course_name = reader.readString($responseFields[3]);
        final double course_score = reader.readDouble($responseFields[4]);
        return new CoursesByNotUserId(__typename, course_id, course_description, course_name, course_score);
      }
    }
  }
}
