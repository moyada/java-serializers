Serialization Framework Performance Test

java version "1.8.0_191"

See Detail: https://moyada.github.io/2019/05/02/serializer/

# Serialize Time

| Framework |  Scope   |   Error   | Unit |
| --------- | -------- | -------- | ------ |
| Avro      | 0.011544 | 0.000105 | ms     |
| Fastjson  | 0.009009 | 0.000098 | ms     |
| Gson      | 0.015223 | 0.000115 | ms     |
| Hessian   | 0.016994 | 0.000113 | ms     |
| Jackson   | 0.008997 | 0.00019  | ms     |
| Kryo      | 0.01249  | 0.000136 | ms     |
| Protobuf  | 0.010184 | 0.000527 | ms     |
| Protostuff | 0.006061	| 0.000121 | ms    |

# Deserialize Time

| Framework |  Scope   |   Error   | Unit |
| --------- | -------- | -------- | ------ |
| Avro      | 0.025744 | 0.001877 | ms     |
| Fastjson  | 0.008745 | 0.000845 | ms     |
| Gson      | 0.010158 | 0.000343 | ms     |
| Hessian   | 0.009347 | 0.000267 | ms     |
| Jackson   | 0.009441 | 0.000233 | ms     |
| Kryo      | 0.00896  | 0.000165 | ms     |
| Protobuf  | 0.005521 | 0.000179 | ms     |
| Protostuff | 0.004943 | 0.000071 | ms    |