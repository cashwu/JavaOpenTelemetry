
# Java OpenTelemetry

```shell
export JAVA_TOOL_OPTIONS="-javaagent:/Users/cash.wu/Downloads/opentelemetry-javaagent.jar" \
OTEL_TRACES_EXPORTER=logging \
OTEL_METRICS_EXPORTER=logging \
OTEL_LOGS_EXPORTER=logging
```

```shell
java -jar ~/github/JavaOpenTelemetry/build/libs/JavaOpenTelemetry-0.0.1-SNAPSHOT.jar
```